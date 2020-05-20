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

public class PonyTermBlock extends AbstractPonyBlock
    implements Block
{
    public PonyTermBlock( @NotNull ASTNode node, @Nullable Alignment alignment, SpacingBuilder spacingBuilder )
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
                if( child.getElementType() == PonyTypes.IF_TERM )
                {
                    block = new PonyIfTermBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.IFTYPE_TERM )
                {
                    block = new PonyIfTypeTermBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.IFDEF_TERM )
                {
                    block = new PonyIfDefTermBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.MATCH_TERM )
                {
                    block = new PonyMatchTermBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.WHILE_TERM )
                {
                    block = new PonyWhileTermBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.REPEAT_TERM )
                {
                    block = new PonyRepeatTermBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.FOR_TERM )
                {
                    block = new PonyForTermBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.WITH_TERM )
                {
                    block = new PonyWithTermBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.TRY_TERM )
                {
                    block = new PonyTryTermBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.RECOVER_TERM )
                {
                    block = new PonyRecoverTermBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.CONSUME_TERM )
                {
                    block = new PonyConsumeTermBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.PATTERN )
                {
                    block = new PonyPatternBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.NEXTPATTERN )
                {
                    block = new PonyPatternBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.HASH_TERM )
                {
                    block = new PonyHashTermBlock( child, getAlignment(), spacingBuilder );
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
