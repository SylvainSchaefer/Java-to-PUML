package pumlFromJava;

import javax.lang.model.element.Element;

public class EnumPUML
{
    public String getName(Element el)
    {
        return "Enum " + el.getSimpleName();
    }
}
