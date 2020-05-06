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
        final PonyFile file = createFile( project, name );
        return (PonyClassDef) file.getFirstChild();
    }

    public static PonyFile createFile( Project project, String text )
    {
        String name = "dummy.simple";
        return (PonyFile) PsiFileFactory.getInstance( project ).
            createFileFromText( name, PonyFileType.PonySource, text );
    }
}
