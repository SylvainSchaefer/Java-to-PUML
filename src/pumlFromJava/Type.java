package pumlFromJava;

import javax.lang.model.element.Element;

public class Type {

    private Element e;

    public Type(Element xel)
    {
        this.e = xel;
    }
    public String getType()
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
}
