package org.hedhman.pony.idea.formatter;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.Block;
import com.intellij.formatting.SpacingBuilder;
import com.intellij.lang.ASTNode;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PonyCommentBlock extends AbstractPonyBlock
{
    protected PonyCommentBlock( @NotNull ASTNode node, @Nullable Alignment alignment, SpacingBuilder spacingBuilder )
    {
        super( node, null, alignment, spacingBuilder );
    }

    @Override
    protected List<Block> buildChildren()
    {
        return Collections.emptyList();
    }
}
