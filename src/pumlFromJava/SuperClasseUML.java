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


        return el.getSimpleName() +" ---|> "+superClasse.toString();
=======
        System.out.println(el.toString() +" ---|> "+superClasse.toString());
        if(isInternal(superClasse))
        {
            System.out.println("Passé: " + el.toString() +" ---|> "+superClasse.toString());
            return el.toString() +" ---|> "+superClasse.toString();
        }
        System.out.println("Pas passé: " + el.toString() +" ---|> "+superClasse.toString());
        return "";
>>>>>>> 9f5f5fa574a30b7222b9b923977647a73b88632a
    }


    public boolean isInternal(TypeMirror element)
    {
        for (Element e : el.getEnclosingElement().getEnclosedElements())//Classe -> Package -> Elements du package
        {
            if(e.asType() == element)
            {
                System.out.println(e.toString() + "|" + element.toString());
                return true;
            }
        }
        System.out.println("Non validé");
        return false;
    }

}
