package org.hedhman.pony.idea.formatter;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.Block;
import com.intellij.formatting.BlockEx;
import com.intellij.formatting.Indent;
import com.intellij.formatting.Spacing;
import com.intellij.formatting.SpacingBuilder;
import com.intellij.formatting.Wrap;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.psi.formatter.common.AbstractBlock;
import org.hedhman.pony.idea.PonyLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractPonyBlock extends AbstractBlock
    implements BlockEx
{
    protected final SpacingBuilder spacingBuilder;

    protected AbstractPonyBlock( @NotNull ASTNode node, @Nullable Wrap wrap, @Nullable Alignment alignment, SpacingBuilder spacingBuilder )
    {
        super( node, wrap, alignment );
        this.spacingBuilder = spacingBuilder;
    }

    @Nullable
    @Override
    public Language getLanguage()
    {
        return PonyLanguage.INSTANCE;
    }

    @Nullable
    @Override
    public Spacing getSpacing( @Nullable Block child1, @NotNull Block child2 )
    {
        return null;
//        return spacingBuilder.getSpacing( this, child1, child2 );
    }

    @Override
    public boolean isLeaf()
    {
        return myNode.getFirstChildNode() == null;
    }

    protected boolean isNotIndentable()
    {
        if( myNode.getText().trim().length() == 0 )
        {
            return true;
        }
        return false;
    }

    @Override
    public Indent getIndent()
    {
        return null;
    }

    @Nullable
    @Override
    public String getDebugName()
    {
        String simpleName = getClass().getSimpleName();
        String name = simpleName.substring( 4, simpleName.length() - 5 );
        return name;
    }
}
