package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;

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
        /*String res = "";
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
            int indexLastPoint = e.asType().toString().lastIndexOf(".");
            if(indexLastPoint < indexLastParenthese)
            {
                res += e.asType().toString().substring(e.asType().toString().lastIndexOf(')') + 1);
            }
            else
            {
                res += e.asType().toString().substring(e.asType().toString().lastIndexOf('.') + 1);
            }
        }

        System.out.println("Test type : " + e.getSimpleName() + res);

        return res;*/


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

        return res;
    }
}
