package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.*;

public class Type {

    /*private Element e;

    public Type(Element xel)
    {
        this.e = xel;
    }*/

    private TypeMirror t;

    public Type(TypeMirror xT)
    {
        this.t = xT;
    }
    public String getType()
    {
        /*
        String res = "";
        res += ": " ;
        int indexLastParenthese = t.toString().lastIndexOf(")");
        int indexIndicateurList;
        if (t.toString().contains("<") && t.toString().contains(">"))
        {
            indexIndicateurList = t.toString().lastIndexOf(">");
            if(indexIndicateurList > indexLastParenthese)
            {
                String nomCollection = t.toString().substring(t.toString().lastIndexOf('.') + 1);
                System.out.println("nom collection : " + t.toString());
                nomCollection = nomCollection.substring(0, nomCollection.length() - 1);

                res += nomCollection + "[*]";
            }
            else
            {
                res += t.toString().substring(t.toString().lastIndexOf('.') + 1);
            }
        }
        else
        {
            int indexLastPoint = t.toString().lastIndexOf(".");
            if(indexLastPoint < indexLastParenthese)
            {
                res += t.toString().substring(t.toString().lastIndexOf(')') + 1);
            }
            else
            {
                res += t.toString().substring(t.toString().lastIndexOf('.') + 1);
            }
        }

        return res;*/



        String res = getSwitch();
        return res;


    }


    public String getSwitch()
    {
        String res = ": ";
        switch (t.getKind())
        {
            case INT, BYTE, LONG, SHORT -> res += "Integer";
            case FLOAT, DOUBLE -> res += "Real";
            case BOOLEAN -> res += "Boolean";
            case CHAR -> res += "String";
            //case UNION -> Type type = new Type(((UnionType)t).getAlternatives().get(0)).getSwitch();  res +=
            case DECLARED -> {
                res += ((DeclaredType)t).asElement().getSimpleName().toString() + "[*]";
            }
            default -> res += "void";
        }

        return res;
    }


}
