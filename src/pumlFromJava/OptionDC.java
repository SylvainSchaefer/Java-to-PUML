package pumlFromJava;

import jdk.javadoc.doclet.Doclet;

import java.util.List;

public class OptionDC implements Doclet.Option {
    private String typeDC;
    @Override
    public int getArgumentCount() {
        return 1;
    }

    @Override
    public String getDescription() {
        return "Choix entre DCC et DCA";
    }

    @Override
    public Kind getKind() {
        return Kind.STANDARD;
    }

    @Override
    public List<String> getNames() {
        return List.of("-dc");
    }

    @Override
    public String getParameters() {
        return "<String>";
    }

    @Override
    public boolean process(String option, List<String> arguments) {
        this.typeDC = arguments.get(0).toUpperCase();
        return true;
    }


    public String getTypeDC()
    {
        return this.typeDC;
    }

    public boolean isDCA()
    {
        if(typeDC.compareTo("A") == 0)
        {
            return true;
        }
        return false;
    }
}
