package org.hedhman.pony.idea.formatter;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.Block;
import com.intellij.formatting.Indent;
import com.intellij.formatting.Spacing;
import com.intellij.formatting.SpacingBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.psi.TokenType;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.intellij.psi.tree.IElementType;
import java.util.Collections;
import java.util.List;
import org.hedhman.pony.idea.psi.PonyTokenType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PonyTokenBlock extends AbstractBlock
{
    protected PonyTokenBlock( @NotNull ASTNode node, @Nullable Alignment alignment, SpacingBuilder spacingBuilder )
    {
        super( node, null, alignment );
    }

    @Override
    protected List<Block> buildChildren()
    {
        IElementType type = myNode.getElementType();
        if( !( type instanceof PonyTokenType ) )
        {
            if( !type.toString().equals( "WHITE_SPACE" )
                && !type.toString().equals( "LITERAL" ) )
            {
                System.err.println( "ERROR: Invalid Block Structure: " + myNode.getTextRange() + " unexpected " + type + "\n" + myNode.getText() );
            }
        }
        return Collections.emptyList();
    }

    @Override
    public Indent getIndent()
    {
        return Indent.getNormalIndent( true );
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
