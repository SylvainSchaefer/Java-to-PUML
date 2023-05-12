package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class ClassPUML
{

    private Element el;

    public ClassPUML(Element xel)
    {
        this.el = xel;
    }
    public String getNomClasse()
    {
        return "Class " + this.el.getSimpleName()+"{";
    }

    public String getField()
    {
        String res = "";

       for (Element e : this.el.getEnclosedElements())
       {
           if (e.getKind().isField()) //VefrifPrimitif
           {
               res+=(e.getSimpleName().toString())+"\n";
           }

       }
       return res;
    }
    public String getEnd()
    {
        return "}";
    }
}
