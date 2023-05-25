package pumlFromJava;

import com.sun.jdi.ClassType;
import jdk.jshell.Snippet;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

public class SuperClasseUML
{
    private Element el;

    public SuperClasseUML(Element e)
    {
        this.el = e;
    }

    public String getSuperClassName()
    {

        /*
        String superSimpleClassName = ((DeclaredType) superClassType).asElement().getSimpleName().toString();

        return superSimpleClassName;*/


        TypeElement typeElement = (TypeElement) this.el;
        TypeMirror superClasse = typeElement.getSuperclass();



<<<<<<< HEAD

        //return el.getSimpleName() +" ---|> "+superClasse.toString();


=======
        //return el.getSimpleName() +" ---|> "+superClasse.toString();
        //System.out.println(el.toString() +" ---|> "+superClasse.toString());
>>>>>>> bcc6c3b16541489229d1af834ccd5d28864f9cdf
        if(isInternal(superClasse))
        {

            return el.toString() +" ---|> "+superClasse.toString();
        }

        return "";
<<<<<<< HEAD

=======
>>>>>>> bcc6c3b16541489229d1af834ccd5d28864f9cdf
    }


    public boolean isInternal(TypeMirror element)
    {
        for (Element e : el.getEnclosingElement().getEnclosedElements())//Classe -> Package -> Elements du package
        {
            if(e.asType() == element)
            {

                return true;
            }
        }

        return false;
    }

}
