package pumlFromJava;

import jdk.javadoc.doclet.Doclet;
import jdk.javadoc.doclet.DocletEnvironment;
import jdk.javadoc.doclet.Reporter;

import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class PumlDoclet implements Doclet {
    String chemin = "C:\\Users\\sylva\\Documents\\Cours\\IUT\\P21\\p21_projet\\src\\pumlFromJava\\";
    String nom = "DC";
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
        OptionOut optionOut = new OptionOut();
        OptionD optionD = new OptionD();

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
        ArrayList<String> classes = new ArrayList<>();
        for (Element element : environment.getSpecifiedElements())
        {
            classes.add(String.valueOf(element.getSimpleName()));
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

    private void dumpElement(Element element)
    {
        System.out.print("---- ");
        System.out.println("element: " + element);
        System.out.println("kind: " + element.getKind());
        System.out.println("simpleName: " + element.getSimpleName());
        System.out.println("enclosingElement: " + element.getEnclosingElement());
        System.out.println("enclosedElement: " + element.getEnclosedElements());
        System.out.println("modifiers: " + element.getModifiers());
        System.out.println();
    }


    private void creationUml(ArrayList<String> classes) throws IOException
    {
        File fichier = new File(chemin +  nom + ".puml");
        if(fichier.exists())
        {
            fichier.delete();
        }
        fichier.createNewFile();

        try
        {
            PrintWriter writer = new PrintWriter(fichier);
            for (String s:classes)
            {
                writer.println("Class " + s);
            }
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}

