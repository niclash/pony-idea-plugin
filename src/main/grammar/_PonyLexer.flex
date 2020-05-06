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

WHITE_SPACE=\s+

NUMBER=[0-9]+
FLOAT=[0-9]+(\.[0-9]*)?(E|e[0-9]+)?
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
LINE_COMMENT=("//".*)
BLOCK_COMMENT=("/"\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+"/")
ID=(_|[:letter:])(_|'|[a-zA-Z_0-9])*
LPAREN_NEW=(\r|\n|\r\n) \(
LSQUARE_NEW=(\r|\n|\r\n) \[
MINUS_NEW=(\r|\n|\r\n) -
MINUS_TILDE_NEW=(\r|\n|\r\n) -\~

%%
<YYINITIAL> {
  {WHITE_SPACE}            { return WHITE_SPACE; }

  "this"                   { return THIS; }
  "fun"                    { return FUN; }
  "be"                     { return BE; }
  "new"                    { return NEW; }
  "use"                    { return USE; }
  "return"                 { return RETURN; }
  "break"                  { return BREAK; }
  "continue"               { return CONTINUE; }
  "type"                   { return TYPE; }
  "class"                  { return CLASS; }
  "interface"              { return INTERFACE; }
  "trait"                  { return TRAIT; }
  "object"                 { return OBJECT; }
  "error"                  { return ERROR; }
  "compile_intrinsic"      { return COMPILE_INTRINSIC; }
  "primitive"              { return PRIMITIVE; }
  "actor"                  { return ACTOR; }
  "struct"                 { return STRUCT; }
  "is"                     { return IS; }
  "isnt"                   { return ISNT; }
  "var"                    { return VAR; }
  "let"                    { return LET; }
  "embed"                  { return EMBED; }
  "where"                  { return WHERE; }
  "@"                      { return FFI_CHAR; }
  "compile_error"          { return COMPILE_ERROR; }
  "as"                     { return AS; }
  "and"                    { return AND; }
  "or"                     { return OR; }
  "xor"                    { return XOR; }
  "not"                    { return NOT; }
  "addressof"              { return ADDRESSOF; }
  "digestof"               { return DIGESTOF; }
  "if"                     { return IF; }
  "ifdef"                  { return IFDEF; }
  "iftype"                 { return IFTYPE; }
  "match"                  { return MATCH; }
  "while"                  { return WHILE; }
  "repeat"                 { return REPEAT; }
  "for"                    { return FOR; }
  "with"                   { return WITH; }
  "do"                     { return DO; }
  "until"                  { return UNTIL; }
  "in"                     { return IN; }
  "end"                    { return END; }
  "else"                   { return ELSE; }
  "elseif"                 { return ELSEIF; }
  "then"                   { return THEN; }
  "try"                    { return TRY; }
  "recover"                { return RECOVER; }
  "consume"                { return CONSUME; }
  "#"                      { return HASH; }
  "#read"                  { return HASH_READ; }
  "#send"                  { return HASH_SEND; }
  "#share"                 { return HASH_SHARE; }
  "#alias"                 { return HASH_ALIAS; }
  "#any"                   { return HASH_ANY; }
  "iso"                    { return ISO; }
  "trn"                    { return TRN; }
  "ref"                    { return REF; }
  "val"                    { return VAL; }
  "box"                    { return BOX; }
  "tag"                    { return TAG; }
  "__loc"                  { return LOC; }
  "true"                   { return TRUE; }
  "false"                  { return FALSE; }

  {NUMBER}                 { return NUMBER; }
  {FLOAT}                  { return FLOAT; }
  {STRING}                 { return STRING; }
  {LINE_COMMENT}           { return LINE_COMMENT; }
  {BLOCK_COMMENT}          { return BLOCK_COMMENT; }
  {ID}                     { return ID; }
  {LPAREN_NEW}             { return LPAREN_NEW; }
  {LSQUARE_NEW}            { return LSQUARE_NEW; }
  {MINUS_NEW}              { return MINUS_NEW; }
  {MINUS_TILDE_NEW}        { return MINUS_TILDE_NEW; }

}

[^] { return BAD_CHARACTER; }
