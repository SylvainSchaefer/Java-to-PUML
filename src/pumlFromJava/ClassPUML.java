package pumlFromJava;

import javax.lang.model.element.*;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import java.util.*;


public class ClassPUML extends GeneralClassUML
{

    private Element el;

    public ClassPUML(Element xel)
    {
        el = xel;
        //super(xel);
    }
    @Override
    public String getNomClasse()
    {
        //if (this.el.getKind() == TypeElement.class)
        return "Class " + this.el.toString()+"{";
    }

    public String getBody()
    {
        String res = "";

        Constructor constructor = new Constructor(el);
        res += constructor.getConstructors();

        for (Element enclosedElement : el.getEnclosedElements())
        {
            if (enclosedElement.getKind() == ElementKind.FIELD)
            {
                FieldUML field = new FieldUML(enclosedElement);
                res += field.toString() + "\n";
            }
            else if (enclosedElement.getKind() == ElementKind.METHOD)
            {
                MethodeUML method = new MethodeUML(enclosedElement);
                res += method.toString() + "\n";
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



}
