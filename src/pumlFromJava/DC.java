package pumlFromJava;

public interface DC {
    static String getEn_tete()
    {
        return ("@startuml\n" +
                "'https://plantuml.com/class-diagram\n" +
                "skinparam style strictuml\n" +
                "skinparam classAttributeIconSize 0\n" +
                "skinparam classFontStyle Bold\n" +
                "hide empty members\n");
    }
    static String getFin()
    {
        return ("@enduml\n");
    }
    String getUML(OptionRel optionRel);
}
