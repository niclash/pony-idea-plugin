package org.hedhman.pony.idea.completion;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import org.hedhman.pony.idea.util.PonyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class PonyNamedElementImpl extends ASTWrapperPsiElement
    implements PonyNamedElement
{
    public PonyNamedElementImpl( @NotNull ASTNode node )
    {
        super( node );
    }
}
