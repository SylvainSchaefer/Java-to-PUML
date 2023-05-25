package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import java.util.ArrayList;

public class DCC {
    private ArrayList<Element> classes;

    public DCC(ArrayList<Element> Xcl)
    {
        classes = Xcl;
    }
    public static String getEn_tete()
    {
        return ("@startuml\n" +
                "'https://plantuml.com/class-diagram\n" +
                "skinparam style strictuml\n" +
                "skinparam classAttributeIconSize 0\n" +
                "skinparam classFontStyle Bold\n" +
                "hide empty members\n");
    }

    public static String getFin()
    {
        return ("@enduml\n");
    }

    public String getUML()
    {
        String uml = "";
        for (Element e : classes) {
            if(e.getKind() == ElementKind.CLASS)
            {
                ClassPUML c = new ClassPUML(e);
                uml += (c.getNomClasse()) + "\n";
                uml += (c.getField()) + "\n";

                Constructor constructor = new Constructor(e);
                uml += (constructor.getConstructors()) + "\n";

                uml += (c.getMethode()) + "\n";
                uml += (c.getEnd()) + "\n";
                uml += (c.getAssociations()) + "\n";
                SuperClasseUML sup = new SuperClasseUML(e);
                uml += (sup.getSuperClassName()) + "\n";

            }
            else if(e.getKind() == ElementKind.INTERFACE) {

                InterfacePUML i = new InterfacePUML(e);
                uml += (i.getNameI()) + "\n";
                uml += (i.getEnd()) + "\n";
            }
            else if (e.getKind() == ElementKind.ENUM)
            {
                EnumPUML en = new EnumPUML(e);
                uml += (en.getNameE()) + "\n";
                uml += (en.getConst()) + "\n";
                uml += (en.getEnd()) + "\n";
            }

        }
        return uml;
    }
}
