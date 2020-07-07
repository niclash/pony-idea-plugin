/* Copyright Niclas Hedhman, 2020. All rights reserved. Licensed under the Apache License, Version 2.0 (the "License"). See LICENSE.txt*/
package org.hedhman.pony.idea.generated.parsing;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.hedhman.pony.idea.psi.PonyElementType;
import org.hedhman.pony.idea.psi.PonyTokenType;
import org.hedhman.pony.idea.generated.psi.impl.*;

public interface PonyTypes {

  IElementType ANNOTATEDRAWSEQ = new PonyElementType("ANNOTATEDRAWSEQ");
  IElementType ANNOTATIONS = new PonyElementType("ANNOTATIONS");
  IElementType ASSIGNMENT = new PonyElementType("ASSIGNMENT");
  IElementType AS_OP = new PonyElementType("AS_OP");
  IElementType ATOM = new PonyElementType("ATOM");
  IElementType ATOMTYPE = new PonyElementType("ATOMTYPE");
  IElementType BARELAMBDATYPE = new PonyElementType("BARELAMBDATYPE");
  IElementType BINOP = new PonyElementType("BINOP");
  IElementType CALL = new PonyElementType("CALL");
  IElementType CALLSITE = new PonyElementType("CALLSITE");
  IElementType CAP = new PonyElementType("CAP");
  IElementType CASEEXPR = new PonyElementType("CASEEXPR");
  IElementType CHAIN = new PonyElementType("CHAIN");
  IElementType CLASS_DEF = new PonyElementType("CLASS_DEF");
  IElementType CLASS_NAME = new PonyElementType("CLASS_NAME");
  IElementType CLASS_TYPE = new PonyElementType("CLASS_TYPE");
  IElementType CONSUME_TERM = new PonyElementType("CONSUME_TERM");
  IElementType DOC_STRING = new PonyElementType("DOC_STRING");
  IElementType ELSEIFDEF = new PonyElementType("ELSEIFDEF");
  IElementType ELSEIFTYPE = new PonyElementType("ELSEIFTYPE");
  IElementType ELSEIF_ = new PonyElementType("ELSEIF_");
  IElementType EXPRSEQ = new PonyElementType("EXPRSEQ");
  IElementType FFI_DECL = new PonyElementType("FFI_DECL");
  IElementType FIELD_DECL = new PonyElementType("FIELD_DECL");
  IElementType FIELD_NAME = new PonyElementType("FIELD_NAME");
  IElementType FIELD_TYPE = new PonyElementType("FIELD_TYPE");
  IElementType FOR_TERM = new PonyElementType("FOR_TERM");
  IElementType GENCAP = new PonyElementType("GENCAP");
  IElementType HASH_TERM = new PonyElementType("HASH_TERM");
  IElementType IDSEQ = new PonyElementType("IDSEQ");
  IElementType IDSEQ_IN_SEQ = new PonyElementType("IDSEQ_IN_SEQ");
  IElementType IFDEF_TERM = new PonyElementType("IFDEF_TERM");
  IElementType IFTYPE_ = new PonyElementType("IFTYPE_");
  IElementType IFTYPE_TERM = new PonyElementType("IFTYPE_TERM");
  IElementType IF_TERM = new PonyElementType("IF_TERM");
  IElementType INFIX = new PonyElementType("INFIX");
  IElementType INFIXTYPE = new PonyElementType("INFIXTYPE");
  IElementType ISECTTYPE = new PonyElementType("ISECTTYPE");
  IElementType ISOP = new PonyElementType("ISOP");
  IElementType JUMP = new PonyElementType("JUMP");
  IElementType LAMBDACAPTURE = new PonyElementType("LAMBDACAPTURE");
  IElementType LAMBDACAPTURES = new PonyElementType("LAMBDACAPTURES");
  IElementType LAMBDAPARAM = new PonyElementType("LAMBDAPARAM");
  IElementType LAMBDAPARAMS = new PonyElementType("LAMBDAPARAMS");
  IElementType LAMBDATYPE = new PonyElementType("LAMBDATYPE");
  IElementType LAMBDA_DECL = new PonyElementType("LAMBDA_DECL");
  IElementType LITERAL = new PonyElementType("LITERAL");
  IElementType MATCH_TERM = new PonyElementType("MATCH_TERM");
  IElementType MEMBERS = new PonyElementType("MEMBERS");
  IElementType METHOD_BODY = new PonyElementType("METHOD_BODY");
  IElementType METHOD_BODY_DECL = new PonyElementType("METHOD_BODY_DECL");
  IElementType METHOD_DECL = new PonyElementType("METHOD_DECL");
  IElementType METHOD_NAME = new PonyElementType("METHOD_NAME");
  IElementType METHOD_TYPE = new PonyElementType("METHOD_TYPE");
  IElementType NAMED = new PonyElementType("NAMED");
  IElementType NAMEDARG = new PonyElementType("NAMEDARG");
  IElementType NEXTASSIGNMENT = new PonyElementType("NEXTASSIGNMENT");
  IElementType NEXTATOM = new PonyElementType("NEXTATOM");
  IElementType NEXTEXPRSEQ = new PonyElementType("NEXTEXPRSEQ");
  IElementType NEXTINFIX = new PonyElementType("NEXTINFIX");
  IElementType NEXTPARAMPATTERN = new PonyElementType("NEXTPARAMPATTERN");
  IElementType NEXTPATTERN = new PonyElementType("NEXTPATTERN");
  IElementType NEXTPOSTFIX = new PonyElementType("NEXTPOSTFIX");
  IElementType NEXTTERM = new PonyElementType("NEXTTERM");
  IElementType NEXT_TUPLE_DECL = new PonyElementType("NEXT_TUPLE_DECL");
  IElementType NOMINAL = new PonyElementType("NOMINAL");
  IElementType NOSEMI = new PonyElementType("NOSEMI");
  IElementType OBJECT_DECL = new PonyElementType("OBJECT_DECL");
  IElementType PARAM = new PonyElementType("PARAM");
  IElementType PARAMPATTERN = new PonyElementType("PARAMPATTERN");
  IElementType PARAMS = new PonyElementType("PARAMS");
  IElementType PATTERN = new PonyElementType("PATTERN");
  IElementType POSITIONAL = new PonyElementType("POSITIONAL");
  IElementType POSTFIX = new PonyElementType("POSTFIX");
  IElementType RAWSEQ = new PonyElementType("RAWSEQ");
  IElementType RECOVER_TERM = new PonyElementType("RECOVER_TERM");
  IElementType REPEAT_TERM = new PonyElementType("REPEAT_TERM");
  IElementType SEMIEXPR = new PonyElementType("SEMIEXPR");
  IElementType TERM = new PonyElementType("TERM");
  IElementType TILDE = new PonyElementType("TILDE");
  IElementType TRY_TERM = new PonyElementType("TRY_TERM");
  IElementType TUPLE = new PonyElementType("TUPLE");
  IElementType TUPLETYPE = new PonyElementType("TUPLETYPE");
  IElementType TUPLE_DECL = new PonyElementType("TUPLE_DECL");
  IElementType TYPEARG = new PonyElementType("TYPEARG");
  IElementType TYPEARGS = new PonyElementType("TYPEARGS");
  IElementType TYPEPARAM = new PonyElementType("TYPEPARAM");
  IElementType TYPEPARAMS = new PonyElementType("TYPEPARAMS");
  IElementType TYPE_ = new PonyElementType("TYPE_");
  IElementType TYPE_DECL = new PonyElementType("TYPE_DECL");
  IElementType UNIONTYPE = new PonyElementType("UNIONTYPE");
  IElementType USE_ = new PonyElementType("USE_");
  IElementType USE_ALIAS = new PonyElementType("USE_ALIAS");
  IElementType USE_COND = new PonyElementType("USE_COND");
  IElementType USE_FFI = new PonyElementType("USE_FFI");
  IElementType WHILE_TERM = new PonyElementType("WHILE_TERM");
  IElementType WITHELEM = new PonyElementType("WITHELEM");
  IElementType WITH_TERM = new PonyElementType("WITH_TERM");

