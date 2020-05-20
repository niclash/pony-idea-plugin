package org.hedhman.pony.idea.formatter;

import com.intellij.formatting.Block;
import com.intellij.formatting.Indent;
import com.intellij.formatting.SpacingBuilder;
import com.intellij.lang.ASTNode;
import java.util.ArrayList;
import java.util.List;
import org.hedhman.pony.idea.generated.parsing.PonyTypes;
import org.jetbrains.annotations.NotNull;

import static org.hedhman.pony.idea.formatter.PonyFormattingModelBuilder.handleCommentAndWhitespaceBlock;

public class PonyModuleBlock extends AbstractPonyBlock
{
    protected PonyModuleBlock( @NotNull ASTNode node, SpacingBuilder spacingBuilder )
    {
        super( node, null, Alignments.root, spacingBuilder );
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
                if( child.getElementType() == PonyTypes.USE_ )
                {
                    block = new PonyUseBlock( child, null, spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.CLASS_DEF )
                {
                    block = new PonyClassDefBlock( child, null, spacingBuilder );
                }
                else if( child.getElementType() == PonyTypes.DOC_STRING )
                {
                    block = new PonyDocStringBlock( child, null, spacingBuilder );
                }
                else // nothing, hopefully
                {
                    block = new PonyTokenBlock( child, null, spacingBuilder );
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
        if( isNotIndentable() )
        {
            return null;
        }
        return Indent.getNoneIndent();
    }
}
