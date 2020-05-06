package org.hedhman.pony.idea.util;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.hedhman.pony.idea.PonyFile;
import org.hedhman.pony.idea.PonyFileType;
import org.hedhman.pony.idea.generated.psi.PonyClassDef;

public class PonyUtils
{

    public static List<PonyClassDef> findClassDefs( Project project, String key )
    {
        List<PonyClassDef> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
            FileTypeIndex.getFiles( PonyFileType.PonySource, GlobalSearchScope.allScope( project ) );
        for( VirtualFile virtualFile : virtualFiles )
        {
            PonyFile simpleFile = (PonyFile) PsiManager.getInstance( project ).findFile( virtualFile );
            if( simpleFile != null )
            {
                PonyClassDef[] classDefs = PsiTreeUtil.getChildrenOfType( simpleFile, PonyClassDef.class );
                if( classDefs != null )
                {
                    for( PonyClassDef classDef : classDefs )
                    {
                        if( key.equals( classDef.getClassName().getText() ) )
                        {
                            result.add( classDef );
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<PonyClassDef> findClassDefs( Project project )
    {
        List<PonyClassDef> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
            FileTypeIndex.getFiles( PonyFileType.PonySource, GlobalSearchScope.allScope( project ) );
        for( VirtualFile virtualFile : virtualFiles )
        {
            PonyFile simpleFile = (PonyFile) PsiManager.getInstance( project ).findFile( virtualFile );
            if( simpleFile != null )
            {
                PonyClassDef[] classDefs = PsiTreeUtil.getChildrenOfType( simpleFile, PonyClassDef.class );
                if( classDefs != null )
                {
                    Collections.addAll( result, classDefs );
                }
            }
        }
        return result;
    }
}
