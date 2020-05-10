package org.hedhman.pony.idea.formatter;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.Block;
import com.intellij.formatting.Indent;
import com.intellij.formatting.Spacing;
import com.intellij.formatting.SpacingBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.intellij.psi.tree.IElementType;
import java.util.ArrayList;
import java.util.List;
import org.hedhman.pony.idea.generated.parsing.PonyTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.hedhman.pony.idea.formatter.PonyFormattingModelBuilder.handleCommentBlock;

public class PonyAnnotatedRawSeqBlock extends AbstractBlock
    implements Block
{
    private final SpacingBuilder spacingBuilder;

    public PonyAnnotatedRawSeqBlock( @NotNull ASTNode node, @Nullable Alignment alignment, SpacingBuilder spacingBuilder )
    {
        super( node, null, alignment );
        this.spacingBuilder = spacingBuilder;
    }

    @Override
    protected List<Block> buildChildren()
    {
        List<Block> blocks = new ArrayList<>();
        ASTNode child = myNode.getFirstChildNode();
        while( child != null )
        {
            if( handleCommentBlock( blocks, child, getAlignment(), spacingBuilder ) )
            {
                Block block;
                IElementType elementType = child.getElementType();
                if( elementType == PonyTypes.ANNOTATIONS )
                {
                    block = new PonyAnnotationsBlock( child, getAlignment(), spacingBuilder );
                }
                else if( elementType == PonyTypes.EXPRSEQ )
                {
                    block = new PonyExprSeqBlock( child, getAlignment(), spacingBuilder );
                }
                else if( elementType == PonyTypes.NEXTEXPRSEQ )
                {
                    block = new PonyExprSeqBlock( child, getAlignment(), spacingBuilder );
                }
                else if( elementType == PonyTypes.JUMP )
                {
                    block = new PonyJumpBlock( child, getAlignment(), spacingBuilder );
                }
                else
                {
                    block = new PonyTokenBlock( child, getAlignment(), spacingBuilder );
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
