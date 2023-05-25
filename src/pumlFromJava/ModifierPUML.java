package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

public class ModifierPUML
{
    private Element el;

    public ModifierPUML(Element xel)
    {
        this.el = xel;
    }

    private String getVisibility(Element element)
    {
        String res = "";

        String modifier = element.getModifiers().toString().toLowerCase();
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
