package org.hedhman.pony.idea.formatter;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.Block;
import com.intellij.formatting.Indent;
import com.intellij.formatting.SpacingBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.IElementType;
import java.util.ArrayList;
import java.util.List;
import org.hedhman.pony.idea.generated.parsing.PonyTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.hedhman.pony.idea.formatter.PonyFormattingModelBuilder.handleCommentAndWhitespaceBlock;

public class PonyClassDefBlock extends AbstractPonyBlock
{
    protected PonyClassDefBlock( @NotNull ASTNode node, @Nullable Alignment alignment,
                                 SpacingBuilder spacingBuilder )
    {
        super( node, null, Alignments.member, spacingBuilder );
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
                IElementType childElement = child.getElementType();
                Block block;
                if( childElement == PonyTypes.CLASS_TYPE )
                {
                    block = new PonyClassTypeBlock( child, getAlignment(), spacingBuilder );
                }
                else if( childElement == PonyTypes.ANNOTATIONS )
                {
                    block = new PonyAnnotationsBlock( child, getAlignment(), spacingBuilder );
                }
                else if( childElement == PonyTypes.CAP )
                {
                    block = new PonyCapBlock( child, getAlignment(), spacingBuilder );
                }
                else if( childElement == PonyTypes.CLASS_NAME )
                {
                    block = new PonyClassNameBlock( child, getAlignment(), spacingBuilder );
                }
                else if( childElement == PonyTypes.TYPEPARAMS )
                {
                    block = new PonyParamsBlock( child, getAlignment(), spacingBuilder );
                }
                else if( childElement == PonyTypes.TYPE_DECL )
                {
                    block = new PonyTypeDeclBlock( child, getAlignment(), spacingBuilder );
                }
                else if( childElement == PonyTypes.DOC_STRING )
                {
                    block = new PonyDocStringBlock( child, getAlignment(), spacingBuilder );
                }
                else if( childElement == PonyTypes.MEMBERS )
                {
                    block = new PonyMembersBlock( child, getAlignment(), spacingBuilder );
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
        if( isNotIndentable() )
        {
            return null;
        }
        return Indent.getAbsoluteNoneIndent();
    }
}
