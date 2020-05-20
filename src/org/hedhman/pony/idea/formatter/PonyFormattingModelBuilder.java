package org.hedhman.pony.idea.formatter;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.Block;
import com.intellij.formatting.FormattingModel;
import com.intellij.formatting.FormattingModelBuilder;
import com.intellij.formatting.SpacingBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.tree.IElementType;
import java.util.List;
import org.hedhman.pony.idea.PonyLanguage;
import org.hedhman.pony.idea.generated.parsing.PonyTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.intellij.formatting.FormattingModelProvider.createFormattingModelForPsiFile;

public class PonyFormattingModelBuilder
    implements FormattingModelBuilder
{
    @NotNull
    @Override
    public FormattingModel createModel( PsiElement element, CodeStyleSettings settings )
    {
        ASTNode rootNode = element.getNode();
        PonyModuleBlock rootBlock = new PonyModuleBlock( rootNode, createSpacingBuilder( settings ) );
        return createFormattingModelForPsiFile( element.getContainingFile(), rootBlock, settings );
    }

    private static SpacingBuilder createSpacingBuilder( CodeStyleSettings settings )
    {
        return new SpacingBuilder( settings, PonyLanguage.INSTANCE )
            .around( PonyTypes.ID )
            .spaceIf( settings.getCommonSettings( PonyLanguage.INSTANCE.getID() ).SPACE_AROUND_ASSIGNMENT_OPERATORS )
            ;
    }

    @Nullable
    @Override
    public TextRange getRangeAffectingIndent( PsiFile file, int offset, ASTNode elementAtOffset )
    {
        return null;
    }

    static boolean handleCommentAndWhitespaceBlock( List<Block> blocks, ASTNode child, Alignment alignment, SpacingBuilder spacingBuilder )
    {
        if( child instanceof PsiWhiteSpace )
        {
            return false;
        }
        IElementType type = child.getElementType();
        if( type == PonyTypes.LINE_COMMENT || type == PonyTypes.BLOCK_COMMENT )
        {
            Block block = new PonyCommentBlock( child, alignment, spacingBuilder );
            blocks.add( block );
            return false;
        }
        return true;
    }
}
