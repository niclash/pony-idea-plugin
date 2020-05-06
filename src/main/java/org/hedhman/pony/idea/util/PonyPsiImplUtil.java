package org.hedhman.pony.idea.util;

import com.intellij.lang.ASTNode;
import org.hedhman.pony.idea.generated.parsing.PonyTypes;
import org.hedhman.pony.idea.generated.psi.PonyClassDef;
import org.hedhman.pony.idea.generated.psi.PonyMethod;

public class PonyPsiImplUtil
{
    public static String getClassDef( PonyClassDef element )
    {
        ASTNode classDefNode = element.getNode().findChildByType( PonyTypes.CLASS_DEF );
        if( classDefNode != null )
        {
            return classDefNode.getText();
        }
        else
        {
            return null;
        }
    }

    public static String getMethod( PonyMethod element )
    {
        ASTNode methodNode = element.getNode().findChildByType( PonyTypes.METHOD );
        if( methodNode != null )
        {
            return methodNode.getText();
        }
        else
        {
            return null;
        }
    }
}
