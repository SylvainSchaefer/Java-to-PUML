package pumlFromJava;

import jdk.javadoc.doclet.Doclet;

import java.util.List;

public class OptionRel implements Doclet.Option{
    private String typeRel;
    @Override
    public int getArgumentCount() {
        return 1;
    }

    @Override
    public String getDescription() {
        return "Limiter les relations";
    }

    @Override
    public Kind getKind() {
        return Kind.STANDARD;
    }

    @Override
    public List<String> getNames() {
        return List.of("-rel");
    }

    @Override
    public String getParameters() {
        return "<String>";
    }

    @Override
    public boolean process(String option, List<String> arguments) {
        this.typeRel = arguments.get(0);
        return true;
    }

    public String getTypeRel()
    {
        return this.typeRel;
    }


    public boolean isAll()
    {
        if(typeRel != null)
        {
            if(typeRel.toLowerCase() == "a")
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return true;
        }
    }
}
