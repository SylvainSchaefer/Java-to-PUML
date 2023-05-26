package pumlFromJava;

import javax.lang.model.element.Element;

public abstract class GeneralClassUML
{
    /*private Element el;

    public GeneralClassUML(Element el)
    {
        this.el = el;
    }*/


    public abstract String getNomClasse();

    public String getEnd()
    {
        return "}";
    }

    public abstract String getBody();

    //public abstract String  getField();

    //public abstract String getFieldDCA();

    //public abstract String  getAssociations();

    //public abstract String getMethode();


}
