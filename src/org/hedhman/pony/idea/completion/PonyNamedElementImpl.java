package org.hedhman.pony.idea.completion;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public abstract class PonyNamedElementImpl extends ASTWrapperPsiElement
    implements PonyNamedElement
{
    public PonyNamedElementImpl( @NotNull ASTNode node )
    {
        super( node );
    }
}
