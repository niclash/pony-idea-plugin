package org.hedhman.pony.idea.generated.parsing;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static org.hedhman.pony.idea.generated.parsing.PonyTypes.*;

%%

%{
  public _PonyLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _PonyLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

SPACE=[ \t\n\x0B\f\r]+
COMMENT=("/"\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+"/")|("//".*)
NUMBER=[0-9]+
FLOAT=[0-9]+(\.[0-9]*)?(E|e[0-9]+)?
ID=[:letter:][a-zA-Z_0-9]*
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
LPAREN_NEW=(\r|\n|\r\n) \(
LSQUARE_NEW=(\r|\n|\r\n) \[
MINUS_NEW=(\r|\n|\r\n) -
MINUS_TILDE_NEW=(\r|\n|\r\n) -\~

%%
<YYINITIAL> {
  {WHITE_SPACE}          { return WHITE_SPACE; }


  {WHITE_SPACE}          { return SPACE; }
  {COMMENT}              { return COMMENT; }
  {NUMBER}               { return NUMBER; }
  {FLOAT}                { return FLOAT; }
  {ID}                   { return ID; }
  {STRING}               { return STRING; }
  {LPAREN_NEW}           { return LPAREN_NEW; }
  {LSQUARE_NEW}          { return LSQUARE_NEW; }
  {MINUS_NEW}            { return MINUS_NEW; }
  {MINUS_TILDE_NEW}      { return MINUS_TILDE_NEW; }

}

[^] { return BAD_CHARACTER; }
