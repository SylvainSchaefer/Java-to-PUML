package pumlFromJava;

import javax.lang.model.element.Element;

public class InterfacePUML
{
    public String getName(Element el)
    {
        return "Interface " + el.getSimpleName();
    }
}
