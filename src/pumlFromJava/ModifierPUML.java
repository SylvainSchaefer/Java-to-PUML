package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

public class ModifierPUML
{
    private Element element;

    public ModifierPUML(Element xel)
    {
        this.element = xel;
    }

    public String getModifier()
    {
        String res = "";

        String modifier = element.getModifiers().toString().toLowerCase();
        if (modifier.contains("static"))
        {
            res+= "{static} ";
        }
        else if (modifier.contains("final"))
        {
            res+= "{read only} ";
        }
        /*else if (modifier.contains("abstract"))
        {
            res+= "abstract ";
        }*/
        if (modifier.contains("public"))
        {
            res+= "+ ";
        }
        else if (modifier.contains("private"))
        {
            res+= "- ";
        }
        else if (modifier.contains("protected"))
        {
            res+= "# ";
        }

        return res;
    }
}
