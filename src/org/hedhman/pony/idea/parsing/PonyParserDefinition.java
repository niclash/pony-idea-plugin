package org.hedhman.pony.idea.parsing;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.hedhman.pony.idea.PonyFile;
import org.hedhman.pony.idea.PonyLanguage;
import org.hedhman.pony.idea.generated.parsing.PonyParser;
import org.hedhman.pony.idea.generated.parsing.PonyTypes;
import org.jetbrains.annotations.NotNull;

public class PonyParserDefinition implements ParserDefinition
{
    public static final TokenSet WHITE_SPACES = TokenSet.create( TokenType.WHITE_SPACE );
    public static final TokenSet COMMENTS = TokenSet.create( PonyTypes.LINE_COMMENT, PonyTypes.BLOCK_COMMENT );

    public static final IFileElementType FILE = new IFileElementType( PonyLanguage.INSTANCE );

    @NotNull
    @Override
    public Lexer createLexer( Project project )
    {
        return new PonyLexer();
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens()
    {
        return WHITE_SPACES;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens()
    {
        return COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements()
    {
        return TokenSet.create( PonyTypes.STRING );
    }

    @NotNull
    @Override
    public PsiParser createParser( final Project project )
    {
        return new PonyParser();
    }

    @Override
    public IFileElementType getFileNodeType()
    {
        return FILE;
    }

    @Override
    public PsiFile createFile( FileViewProvider viewProvider )
    {
        return new PonyFile( viewProvider );
    }

    @Override
    public SpaceRequirements spaceExistenceTypeBetweenTokens( ASTNode left, ASTNode right )
    {
        return SpaceRequirements.MAY;
    }

    @NotNull
    @Override
    public PsiElement createElement( ASTNode node )
    {
        return PonyTypes.Factory.createElement( node );
    }
}
