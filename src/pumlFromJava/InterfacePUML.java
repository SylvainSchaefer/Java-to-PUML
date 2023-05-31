package pumlFromJava;

import javax.lang.model.element.Element;

public class InterfacePUML extends GeneralClassUML
{
    private Element el;

    public InterfacePUML(Element element)
    {
        super(element);
        //super(element);
    }
    @Override
    public String getNomClasse()
    {
        return "Interface " + getElement().toString()+"<<interface>> {";
    }

    @Override
    public String getBody()
    {
        return ""; // Les interfaces n'ont pas de corps dans un diagramme de classe
    }
}
