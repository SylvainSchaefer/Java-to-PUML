package pumlFromJava;

import javax.lang.model.element.Element;

public class InterfacePUML extends GeneralClassUML
{
    private Element el;

    public InterfacePUML(Element element)
    {
        el = element;
        //super(element);
    }
    @Override
    public String getNomClasse()
    {
        return "Interface " + el.toString()+"<<interface>> {";
    }

    @Override
    public String getBody()
    {
        return ""; // Les interfaces n'ont pas de corps dans un diagramme de classe
    }
}
