package org.hedhman.pony.idea.formatter;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.Block;
import com.intellij.formatting.Indent;
import com.intellij.formatting.SpacingBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.IElementType;
import java.util.Collections;
import java.util.List;
import org.hedhman.pony.idea.psi.PonyTokenType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PonyTokenBlock extends AbstractPonyBlock
{
    protected PonyTokenBlock( @NotNull ASTNode node, @Nullable Alignment alignment, SpacingBuilder spacingBuilder )
    {
        super( node, null, alignment, spacingBuilder );
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
}