  IElementType ACTOR = new PonyTokenType("actor");
  IElementType ADDRESSOF = new PonyTokenType("addressof");
  IElementType AND = new PonyTokenType("and");
  IElementType ARROW = new PonyTokenType("=>");
  IElementType AS = new PonyTokenType("as");
  IElementType ASSIGN = new PonyTokenType("ASSIGN");
  IElementType ATLBRACE = new PonyTokenType("@{");
  IElementType BACKSLASH = new PonyTokenType("BACKSLASH");
  IElementType BANG = new PonyTokenType("!");
  IElementType BE = new PonyTokenType("be");
  IElementType BLOCK_COMMENT = new PonyTokenType("BLOCK_COMMENT");
  IElementType BOX = new PonyTokenType("box");
  IElementType BREAK = new PonyTokenType("break");
  IElementType CALL_OP = new PonyTokenType("CALL_OP");
  IElementType CAP_ARROW = new PonyTokenType("->");
  IElementType CHAIN_OP = new PonyTokenType("CHAIN_OP");
  IElementType CLASS = new PonyTokenType("class");
  IElementType COMMA = new PonyTokenType("COMMA");
  IElementType COMPILE_ERROR = new PonyTokenType("compile_error");
  IElementType COMPILE_INTRINSIC = new PonyTokenType("compile_intrinsic");
  IElementType CONSUME = new PonyTokenType("consume");
  IElementType CONTINUE = new PonyTokenType("continue");
  IElementType DIGESTOF = new PonyTokenType("digestof");
  IElementType DIV_OP = new PonyTokenType("/");
  IElementType DIV_UNSAFE = new PonyTokenType("/~");
  IElementType DO = new PonyTokenType("do");
  IElementType ELSE = new PonyTokenType("else");
  IElementType ELSEIF = new PonyTokenType("elseif");
  IElementType EMBED = new PonyTokenType("embed");
  IElementType END = new PonyTokenType("end");
  IElementType EQUALITY = new PonyTokenType("==");
  IElementType EQUALITY_UNSAFE = new PonyTokenType("==~");
  IElementType ERROR = new PonyTokenType("error");
  IElementType FALSE = new PonyTokenType("false");
  IElementType FFI_CHAR = new PonyTokenType("@");
  IElementType FLOAT = new PonyTokenType("FLOAT");
  IElementType FOR = new PonyTokenType("for");
  IElementType FUN = new PonyTokenType("fun");
  IElementType GTE_OP = new PonyTokenType(">");
  IElementType GTE_UNSAFE = new PonyTokenType(">~");
  IElementType GT_OP = new PonyTokenType(">=");
  IElementType GT_UNSAFE = new PonyTokenType(">=~");
  IElementType HASH = new PonyTokenType("#");
  IElementType HASH_ALIAS = new PonyTokenType("#alias");
  IElementType HASH_ANY = new PonyTokenType("#any");
  IElementType HASH_READ = new PonyTokenType("#read");
  IElementType HASH_SEND = new PonyTokenType("#send");
  IElementType HASH_SHARE = new PonyTokenType("#share");
  IElementType HAT = new PonyTokenType("^");
  IElementType ID = new PonyTokenType("ID");
  IElementType IF = new PonyTokenType("if");
  IElementType IFDEF = new PonyTokenType("ifdef");
  IElementType IFTYPE = new PonyTokenType("iftype");
  IElementType IN = new PonyTokenType("in");
  IElementType INTERFACE = new PonyTokenType("interface");
  IElementType IS = new PonyTokenType("is");
  IElementType ISECT_OP = new PonyTokenType("&");
  IElementType ISNT = new PonyTokenType("isnt");
  IElementType ISO = new PonyTokenType("iso");
  IElementType LBRACE = new PonyTokenType("{");
  IElementType LET = new PonyTokenType("let");
  IElementType LINE_COMMENT = new PonyTokenType("LINE_COMMENT");
  IElementType LIST_OP = new PonyTokenType(";");
  IElementType LOC = new PonyTokenType("__loc");
  IElementType LPAREN = new PonyTokenType("(");
  IElementType LPAREN_NEW = new PonyTokenType("LPAREN_NEW");
  IElementType LSHIFT = new PonyTokenType("<<");
  IElementType LSHIFT_UNSAFE = new PonyTokenType("<<~");
  IElementType LSQUARE = new PonyTokenType("LSQUARE");
  IElementType LSQUARE_NEW = new PonyTokenType("LSQUARE_NEW");
  IElementType LTE_OP = new PonyTokenType("<=");
  IElementType LTE_UNSAFE = new PonyTokenType("<=~");
  IElementType LT_OP = new PonyTokenType("<");
  IElementType LT_UNSAFE = new PonyTokenType("<~");
  IElementType MATCH = new PonyTokenType("match");
  IElementType MINUS_NEW = new PonyTokenType("MINUS_NEW");
  IElementType MINUS_OP = new PonyTokenType("-");
  IElementType MINUS_TILDE = new PonyTokenType("MINUS_TILDE");
  IElementType MINUS_TILDE_NEW = new PonyTokenType("MINUS_TILDE_NEW");
  IElementType MODULO = new PonyTokenType("%%");
  IElementType MODULO_UNSAFE = new PonyTokenType("%%~");
  IElementType MULT_OP = new PonyTokenType("*");
  IElementType MULT_UNSAFE = new PonyTokenType("*~");
  IElementType NEW = new PonyTokenType("new");
  IElementType NON_EQUALITY = new PonyTokenType("!=");
  IElementType NON_EQUALITY_UNSAFE = new PonyTokenType("!=~");
  IElementType NOT = new PonyTokenType("not");
  IElementType NUMBER = new PonyTokenType("NUMBER");
  IElementType OBJECT = new PonyTokenType("object");
  IElementType OR = new PonyTokenType("or");
  IElementType PARTIAL_OP = new PonyTokenType("PARTIAL_OP");
  IElementType PIPE_OP = new PonyTokenType("|");
  IElementType PLUS_OP = new PonyTokenType("+");
  IElementType PLUS_UNSAFE = new PonyTokenType("+~");
  IElementType PRIMITIVE = new PonyTokenType("primitive");
  IElementType RBRACE = new PonyTokenType("}");
  IElementType RECOVER = new PonyTokenType("recover");
  IElementType REF = new PonyTokenType("ref");
  IElementType REMAINDER = new PonyTokenType("%");
  IElementType REMAINDER_UNSAFE = new PonyTokenType("%~");
  IElementType REPEAT = new PonyTokenType("repeat");
  IElementType RETURN = new PonyTokenType("return");
  IElementType RPAREN = new PonyTokenType(")");
  IElementType RSHIFT = new PonyTokenType(">>");
  IElementType RSHIFT_UNSAFE = new PonyTokenType(">>~");
  IElementType RSQUARE = new PonyTokenType("RSQUARE");
  IElementType STRING = new PonyTokenType("STRING");
  IElementType STRUCT = new PonyTokenType("struct");
  IElementType TAG = new PonyTokenType("tag");
  IElementType THEN = new PonyTokenType("then");
  IElementType THIS = new PonyTokenType("this");
  IElementType THREE_DOTS = new PonyTokenType("...");
  IElementType THROWS = new PonyTokenType("?");
  IElementType TRAIT = new PonyTokenType("trait");
  IElementType TRN = new PonyTokenType("trn");
  IElementType TRUE = new PonyTokenType("true");
  IElementType TRY = new PonyTokenType("try");
  IElementType TYPE = new PonyTokenType("type");
  IElementType TYPE_EQ = new PonyTokenType("<::=");
  IElementType TYPE_OP = new PonyTokenType("TYPE_OP");
  IElementType UNTIL = new PonyTokenType("until");
  IElementType USE = new PonyTokenType("use");
  IElementType VAL = new PonyTokenType("val");
  IElementType VAR = new PonyTokenType("var");
  IElementType WHERE = new PonyTokenType("where");
  IElementType WHILE = new PonyTokenType("while");
  IElementType WITH = new PonyTokenType("with");
  IElementType XOR = new PonyTokenType("xor");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ANNOTATEDRAWSEQ) {
        return new PonyAnnotatedrawseqImpl(node);
      }
      else if (type == ANNOTATIONS) {
        return new PonyAnnotationsImpl(node);
      }
      else if (type == ASSIGNMENT) {
        return new PonyAssignmentImpl(node);
      }
      else if (type == AS_OP) {
        return new PonyAsOpImpl(node);
      }
      else if (type == ATOM) {
        return new PonyAtomImpl(node);
      }
      else if (type == ATOMTYPE) {
        return new PonyAtomtypeImpl(node);
      }
      else if (type == BARELAMBDATYPE) {
        return new PonyBarelambdatypeImpl(node);
      }
      else if (type == BINOP) {
        return new PonyBinopImpl(node);
      }
      else if (type == CALL) {
        return new PonyCallImpl(node);
      }
      else if (type == CALLSITE) {
        return new PonyCallsiteImpl(node);
      }
      else if (type == CAP) {
        return new PonyCapImpl(node);
      }
      else if (type == CASEEXPR) {
        return new PonyCaseexprImpl(node);
      }
      else if (type == CHAIN) {
        return new PonyChainImpl(node);
      }
      else if (type == CLASS_DEF) {
        return new PonyClassDefImpl(node);
      }
      else if (type == CLASS_NAME) {
        return new PonyClassNameImpl(node);
      }
      else if (type == CLASS_TYPE) {
        return new PonyClassTypeImpl(node);
      }
      else if (type == CONSUME_TERM) {
        return new PonyConsumeTermImpl(node);
      }
      else if (type == DOC_STRING) {
        return new PonyDocStringImpl(node);
      }
      else if (type == ELSEIFDEF) {
        return new PonyElseifdefImpl(node);
      }
      else if (type == ELSEIFTYPE) {
        return new PonyElseiftypeImpl(node);
      }
      else if (type == ELSEIF_) {
        return new PonyElseif_Impl(node);
      }
      else if (type == EXPRSEQ) {
        return new PonyExprseqImpl(node);
      }
      else if (type == FFI_DECL) {
        return new PonyFfiDeclImpl(node);
      }
      else if (type == FIELD_DECL) {
        return new PonyFieldDeclImpl(node);
      }
      else if (type == FIELD_NAME) {
        return new PonyFieldNameImpl(node);
      }
      else if (type == FIELD_TYPE) {
        return new PonyFieldTypeImpl(node);
      }
      else if (type == FOR_TERM) {
        return new PonyForTermImpl(node);
      }
      else if (type == GENCAP) {
        return new PonyGencapImpl(node);
      }
      else if (type == HASH_TERM) {
        return new PonyHashTermImpl(node);
      }
      else if (type == IDSEQ) {
        return new PonyIdseqImpl(node);
      }
      else if (type == IDSEQ_IN_SEQ) {
        return new PonyIdseqInSeqImpl(node);
      }
      else if (type == IFDEF_TERM) {
        return new PonyIfdefTermImpl(node);
      }
      else if (type == IFTYPE_) {
        return new PonyIftype_Impl(node);
      }
      else if (type == IFTYPE_TERM) {
        return new PonyIftypeTermImpl(node);
      }
      else if (type == IF_TERM) {
        return new PonyIfTermImpl(node);
      }
      else if (type == INFIX) {
        return new PonyInfixImpl(node);
      }
      else if (type == INFIXTYPE) {
        return new PonyInfixtypeImpl(node);
      }
      else if (type == ISECTTYPE) {
        return new PonyIsecttypeImpl(node);
      }
      else if (type == ISOP) {
        return new PonyIsopImpl(node);
      }
      else if (type == JUMP) {
        return new PonyJumpImpl(node);
      }
      else if (type == LAMBDACAPTURE) {
        return new PonyLambdacaptureImpl(node);
      }
      else if (type == LAMBDACAPTURES) {
        return new PonyLambdacapturesImpl(node);
      }
      else if (type == LAMBDAPARAM) {
        return new PonyLambdaparamImpl(node);
      }
      else if (type == LAMBDAPARAMS) {
        return new PonyLambdaparamsImpl(node);
      }
      else if (type == LAMBDATYPE) {
        return new PonyLambdatypeImpl(node);
      }
      else if (type == LAMBDA_DECL) {
        return new PonyLambdaDeclImpl(node);
      }
      else if (type == LITERAL) {
        return new PonyLiteralImpl(node);
      }
      else if (type == MATCH_TERM) {
        return new PonyMatchTermImpl(node);
      }
      else if (type == MEMBERS) {
        return new PonyMembersImpl(node);
      }
      else if (type == METHOD_BODY) {
        return new PonyMethodBodyImpl(node);
      }
      else if (type == METHOD_BODY_DECL) {
        return new PonyMethodBodyDeclImpl(node);
      }
      else if (type == METHOD_DECL) {
        return new PonyMethodDeclImpl(node);
      }
      else if (type == METHOD_NAME) {
        return new PonyMethodNameImpl(node);
      }
      else if (type == METHOD_TYPE) {
        return new PonyMethodTypeImpl(node);
      }
      else if (type == NAMED) {
        return new PonyNamedImpl(node);
      }
      else if (type == NAMEDARG) {
        return new PonyNamedargImpl(node);
      }
      else if (type == NEXTASSIGNMENT) {
        return new PonyNextassignmentImpl(node);
      }
      else if (type == NEXTATOM) {
        return new PonyNextatomImpl(node);
      }
      else if (type == NEXTEXPRSEQ) {
        return new PonyNextexprseqImpl(node);
      }
      else if (type == NEXTINFIX) {
        return new PonyNextinfixImpl(node);
      }
      else if (type == NEXTPARAMPATTERN) {
        return new PonyNextparampatternImpl(node);
      }
      else if (type == NEXTPATTERN) {
        return new PonyNextpatternImpl(node);
      }
      else if (type == NEXTPOSTFIX) {
        return new PonyNextpostfixImpl(node);
      }
      else if (type == NEXTTERM) {
        return new PonyNexttermImpl(node);
      }
      else if (type == NEXT_TUPLE_DECL) {
        return new PonyNextTupleDeclImpl(node);
      }
      else if (type == NOMINAL) {
        return new PonyNominalImpl(node);
      }
      else if (type == NOSEMI) {
        return new PonyNosemiImpl(node);
      }
      else if (type == OBJECT_DECL) {
        return new PonyObjectDeclImpl(node);
      }
      else if (type == PARAM) {
        return new PonyParamImpl(node);
      }
      else if (type == PARAMPATTERN) {
        return new PonyParampatternImpl(node);
      }
      else if (type == PARAMS) {
        return new PonyParamsImpl(node);
      }
      else if (type == PATTERN) {
        return new PonyPatternImpl(node);
      }
      else if (type == POSITIONAL) {
        return new PonyPositionalImpl(node);
      }
      else if (type == POSTFIX) {
        return new PonyPostfixImpl(node);
      }
      else if (type == RAWSEQ) {
        return new PonyRawseqImpl(node);
      }
      else if (type == RECOVER_TERM) {
        return new PonyRecoverTermImpl(node);
      }
      else if (type == REPEAT_TERM) {
        return new PonyRepeatTermImpl(node);
      }
      else if (type == SEMIEXPR) {
        return new PonySemiexprImpl(node);
      }
      else if (type == TERM) {
        return new PonyTermImpl(node);
      }
      else if (type == TILDE) {
        return new PonyTildeImpl(node);
      }
      else if (type == TRY_TERM) {
        return new PonyTryTermImpl(node);
      }
      else if (type == TUPLE) {
        return new PonyTupleImpl(node);
      }
      else if (type == TUPLETYPE) {
        return new PonyTupletypeImpl(node);
      }
      else if (type == TUPLE_DECL) {
        return new PonyTupleDeclImpl(node);
      }
      else if (type == TYPEARG) {
        return new PonyTypeargImpl(node);
      }
      else if (type == TYPEARGS) {
        return new PonyTypeargsImpl(node);
      }
      else if (type == TYPEPARAM) {
        return new PonyTypeparamImpl(node);
      }
      else if (type == TYPEPARAMS) {
        return new PonyTypeparamsImpl(node);
      }
      else if (type == TYPE_) {
        return new PonyType_Impl(node);
      }
      else if (type == TYPE_DECL) {
        return new PonyTypeDeclImpl(node);
      }
      else if (type == UNIONTYPE) {
        return new PonyUniontypeImpl(node);
      }
      else if (type == USE_) {
        return new PonyUse_Impl(node);
      }
      else if (type == USE_ALIAS) {
        return new PonyUseAliasImpl(node);
      }
      else if (type == USE_COND) {
        return new PonyUseCondImpl(node);
      }
      else if (type == USE_FFI) {
        return new PonyUseFfiImpl(node);
      }
      else if (type == WHILE_TERM) {
        return new PonyWhileTermImpl(node);
      }
      else if (type == WITHELEM) {
        return new PonyWithelemImpl(node);
      }
      else if (type == WITH_TERM) {
        return new PonyWithTermImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
