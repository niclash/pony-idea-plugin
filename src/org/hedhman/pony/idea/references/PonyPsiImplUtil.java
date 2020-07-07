package org.hedhman.pony.idea.references;

import com.intellij.lang.ASTNode;
import com.intellij.lang.DefaultASTFactoryImpl;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import org.hedhman.pony.idea.generated.parsing.PonyTypes;
import org.hedhman.pony.idea.generated.psi.PonyAtom;
import org.hedhman.pony.idea.generated.psi.PonyCallsite;
import org.hedhman.pony.idea.generated.psi.PonyClassDef;
import org.hedhman.pony.idea.generated.psi.PonyFieldDecl;
import org.hedhman.pony.idea.generated.psi.PonyMethodDecl;
import org.hedhman.pony.idea.generated.psi.PonyNextatom;

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

    public static String getMethod( PonyMethodDecl element )
    {
        ASTNode methodNode = element.getNode();
        if( methodNode != null )
        {
            return methodNode.getText();
        }
        return null;
    }

    public static String getMethodType( PonyMethodDecl element )
    {
        ASTNode methodTypeNode = element.getMethodType().getNode();
        if( methodTypeNode != null )
        {
            return methodTypeNode.getText();
        }
        return null;
    }

    public static String getField( PonyFieldDecl element )
    {
        ASTNode fieldNode = element.getNode();
        if( fieldNode != null )
        {
            return fieldNode.getText();
        }
        return null;
    }

    public static String getFieldType( PonyFieldDecl element )
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
        ASTNode newClassName = new DefaultASTFactoryImpl().createLeaf( PonyTypes.CLASS_NAME, newName );
        element.getNode().replaceChild( oldClassNameNode, newClassName );
        return element;
    }

    public static PsiElement getNameIdentifier( PonyClassDef element )
    {
        ASTNode keyNode = element.getClassName().getNode();
        if( keyNode != null )
        {
            return keyNode.getPsi();
        }
        else
        {
            return null;
        }
    }

    public static String getMethodDecl(PonyMethodDecl method)
    {
        ASTNode methodNameNode = method.getMethodName().getNode();
        if( methodNameNode != null )
        {
            return methodNameNode.getText();
        }
        return null;
    }

    public static PsiElement setName( PonyMethodDecl element, String newName )
    {
        ASTNode oldClassNameNode = element.getMethodName().getNode();
        ASTNode newMethodName = new DefaultASTFactoryImpl().createLeaf( PonyTypes.METHOD_NAME, newName );
        element.getNode().replaceChild( oldClassNameNode, newMethodName );
        return element;
    }

    public static PsiElement getNameIdentifier( PonyMethodDecl element )
    {
        ASTNode keyNode = element.getMethodName().getNode();
        if( keyNode != null )
        {
            return keyNode.getPsi();
        }
        else
        {
            return null;
        }
    }


    public static String getFieldDecl(PonyFieldDecl field)
    {
        ASTNode fieldName = field.getFieldName().getNode();
        if( fieldName != null )
        {
            return fieldName.getText();
        }
        return null;
    }

    public static PsiElement setName( PonyFieldDecl element, String newName )
    {
        ASTNode oldClassNameNode = element.getFieldName().getNode();
        ASTNode newMethodName = new DefaultASTFactoryImpl().createLeaf( PonyTypes.FIELD_NAME, newName );
        element.getNode().replaceChild( oldClassNameNode, newMethodName );
        return element;
    }

    public static PsiElement getNameIdentifier( PonyFieldDecl element )
    {
        ASTNode keyNode = element.getFieldName().getNode();
        if( keyNode != null )
        {
            return keyNode.getPsi();
        }
        else
        {
            return null;
        }
    }

    public static PsiReference getReference( PonyCallsite callsite )
    {
        PsiElement parent = callsite.getParent();
        if( parent instanceof PonyNextatom )
        {
            PonyNextatom atom = (PonyNextatom) parent;
        }
        if( parent instanceof PonyAtom )
        {
            PonyAtom atom = (PonyAtom) parent;
        }
        return null;
    }
}
