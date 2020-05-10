package org.hedhman.pony.idea.formatter;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.Block;
import com.intellij.formatting.Indent;
import com.intellij.formatting.Spacing;
import com.intellij.formatting.SpacingBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.psi.formatter.common.AbstractBlock;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PonyPartialOpBlock extends AbstractBlock
    implements Block
{
    public PonyPartialOpBlock( @NotNull ASTNode node, @Nullable Alignment alignment, SpacingBuilder spacingBuilder )
    {
        super( node, null, alignment );
    }

    protected List<Block> buildChildren()
    {
        return Collections.emptyList();
    }

    @Override
    public Indent getIndent()
    {
        return Indent.getNoneIndent();
    }

    @Nullable
    @Override
    public Spacing getSpacing( @Nullable Block child1, @NotNull Block child2 )
    {
        return null;
    }

    @Override
    public boolean isLeaf()
    {
        return myNode.getFirstChildNode() == null;
    }
}
