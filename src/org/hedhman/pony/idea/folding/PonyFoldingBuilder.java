package org.hedhman.pony.idea.folding;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.FoldingGroup;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hedhman.pony.idea.generated.psi.PonyClassDef;
import org.hedhman.pony.idea.generated.psi.PonyDocString;
import org.hedhman.pony.idea.generated.psi.PonyLambdaDecl;
import org.hedhman.pony.idea.generated.psi.PonyMethodBodyDecl;
import org.hedhman.pony.idea.generated.psi.PonyMethodDecl;
import org.hedhman.pony.idea.generated.psi.PonyObjectDecl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PonyFoldingBuilder extends FoldingBuilderEx
    implements DumbAware
{

    private static final String FOLDING_CLASS = "c:";
    private static final String FOLDING_METHOD = "m:";
    private static final String FOLDING_LOCATION = "l:";

    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions( @NotNull PsiElement root, @NotNull Document document, boolean quick )
    {
        List<FoldingDescriptor> descriptors = new ArrayList<>();
        buildClassRegions( root, descriptors );
        buildObjectRegions( root, descriptors );
        buildMethodRegions( root, descriptors );
        buildLambdaRegions( root, descriptors );
        return descriptors.toArray( new FoldingDescriptor[ 0 ] );
    }

    private void buildClassRegions( @NotNull PsiElement root, List<FoldingDescriptor> descriptors )
    {
        Collection<PonyClassDef> classDefs = PsiTreeUtil.findChildrenOfType( root, PonyClassDef.class );
        for( final PonyClassDef decl : classDefs )
        {
            TextRange textRange = decl.getTextRange();
            String classname = decl.getClassName().getId().getText();
            FoldingGroup methodGroup = FoldingGroup.newGroup( FOLDING_CLASS + classname );
            descriptors.add( new FoldingDescriptor( decl.getNode(), textRange, methodGroup ) );
        }
    }

    private void buildObjectRegions( @NotNull PsiElement root, List<FoldingDescriptor> descriptors )
    {
        Collection<PonyObjectDecl> objectDecls = PsiTreeUtil.findChildrenOfType( root, PonyObjectDecl.class );
        for( final PonyObjectDecl decl : objectDecls )
        {
            TextRange textRange = decl.getTextRange();
            FoldingGroup methodGroup = FoldingGroup.newGroup( FOLDING_LOCATION + textRange.getStartOffset() + "." + textRange.getEndOffset() );
            descriptors.add( new FoldingDescriptor( decl.getNode(), textRange, methodGroup ) );
        }
    }

    private void buildMethodRegions( @NotNull PsiElement root, List<FoldingDescriptor> descriptors )
    {
        Collection<PonyMethodDecl> methodDecls = PsiTreeUtil.findChildrenOfType( root, PonyMethodDecl.class );
        for( final PonyMethodDecl decl : methodDecls )
        {
            FoldingGroup methodGroup = FoldingGroup.newGroup( FOLDING_METHOD + decl.getMethodName().getId().getText() );
            TextRange textRange = decl.getTextRange();
            descriptors.add( new FoldingDescriptor( decl.getNode(), textRange, methodGroup ) );
        }
    }

    private void buildLambdaRegions( @NotNull PsiElement root, List<FoldingDescriptor> descriptors )
    {
        Collection<PonyLambdaDecl> lambdaDecls = PsiTreeUtil.findChildrenOfType( root, PonyLambdaDecl.class );
        for( final PonyLambdaDecl decl : lambdaDecls )
        {
            TextRange textRange = decl.getTextRange();
            FoldingGroup methodGroup = FoldingGroup.newGroup( FOLDING_LOCATION + textRange.getStartOffset() + "." + textRange.getEndOffset() );
            descriptors.add( new FoldingDescriptor( decl.getNode(), textRange, methodGroup ) );
        }
    }

    @Nullable
    @Override
    public String getPlaceholderText( @NotNull ASTNode node )
    {
        PsiElement psi = node.getPsi();
        if( psi instanceof PonyMethodDecl )
        {
            return foldedMethodReplacement( (PonyMethodDecl) psi );
        }
        if( psi instanceof PonyLambdaDecl )
        {
            return foldedLambdaReplacement( (PonyLambdaDecl) psi );
        }
        if( psi instanceof PonyClassDef )
        {
            return foldedClassReplacement( (PonyClassDef) psi );
        }
        if( psi instanceof PonyObjectDecl )
        {
            return foldedObjectReplacement( (PonyObjectDecl) psi );
        }
        return "...";
    }

    private String foldedClassReplacement( PonyClassDef psi )
    {
        int start = psi.getTextRange().getStartOffset();
        PonyDocString docString = psi.getDocString();
        int end;
        if( docString != null )
        {
            end = docString.getTextRange().getStartOffset();
        }
        else
        {
            end = psi.getMembers().getTextRange().getStartOffset();
        }
        String replacement = "...";
// TODO: I would prefer the following replacement, but "\n" is filtered out and all methods are placed on a single line.
//        Collection<PonyMethodDecl> methodDecls = PsiTreeUtil.findChildrenOfType( psi, PonyMethodDecl.class );
//        StringBuilder b = new StringBuilder();
//        for( PonyMethodDecl m : methodDecls )
//        {
//            b.append( "\n" );
//            b.append( foldedMethodReplacement( m ) );
//        }
//        String replacement = b.toString();
        return psi.getText().substring( 0, end - start ).trim() + replacement;
    }

    private String foldedObjectReplacement( PonyObjectDecl psi )
    {
        int start = psi.getTextRange().getStartOffset();
        int end = psi.getMembers().getTextRange().getStartOffset();
        return psi.getText().substring( 0, end - start ).trim() + " ... end";
    }

    @NotNull
    private String foldedMethodReplacement( PonyMethodDecl method )
    {
        int start = method.getTextRange().getStartOffset();
        PonyDocString docString = method.getDocString();
        PonyMethodBodyDecl bodyDecl = method.getMethodBodyDecl();
        int end;
        if( docString != null )
        {
            end = docString.getTextRange().getStartOffset();
        }
        else if( bodyDecl != null )
        {
            end = bodyDecl.getMethodBody().getTextRange().getStartOffset();
        }
        else
        {
            end = method.getTextRange().getStartOffset();
        }
        int length = end - start;
        return method.getText().substring( 0, length ).trim() + " ...";
    }

    @NotNull
    private String foldedLambdaReplacement( PonyLambdaDecl lambda )
    {
        int start = lambda.getTextRange().getStartOffset();
        int end = lambda.getRawseq().getTextRange().getStartOffset();
        return lambda.getText().substring( 0, end - start ).trim() + " ... }";
    }

    @Override
    public boolean isCollapsedByDefault( @NotNull ASTNode node )
    {
        return false;
    }
}
