package pumlFromJava;

import javax.lang.model.element.Element;

public class Visibility {
    private Element element;

    public Visibility(Element xEl)
    {
        element = xEl;
    }
    public String getVisibility()
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
