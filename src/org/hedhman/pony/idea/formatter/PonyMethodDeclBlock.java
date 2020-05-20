package org.hedhman.pony.idea.formatter;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.Block;
import com.intellij.formatting.SpacingBuilder;
import com.intellij.formatting.Wrap;
import com.intellij.formatting.WrapType;
import com.intellij.lang.ASTNode;
import java.util.ArrayList;
import java.util.List;
import org.hedhman.pony.idea.generated.parsing.PonyTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.hedhman.pony.idea.formatter.PonyFormattingModelBuilder.handleCommentAndWhitespaceBlock;

public class PonyMethodDeclBlock extends AbstractPonyBlock
{
    protected PonyMethodDeclBlock( @NotNull ASTNode node, @Nullable Alignment alignment, SpacingBuilder spacingBuilder )
    {
        super( node, Wrap.createWrap( WrapType.CHOP_DOWN_IF_LONG, true ), Alignments.member, spacingBuilder );
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
                if( child.getElementType() == PonyTypes.METHOD_TYPE )
                {
                    block = new PonyMethodTypeBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.ANNOTATIONS )
                {
                    block = new PonyAnnotationsBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.CAP )
                {
                    block = new PonyCapBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.METHOD_NAME )
                {
                    block = new PonyMethodNameBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.TYPEPARAMS )
                {
                    block = new PonyTypeParamsBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.PARAMS )
                {
                    block = new PonyParamsBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.TYPE_ )
                {
                    block = new PonyTypeBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.DOC_STRING )
                {
                    block = new PonyDocStringBlock( child, getAlignment(), spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.METHOD_BODY_DECL )
                {
                    block = new PonyMethodBodyDeclBlock( child, getAlignment(), spacingBuilder );
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
