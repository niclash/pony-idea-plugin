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

public class PonyAtomBlock extends AbstractPonyBlock
    implements Block
{
    public PonyAtomBlock( @NotNull ASTNode node, @Nullable Alignment alignment, SpacingBuilder spacingBuilder )
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
                if( child.getElementType() == PonyTypes.TUPLE_DECL )
                {
                    block = new PonyTupleDeclBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.NEXT_TUPLE_DECL )
                {
                    block = new PonyTupleDeclBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.RAWSEQ )
                {
                    block = new PonyRawSeqBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.TYPE_ )
                {
                    block = new PonyTypeBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.OBJECT_DECL )
                {
                    block = new PonyObjectDeclBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.LAMBDA_DECL )
                {
                    block = new PonyLambdaDeclBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.FFI_DECL )
                {
                    block = new PonyFfiDeclBlock( child, getAlignment(), spacingBuilder );
                }
                else // ID, THIS, LITERAL
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
