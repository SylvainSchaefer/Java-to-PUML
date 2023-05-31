package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;

public class FieldUML
{
    private VariableElement fieldElement;

    public FieldUML(Element element)
    {

        this.fieldElement = (VariableElement) element;
    }

    public String getName()
    {
        return fieldElement.getSimpleName().toString();
    }

    public String getType() {
        TypeMirror fieldType = fieldElement.asType();
        Type type = new Type(fieldType);
        return type.getType();

    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        // Modifier
        ModifierPUML modifierPUML = new ModifierPUML((Element) fieldElement);
        builder.append(modifierPUML.getModifier());

        // Nom du champ
        builder.append(getName());

        // Type du champ
        builder.append(getType());

        return builder.toString();
    }
}
// Type declaré = agregation
// SWITCH DS getField pour les primitif UML int,byte , short --> Integer etc..