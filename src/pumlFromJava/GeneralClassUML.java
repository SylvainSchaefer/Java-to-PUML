package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;

public abstract class GeneralClassUML
{
    private Element el;

    public GeneralClassUML(Element el)
    {
        this.el = el;
    }


    public abstract String getNomClasse();



    public String getEnd()
    {
        return "}";
    }

    public boolean isInternal(TypeMirror element)
    {
        for (Element e : el.getEnclosingElement().getEnclosedElements())//Classe -> Package -> Elements du package
        {
            if(e.asType() == element)
            {
                return true;
            }
        }

        return false;
    }

    public abstract String getBody();

    public Element getElement()
    {
        return this.el;
    }

    //public abstract String  getField();

    //public abstract String getFieldDCA();

    //public abstract String  getAssociations();

    //public abstract String getMethode();


}
