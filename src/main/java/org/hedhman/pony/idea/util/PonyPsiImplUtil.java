package org.hedhman.pony.idea.util;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.hedhman.pony.idea.references.PonyElementFactory;
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

    public static String getClassName( PonyClassDef element )
    {
        ASTNode classNameNode = element.getClassName().getNode();
        if( classNameNode != null )
        {
            return classNameNode.getText();
        }
        return null;
    }

    public static PsiElement setName( PonyClassDef element, String newName )
    {
        ASTNode oldClassNameNode = element.getClassName().getNode();
        PonyClassDef classDef = PonyElementFactory.createClass( element.getProject(), newName );
        ASTNode newClassNameNode = classDef.getClassName().getNode();
        element.getNode().replaceChild( oldClassNameNode, newClassNameNode );
        return element;
    }

    public static PsiElement getNameIdentifier( PonyClassDef element )
    {
        ASTNode keyNode = element.getNode();
        if( keyNode != null )
        {
            return keyNode.getPsi();
        }
        else
        {
            return null;
        }
    }
}
