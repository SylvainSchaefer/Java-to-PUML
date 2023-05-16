package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class ClassPUML
{

    private Element el;

    public ClassPUML(Element xel)
    {
        this.el = xel;
    }
    public String getNomClasse()
    {
        //if (this.el.getKind() == TypeElement.class)
        return "Class " + this.el.getSimpleName()+"{";
    }

    public String getField()
    {
        String res = "";

       for (Element e : this.el.getEnclosedElements())
       {
           if (e.getKind() == ElementKind.FIELD) //Vefrif Si argument
           {
               TypeMirror fieldType = e.asType();
               if (fieldType.getKind().isPrimitive())//VefrifPrimitif
               {
                   res+= this.getVisibility(e)+(e.getSimpleName().toString())+"\n";
               }
           }

       }
       return res;
    }
    public String getEnd()
    {
        return "}";
    }

    public String getType(Element e)
    {
        return e.asType().toString();
    }

    private String getVisibility(Element element)
    {
        String res = "";

        String modifier = element.getModifiers().toString().toLowerCase();
        System.out.println(modifier+"test");
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
