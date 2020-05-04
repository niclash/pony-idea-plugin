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
  IElementType ASSIGNMENT = new PonyElementType("ASSIGNMENT");
  IElementType ATOM = new PonyElementType("ATOM");
  IElementType ATOMTYPE = new PonyElementType("ATOMTYPE");
  IElementType BARELAMBDATYPE = new PonyElementType("BARELAMBDATYPE");
  IElementType BINOP = new PonyElementType("BINOP");
  IElementType CALL = new PonyElementType("CALL");
  IElementType CAP = new PonyElementType("CAP");
  IElementType CASEEXPR = new PonyElementType("CASEEXPR");
  IElementType CHAIN = new PonyElementType("CHAIN");
  IElementType CLASS_DEF = new PonyElementType("CLASS_DEF");
  IElementType DOC_STRING = new PonyElementType("DOC_STRING");
  IElementType DOT = new PonyElementType("DOT");
  IElementType ELSEIF = new PonyElementType("ELSEIF");
  IElementType ELSEIFDEF = new PonyElementType("ELSEIFDEF");
  IElementType ELSEIFTYPE = new PonyElementType("ELSEIFTYPE");
  IElementType EXPRSEQ = new PonyElementType("EXPRSEQ");
  IElementType FFI_DECL = new PonyElementType("FFI_DECL");
  IElementType FIELD = new PonyElementType("FIELD");
  IElementType GENCAP = new PonyElementType("GENCAP");
  IElementType IDSEQ = new PonyElementType("IDSEQ");
  IElementType IDSEQ_IN_SEQ = new PonyElementType("IDSEQ_IN_SEQ");
  IElementType IFTYPE = new PonyElementType("IFTYPE");
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
  IElementType LITERAL = new PonyElementType("LITERAL");
  IElementType MEMBERS = new PonyElementType("MEMBERS");
  IElementType METHOD = new PonyElementType("METHOD");
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
  IElementType NOMINAL = new PonyElementType("NOMINAL");
  IElementType NOSEMI = new PonyElementType("NOSEMI");
  IElementType PARAM = new PonyElementType("PARAM");
  IElementType PARAMPATTERN = new PonyElementType("PARAMPATTERN");
  IElementType PARAMS = new PonyElementType("PARAMS");
  IElementType PATTERN = new PonyElementType("PATTERN");
  IElementType POSITIONAL = new PonyElementType("POSITIONAL");
  IElementType POSTFIX = new PonyElementType("POSTFIX");
  IElementType RAWSEQ = new PonyElementType("RAWSEQ");
  IElementType SEMIEXPR = new PonyElementType("SEMIEXPR");
  IElementType TERM = new PonyElementType("TERM");
  IElementType TILDE = new PonyElementType("TILDE");
  IElementType TUPLE = new PonyElementType("TUPLE");
  IElementType TUPLETYPE = new PonyElementType("TUPLETYPE");
  IElementType TYPE = new PonyElementType("TYPE");
  IElementType TYPEARG = new PonyElementType("TYPEARG");
  IElementType TYPEARGS = new PonyElementType("TYPEARGS");
  IElementType TYPEPARAM = new PonyElementType("TYPEPARAM");
  IElementType TYPEPARAMS = new PonyElementType("TYPEPARAMS");
  IElementType UNIONTYPE = new PonyElementType("UNIONTYPE");
  IElementType USE = new PonyElementType("USE");
  IElementType USE_FFI = new PonyElementType("USE_FFI");
  IElementType WITHELEM = new PonyElementType("WITHELEM");

  IElementType COMMENT = new PonyTokenType("COMMENT");
  IElementType FLOAT = new PonyTokenType("FLOAT");
  IElementType ID = new PonyTokenType("ID");
  IElementType LPAREN_NEW = new PonyTokenType("LPAREN_NEW");
  IElementType LSQUARE_NEW = new PonyTokenType("LSQUARE_NEW");
  IElementType MINUS_NEW = new PonyTokenType("MINUS_NEW");
  IElementType MINUS_TILDE_NEW = new PonyTokenType("MINUS_TILDE_NEW");
  IElementType NUMBER = new PonyTokenType("NUMBER");
  IElementType STRING = new PonyTokenType("STRING");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ANNOTATEDRAWSEQ) {
        return new PonyAnnotatedrawseqImpl(node);
      }
      else if (type == ASSIGNMENT) {
        return new PonyAssignmentImpl(node);
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
      else if (type == DOC_STRING) {
        return new PonyDocStringImpl(node);
      }
      else if (type == DOT) {
        return new PonyDotImpl(node);
      }
      else if (type == ELSEIF) {
        return new PonyElseifImpl(node);
      }
      else if (type == ELSEIFDEF) {
        return new PonyElseifdefImpl(node);
      }
      else if (type == ELSEIFTYPE) {
        return new PonyElseiftypeImpl(node);
      }
      else if (type == EXPRSEQ) {
        return new PonyExprseqImpl(node);
      }
      else if (type == FFI_DECL) {
        return new PonyFfiDeclImpl(node);
      }
      else if (type == FIELD) {
        return new PonyFieldImpl(node);
      }
      else if (type == GENCAP) {
        return new PonyGencapImpl(node);
      }
      else if (type == IDSEQ) {
        return new PonyIdseqImpl(node);
      }
      else if (type == IDSEQ_IN_SEQ) {
        return new PonyIdseqInSeqImpl(node);
      }
      else if (type == IFTYPE) {
        return new PonyIftypeImpl(node);
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
      else if (type == LITERAL) {
        return new PonyLiteralImpl(node);
      }
      else if (type == MEMBERS) {
        return new PonyMembersImpl(node);
      }
      else if (type == METHOD) {
        return new PonyMethodImpl(node);
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
      else if (type == NOMINAL) {
        return new PonyNominalImpl(node);
      }
      else if (type == NOSEMI) {
        return new PonyNosemiImpl(node);
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
      else if (type == SEMIEXPR) {
        return new PonySemiexprImpl(node);
      }
      else if (type == TERM) {
        return new PonyTermImpl(node);
      }
      else if (type == TILDE) {
        return new PonyTildeImpl(node);
      }
      else if (type == TUPLE) {
        return new PonyTupleImpl(node);
      }
      else if (type == TUPLETYPE) {
        return new PonyTupletypeImpl(node);
      }
      else if (type == TYPE) {
        return new PonyTypeImpl(node);
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
      else if (type == UNIONTYPE) {
        return new PonyUniontypeImpl(node);
      }
      else if (type == USE) {
        return new PonyUseImpl(node);
      }
      else if (type == USE_FFI) {
        return new PonyUseFfiImpl(node);
      }
      else if (type == WITHELEM) {
        return new PonyWithelemImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
