package pumlFromJava;

import javax.lang.model.element.Element;

public class InterfacePUML
{
    private Element el;

    public InterfacePUML(Element xel)
    {
        this.el = xel;
    }

    public String getNameI()
    {
        return "Interface " + el.toString()+"<<interface>> {";
    }

    public String getEnd()
    {
        return "}";
    }
}
