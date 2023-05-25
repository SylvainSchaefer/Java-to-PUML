package pumlFromJava;

import javax.lang.model.element.*;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import java.lang.reflect.Field;
import java.util.*;
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


    public String getType(Element e)
    {
        String res = "";
        res += ": " ;
        int indexLastParenthese = e.asType().toString().lastIndexOf(")");
        int indexIndicateurList;
        if (e.asType().toString().contains("<") && e.asType().toString().contains(">"))
        {
            indexIndicateurList = e.asType().toString().lastIndexOf(">");
            if(indexIndicateurList > indexLastParenthese)
            {
                String nomCollection = e.asType().toString().substring(e.asType().toString().lastIndexOf('.') + 1);
                System.out.println("nom collection : " + e.asType().toString());
                nomCollection = nomCollection.substring(0, nomCollection.length() - 1);

                res += nomCollection + "[*]";
            }
            else
            {
                res += e.asType().toString().substring(e.asType().toString().lastIndexOf('.') + 1);
            }
        }
        else
        {
            res += e.asType().toString().substring(e.asType().toString().lastIndexOf('.') + 1);
        }

        return res;
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
                res += e.getSimpleName() + "("+ getParametersUML(xEl) + ")";

                String returnType = e.asType().toString();
                if (!returnType.toLowerCase().contains("void"))
                {
                    res += getType(e);
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


        String res = "";

        // Visibility modifier
        res += getVisibility(constructorEl) + "<<create>> ";

        // Nom du constructeur

        String nomConstructeur = constructorEl.getEnclosingElement().getSimpleName().toString();
        res += nomConstructeur+"(";

        res += getParametersUML(constructorEl);

        res+=")";

        return res;
    }


    public String getParametersUML(ExecutableElement constructorEl)
    {
        List<? extends Element> parameters = constructorEl.getParameters();
        String res = "";
        for (int i = 0; i < parameters.size(); i++)
        {
            Element parameter = parameters.get(i);

            res+= parameter.getSimpleName() + getType(parameter);


            if (i < parameters.size() - 1)
            {
                res+=", ";
            }
        }

        return res;
    }
}
