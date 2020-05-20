package org.hedhman.pony.idea.formatter;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.Block;
import com.intellij.formatting.SpacingBuilder;
import com.intellij.lang.ASTNode;
import java.util.ArrayList;
import java.util.List;
import org.hedhman.pony.idea.generated.parsing.PonyTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.hedhman.pony.idea.formatter.PonyFormattingModelBuilder.handleCommentAndWhitespaceBlock;

public class PonyLambdaDeclBlock extends AbstractPonyBlock
    implements Block
{
    public PonyLambdaDeclBlock( @NotNull ASTNode node, @Nullable Alignment alignment, SpacingBuilder spacingBuilder )
    {
        super( node, null, alignment, spacingBuilder );
    }

    @Override
    protected List<Block> buildChildren()
    {
        List<Block> blocks = new ArrayList<>();
        ASTNode child = myNode.getFirstChildNode();
        while( child != null )
        {
            if( handleCommentAndWhitespaceBlock( blocks, child, getAlignment(), spacingBuilder ) )
            {
                Block block;
                if( child.getElementType() == PonyTypes.ANNOTATIONS )
                {
                    block = new PonyAnnotationsBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.TYPEPARAMS )
                {
                    block = new PonyTypeParamsBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.LAMBDAPARAMS )
                {
                    block = new PonyLambdaParamsBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.LAMBDACAPTURES )
                {
                    block = new PonyLambdaCapturesBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.TYPE_ )
                {
                    block = new PonyTypeBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.RAWSEQ )
                {
                    block = new PonyRawSeqBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.CAP )
                {
                    block = new PonyCapBlock( child, getAlignment(), spacingBuilder );
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
}
