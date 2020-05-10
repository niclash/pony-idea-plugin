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

LPAREN_NEW=[\r\n][ \t\n\x0B\f\r]*\(
LSQUARE_NEW=[\r\n][ \t\n\x0B\f\r]*\[
MINUS_NEW=[\r\n][ \t\n\x0B\f\r]*-
MINUS_TILDE_NEW=[\r\n][ \t\n\x0B\f\r]*-\~
MINUS_TILDE=[-][~]
LSQUARE=[\[]
RSQUARE=[\]]
BACKSLASH=[\\]
COMMA=[,]
ASSIGN=[=]
TYPE_OP=[:]
CHAIN_OP=[.]>
PARTIAL_OP=[~]
CALL_OP=[.]
NUMBER=[0-9]+
FLOAT=[0-9]+(\.[0-9]*)?(E|e[0-9]+)?
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
LINE_COMMENT=("//".*)
BLOCK_COMMENT=("/"\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+"/")
ID=(_|[:letter:])(_|'|[a-zA-Z_0-9])*

%%
<YYINITIAL> {

  "?"                      { return THROWS; }
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
  "=>"                     { return ARROW; }
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
  "("                      { return LPAREN; }
  ")"                      { return RPAREN; }
  "{"                      { return LBRACE; }
  "@{"                     { return ATLBRACE; }
  "}"                      { return RBRACE; }
  ";"                      { return LIST_OP; }
  "<::="                   { return TYPE_EQ; }
  "+"                      { return PLUS_OP; }
  "-"                      { return MINUS_OP; }
  "*"                      { return MULT_OP; }
  "/"                      { return DIV_OP; }
  "%"                      { return REMAINDER; }
  "%%"                     { return MODULO; }
  "+~"                     { return PLUS_UNSAFE; }
  "*~"                     { return MULT_UNSAFE; }
  "/~"                     { return DIV_UNSAFE; }
  "%~"                     { return REMAINDER_UNSAFE; }
  "%%~"                    { return MODULO_UNSAFE; }
  "<<"                     { return LSHIFT; }
  ">>"                     { return RSHIFT; }
  "<<~"                    { return LSHIFT_UNSAFE; }
  ">>~"                    { return RSHIFT_UNSAFE; }
  "=="                     { return EQUALITY; }
  "!="                     { return NON_EQUALITY; }
  "<"                      { return LT_OP; }
  "<="                     { return LTE_OP; }
  ">="                     { return GT_OP; }
  ">"                      { return GTE_OP; }
  "==~"                    { return EQUALITY_UNSAFE; }
  "!=~"                    { return NON_EQUALITY_UNSAFE; }
  "<~"                     { return LT_UNSAFE; }
  "<=~"                    { return LTE_UNSAFE; }
  ">=~"                    { return GT_UNSAFE; }
  ">~"                     { return GTE_UNSAFE; }
  "^"                      { return HAT; }
  "!"                      { return BANG; }
  "|"                      { return PIPE_OP; }
  "&"                      { return ISECT_OP; }
  "..."                    { return THREE_DOTS; }
  "->"                     { return CAP_ARROW; }
  "true"                   { return TRUE; }
  "false"                  { return FALSE; }

  {LPAREN_NEW}             { return LPAREN_NEW; }
  {LSQUARE_NEW}            { return LSQUARE_NEW; }
  {MINUS_NEW}              { return MINUS_NEW; }
  {MINUS_TILDE_NEW}        { return MINUS_TILDE_NEW; }
  {MINUS_TILDE}            { return MINUS_TILDE; }
  {LSQUARE}                { return LSQUARE; }
  {RSQUARE}                { return RSQUARE; }
  {BACKSLASH}              { return BACKSLASH; }
  {COMMA}                  { return COMMA; }
  {ASSIGN}                 { return ASSIGN; }
  {TYPE_OP}                { return TYPE_OP; }
  {CHAIN_OP}               { return CHAIN_OP; }
  {PARTIAL_OP}             { return PARTIAL_OP; }
  {CALL_OP}                { return CALL_OP; }
  {NUMBER}                 { return NUMBER; }
  {FLOAT}                  { return FLOAT; }
  {STRING}                 { return STRING; }
  {WHITE_SPACE}            { return WHITE_SPACE; }
  {LINE_COMMENT}           { return LINE_COMMENT; }
  {BLOCK_COMMENT}          { return BLOCK_COMMENT; }
  {ID}                     { return ID; }

}

[^] { return BAD_CHARACTER; }
