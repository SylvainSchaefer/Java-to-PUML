package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import java.util.ArrayList;

public class DCC implements DC{
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

    public String getUML(OptionRel optionRel)
    {
        String uml = "";
        for (Element e : classes) {
            if(e.getKind() == ElementKind.CLASS)
            {
                ClassPUML c = new ClassPUML(e);
                //SuperClasseUML sup = new SuperClasseUML(e);

                uml += (c.getNomClasse())+ "\n";

                uml += (c.getBody())+ "\n";
                uml += (c.getEnd()+ "\n");
                uml+=(c.getImplementations()+"\n");
                if(optionRel.isAll())
                {
                    uml += (c.getAssociationsAllRel()+ "\n");
                }
                else
                {
                    uml += (c.getAssociations()+ "\n");
                }

                uml += (c.getSuperClassName()+ "\n");

            }
            else if(e.getKind() == ElementKind.INTERFACE) {

                InterfacePUML i = new InterfacePUML(e);
                uml += (i.getNomClasse()+ "\n");
                uml += (i.getBody())+ "\n";
                uml += (i.getEnd())+ "\n";
                uml += (i.getSuperInterfacesName()+ "\n");
            }
            else if (e.getKind() == ElementKind.ENUM)
            {
                EnumPUML en = new EnumPUML(e);
                uml += (en.getNomClasse()) + "\n";
                uml += (en.getBody())+ "\n";
                //uml += (en.getConst()) + "\n";
                uml += (en.getEnd()) + "\n";
            }

        }
        return uml;
    }



}
