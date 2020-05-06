package org.hedhman.pony.idea.util;

import com.intellij.lang.ASTNode;
import org.hedhman.pony.idea.generated.parsing.PonyTypes;
import org.hedhman.pony.idea.generated.psi.PonyClassDef;
import org.hedhman.pony.idea.generated.psi.PonyField;
import org.hedhman.pony.idea.generated.psi.PonyMethod;

// TODO: What is this really for? The default implementations work just without it.
public class PonyPsiImplUtil
{
    public static String getClassDef( PonyClassDef element )
    {
        ASTNode classDefNode = element.getNode();
        if( classDefNode != null )
        {
            return classDefNode.getText();
        }
        return null;
    }

    public static String getClassType( PonyClassDef element )
    {
        ASTNode classTypeNode = element.getClassType().getNode();
        if( classTypeNode != null )
        {
            return classTypeNode.getText();
        }
        return null;
    }

    public static String getMethod( PonyMethod element )
    {
        ASTNode methodNode = element.getNode();
        if( methodNode != null )
        {
            return methodNode.getText();
        }
        return null;
    }

    public static String getMethodType( PonyMethod element )
    {
        ASTNode methodTypeNode = element.getMethodType().getNode();
        if( methodTypeNode != null )
        {
            return methodTypeNode.getText();
        }
        return null;
    }
    public static String getField( PonyField element )
    {
        ASTNode fieldNode = element.getNode();
        if( fieldNode != null )
        {
            return fieldNode.getText();
        }
        return null;
    }

    public static String getFieldType( PonyField element )
    {
        ASTNode fieldTypeNode = element.getFieldType().getNode();
        if( fieldTypeNode != null )
        {
            return fieldTypeNode.getText();
        }
        return null;
    }
}
