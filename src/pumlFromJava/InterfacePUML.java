package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import java.util.List;

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
        String res = "";

        for (Element enclosedElement : getElement().getEnclosedElements())
        {

            if (enclosedElement.getKind() == ElementKind.METHOD)
            {
                MethodeUML method = new MethodeUML(enclosedElement);
                res += method.toString() + "\n";
            }
        }

        return res;
    }

    public String getSuperInterfacesName()
    {

        String res = "";


        TypeElement typeElement = (TypeElement) this.getElement();

        List<? extends TypeMirror> superInterfac = typeElement.getInterfaces();


        for ( TypeMirror t : superInterfac)
        {
            if(isInternal(t))
            {
                res+= getElement().toString() +" ---|> "+t.toString()+"\n";
            }
        }




        return res;



    }
}
