package pumlFromJava;

import javax.lang.model.element.*;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import java.util.*;


public class ClassPUML extends GeneralClassUML
{

    public ClassPUML(Element xel)
    {
        //el = xel;
        super(xel);
        //super(xel);
    }
    @Override
    public String getNomClasse()
    {
        //if (this.el.getKind() == TypeElement.class)
        return "Class " + getElement().toString()+"{";
    }

    public String getBody()
    {
        String res = "";

        Constructor constructor = new Constructor(getElement());
        res += constructor.getConstructors();

        for (Element enclosedElement : getElement().getEnclosedElements())
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



    public String getBodyDCA()
    {
        String res = "";


        for (Element enclosedElement : getElement().getEnclosedElements())
        {
            if (enclosedElement.getKind() == ElementKind.FIELD)
            {
                FieldUML field = new FieldUML(enclosedElement);
                res += field.toStringDCA() + "\n";
            }
        }

        return res;
    }



    public String getAssociations()
    {
        String res = "";

        for (Element e : this.getElement().getEnclosedElements())
        {
            if (e.getKind() == ElementKind.FIELD)
            {
                if (!isPrimitive(e)) //&& isInternal(e.asType()))
                {
                    TypeMirror fieldType = e.asType();
                    if (fieldType.getKind() == TypeKind.DECLARED)
                    {
                        DeclaredType declaredType = (DeclaredType) fieldType;
                        List<? extends TypeMirror> typeArguments = declaredType.getTypeArguments();

                        FieldUML fieldUML = new FieldUML(e);
                        if (!typeArguments.isEmpty())
                        {
                            TypeMirror typeArgument = typeArguments.get(0);
                            if(isInternal(typeArgument))
                            {
                                String className = typeArgument.toString();
                                res += (getElement().toString() + " o--- " + '"' + fieldUML.getName() + '"' + className) + "\n";
                            }

                        }

                        else if(isInternal(e.asType()))
                        {
                            res += (getElement().toString() + " o-- " + '"' + fieldUML.getName() + '"' + fieldType.toString()) + "\n";
                        }
                    }
                }
            }
        }
        System.out.println(res);
        return res;
    }

    public String getImplementations()
    {
        StringBuilder res = new StringBuilder();

        TypeElement typeElement = (TypeElement) getElement();

        List<? extends TypeMirror> interfaces = typeElement.getInterfaces();

        for (TypeMirror interfaceType : interfaces) {
            if (isInternal(interfaceType)) {
                res.append(getElement().toString()).append(" ..|> ").append(interfaceType.toString()).append("\n");
            }
        }

        return res.toString();
    }


    public String getAssociationsAllRel()
    {
        String res = "";
        for (Element e : this.getElement().getEnclosedElements())
        {
            if (e.getKind() == ElementKind.FIELD)
            {
                if (!isPrimitive(e)) //&& isInternal(e.asType()))
                {
                    TypeMirror fieldType = e.asType();
                    if (fieldType.getKind() == TypeKind.DECLARED)
                    {
                        DeclaredType declaredType = (DeclaredType) fieldType;
                        List<? extends TypeMirror> typeArguments = declaredType.getTypeArguments();

                        FieldUML fieldUML = new FieldUML(e);
                        if (!typeArguments.isEmpty())
                        {
                            TypeMirror typeArgument = typeArguments.get(0);
                            if(isInternal(typeArgument))
                            {
                                String className = typeArgument.toString();
                                res += (getElement().toString() + " o--- " + '"' + fieldUML.getName() + '"' + className) + "\n";
                            }
                        }
                        else if(isInternal(e.asType()))
                        {
                            res += (getElement().toString() + " o-- " + '"' + fieldUML.getName() + '"' + fieldType.toString()) + "\n";
                        }
                    }
                }
            }
            else if(e.getKind() == ElementKind.METHOD)
            {
                ExecutableElement executableElement = (ExecutableElement)e;
                for (VariableElement parameter: executableElement.getParameters()) {
                    if(isInternal(parameter.asType()))
                    {
                        res += (getElement().toString() + " --> " + parameter.asType().toString()) + ": " + e.getSimpleName() + "\n";
                    }
                }
            }
        }
        System.out.println(res);
        return res;
    }



    public String getAssociationsDCA()
    {
        String res = "";
        for (Element e : this.getElement().getEnclosedElements())
        {
            if (e.getKind() == ElementKind.FIELD)
            {
                if (!isPrimitive(e)) //&& isInternal(e.asType()))
                {
                    TypeMirror fieldType = e.asType();
                    if (fieldType.getKind() == TypeKind.DECLARED)
                    {
                        DeclaredType declaredType = (DeclaredType) fieldType;
                        List<? extends TypeMirror> typeArguments = declaredType.getTypeArguments();

                        FieldUML fieldUML = new FieldUML(e);
                        if (!typeArguments.isEmpty())
                        {
                            TypeMirror typeArgument = typeArguments.get(0);
                            if(isInternal(typeArgument))
                            {
                                String className = typeArgument.toString();
                                res += (getElement().toString() + " o--- " + '"' + fieldUML.getName() + '"' + className) + "\n";
                            }
                            //String className = typeArgument.toString();
                            //res += (getElement().toString() + " --- " + '"' + fieldUML.getName() + '"' + className) + "\n";
                        }
                        else if(isInternal(e.asType()))
                        {
                            res += (getElement().toString() + " -- " + '"' + fieldUML.getName() + '"' + fieldType.toString()) + "\n";
                        }
                    }
                }
            }
        }
        System.out.println(res);
        return res;
    }

    public String getAssociationsDCA_AllRel()
    {
        String res = "";
        for (Element e : this.getElement().getEnclosedElements())
        {
            if (e.getKind() == ElementKind.FIELD)
            {
                if (!isPrimitive(e)) //&& isInternal(e.asType()))
                {
                    TypeMirror fieldType = e.asType();
                    if (fieldType.getKind() == TypeKind.DECLARED)
                    {
                        DeclaredType declaredType = (DeclaredType) fieldType;
                        List<? extends TypeMirror> typeArguments = declaredType.getTypeArguments();

                        FieldUML fieldUML = new FieldUML(e);
                        if (!typeArguments.isEmpty())
                        {
                            TypeMirror typeArgument = typeArguments.get(0);
                            if(isInternal(typeArgument))
                            {
                                String className = typeArgument.toString();
                                res += (getElement().toString() + " o--- " + '"' + fieldUML.getName() + '"' + className) + "\n";
                            }
                            //String className = typeArgument.toString();
                            //res += (getElement().toString() + " --- " + '"' + fieldUML.getName() + '"' + className) + "\n";
                        }
                        else if(isInternal(e.asType()))
                        {
                            res += (getElement().toString() + " -- " + '"' + fieldUML.getName() + '"' + fieldType.toString()) + "\n";
                        }
                    }
                }
            }
            else if(e.getKind() == ElementKind.METHOD)
            {
                ExecutableElement executableElement = (ExecutableElement)e;
                for (VariableElement parameter: executableElement.getParameters()) {
                    if(isInternal(parameter.asType()))
                    {
                        res += (getElement().toString() + " ----- " + parameter.asType().toString()) + ": " + e.getSimpleName() + "\n";
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

    public String getSuperClassName()
    {




        TypeElement typeElement = (TypeElement) this.getElement();
        TypeMirror superClasse = typeElement.getSuperclass();


        if(isInternal(superClasse))
        {

            return getElement().toString() +" ---|> "+superClasse.toString();
        }

        return "";

    }


    public String getEnd()
    {
        return "}";
    }



}
