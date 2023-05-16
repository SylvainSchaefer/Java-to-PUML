package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
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
        //if (this.el.getKind() == TypeElement.class)
        return "Class " + this.el.getSimpleName()+"{";
    }

    public String getField()
    {
        String res = "";

       for (Element e : this.el.getEnclosedElements())
       {
           if (isPrimitive(e)) //Vefrif Si argument
           {
               TypeMirror fieldType = e.asType();
               if (fieldType.getKind().isPrimitive())//VefrifPrimitif
               {
                   res+=(e.getSimpleName().toString())+"\n";
               }
           }

       }
       return res;
    }


    public String getAssociations()
    {
        String res = "";
        String res2 = "";
        for (Element e : this.el.getEnclosedElements())
        {
            if (e.getKind() == ElementKind.FIELD) //Vefrif Si argument
            {
                if (!isPrimitive(e))//Verif si non Primitif
                {
                    res += (el.toString() + " -> " + e.asType())+"\n";

                }

            }
            System.out.println("getAnnotation :" + res);

        }
        return res;
    }

    public boolean isPrimitive(Element e)
    {
        TypeMirror fieldType = e.asType();
        if(!fieldType.getKind().isPrimitive() && !(e.asType().toString().equals("java.lang.String")))
        {
            return false;
        }
        return true;
    }
    public String getEnd()
    {
        return "}";
    }

    public String getAssociationType()
    {
        String res = "";
        String associationType = getAssociationType(element);
        return res;
    }
}
