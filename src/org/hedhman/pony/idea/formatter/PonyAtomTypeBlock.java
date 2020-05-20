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

public class PonyAtomTypeBlock extends AbstractPonyBlock
    implements Block
{
    public PonyAtomTypeBlock( @NotNull ASTNode node, @Nullable Alignment alignment, SpacingBuilder spacingBuilder )
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
                if( child.getElementType() == PonyTypes.CAP )
                {
                    block = new PonyCapBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.INFIXTYPE )
                {
                    block = new PonyInfixTypeBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.TUPLETYPE )
                {
                    block = new PonyTupleTypeBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.NOMINAL )
                {
                    block = new PonyNominalBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.LAMBDATYPE )
                {
                    block = new PonyLambdaTypeBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.BARELAMBDATYPE )
                {
                    block = new PonyBareLambdaTypeBlock( child, getAlignment(), spacingBuilder );
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
