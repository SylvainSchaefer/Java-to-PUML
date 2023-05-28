package pumlFromJava;

import javax.lang.model.element.*;
import javax.lang.model.type.TypeMirror;
import java.util.List;

public class MethodeUML
{
    private ExecutableElement methodElement;

    public MethodeUML(Element element)
    {
        /*if (element.getKind() != ElementKind.METHOD) {
            throw new IllegalArgumentException("Element is not a method");
        }*/
        this.methodElement = (ExecutableElement) element;
    }


    public String getName() {
        return methodElement.getSimpleName().toString();
    }

    public String getReturnType() {
        TypeMirror returnType = methodElement.getReturnType();
        return returnType.toString();
    }

    public List<? extends VariableElement> getParameters() {
        return methodElement.getParameters();
    }

    public boolean isAbstract()
    {
        return methodElement.getModifiers().contains(Modifier.ABSTRACT);
    }

    public boolean isStatic() {
        return methodElement.getModifiers().contains(Modifier.STATIC);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        // Modificateurs
        if (isAbstract()) {
            builder.append("abstract ");
        }
        if (isStatic()) {
            builder.append("static ");
        }
        builder.append(methodElement.getModifiers().toString());
        builder.append(" ");

        // Nom de la méthode
        builder.append(getName());
        builder.append("(");

        // Paramètres
        List<? extends VariableElement> parameters = getParameters();
        for (int i = 0; i < parameters.size(); i++) {
            VariableElement parameter = parameters.get(i);
            TypeMirror parameterType = parameter.asType();
            builder.append(parameter.getSimpleName().toString());
            Type type = new Type(parameterType);
            builder.append(type.getType());

            if (i < parameters.size() - 1) {
                builder.append(", ");
            }
        }

        builder.append(")");

        // Type de retour
        TypeMirror returnType = methodElement.getReturnType();
        if (!returnType.toString().equals("void")) {
            Type type = new Type(returnType);
            builder.append(type.getType());
        }

        return builder.toString();
    }
}
