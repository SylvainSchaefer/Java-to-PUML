package pumlFromJava;

import javax.lang.model.element.*;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import java.util.*;


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
        return "Class " + this.el.toString()+"{";
    }

    public String getField()
    {
        String res = "";

       for (Element e : this.el.getEnclosedElements())
       {
           if (isPrimitive(e)) //Verif Si argument
           {
               TypeMirror fieldType = e.asType();
               if (fieldType.getKind().isPrimitive())//VefrifPrimitif
               {
                   Visibility v = new Visibility(e);
                   Type type = new Type(e);
                   res += (v.getVisibility()+e.getSimpleName().toString()) + type.getType() + "\n";
                   //res+= this.getVisibility(e)+(e.getSimpleName().toString())+ ": " + fieldType + "\n";
               }
           }

       }
       return res;
    }

    public String getFieldDCA()
    {
        String res = "";

        for (Element e : this.el.getEnclosedElements())
        {
            if (isPrimitive(e)) //Verif Si argument
            {
                TypeMirror fieldType = e.asType();
                if (fieldType.getKind().isPrimitive())//VefrifPrimitif
                {
                    res += (e.getSimpleName().toString()) + "\n";
                    //res+= this.getVisibility(e)+(e.getSimpleName().toString())+ ": " + fieldType + "\n";
                }
            }

        }
        return res;
    }


    public String getAssociations()
    {
        String res = "";
        for (Element e : this.el.getEnclosedElements())
        {
            if (e.getKind() == ElementKind.FIELD)
            {
                if (!isPrimitive(e))
                {
                    TypeMirror fieldType = e.asType();
                    if (fieldType instanceof DeclaredType)
                    {
                        DeclaredType declaredType = (DeclaredType) fieldType;
                        List<? extends TypeMirror> typeArguments = declaredType.getTypeArguments();
                        if (!typeArguments.isEmpty())
                        {
                            TypeMirror typeArgument = typeArguments.get(0);
                            String className = typeArgument.toString();
                            res += (el.toString() + " - " + className) + "\n";
                        }
                        else
                        {
                            res += (el.toString() + " -- " + fieldType.toString()) + "\n";
                        }
                    }
                }
            }
        }
        System.out.println(res);
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






    public String getMethode()
    {
        String res = "";
        ExecutableElement xEl;

        for (Element e : this.el.getEnclosedElements()) {
            if (e.getKind() == ElementKind.METHOD)
            {
                Visibility v = new Visibility(e);
                res += v.getVisibility();

                xEl = (ExecutableElement) e;
                Type type = new Type(xEl);
                Parameter parameter = new Parameter(xEl);
                res += e.getSimpleName() + "("+ parameter.getParametersUML() + ")";

                String returnType = e.asType().toString();
                if (!returnType.toLowerCase().contains("void"))
                {
                    res += type.getType();
                }
                res += "\n";
            }
        }

        return res;
    }






}
