package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;

public class EnumPUML
{

    private Element el;

    public EnumPUML(Element xel)
    {
        this.el = xel;
    }
    public String getNameE()
    {
        return "Enum " + el.toString()+"<<enum>> {";
    }

    public String getConst()
    {
        String res = "";

        for (Element e : this.el.getEnclosedElements())
        {
            if (e.getKind() == ElementKind.ENUM_CONSTANT)
            {
                res += e.getSimpleName().toString()+"\n";
            }
        }
        return res;
    }

    public String getEnd()
    {
        return "}";
    }
}
