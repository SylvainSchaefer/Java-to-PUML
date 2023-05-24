package pumlFromJava;

import jdk.javadoc.doclet.Doclet;
import jdk.javadoc.doclet.DocletEnvironment;
import jdk.javadoc.doclet.Reporter;

import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class PumlDoclet implements Doclet {
    private OptionOut optionOut = new OptionOut();
    private OptionD optionD = new OptionD();
    @Override
    public void init(Locale locale, Reporter reporter) {  }

    @Override
    public String getName() {
        // For this doclet, the name of the doclet is just the
        // simple name of the class. The name may be used in
        // messages related to this doclet, such as in command-line
        // help when doclet-specific options are provided.
        return getClass().getSimpleName();
    }

    @Override
    public Set<? extends Option> getSupportedOptions() {
        // This doclet does not support any options.
        Set<Option> options = new HashSet<>();

        options.add(optionD);
        options.add(optionOut);
        return options;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        // This doclet supports all source versions.
        // More sophisticated doclets may use a more
        // specific version, to ensure that they do not
        // encounter more recent language features that
        // they may not be able to handle.
        return SourceVersion.latest();
    }

    @Override
    public boolean run(DocletEnvironment environment) {
        // This method is called to perform the work of the doclet.
        // In this case, it just prints out the names of the
        // elements specified on the command line.

        System.out.println(this.getName());
        System.out.println(environment.getSpecifiedElements());
        System.out.println(environment.getIncludedElements());
        ArrayList<Element> classes = new ArrayList<>();
        for (Element element : environment.getIncludedElements())
        {
            classes.add(element);
        }
        try
        {
            creationUml(classes);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return true;
    }



    private void creationUml(ArrayList<Element> classes) throws IOException {


        String chemin = optionD.getChemin();
        String nom = optionOut.getNomFichier();
        File fichier = new File(chemin + "\\" + nom + ".puml");
        if (fichier.exists()) {
            fichier.delete();
        }
        fichier.createNewFile();

        try {
            PrintWriter writer = new PrintWriter(fichier);
            writer.println("@startuml\n" +
                    "'https://plantuml.com/class-diagram\n" +
                    "skinparam style strictuml\n" +
                    "skinparam classAttributeIconSize 0\n" +
                    "skinparam classFontStyle Bold\n" +
                    "hide empty members\n");
            for (Element e : classes) {
                if(e.getKind() == ElementKind.CLASS)
                {
                    ClassPUML c = new ClassPUML(e);
                    writer.println(c.getNomClasse());
                    writer.println(c.getField());
                    writer.println(c.getConstructors());
                    writer.println(c.getMethode());
                    writer.println(c.getEnd());
                    writer.println(c.getAssociations());
                    SuperClasseUML sup = new SuperClasseUML(e);
                    writer.println(sup.getSuperClassName());

                }
                else if(e.getKind() == ElementKind.INTERFACE) {

                    InterfacePUML i = new InterfacePUML(e);
                    writer.println(i.getNameI());
                    writer.println(i.getEnd());
                }
                else if (e.getKind() == ElementKind.ENUM)
                {
                    EnumPUML en = new EnumPUML(e);
                    writer.println(en.getNameE());
                    writer.println(en.getConst());
                    writer.println(en.getEnd());
                }
            }
            writer.println("@enduml\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

