package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import java.util.ArrayList;
import java.util.List;

public class Constructor {
    private ExecutableElement constructorEl;
    private List<String> constructors = new ArrayList<>();
    Element el;

    public Constructor(Element xEl)
    {
        el = xEl;
    }

    public String getConstructors()
    {

        String res = "";

        for (Element element : this.el.getEnclosedElements())
        {
            if (element.getKind() == ElementKind.CONSTRUCTOR)
            {
                constructorEl = (ExecutableElement) element;
                String constructorSignature = getConstructorUML();
                constructors.add(constructorSignature);
            }
        }

        for (String construct : constructors)
        {
            res+= construct+"\n";
        }

        return res;
    }
    public String getConstructorUML()
    {
        Parameter parameter = new Parameter(constructorEl);

        String res = "";

        // Visibility modifier
        Visibility v = new Visibility(constructorEl);
        res += v.getVisibility() + "<<create>> ";

        // Nom du constructeur

        String nomConstructeur = constructorEl.getEnclosingElement().getSimpleName().toString();
        res += nomConstructeur+"(";

        res += parameter.getParametersUML();

        res+=")";

        return res;
    }
}
