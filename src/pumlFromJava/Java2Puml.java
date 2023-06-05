package pumlFromJava;

import java.util.spi.ToolProvider;

public class Java2Puml
{
    /*-private
-sourcepath
C:\Users\sylva\Documents\Cours\IUT\P21\p21\p21\P21_Western\src
-doclet
pumlFromJava.PumlDoclet
-docletpath
out/production/p21_projet
western
-out
DC_western
-d
C:\Users\sylva\Documents\Cours\IUT\P21\p21_projet\src\pumlFromJava
-dc
C*/


    /*
    -private
-sourcepath
src\
-doclet
pumlFromJava.PumlDoclet
-docletpath
out/production/p21_projet
pumlFromJava
-out
DC_projet
-d
C:\Users\sylva\Documents\Cours\IUT\P21\p21_projet\src\pumlFromJava
-dc
C
     */
    public static void main(String[] args)
    {
        ToolProvider toolProvider = ToolProvider.findFirst("javadoc").get();
        System.out.println(toolProvider.name());

/*
    javadoc -private -sourcepath <src> -doclet pumlFromJava.FirstDoclet -docletpath out/production/<projet>
      <package> ... <fichiers>
 */

        toolProvider.run(System.out, System.err, args);
    }
}
