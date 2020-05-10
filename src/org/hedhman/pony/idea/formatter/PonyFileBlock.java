package org.hedhman.pony.idea.formatter;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.Block;
import com.intellij.formatting.Indent;
import com.intellij.formatting.Spacing;
import com.intellij.formatting.SpacingBuilder;
import com.intellij.formatting.Wrap;
import com.intellij.lang.ASTNode;
import com.intellij.psi.formatter.common.AbstractBlock;
import java.util.ArrayList;
import java.util.List;
import org.hedhman.pony.idea.generated.parsing.PonyTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.hedhman.pony.idea.formatter.PonyFormattingModelBuilder.handleCommentBlock;

public class PonyFileBlock extends AbstractBlock
{
    private final SpacingBuilder spacingBuilder;

    protected PonyFileBlock( @NotNull ASTNode node,@Nullable Alignment alignment,
                             SpacingBuilder spacingBuilder )
    {
        super( node, null, alignment );
        this.spacingBuilder = spacingBuilder;
    }

    @Override
    protected List<Block> buildChildren()
    {
        Alignment childrenAlignment = Alignment.createChildAlignment( getAlignment() );
        List<Block> blocks = new ArrayList<>();
        ASTNode child = myNode.getFirstChildNode();
        while( child != null )
        {
            if( handleCommentBlock( blocks, child, getAlignment(), spacingBuilder ) )
            {
                Block block;
                if( child.getElementType() == PonyTypes.USE_ )
                {
                    block = new PonyUseBlock( child,
                                              childrenAlignment,
                                              spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.CLASS_DEF )
                {
                    block = new PonyClassDefBlock( child, childrenAlignment, spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.DOC_STRING )
                {
                    block = new PonyDocStringBlock( child, childrenAlignment, spacingBuilder );
                }
                else // nothing, hopefully
                {
                    block = new PonyTokenBlock( child, childrenAlignment, spacingBuilder );
                }
                blocks.add( block );
            }
            child = child.getTreeNext();
        }
        return blocks;
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
