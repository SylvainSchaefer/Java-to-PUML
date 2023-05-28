package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import java.util.List;

public class Parameter
{
    private ExecutableElement constructorEl;
    public Parameter(ExecutableElement xEl)
    {
        this.constructorEl = xEl;
    }


    public String getParametersUML()
    {
        List<? extends Element> parameters = constructorEl.getParameters();
        String res = "";
        for (int i = 0; i < parameters.size(); i++)
        {
            Element parameter = parameters.get(i);
            Type type = new Type(parameter.asType());
            res+= parameter.getSimpleName() + type.getType();


            if (i < parameters.size() - 1)
            {
                res+=", ";
            }
        }

        return res;
    }

}
