package org.hedhman.pony.idea.formatter;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.Block;
import com.intellij.formatting.SpacingBuilder;
import com.intellij.lang.ASTNode;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PonyDocStringBlock extends AbstractPonyBlock
{
    protected PonyDocStringBlock( @NotNull ASTNode node, @Nullable Alignment alignment, SpacingBuilder spacingBuilder )
    {
        super( node, null, Alignments.expression, spacingBuilder );
    }

    @Override
    protected List<Block> buildChildren()
    {
        List<Block> blocks = new ArrayList<>();
        ASTNode child = myNode.getFirstChildNode();
        while( child != null )
        {
            Block block = new PonyTokenBlock( child, getAlignment(), spacingBuilder );
            blocks.add( block );
            child = child.getTreeNext();
        }
        return blocks;
    }
}
