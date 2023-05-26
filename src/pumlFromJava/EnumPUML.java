package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;

public class EnumPUML extends GeneralClassUML
{

    private Element el;

    public EnumPUML(Element xel)
    {
        super(xel);
    }
    @Override
    public String getNomClasse()
    {
        return "Enum " + el.toString()+"<<enum>> {";
    }

    @Override
    public String getBody() {
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


}
