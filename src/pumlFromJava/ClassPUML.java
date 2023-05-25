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
                   res += (getVisibility(e)+e.getSimpleName().toString()) + "\n";
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

    public String getMethode()
    {
        String res = "";
        ExecutableElement xEl;

        for (Element e : this.el.getEnclosedElements()) {
            if (e.getKind() == ElementKind.METHOD)
            {
                res += getVisibility(e);

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



    public String getConstructors()
    {
        List<String> constructors = new ArrayList<>();
        String res = "";

        for (Element element : this.el.getEnclosedElements())
        {
            if (element.getKind() == ElementKind.CONSTRUCTOR)
            {
                ExecutableElement constructorEl = (ExecutableElement) element;
                String constructorSignature = getConstructorUML(constructorEl);
                constructors.add(constructorSignature);
            }
        }

        for (String construct : constructors)
        {
            res+= construct+"\n";
        }

        return res;
    }

    private String getConstructorUML(ExecutableElement constructorEl)
    {
        Parameter parameter = new Parameter(constructorEl);

        String res = "";

        // Visibility modifier
        res += getVisibility(constructorEl) + "<<create>> ";

        // Nom du constructeur

        String nomConstructeur = constructorEl.getEnclosingElement().getSimpleName().toString();
        res += nomConstructeur+"(";

        res += parameter.getParametersUML();

        res+=")";

        return res;
    }
}
