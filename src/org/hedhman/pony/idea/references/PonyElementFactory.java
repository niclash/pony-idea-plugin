package org.hedhman.pony.idea.references;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;
import org.hedhman.pony.idea.PonyFile;
import org.hedhman.pony.idea.PonyFileType;
import org.hedhman.pony.idea.generated.psi.PonyClassDef;

public class PonyElementFactory
{
    public static PonyClassDef createClass( Project project, String name )
    {
        final PonyFile file = createFile( project, "class " + name );
        return (PonyClassDef) file.getFirstChild();
    }

    public static PonyFile createFile( Project project, String text )
    {
        String name = find( text, "actor", "class", "interface", "trait", "primitive", "struct", "type" );
        if( name == null )
        {
            name = "new-file";
        }
        return (PonyFile) PsiFileFactory.getInstance( project ).
            createFileFromText( name, PonyFileType.PonySource, text );
    }

    private static String find( String text, String... search )
    {
        int minPos = Integer.MAX_VALUE;
        int length = 0;
        for( String candidate : search )
        {
            int pos = text.indexOf( candidate );
            if( pos > 0 && pos < minPos )
            {
                minPos = pos;
                length = text.length();
            }
        }

        if( minPos == Integer.MAX_VALUE )
        {
            return null;
        }

        int posSpace1 = minPos + length + 1;
        int posSpace2 = text.indexOf( ' ', posSpace1 + 1 );
        String name;
        if( posSpace2 < 0 )
        {
            name = text.substring( posSpace1 );
        }
        else
        {
            name = text.substring( posSpace1, posSpace2 );
        }
        return name;
    }
}
