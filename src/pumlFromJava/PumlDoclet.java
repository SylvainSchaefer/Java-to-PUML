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
    private OptionDC optionDC = new OptionDC();
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
        options.add(optionDC);
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


            if(optionDC.isDCA())
            {
                DCA dca = new DCA(classes);
                writer.println(dca.getEn_tete());
                writer.println(dca.getUML());
                writer.println(dca.getFin());
                writer.close();
            }
            else
            {
                DCC dcc = new DCC(classes);
                writer.println(dcc.getEn_tete());
                writer.println(dcc.getUML());
                writer.println(DCC.getFin());
                writer.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

