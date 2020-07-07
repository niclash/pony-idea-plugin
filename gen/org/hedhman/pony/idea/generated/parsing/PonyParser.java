/* Copyright Niclas Hedhman, 2020. All rights reserved. Licensed under the Apache License, Version 2.0 (the "License"). See LICENSE.txt*/
package org.hedhman.pony.idea.generated.parsing;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.hedhman.pony.idea.generated.parsing.PonyTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class PonyParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return module(b, l + 1);
  }

  /* ********************************************************** */
  // annotations (exprseq | jump)
  public static boolean annotatedrawseq(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotatedrawseq")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ANNOTATEDRAWSEQ, "<annotatedrawseq>");
    r = annotations(b, l + 1);
    r = r && annotatedrawseq_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // exprseq | jump
  private static boolean annotatedrawseq_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotatedrawseq_1")) return false;
    boolean r;
    r = exprseq(b, l + 1);
    if (!r) r = jump(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (BACKSLASH ID (COMMA ID)* BACKSLASH)?
  public static boolean annotations(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotations")) return false;
    Marker m = enter_section_(b, l, _NONE_, ANNOTATIONS, "<annotations>");
    annotations_0(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // BACKSLASH ID (COMMA ID)* BACKSLASH
  private static boolean annotations_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotations_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BACKSLASH, ID);
    r = r && annotations_0_2(b, l + 1);
    r = r && consumeToken(b, BACKSLASH);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA ID)*
  private static boolean annotations_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotations_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!annotations_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "annotations_0_2", c)) break;
    }
    return true;
  }

  // COMMA ID
  private static boolean annotations_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotations_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // AS type_
  public static boolean as_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "as_op")) return false;
    if (!nextTokenIs(b, AS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AS);
    r = r && type_(b, l + 1);
    exit_section_(b, m, AS_OP, r);
    return r;
  }

  /* ********************************************************** */
  // infix (ASSIGN assignment)?
  public static boolean assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT, "<assignment>");
    r = infix(b, l + 1);
    r = r && assignment_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (ASSIGN assignment)?
  private static boolean assignment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_1")) return false;
    assignment_1_0(b, l + 1);
    return true;
  }

  // ASSIGN assignment
  private static boolean assignment_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && assignment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ID
  //   | THIS
  //   | literal
  //   | tuple_decl
  //   | (LSQUARE | LSQUARE_NEW) (AS type_ TYPE_OP)? rawseq? RSQUARE
  //   | object_decl
  //   | lambda_decl
  //   | ffi_decl typeargs? (LPAREN | LPAREN_NEW) positional? named? RPAREN THROWS?
  //   | LOC
  public static boolean atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOM, "<atom>");
    r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, THIS);
    if (!r) r = literal(b, l + 1);
    if (!r) r = tuple_decl(b, l + 1);
    if (!r) r = atom_4(b, l + 1);
    if (!r) r = object_decl(b, l + 1);
    if (!r) r = lambda_decl(b, l + 1);
    if (!r) r = atom_7(b, l + 1);
    if (!r) r = consumeToken(b, LOC);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (LSQUARE | LSQUARE_NEW) (AS type_ TYPE_OP)? rawseq? RSQUARE
  private static boolean atom_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = atom_4_0(b, l + 1);
    r = r && atom_4_1(b, l + 1);
    r = r && atom_4_2(b, l + 1);
    r = r && consumeToken(b, RSQUARE);
    exit_section_(b, m, null, r);
    return r;
  }

  // LSQUARE | LSQUARE_NEW
  private static boolean atom_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_4_0")) return false;
    boolean r;
    r = consumeToken(b, LSQUARE);
    if (!r) r = consumeToken(b, LSQUARE_NEW);
    return r;
  }

  // (AS type_ TYPE_OP)?
  private static boolean atom_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_4_1")) return false;
    atom_4_1_0(b, l + 1);
    return true;
  }

  // AS type_ TYPE_OP
  private static boolean atom_4_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_4_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AS);
    r = r && type_(b, l + 1);
    r = r && consumeToken(b, TYPE_OP);
    exit_section_(b, m, null, r);
    return r;
  }

  // rawseq?
  private static boolean atom_4_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_4_2")) return false;
    rawseq(b, l + 1);
    return true;
  }

  // ffi_decl typeargs? (LPAREN | LPAREN_NEW) positional? named? RPAREN THROWS?
  private static boolean atom_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ffi_decl(b, l + 1);
    r = r && atom_7_1(b, l + 1);
    r = r && atom_7_2(b, l + 1);
    r = r && atom_7_3(b, l + 1);
    r = r && atom_7_4(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && atom_7_6(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // typeargs?
  private static boolean atom_7_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_7_1")) return false;
    typeargs(b, l + 1);
    return true;
  }

  // LPAREN | LPAREN_NEW
  private static boolean atom_7_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_7_2")) return false;
    boolean r;
    r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, LPAREN_NEW);
    return r;
  }

  // positional?
  private static boolean atom_7_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_7_3")) return false;
    positional(b, l + 1);
    return true;
  }

  // named?
  private static boolean atom_7_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_7_4")) return false;
    named(b, l + 1);
    return true;
  }

  // THROWS?
  private static boolean atom_7_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_7_6")) return false;
    consumeToken(b, THROWS);
    return true;
  }

  /* ********************************************************** */
  // THIS
  //   | cap
  //   | (LPAREN | LPAREN_NEW) infixtype tupletype? RPAREN
  //   | nominal
  //   | lambdatype
  //   | barelambdatype
  public static boolean atomtype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomtype")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOMTYPE, "<atomtype>");
    r = consumeToken(b, THIS);
    if (!r) r = cap(b, l + 1);
    if (!r) r = atomtype_2(b, l + 1);
    if (!r) r = nominal(b, l + 1);
    if (!r) r = lambdatype(b, l + 1);
    if (!r) r = barelambdatype(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (LPAREN | LPAREN_NEW) infixtype tupletype? RPAREN
  private static boolean atomtype_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomtype_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = atomtype_2_0(b, l + 1);
    r = r && infixtype(b, l + 1);
    r = r && atomtype_2_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // LPAREN | LPAREN_NEW
  private static boolean atomtype_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomtype_2_0")) return false;
    boolean r;
    r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, LPAREN_NEW);
    return r;
  }

  // tupletype?
  private static boolean atomtype_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomtype_2_2")) return false;
    tupletype(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ATLBRACE cap? ID? typeparams? (LPAREN | LPAREN_NEW) (type_ (COMMA type_)*)? RPAREN (TYPE_OP type_)? THROWS? RBRACE (cap | gencap)? (HAT | BANG)?
  public static boolean barelambdatype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype")) return false;
    if (!nextTokenIs(b, ATLBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ATLBRACE);
    r = r && barelambdatype_1(b, l + 1);
    r = r && barelambdatype_2(b, l + 1);
    r = r && barelambdatype_3(b, l + 1);
    r = r && barelambdatype_4(b, l + 1);
    r = r && barelambdatype_5(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && barelambdatype_7(b, l + 1);
    r = r && barelambdatype_8(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    r = r && barelambdatype_10(b, l + 1);
    r = r && barelambdatype_11(b, l + 1);
    exit_section_(b, m, BARELAMBDATYPE, r);
    return r;
  }

  // cap?
  private static boolean barelambdatype_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_1")) return false;
    cap(b, l + 1);
    return true;
  }

  // ID?
  private static boolean barelambdatype_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_2")) return false;
    consumeToken(b, ID);
    return true;
  }

  // typeparams?
  private static boolean barelambdatype_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_3")) return false;
    typeparams(b, l + 1);
    return true;
  }

  // LPAREN | LPAREN_NEW
  private static boolean barelambdatype_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_4")) return false;
    boolean r;
    r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, LPAREN_NEW);
    return r;
  }

  // (type_ (COMMA type_)*)?
  private static boolean barelambdatype_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_5")) return false;
    barelambdatype_5_0(b, l + 1);
    return true;
  }

  // type_ (COMMA type_)*
  private static boolean barelambdatype_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_(b, l + 1);
    r = r && barelambdatype_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA type_)*
  private static boolean barelambdatype_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_5_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!barelambdatype_5_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "barelambdatype_5_0_1", c)) break;
    }
    return true;
  }

  // COMMA type_
  private static boolean barelambdatype_5_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_5_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && type_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (TYPE_OP type_)?
  private static boolean barelambdatype_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_7")) return false;
    barelambdatype_7_0(b, l + 1);
    return true;
  }

  // TYPE_OP type_
  private static boolean barelambdatype_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE_OP);
    r = r && type_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THROWS?
  private static boolean barelambdatype_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_8")) return false;
    consumeToken(b, THROWS);
    return true;
  }

  // (cap | gencap)?
  private static boolean barelambdatype_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_10")) return false;
    barelambdatype_10_0(b, l + 1);
    return true;
  }

  // cap | gencap
  private static boolean barelambdatype_10_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_10_0")) return false;
    boolean r;
    r = cap(b, l + 1);
    if (!r) r = gencap(b, l + 1);
    return r;
  }

  // (HAT | BANG)?
  private static boolean barelambdatype_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_11")) return false;
    barelambdatype_11_0(b, l + 1);
    return true;
  }

  // HAT | BANG
  private static boolean barelambdatype_11_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_11_0")) return false;
    boolean r;
    r = consumeToken(b, HAT);
    if (!r) r = consumeToken(b, BANG);
    return r;
  }

  /* ********************************************************** */
  // (AND | OR | XOR
  //        | PLUS_OP | MINUS_OP | MULT_OP | DIV_OP | REMAINDER | MODULO
  //        | PLUS_UNSAFE | MINUS_TILDE | MULT_UNSAFE | DIV_UNSAFE | REMAINDER_UNSAFE | MODULO_UNSAFE
  //        | LSHIFT | RSHIFT | LSHIFT_UNSAFE | RSHIFT_UNSAFE
  //        | EQUALITY | NON_EQUALITY | LT_OP | LTE_OP | GT_OP | GTE_OP
  //        | EQUALITY_UNSAFE | NON_EQUALITY_UNSAFE | LT_UNSAFE | LTE_UNSAFE | GT_UNSAFE | GTE_UNSAFE) THROWS? term
  public static boolean binop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binop")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BINOP, "<binop>");
    r = binop_0(b, l + 1);
    r = r && binop_1(b, l + 1);
    r = r && term(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // AND | OR | XOR
  //        | PLUS_OP | MINUS_OP | MULT_OP | DIV_OP | REMAINDER | MODULO
  //        | PLUS_UNSAFE | MINUS_TILDE | MULT_UNSAFE | DIV_UNSAFE | REMAINDER_UNSAFE | MODULO_UNSAFE
  //        | LSHIFT | RSHIFT | LSHIFT_UNSAFE | RSHIFT_UNSAFE
  //        | EQUALITY | NON_EQUALITY | LT_OP | LTE_OP | GT_OP | GTE_OP
  //        | EQUALITY_UNSAFE | NON_EQUALITY_UNSAFE | LT_UNSAFE | LTE_UNSAFE | GT_UNSAFE | GTE_UNSAFE
  private static boolean binop_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binop_0")) return false;
    boolean r;
    r = consumeToken(b, AND);
    if (!r) r = consumeToken(b, OR);
    if (!r) r = consumeToken(b, XOR);
    if (!r) r = consumeToken(b, PLUS_OP);
    if (!r) r = consumeToken(b, MINUS_OP);
    if (!r) r = consumeToken(b, MULT_OP);
    if (!r) r = consumeToken(b, DIV_OP);
    if (!r) r = consumeToken(b, REMAINDER);
    if (!r) r = consumeToken(b, MODULO);
    if (!r) r = consumeToken(b, PLUS_UNSAFE);
    if (!r) r = consumeToken(b, MINUS_TILDE);
    if (!r) r = consumeToken(b, MULT_UNSAFE);
    if (!r) r = consumeToken(b, DIV_UNSAFE);
    if (!r) r = consumeToken(b, REMAINDER_UNSAFE);
    if (!r) r = consumeToken(b, MODULO_UNSAFE);
    if (!r) r = consumeToken(b, LSHIFT);
    if (!r) r = consumeToken(b, RSHIFT);
    if (!r) r = consumeToken(b, LSHIFT_UNSAFE);
    if (!r) r = consumeToken(b, RSHIFT_UNSAFE);
    if (!r) r = consumeToken(b, EQUALITY);
    if (!r) r = consumeToken(b, NON_EQUALITY);
    if (!r) r = consumeToken(b, LT_OP);
    if (!r) r = consumeToken(b, LTE_OP);
    if (!r) r = consumeToken(b, GT_OP);
    if (!r) r = consumeToken(b, GTE_OP);
    if (!r) r = consumeToken(b, EQUALITY_UNSAFE);
    if (!r) r = consumeToken(b, NON_EQUALITY_UNSAFE);
    if (!r) r = consumeToken(b, LT_UNSAFE);
    if (!r) r = consumeToken(b, LTE_UNSAFE);
    if (!r) r = consumeToken(b, GT_UNSAFE);
    if (!r) r = consumeToken(b, GTE_UNSAFE);
    return r;
  }

  // THROWS?
  private static boolean binop_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binop_1")) return false;
    consumeToken(b, THROWS);
    return true;
  }

  /* ********************************************************** */
  // LPAREN positional? named? RPAREN THROWS?
  public static boolean call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && call_1(b, l + 1);
    r = r && call_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && call_4(b, l + 1);
    exit_section_(b, m, CALL, r);
    return r;
  }

  // positional?
  private static boolean call_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_1")) return false;
    positional(b, l + 1);
    return true;
  }

  // named?
  private static boolean call_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_2")) return false;
    named(b, l + 1);
    return true;
  }

  // THROWS?
  private static boolean call_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_4")) return false;
    consumeToken(b, THROWS);
    return true;
  }

  /* ********************************************************** */
  // CALL_OP ID
  public static boolean callsite(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callsite")) return false;
    if (!nextTokenIs(b, CALL_OP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CALL_OP, ID);
    exit_section_(b, m, CALLSITE, r);
    return r;
  }

  /* ********************************************************** */
  // ISO
  //   | TRN
  //   | REF
  //   | VAL
  //   | BOX
  //   | TAG
  public static boolean cap(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cap")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CAP, "<cap>");
    r = consumeToken(b, ISO);
    if (!r) r = consumeToken(b, TRN);
    if (!r) r = consumeToken(b, REF);
    if (!r) r = consumeToken(b, VAL);
    if (!r) r = consumeToken(b, BOX);
    if (!r) r = consumeToken(b, TAG);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PIPE_OP annotations pattern? (IF rawseq)? (ARROW rawseq)?
  public static boolean caseexpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseexpr")) return false;
    if (!nextTokenIs(b, PIPE_OP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PIPE_OP);
    r = r && annotations(b, l + 1);
    r = r && caseexpr_2(b, l + 1);
    r = r && caseexpr_3(b, l + 1);
    r = r && caseexpr_4(b, l + 1);
    exit_section_(b, m, CASEEXPR, r);
    return r;
  }

  // pattern?
  private static boolean caseexpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseexpr_2")) return false;
    pattern(b, l + 1);
    return true;
  }

  // (IF rawseq)?
  private static boolean caseexpr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseexpr_3")) return false;
    caseexpr_3_0(b, l + 1);
    return true;
  }

  // IF rawseq
  private static boolean caseexpr_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseexpr_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && rawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ARROW rawseq)?
  private static boolean caseexpr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseexpr_4")) return false;
    caseexpr_4_0(b, l + 1);
    return true;
  }

  // ARROW rawseq
  private static boolean caseexpr_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseexpr_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ARROW);
    r = r && rawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CHAIN_OP ID
  public static boolean chain(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chain")) return false;
    if (!nextTokenIs(b, CHAIN_OP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CHAIN_OP, ID);
    exit_section_(b, m, CHAIN, r);
    return r;
  }

  /* ********************************************************** */
  // class_type annotations FFI_CHAR? cap? class_name typeparams? type_decl doc_string? members
  public static boolean class_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_DEF, "<class def>");
    r = class_type(b, l + 1);
    r = r && annotations(b, l + 1);
    r = r && class_def_2(b, l + 1);
    r = r && class_def_3(b, l + 1);
    r = r && class_name(b, l + 1);
    r = r && class_def_5(b, l + 1);
    r = r && type_decl(b, l + 1);
    r = r && class_def_7(b, l + 1);
    r = r && members(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // FFI_CHAR?
  private static boolean class_def_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_2")) return false;
    consumeToken(b, FFI_CHAR);
    return true;
  }

  // cap?
  private static boolean class_def_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_3")) return false;
    cap(b, l + 1);
    return true;
  }

  // typeparams?
  private static boolean class_def_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_5")) return false;
    typeparams(b, l + 1);
    return true;
  }

  // doc_string?
  private static boolean class_def_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_7")) return false;
    doc_string(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ID
  public static boolean class_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_name")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, CLASS_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // TYPE | INTERFACE | TRAIT | PRIMITIVE | STRUCT | CLASS | ACTOR
  public static boolean class_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_TYPE, "<class type>");
    r = consumeToken(b, TYPE);
    if (!r) r = consumeToken(b, INTERFACE);
    if (!r) r = consumeToken(b, TRAIT);
    if (!r) r = consumeToken(b, PRIMITIVE);
    if (!r) r = consumeToken(b, STRUCT);
    if (!r) r = consumeToken(b, CLASS);
    if (!r) r = consumeToken(b, ACTOR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CONSUME cap? term
  public static boolean consume_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consume_term")) return false;
    if (!nextTokenIs(b, CONSUME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONSUME);
    r = r && consume_term_1(b, l + 1);
    r = r && term(b, l + 1);
    exit_section_(b, m, CONSUME_TERM, r);
    return r;
  }

  // cap?
  private static boolean consume_term_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consume_term_1")) return false;
    cap(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // STRING
  public static boolean doc_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc_string")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, DOC_STRING, r);
    return r;
  }

  /* ********************************************************** */
  // ELSEIF annotations rawseq THEN rawseq (elseif_ | (ELSE annotatedrawseq))?
  public static boolean elseif_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseif_")) return false;
    if (!nextTokenIs(b, ELSEIF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSEIF);
    r = r && annotations(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && rawseq(b, l + 1);
    r = r && elseif__5(b, l + 1);
    exit_section_(b, m, ELSEIF_, r);
    return r;
  }

  // (elseif_ | (ELSE annotatedrawseq))?
  private static boolean elseif__5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseif__5")) return false;
    elseif__5_0(b, l + 1);
    return true;
  }

  // elseif_ | (ELSE annotatedrawseq)
  private static boolean elseif__5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseif__5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elseif_(b, l + 1);
    if (!r) r = elseif__5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ELSE annotatedrawseq
  private static boolean elseif__5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseif__5_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ELSEIF annotations infix THEN rawseq (elseifdef | (ELSE annotatedrawseq))?
  public static boolean elseifdef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseifdef")) return false;
    if (!nextTokenIs(b, ELSEIF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSEIF);
    r = r && annotations(b, l + 1);
    r = r && infix(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && rawseq(b, l + 1);
    r = r && elseifdef_5(b, l + 1);
    exit_section_(b, m, ELSEIFDEF, r);
    return r;
  }

  // (elseifdef | (ELSE annotatedrawseq))?
  private static boolean elseifdef_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseifdef_5")) return false;
    elseifdef_5_0(b, l + 1);
    return true;
  }

  // elseifdef | (ELSE annotatedrawseq)
  private static boolean elseifdef_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseifdef_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elseifdef(b, l + 1);
    if (!r) r = elseifdef_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ELSE annotatedrawseq
  private static boolean elseifdef_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseifdef_5_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ELSEIF annotations iftype_ (elseiftype | (ELSE annotatedrawseq))?
  public static boolean elseiftype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseiftype")) return false;
    if (!nextTokenIs(b, ELSEIF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSEIF);
    r = r && annotations(b, l + 1);
    r = r && iftype_(b, l + 1);
    r = r && elseiftype_3(b, l + 1);
    exit_section_(b, m, ELSEIFTYPE, r);
    return r;
  }

  // (elseiftype | (ELSE annotatedrawseq))?
  private static boolean elseiftype_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseiftype_3")) return false;
    elseiftype_3_0(b, l + 1);
    return true;
  }

  // elseiftype | (ELSE annotatedrawseq)
  private static boolean elseiftype_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseiftype_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elseiftype(b, l + 1);
    if (!r) r = elseiftype_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ELSE annotatedrawseq
  private static boolean elseiftype_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseiftype_3_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // assignment (semiexpr | nosemi)?
  public static boolean exprseq(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprseq")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRSEQ, "<exprseq>");
    r = assignment(b, l + 1);
    r = r && exprseq_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (semiexpr | nosemi)?
  private static boolean exprseq_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprseq_1")) return false;
    exprseq_1_0(b, l + 1);
    return true;
  }

  // semiexpr | nosemi
  private static boolean exprseq_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprseq_1_0")) return false;
    boolean r;
    r = semiexpr(b, l + 1);
    if (!r) r = nosemi(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // FFI_CHAR (ID | STRING) typeargs? (LPAREN | LPAREN_NEW) positional? named? RPAREN THROWS?
  public static boolean ffi_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ffi_decl")) return false;
    if (!nextTokenIs(b, FFI_CHAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FFI_CHAR);
    r = r && ffi_decl_1(b, l + 1);
    r = r && ffi_decl_2(b, l + 1);
    r = r && ffi_decl_3(b, l + 1);
    r = r && ffi_decl_4(b, l + 1);
    r = r && ffi_decl_5(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && ffi_decl_7(b, l + 1);
    exit_section_(b, m, FFI_DECL, r);
    return r;
  }

  // ID | STRING
  private static boolean ffi_decl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ffi_decl_1")) return false;
    boolean r;
    r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, STRING);
    return r;
  }

  // typeargs?
  private static boolean ffi_decl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ffi_decl_2")) return false;
    typeargs(b, l + 1);
    return true;
  }

  // LPAREN | LPAREN_NEW
  private static boolean ffi_decl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ffi_decl_3")) return false;
    boolean r;
    r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, LPAREN_NEW);
    return r;
  }

  // positional?
  private static boolean ffi_decl_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ffi_decl_4")) return false;
    positional(b, l + 1);
    return true;
  }

  // named?
  private static boolean ffi_decl_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ffi_decl_5")) return false;
    named(b, l + 1);
    return true;
  }

  // THROWS?
  private static boolean ffi_decl_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ffi_decl_7")) return false;
    consumeToken(b, THROWS);
    return true;
  }

  /* ********************************************************** */
  // field_type field_name TYPE_OP type_ (ASSIGN infix)? doc_string?
  public static boolean field_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_decl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_DECL, "<field decl>");
    r = field_type(b, l + 1);
    r = r && field_name(b, l + 1);
    r = r && consumeToken(b, TYPE_OP);
    r = r && type_(b, l + 1);
    r = r && field_decl_4(b, l + 1);
    r = r && field_decl_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (ASSIGN infix)?
  private static boolean field_decl_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_decl_4")) return false;
    field_decl_4_0(b, l + 1);
    return true;
  }

  // ASSIGN infix
  private static boolean field_decl_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_decl_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && infix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // doc_string?
  private static boolean field_decl_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_decl_5")) return false;
    doc_string(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ID
  public static boolean field_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_name")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, FIELD_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // VAR | LET | EMBED
  public static boolean field_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_TYPE, "<field type>");
    r = consumeToken(b, VAR);
    if (!r) r = consumeToken(b, LET);
    if (!r) r = consumeToken(b, EMBED);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // FOR annotations idseq IN rawseq DO rawseq (ELSE annotatedrawseq)? END
  public static boolean for_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_term")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR);
    r = r && annotations(b, l + 1);
    r = r && idseq(b, l + 1);
    r = r && consumeToken(b, IN);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, DO);
    r = r && rawseq(b, l + 1);
    r = r && for_term_7(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, FOR_TERM, r);
    return r;
  }

  // (ELSE annotatedrawseq)?
  private static boolean for_term_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_term_7")) return false;
    for_term_7_0(b, l + 1);
    return true;
  }

  // ELSE annotatedrawseq
  private static boolean for_term_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_term_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // HASH_READ
  //   | HASH_SEND
  //   | HASH_SHARE
  //   | HASH_ALIAS
  //   | HASH_ANY
  public static boolean gencap(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gencap")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GENCAP, "<gencap>");
    r = consumeToken(b, HASH_READ);
    if (!r) r = consumeToken(b, HASH_SEND);
    if (!r) r = consumeToken(b, HASH_SHARE);
    if (!r) r = consumeToken(b, HASH_ALIAS);
    if (!r) r = consumeToken(b, HASH_ANY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // HASH postfix
  public static boolean hash_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hash_term")) return false;
    if (!nextTokenIs(b, HASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HASH);
    r = r && postfix(b, l + 1);
    exit_section_(b, m, HASH_TERM, r);
    return r;
  }

  /* ********************************************************** */
  // ID | (LPAREN | LPAREN_NEW) idseq_in_seq (COMMA idseq_in_seq)* RPAREN
  public static boolean idseq(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDSEQ, "<idseq>");
    r = consumeToken(b, ID);
    if (!r) r = idseq_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (LPAREN | LPAREN_NEW) idseq_in_seq (COMMA idseq_in_seq)* RPAREN
  private static boolean idseq_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = idseq_1_0(b, l + 1);
    r = r && idseq_in_seq(b, l + 1);
    r = r && idseq_1_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // LPAREN | LPAREN_NEW
  private static boolean idseq_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq_1_0")) return false;
    boolean r;
    r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, LPAREN_NEW);
    return r;
  }

  // (COMMA idseq_in_seq)*
  private static boolean idseq_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq_1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!idseq_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "idseq_1_2", c)) break;
    }
    return true;
  }

  // COMMA idseq_in_seq
  private static boolean idseq_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && idseq_in_seq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ID | (LPAREN | LPAREN_NEW) idseq_in_seq (COMMA idseq_in_seq)* RPAREN
  public static boolean idseq_in_seq(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq_in_seq")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDSEQ_IN_SEQ, "<idseq in seq>");
    r = consumeToken(b, ID);
    if (!r) r = idseq_in_seq_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (LPAREN | LPAREN_NEW) idseq_in_seq (COMMA idseq_in_seq)* RPAREN
  private static boolean idseq_in_seq_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq_in_seq_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = idseq_in_seq_1_0(b, l + 1);
    r = r && idseq_in_seq(b, l + 1);
    r = r && idseq_in_seq_1_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // LPAREN | LPAREN_NEW
  private static boolean idseq_in_seq_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq_in_seq_1_0")) return false;
    boolean r;
    r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, LPAREN_NEW);
    return r;
  }

  // (COMMA idseq_in_seq)*
  private static boolean idseq_in_seq_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq_in_seq_1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!idseq_in_seq_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "idseq_in_seq_1_2", c)) break;
    }
    return true;
  }

  // COMMA idseq_in_seq
  private static boolean idseq_in_seq_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq_in_seq_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && idseq_in_seq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IF annotations rawseq THEN rawseq (elseif_ | (ELSE annotatedrawseq))? END
  public static boolean if_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_term")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && annotations(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && rawseq(b, l + 1);
    r = r && if_term_5(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, IF_TERM, r);
    return r;
  }

  // (elseif_ | (ELSE annotatedrawseq))?
  private static boolean if_term_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_term_5")) return false;
    if_term_5_0(b, l + 1);
    return true;
  }

  // elseif_ | (ELSE annotatedrawseq)
  private static boolean if_term_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_term_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elseif_(b, l + 1);
    if (!r) r = if_term_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ELSE annotatedrawseq
  private static boolean if_term_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_term_5_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IFDEF annotations infix THEN rawseq (elseifdef | (ELSE annotatedrawseq))? END
  public static boolean ifdef_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifdef_term")) return false;
    if (!nextTokenIs(b, IFDEF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IFDEF);
    r = r && annotations(b, l + 1);
    r = r && infix(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && rawseq(b, l + 1);
    r = r && ifdef_term_5(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, IFDEF_TERM, r);
    return r;
  }

  // (elseifdef | (ELSE annotatedrawseq))?
  private static boolean ifdef_term_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifdef_term_5")) return false;
    ifdef_term_5_0(b, l + 1);
    return true;
  }

  // elseifdef | (ELSE annotatedrawseq)
  private static boolean ifdef_term_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifdef_term_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elseifdef(b, l + 1);
    if (!r) r = ifdef_term_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ELSE annotatedrawseq
  private static boolean ifdef_term_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifdef_term_5_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // type_ TYPE_EQ type_ THEN rawseq
  public static boolean iftype_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iftype_")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IFTYPE_, "<iftype>");
    r = type_(b, l + 1);
    r = r && consumeToken(b, TYPE_EQ);
    r = r && type_(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && rawseq(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IFTYPE annotations iftype_ (elseiftype | (ELSE annotatedrawseq))? END
  public static boolean iftype_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iftype_term")) return false;
    if (!nextTokenIs(b, IFTYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IFTYPE);
    r = r && annotations(b, l + 1);
    r = r && iftype_(b, l + 1);
    r = r && iftype_term_3(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, IFTYPE_TERM, r);
    return r;
  }

  // (elseiftype | (ELSE annotatedrawseq))?
  private static boolean iftype_term_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iftype_term_3")) return false;
    iftype_term_3_0(b, l + 1);
    return true;
  }

  // elseiftype | (ELSE annotatedrawseq)
  private static boolean iftype_term_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iftype_term_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elseiftype(b, l + 1);
    if (!r) r = iftype_term_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ELSE annotatedrawseq
  private static boolean iftype_term_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iftype_term_3_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // term (binop | isop | as_op)*
  public static boolean infix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INFIX, "<infix>");
    r = term(b, l + 1);
    r = r && infix_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (binop | isop | as_op)*
  private static boolean infix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infix_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!infix_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "infix_1", c)) break;
    }
    return true;
  }

  // binop | isop | as_op
  private static boolean infix_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infix_1_0")) return false;
    boolean r;
    r = binop(b, l + 1);
    if (!r) r = isop(b, l + 1);
    if (!r) r = as_op(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // type_ (uniontype | isecttype)*
  public static boolean infixtype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infixtype")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INFIXTYPE, "<infixtype>");
    r = type_(b, l + 1);
    r = r && infixtype_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (uniontype | isecttype)*
  private static boolean infixtype_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infixtype_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!infixtype_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "infixtype_1", c)) break;
    }
    return true;
  }

  // uniontype | isecttype
  private static boolean infixtype_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infixtype_1_0")) return false;
    boolean r;
    r = uniontype(b, l + 1);
    if (!r) r = isecttype(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ISECT_OP type_
  public static boolean isecttype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "isecttype")) return false;
    if (!nextTokenIs(b, ISECT_OP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ISECT_OP);
    r = r && type_(b, l + 1);
    exit_section_(b, m, ISECTTYPE, r);
    return r;
  }

  /* ********************************************************** */
  // (IS | ISNT) term
  public static boolean isop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "isop")) return false;
    if (!nextTokenIs(b, "<isop>", IS, ISNT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ISOP, "<isop>");
    r = isop_0(b, l + 1);
    r = r && term(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IS | ISNT
  private static boolean isop_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "isop_0")) return false;
    boolean r;
    r = consumeToken(b, IS);
    if (!r) r = consumeToken(b, ISNT);
    return r;
  }

  /* ********************************************************** */
  // (RETURN | BREAK | CONTINUE | ERROR | COMPILE_INTRINSIC | COMPILE_ERROR) rawseq?
  public static boolean jump(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jump")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, JUMP, "<jump>");
    r = jump_0(b, l + 1);
    r = r && jump_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // RETURN | BREAK | CONTINUE | ERROR | COMPILE_INTRINSIC | COMPILE_ERROR
  private static boolean jump_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jump_0")) return false;
    boolean r;
    r = consumeToken(b, RETURN);
    if (!r) r = consumeToken(b, BREAK);
    if (!r) r = consumeToken(b, CONTINUE);
    if (!r) r = consumeToken(b, ERROR);
    if (!r) r = consumeToken(b, COMPILE_INTRINSIC);
    if (!r) r = consumeToken(b, COMPILE_ERROR);
    return r;
  }

  // rawseq?
  private static boolean jump_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jump_1")) return false;
    rawseq(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LBRACE annotations cap? ID? typeparams? (LPAREN | LPAREN_NEW) lambdaparams? RPAREN lambdacaptures? (TYPE_OP type_)? THROWS? ARROW rawseq RBRACE cap?
  //   | ATLBRACE annotations cap? ID? typeparams? (LPAREN | LPAREN_NEW) lambdaparams? RPAREN lambdacaptures? (TYPE_OP type_)? THROWS? ARROW rawseq RBRACE cap?
  public static boolean lambda_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_decl")) return false;
    if (!nextTokenIs(b, "<lambda decl>", ATLBRACE, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LAMBDA_DECL, "<lambda decl>");
    r = lambda_decl_0(b, l + 1);
    if (!r) r = lambda_decl_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LBRACE annotations cap? ID? typeparams? (LPAREN | LPAREN_NEW) lambdaparams? RPAREN lambdacaptures? (TYPE_OP type_)? THROWS? ARROW rawseq RBRACE cap?
  private static boolean lambda_decl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_decl_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && annotations(b, l + 1);
    r = r && lambda_decl_0_2(b, l + 1);
    r = r && lambda_decl_0_3(b, l + 1);
    r = r && lambda_decl_0_4(b, l + 1);
    r = r && lambda_decl_0_5(b, l + 1);
    r = r && lambda_decl_0_6(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && lambda_decl_0_8(b, l + 1);
    r = r && lambda_decl_0_9(b, l + 1);
    r = r && lambda_decl_0_10(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    r = r && lambda_decl_0_14(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // cap?
  private static boolean lambda_decl_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_decl_0_2")) return false;
    cap(b, l + 1);
    return true;
  }

  // ID?
  private static boolean lambda_decl_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_decl_0_3")) return false;
    consumeToken(b, ID);
    return true;
  }

  // typeparams?
  private static boolean lambda_decl_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_decl_0_4")) return false;
    typeparams(b, l + 1);
    return true;
  }

  // LPAREN | LPAREN_NEW
  private static boolean lambda_decl_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_decl_0_5")) return false;
    boolean r;
    r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, LPAREN_NEW);
    return r;
  }

  // lambdaparams?
  private static boolean lambda_decl_0_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_decl_0_6")) return false;
    lambdaparams(b, l + 1);
    return true;
  }

  // lambdacaptures?
  private static boolean lambda_decl_0_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_decl_0_8")) return false;
    lambdacaptures(b, l + 1);
    return true;
  }

  // (TYPE_OP type_)?
  private static boolean lambda_decl_0_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_decl_0_9")) return false;
    lambda_decl_0_9_0(b, l + 1);
    return true;
  }

  // TYPE_OP type_
  private static boolean lambda_decl_0_9_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_decl_0_9_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE_OP);
    r = r && type_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THROWS?
  private static boolean lambda_decl_0_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_decl_0_10")) return false;
    consumeToken(b, THROWS);
    return true;
  }

  // cap?
  private static boolean lambda_decl_0_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_decl_0_14")) return false;
    cap(b, l + 1);
    return true;
  }

  // ATLBRACE annotations cap? ID? typeparams? (LPAREN | LPAREN_NEW) lambdaparams? RPAREN lambdacaptures? (TYPE_OP type_)? THROWS? ARROW rawseq RBRACE cap?
  private static boolean lambda_decl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_decl_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ATLBRACE);
    r = r && annotations(b, l + 1);
    r = r && lambda_decl_1_2(b, l + 1);
    r = r && lambda_decl_1_3(b, l + 1);
    r = r && lambda_decl_1_4(b, l + 1);
    r = r && lambda_decl_1_5(b, l + 1);
    r = r && lambda_decl_1_6(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && lambda_decl_1_8(b, l + 1);
    r = r && lambda_decl_1_9(b, l + 1);
    r = r && lambda_decl_1_10(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    r = r && lambda_decl_1_14(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // cap?
  private static boolean lambda_decl_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_decl_1_2")) return false;
    cap(b, l + 1);
    return true;
  }

  // ID?
  private static boolean lambda_decl_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_decl_1_3")) return false;
    consumeToken(b, ID);
    return true;
  }

  // typeparams?
  private static boolean lambda_decl_1_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_decl_1_4")) return false;
    typeparams(b, l + 1);
    return true;
  }

  // LPAREN | LPAREN_NEW
  private static boolean lambda_decl_1_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_decl_1_5")) return false;
    boolean r;
    r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, LPAREN_NEW);
    return r;
  }

  // lambdaparams?
  private static boolean lambda_decl_1_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_decl_1_6")) return false;
    lambdaparams(b, l + 1);
    return true;
  }

  // lambdacaptures?
  private static boolean lambda_decl_1_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_decl_1_8")) return false;
    lambdacaptures(b, l + 1);
    return true;
  }

  // (TYPE_OP type_)?
  private static boolean lambda_decl_1_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_decl_1_9")) return false;
    lambda_decl_1_9_0(b, l + 1);
    return true;
  }

  // TYPE_OP type_
  private static boolean lambda_decl_1_9_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_decl_1_9_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE_OP);
    r = r && type_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THROWS?
  private static boolean lambda_decl_1_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_decl_1_10")) return false;
    consumeToken(b, THROWS);
    return true;
  }

  // cap?
  private static boolean lambda_decl_1_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_decl_1_14")) return false;
    cap(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ID (TYPE_OP type_)? (ASSIGN infix)?
  public static boolean lambdacapture(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacapture")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && lambdacapture_1(b, l + 1);
    r = r && lambdacapture_2(b, l + 1);
    exit_section_(b, m, LAMBDACAPTURE, r);
    return r;
  }

  // (TYPE_OP type_)?
  private static boolean lambdacapture_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacapture_1")) return false;
    lambdacapture_1_0(b, l + 1);
    return true;
  }

  // TYPE_OP type_
  private static boolean lambdacapture_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacapture_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE_OP);
    r = r && type_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ASSIGN infix)?
  private static boolean lambdacapture_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacapture_2")) return false;
    lambdacapture_2_0(b, l + 1);
    return true;
  }

  // ASSIGN infix
  private static boolean lambdacapture_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacapture_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && infix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (LPAREN | LPAREN_NEW) (lambdacapture | THIS) (COMMA (lambdacapture | THIS))* RPAREN
  public static boolean lambdacaptures(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacaptures")) return false;
    if (!nextTokenIs(b, "<lambdacaptures>", LPAREN, LPAREN_NEW)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LAMBDACAPTURES, "<lambdacaptures>");
    r = lambdacaptures_0(b, l + 1);
    r = r && lambdacaptures_1(b, l + 1);
    r = r && lambdacaptures_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LPAREN | LPAREN_NEW
  private static boolean lambdacaptures_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacaptures_0")) return false;
    boolean r;
    r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, LPAREN_NEW);
    return r;
  }

  // lambdacapture | THIS
  private static boolean lambdacaptures_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacaptures_1")) return false;
    boolean r;
    r = lambdacapture(b, l + 1);
    if (!r) r = consumeToken(b, THIS);
    return r;
  }

  // (COMMA (lambdacapture | THIS))*
  private static boolean lambdacaptures_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacaptures_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!lambdacaptures_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lambdacaptures_2", c)) break;
    }
    return true;
  }

  // COMMA (lambdacapture | THIS)
  private static boolean lambdacaptures_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacaptures_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && lambdacaptures_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // lambdacapture | THIS
  private static boolean lambdacaptures_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacaptures_2_0_1")) return false;
    boolean r;
    r = lambdacapture(b, l + 1);
    if (!r) r = consumeToken(b, THIS);
    return r;
  }

  /* ********************************************************** */
  // ID (TYPE_OP type_)? (ASSIGN infix)?
  public static boolean lambdaparam(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaparam")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && lambdaparam_1(b, l + 1);
    r = r && lambdaparam_2(b, l + 1);
    exit_section_(b, m, LAMBDAPARAM, r);
    return r;
  }

  // (TYPE_OP type_)?
  private static boolean lambdaparam_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaparam_1")) return false;
    lambdaparam_1_0(b, l + 1);
    return true;
  }

  // TYPE_OP type_
  private static boolean lambdaparam_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaparam_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE_OP);
    r = r && type_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ASSIGN infix)?
  private static boolean lambdaparam_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaparam_2")) return false;
    lambdaparam_2_0(b, l + 1);
    return true;
  }

  // ASSIGN infix
  private static boolean lambdaparam_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaparam_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && infix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // lambdaparam (COMMA lambdaparam)*
  public static boolean lambdaparams(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaparams")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = lambdaparam(b, l + 1);
    r = r && lambdaparams_1(b, l + 1);
    exit_section_(b, m, LAMBDAPARAMS, r);
    return r;
  }

  // (COMMA lambdaparam)*
  private static boolean lambdaparams_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaparams_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!lambdaparams_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lambdaparams_1", c)) break;
    }
    return true;
  }

  // COMMA lambdaparam
  private static boolean lambdaparams_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaparams_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && lambdaparam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LBRACE cap? ID? typeparams? (LPAREN | LPAREN_NEW) (type_ (COMMA type_)*)? RPAREN (TYPE_OP type_)? THROWS? RBRACE (cap | gencap)? (HAT | BANG)?
  public static boolean lambdatype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && lambdatype_1(b, l + 1);
    r = r && lambdatype_2(b, l + 1);
    r = r && lambdatype_3(b, l + 1);
    r = r && lambdatype_4(b, l + 1);
    r = r && lambdatype_5(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && lambdatype_7(b, l + 1);
    r = r && lambdatype_8(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    r = r && lambdatype_10(b, l + 1);
    r = r && lambdatype_11(b, l + 1);
    exit_section_(b, m, LAMBDATYPE, r);
    return r;
  }

  // cap?
  private static boolean lambdatype_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_1")) return false;
    cap(b, l + 1);
    return true;
  }

  // ID?
  private static boolean lambdatype_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_2")) return false;
    consumeToken(b, ID);
    return true;
  }

  // typeparams?
  private static boolean lambdatype_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_3")) return false;
    typeparams(b, l + 1);
    return true;
  }

  // LPAREN | LPAREN_NEW
  private static boolean lambdatype_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_4")) return false;
    boolean r;
    r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, LPAREN_NEW);
    return r;
  }

  // (type_ (COMMA type_)*)?
  private static boolean lambdatype_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_5")) return false;
    lambdatype_5_0(b, l + 1);
    return true;
  }

  // type_ (COMMA type_)*
  private static boolean lambdatype_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_(b, l + 1);
    r = r && lambdatype_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA type_)*
  private static boolean lambdatype_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_5_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!lambdatype_5_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lambdatype_5_0_1", c)) break;
    }
    return true;
  }

  // COMMA type_
  private static boolean lambdatype_5_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_5_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && type_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (TYPE_OP type_)?
  private static boolean lambdatype_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_7")) return false;
    lambdatype_7_0(b, l + 1);
    return true;
  }

  // TYPE_OP type_
  private static boolean lambdatype_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE_OP);
    r = r && type_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THROWS?
  private static boolean lambdatype_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_8")) return false;
    consumeToken(b, THROWS);
    return true;
  }

  // (cap | gencap)?
  private static boolean lambdatype_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_10")) return false;
    lambdatype_10_0(b, l + 1);
    return true;
  }

  // cap | gencap
  private static boolean lambdatype_10_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_10_0")) return false;
    boolean r;
    r = cap(b, l + 1);
    if (!r) r = gencap(b, l + 1);
    return r;
  }

  // (HAT | BANG)?
  private static boolean lambdatype_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_11")) return false;
    lambdatype_11_0(b, l + 1);
    return true;
  }

  // HAT | BANG
  private static boolean lambdatype_11_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_11_0")) return false;
    boolean r;
    r = consumeToken(b, HAT);
    if (!r) r = consumeToken(b, BANG);
    return r;
  }

  /* ********************************************************** */
  // TRUE
  //   | FALSE
  //   | NUMBER
  //   | FLOAT
  //   | STRING
  public static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL, "<literal>");
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // MATCH annotations rawseq caseexpr* (ELSE annotatedrawseq)? END
  public static boolean match_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_term")) return false;
    if (!nextTokenIs(b, MATCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MATCH);
    r = r && annotations(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && match_term_3(b, l + 1);
    r = r && match_term_4(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, MATCH_TERM, r);
    return r;
  }

  // caseexpr*
  private static boolean match_term_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_term_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!caseexpr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "match_term_3", c)) break;
    }
    return true;
  }

  // (ELSE annotatedrawseq)?
  private static boolean match_term_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_term_4")) return false;
    match_term_4_0(b, l + 1);
    return true;
  }

  // ELSE annotatedrawseq
  private static boolean match_term_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_term_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // field_decl* method_decl*
  public static boolean members(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "members")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MEMBERS, "<members>");
    r = members_0(b, l + 1);
    r = r && members_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // field_decl*
  private static boolean members_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "members_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!field_decl(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "members_0", c)) break;
    }
    return true;
  }

  // method_decl*
  private static boolean members_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "members_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!method_decl(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "members_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // rawseq
  public static boolean method_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD_BODY, "<method body>");
    r = rawseq(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ARROW method_body
  public static boolean method_body_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_body_decl")) return false;
    if (!nextTokenIs(b, ARROW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ARROW);
    r = r && method_body(b, l + 1);
    exit_section_(b, m, METHOD_BODY_DECL, r);
    return r;
  }

  /* ********************************************************** */
  // method_type annotations (cap | FFI_CHAR)? method_name typeparams? (LPAREN | LPAREN_NEW) params? RPAREN (TYPE_OP type_)? THROWS? doc_string? (method_body_decl)?
  public static boolean method_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_decl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD_DECL, "<method decl>");
    r = method_type(b, l + 1);
    r = r && annotations(b, l + 1);
    r = r && method_decl_2(b, l + 1);
    r = r && method_name(b, l + 1);
    r = r && method_decl_4(b, l + 1);
    r = r && method_decl_5(b, l + 1);
    r = r && method_decl_6(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && method_decl_8(b, l + 1);
    r = r && method_decl_9(b, l + 1);
    r = r && method_decl_10(b, l + 1);
    r = r && method_decl_11(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (cap | FFI_CHAR)?
  private static boolean method_decl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_decl_2")) return false;
    method_decl_2_0(b, l + 1);
    return true;
  }

  // cap | FFI_CHAR
  private static boolean method_decl_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_decl_2_0")) return false;
    boolean r;
    r = cap(b, l + 1);
    if (!r) r = consumeToken(b, FFI_CHAR);
    return r;
  }

  // typeparams?
  private static boolean method_decl_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_decl_4")) return false;
    typeparams(b, l + 1);
    return true;
  }

  // LPAREN | LPAREN_NEW
  private static boolean method_decl_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_decl_5")) return false;
    boolean r;
    r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, LPAREN_NEW);
    return r;
  }

  // params?
  private static boolean method_decl_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_decl_6")) return false;
    params(b, l + 1);
    return true;
  }

  // (TYPE_OP type_)?
  private static boolean method_decl_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_decl_8")) return false;
    method_decl_8_0(b, l + 1);
    return true;
  }

  // TYPE_OP type_
  private static boolean method_decl_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_decl_8_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE_OP);
    r = r && type_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THROWS?
  private static boolean method_decl_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_decl_9")) return false;
    consumeToken(b, THROWS);
    return true;
  }

  // doc_string?
  private static boolean method_decl_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_decl_10")) return false;
    doc_string(b, l + 1);
    return true;
  }

  // (method_body_decl)?
  private static boolean method_decl_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_decl_11")) return false;
    method_decl_11_0(b, l + 1);
    return true;
  }

  // (method_body_decl)
  private static boolean method_decl_11_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_decl_11_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = method_body_decl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ID
  public static boolean method_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_name")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, METHOD_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // FUN | BE | NEW
  public static boolean method_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD_TYPE, "<method type>");
    r = consumeToken(b, FUN);
    if (!r) r = consumeToken(b, BE);
    if (!r) r = consumeToken(b, NEW);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // doc_string? use_* class_def*
  static boolean module(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_0(b, l + 1);
    r = r && module_1(b, l + 1);
    r = r && module_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // doc_string?
  private static boolean module_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_0")) return false;
    doc_string(b, l + 1);
    return true;
  }

  // use_*
  private static boolean module_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!use_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_1", c)) break;
    }
    return true;
  }

  // class_def*
  private static boolean module_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!class_def(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // WHERE namedarg (COMMA namedarg)*
  public static boolean named(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named")) return false;
    if (!nextTokenIs(b, WHERE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHERE);
    r = r && namedarg(b, l + 1);
    r = r && named_2(b, l + 1);
    exit_section_(b, m, NAMED, r);
    return r;
  }

  // (COMMA namedarg)*
  private static boolean named_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!named_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "named_2", c)) break;
    }
    return true;
  }

  // COMMA namedarg
  private static boolean named_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && namedarg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ID ASSIGN rawseq
  public static boolean namedarg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namedarg")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, ASSIGN);
    r = r && rawseq(b, l + 1);
    exit_section_(b, m, NAMEDARG, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN_NEW rawseq tuple? RPAREN
  public static boolean next_tuple_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "next_tuple_decl")) return false;
    if (!nextTokenIs(b, LPAREN_NEW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN_NEW);
    r = r && rawseq(b, l + 1);
    r = r && next_tuple_decl_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, NEXT_TUPLE_DECL, r);
    return r;
  }

  // tuple?
  private static boolean next_tuple_decl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "next_tuple_decl_2")) return false;
    tuple(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // nextinfix (ASSIGN assignment)?
  public static boolean nextassignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextassignment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NEXTASSIGNMENT, "<nextassignment>");
    r = nextinfix(b, l + 1);
    r = r && nextassignment_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (ASSIGN assignment)?
  private static boolean nextassignment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextassignment_1")) return false;
    nextassignment_1_0(b, l + 1);
    return true;
  }

  // ASSIGN assignment
  private static boolean nextassignment_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextassignment_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && assignment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ID
  //   | THIS
  //   | literal
  //   | next_tuple_decl
  //   | LSQUARE_NEW (AS type_ TYPE_OP)? rawseq? RSQUARE
  //   | object_decl
  //   | lambda_decl
  //   | ffi_decl
  //   | LOC
  public static boolean nextatom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NEXTATOM, "<nextatom>");
    r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, THIS);
    if (!r) r = literal(b, l + 1);
    if (!r) r = next_tuple_decl(b, l + 1);
    if (!r) r = nextatom_4(b, l + 1);
    if (!r) r = object_decl(b, l + 1);
    if (!r) r = lambda_decl(b, l + 1);
    if (!r) r = ffi_decl(b, l + 1);
    if (!r) r = consumeToken(b, LOC);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LSQUARE_NEW (AS type_ TYPE_OP)? rawseq? RSQUARE
  private static boolean nextatom_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LSQUARE_NEW);
    r = r && nextatom_4_1(b, l + 1);
    r = r && nextatom_4_2(b, l + 1);
    r = r && consumeToken(b, RSQUARE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (AS type_ TYPE_OP)?
  private static boolean nextatom_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_4_1")) return false;
    nextatom_4_1_0(b, l + 1);
    return true;
  }

  // AS type_ TYPE_OP
  private static boolean nextatom_4_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_4_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AS);
    r = r && type_(b, l + 1);
    r = r && consumeToken(b, TYPE_OP);
    exit_section_(b, m, null, r);
    return r;
  }

  // rawseq?
  private static boolean nextatom_4_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_4_2")) return false;
    rawseq(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // nextassignment (semiexpr | nosemi)?
  public static boolean nextexprseq(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextexprseq")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NEXTEXPRSEQ, "<nextexprseq>");
    r = nextassignment(b, l + 1);
    r = r && nextexprseq_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (semiexpr | nosemi)?
  private static boolean nextexprseq_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextexprseq_1")) return false;
    nextexprseq_1_0(b, l + 1);
    return true;
  }

  // semiexpr | nosemi
  private static boolean nextexprseq_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextexprseq_1_0")) return false;
    boolean r;
    r = semiexpr(b, l + 1);
    if (!r) r = nosemi(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // nextterm (binop | isop | as_op)*
  public static boolean nextinfix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextinfix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NEXTINFIX, "<nextinfix>");
    r = nextterm(b, l + 1);
    r = r && nextinfix_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (binop | isop | as_op)*
  private static boolean nextinfix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextinfix_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nextinfix_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nextinfix_1", c)) break;
    }
    return true;
  }

  // binop | isop | as_op
  private static boolean nextinfix_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextinfix_1_0")) return false;
    boolean r;
    r = binop(b, l + 1);
    if (!r) r = isop(b, l + 1);
    if (!r) r = as_op(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (NOT | ADDRESSOF | MINUS_NEW | MINUS_TILDE_NEW | DIGESTOF) parampattern
  //   | nextpostfix
  public static boolean nextparampattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextparampattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NEXTPARAMPATTERN, "<nextparampattern>");
    r = nextparampattern_0(b, l + 1);
    if (!r) r = nextpostfix(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (NOT | ADDRESSOF | MINUS_NEW | MINUS_TILDE_NEW | DIGESTOF) parampattern
  private static boolean nextparampattern_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextparampattern_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nextparampattern_0_0(b, l + 1);
    r = r && parampattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NOT | ADDRESSOF | MINUS_NEW | MINUS_TILDE_NEW | DIGESTOF
  private static boolean nextparampattern_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextparampattern_0_0")) return false;
    boolean r;
    r = consumeToken(b, NOT);
    if (!r) r = consumeToken(b, ADDRESSOF);
    if (!r) r = consumeToken(b, MINUS_NEW);
    if (!r) r = consumeToken(b, MINUS_TILDE_NEW);
    if (!r) r = consumeToken(b, DIGESTOF);
    return r;
  }

  /* ********************************************************** */
  // (VAR | LET | EMBED) ID (TYPE_OP type_)? | nextparampattern
  public static boolean nextpattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextpattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NEXTPATTERN, "<nextpattern>");
    r = nextpattern_0(b, l + 1);
    if (!r) r = nextparampattern(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (VAR | LET | EMBED) ID (TYPE_OP type_)?
  private static boolean nextpattern_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextpattern_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nextpattern_0_0(b, l + 1);
    r = r && consumeToken(b, ID);
    r = r && nextpattern_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VAR | LET | EMBED
  private static boolean nextpattern_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextpattern_0_0")) return false;
    boolean r;
    r = consumeToken(b, VAR);
    if (!r) r = consumeToken(b, LET);
    if (!r) r = consumeToken(b, EMBED);
    return r;
  }

  // (TYPE_OP type_)?
  private static boolean nextpattern_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextpattern_0_2")) return false;
    nextpattern_0_2_0(b, l + 1);
    return true;
  }

  // TYPE_OP type_
  private static boolean nextpattern_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextpattern_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE_OP);
    r = r && type_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // nextatom (callsite | tilde | chain | typeargs | call)*
  public static boolean nextpostfix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextpostfix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NEXTPOSTFIX, "<nextpostfix>");
    r = nextatom(b, l + 1);
    r = r && nextpostfix_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (callsite | tilde | chain | typeargs | call)*
  private static boolean nextpostfix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextpostfix_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nextpostfix_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nextpostfix_1", c)) break;
    }
    return true;
  }

  // callsite | tilde | chain | typeargs | call
  private static boolean nextpostfix_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextpostfix_1_0")) return false;
    boolean r;
    r = callsite(b, l + 1);
    if (!r) r = tilde(b, l + 1);
    if (!r) r = chain(b, l + 1);
    if (!r) r = typeargs(b, l + 1);
    if (!r) r = call(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // if_term
  //   | ifdef_term
  //   | iftype_term
  //   | match_term
  //   | while_term
  //   | repeat_term
  //   | for_term
  //   | with_term
  //   | try_term
  //   | recover_term
  //   | consume_term
  //   | nextpattern
  //   | hash_term
  public static boolean nextterm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NEXTTERM, "<nextterm>");
    r = if_term(b, l + 1);
    if (!r) r = ifdef_term(b, l + 1);
    if (!r) r = iftype_term(b, l + 1);
    if (!r) r = match_term(b, l + 1);
    if (!r) r = while_term(b, l + 1);
    if (!r) r = repeat_term(b, l + 1);
    if (!r) r = for_term(b, l + 1);
    if (!r) r = with_term(b, l + 1);
    if (!r) r = try_term(b, l + 1);
    if (!r) r = recover_term(b, l + 1);
    if (!r) r = consume_term(b, l + 1);
    if (!r) r = nextpattern(b, l + 1);
    if (!r) r = hash_term(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ID (CALL_OP ID)? typeargs? (cap | gencap)? (HAT | BANG)?
  public static boolean nominal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nominal")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && nominal_1(b, l + 1);
    r = r && nominal_2(b, l + 1);
    r = r && nominal_3(b, l + 1);
    r = r && nominal_4(b, l + 1);
    exit_section_(b, m, NOMINAL, r);
    return r;
  }

  // (CALL_OP ID)?
  private static boolean nominal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nominal_1")) return false;
    nominal_1_0(b, l + 1);
    return true;
  }

  // CALL_OP ID
  private static boolean nominal_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nominal_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CALL_OP, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // typeargs?
  private static boolean nominal_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nominal_2")) return false;
    typeargs(b, l + 1);
    return true;
  }

  // (cap | gencap)?
  private static boolean nominal_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nominal_3")) return false;
    nominal_3_0(b, l + 1);
    return true;
  }

  // cap | gencap
  private static boolean nominal_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nominal_3_0")) return false;
    boolean r;
    r = cap(b, l + 1);
    if (!r) r = gencap(b, l + 1);
    return r;
  }

  // (HAT | BANG)?
  private static boolean nominal_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nominal_4")) return false;
    nominal_4_0(b, l + 1);
    return true;
  }

  // HAT | BANG
  private static boolean nominal_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nominal_4_0")) return false;
    boolean r;
    r = consumeToken(b, HAT);
    if (!r) r = consumeToken(b, BANG);
    return r;
  }

  /* ********************************************************** */
  // nextexprseq | jump
  public static boolean nosemi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nosemi")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NOSEMI, "<nosemi>");
    r = nextexprseq(b, l + 1);
    if (!r) r = jump(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OBJECT annotations cap? type_decl members END
  public static boolean object_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_decl")) return false;
    if (!nextTokenIs(b, OBJECT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OBJECT);
    r = r && annotations(b, l + 1);
    r = r && object_decl_2(b, l + 1);
    r = r && type_decl(b, l + 1);
    r = r && members(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, OBJECT_DECL, r);
    return r;
  }

  // cap?
  private static boolean object_decl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_decl_2")) return false;
    cap(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ID TYPE_OP type_ (ASSIGN infix)?
  public static boolean param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, TYPE_OP);
    r = r && type_(b, l + 1);
    r = r && param_3(b, l + 1);
    exit_section_(b, m, PARAM, r);
    return r;
  }

  // (ASSIGN infix)?
  private static boolean param_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_3")) return false;
    param_3_0(b, l + 1);
    return true;
  }

  // ASSIGN infix
  private static boolean param_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && infix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (NOT | ADDRESSOF | MINUS_OP | MINUS_TILDE | MINUS_NEW | MINUS_TILDE_NEW | DIGESTOF) parampattern
  //   | postfix
  public static boolean parampattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parampattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, PARAMPATTERN, "<parampattern>");
    r = parampattern_0(b, l + 1);
    if (!r) r = postfix(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (NOT | ADDRESSOF | MINUS_OP | MINUS_TILDE | MINUS_NEW | MINUS_TILDE_NEW | DIGESTOF) parampattern
  private static boolean parampattern_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parampattern_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parampattern_0_0(b, l + 1);
    r = r && parampattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NOT | ADDRESSOF | MINUS_OP | MINUS_TILDE | MINUS_NEW | MINUS_TILDE_NEW | DIGESTOF
  private static boolean parampattern_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parampattern_0_0")) return false;
    boolean r;
    r = consumeToken(b, NOT);
    if (!r) r = consumeToken(b, ADDRESSOF);
    if (!r) r = consumeToken(b, MINUS_OP);
    if (!r) r = consumeToken(b, MINUS_TILDE);
    if (!r) r = consumeToken(b, MINUS_NEW);
    if (!r) r = consumeToken(b, MINUS_TILDE_NEW);
    if (!r) r = consumeToken(b, DIGESTOF);
    return r;
  }

  /* ********************************************************** */
  // (param | THREE_DOTS) (COMMA (param | THREE_DOTS))*
  public static boolean params(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params")) return false;
    if (!nextTokenIs(b, "<params>", ID, THREE_DOTS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMS, "<params>");
    r = params_0(b, l + 1);
    r = r && params_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // param | THREE_DOTS
  private static boolean params_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_0")) return false;
    boolean r;
    r = param(b, l + 1);
    if (!r) r = consumeToken(b, THREE_DOTS);
    return r;
  }

  // (COMMA (param | THREE_DOTS))*
  private static boolean params_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!params_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "params_1", c)) break;
    }
    return true;
  }

  // COMMA (param | THREE_DOTS)
  private static boolean params_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && params_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // param | THREE_DOTS
  private static boolean params_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_1_0_1")) return false;
    boolean r;
    r = param(b, l + 1);
    if (!r) r = consumeToken(b, THREE_DOTS);
    return r;
  }

  /* ********************************************************** */
  // (VAR | LET | EMBED) ID (TYPE_OP type_)? | parampattern
  public static boolean pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN, "<pattern>");
    r = pattern_0(b, l + 1);
    if (!r) r = parampattern(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (VAR | LET | EMBED) ID (TYPE_OP type_)?
  private static boolean pattern_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern_0_0(b, l + 1);
    r = r && consumeToken(b, ID);
    r = r && pattern_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VAR | LET | EMBED
  private static boolean pattern_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_0_0")) return false;
    boolean r;
    r = consumeToken(b, VAR);
    if (!r) r = consumeToken(b, LET);
    if (!r) r = consumeToken(b, EMBED);
    return r;
  }

  // (TYPE_OP type_)?
  private static boolean pattern_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_0_2")) return false;
    pattern_0_2_0(b, l + 1);
    return true;
  }

  // TYPE_OP type_
  private static boolean pattern_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE_OP);
    r = r && type_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // rawseq (COMMA rawseq)*
  public static boolean positional(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "positional")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, POSITIONAL, "<positional>");
    r = rawseq(b, l + 1);
    r = r && positional_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA rawseq)*
  private static boolean positional_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "positional_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!positional_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "positional_1", c)) break;
    }
    return true;
  }

  // COMMA rawseq
  private static boolean positional_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "positional_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && rawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // atom (callsite | tilde | chain | typeargs | call)*
  public static boolean postfix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, POSTFIX, "<postfix>");
    r = atom(b, l + 1);
    r = r && postfix_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (callsite | tilde | chain | typeargs | call)*
  private static boolean postfix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfix_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!postfix_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "postfix_1", c)) break;
    }
    return true;
  }

  // callsite | tilde | chain | typeargs | call
  private static boolean postfix_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfix_1_0")) return false;
    boolean r;
    r = callsite(b, l + 1);
    if (!r) r = tilde(b, l + 1);
    if (!r) r = chain(b, l + 1);
    if (!r) r = typeargs(b, l + 1);
    if (!r) r = call(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // exprseq | jump
  public static boolean rawseq(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rawseq")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RAWSEQ, "<rawseq>");
    r = exprseq(b, l + 1);
    if (!r) r = jump(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // RECOVER annotations cap? rawseq END
  public static boolean recover_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_term")) return false;
    if (!nextTokenIs(b, RECOVER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RECOVER);
    r = r && annotations(b, l + 1);
    r = r && recover_term_2(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, RECOVER_TERM, r);
    return r;
  }

  // cap?
  private static boolean recover_term_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_term_2")) return false;
    cap(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // REPEAT annotations rawseq UNTIL annotatedrawseq (ELSE annotatedrawseq)? END
  public static boolean repeat_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeat_term")) return false;
    if (!nextTokenIs(b, REPEAT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REPEAT);
    r = r && annotations(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, UNTIL);
    r = r && annotatedrawseq(b, l + 1);
    r = r && repeat_term_5(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, REPEAT_TERM, r);
    return r;
  }

  // (ELSE annotatedrawseq)?
  private static boolean repeat_term_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeat_term_5")) return false;
    repeat_term_5_0(b, l + 1);
    return true;
  }

  // ELSE annotatedrawseq
  private static boolean repeat_term_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeat_term_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LIST_OP (exprseq | jump)
  public static boolean semiexpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "semiexpr")) return false;
    if (!nextTokenIs(b, LIST_OP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LIST_OP);
    r = r && semiexpr_1(b, l + 1);
    exit_section_(b, m, SEMIEXPR, r);
    return r;
  }

  // exprseq | jump
  private static boolean semiexpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "semiexpr_1")) return false;
    boolean r;
    r = exprseq(b, l + 1);
    if (!r) r = jump(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // if_term
  //   | ifdef_term
  //   | iftype_term
  //   | match_term
  //   | while_term
  //   | repeat_term
  //   | for_term
  //   | with_term
  //   | try_term
  //   | recover_term
  //   | consume_term
  //   | pattern
  //   | hash_term
  public static boolean term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TERM, "<term>");
    r = if_term(b, l + 1);
    if (!r) r = ifdef_term(b, l + 1);
    if (!r) r = iftype_term(b, l + 1);
    if (!r) r = match_term(b, l + 1);
    if (!r) r = while_term(b, l + 1);
    if (!r) r = repeat_term(b, l + 1);
    if (!r) r = for_term(b, l + 1);
    if (!r) r = with_term(b, l + 1);
    if (!r) r = try_term(b, l + 1);
    if (!r) r = recover_term(b, l + 1);
    if (!r) r = consume_term(b, l + 1);
    if (!r) r = pattern(b, l + 1);
    if (!r) r = hash_term(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PARTIAL_OP ID
  public static boolean tilde(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tilde")) return false;
    if (!nextTokenIs(b, PARTIAL_OP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PARTIAL_OP, ID);
    exit_section_(b, m, TILDE, r);
    return r;
  }

  /* ********************************************************** */
  // TRY annotations rawseq (ELSE annotatedrawseq)? (THEN annotatedrawseq)? END
  public static boolean try_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "try_term")) return false;
    if (!nextTokenIs(b, TRY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRY);
    r = r && annotations(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && try_term_3(b, l + 1);
    r = r && try_term_4(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, TRY_TERM, r);
    return r;
  }

  // (ELSE annotatedrawseq)?
  private static boolean try_term_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "try_term_3")) return false;
    try_term_3_0(b, l + 1);
    return true;
  }

  // ELSE annotatedrawseq
  private static boolean try_term_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "try_term_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (THEN annotatedrawseq)?
  private static boolean try_term_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "try_term_4")) return false;
    try_term_4_0(b, l + 1);
    return true;
  }

  // THEN annotatedrawseq
  private static boolean try_term_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "try_term_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, THEN);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COMMA rawseq (COMMA rawseq)*
  public static boolean tuple(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple")) return false;
    if (!nextTokenIs(b, COMMA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && rawseq(b, l + 1);
    r = r && tuple_2(b, l + 1);
    exit_section_(b, m, TUPLE, r);
    return r;
  }

  // (COMMA rawseq)*
  private static boolean tuple_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tuple_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tuple_2", c)) break;
    }
    return true;
  }

  // COMMA rawseq
  private static boolean tuple_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && rawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (LPAREN | LPAREN_NEW) rawseq tuple? RPAREN
  public static boolean tuple_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_decl")) return false;
    if (!nextTokenIs(b, "<tuple decl>", LPAREN, LPAREN_NEW)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TUPLE_DECL, "<tuple decl>");
    r = tuple_decl_0(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && tuple_decl_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LPAREN | LPAREN_NEW
  private static boolean tuple_decl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_decl_0")) return false;
    boolean r;
    r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, LPAREN_NEW);
    return r;
  }

  // tuple?
  private static boolean tuple_decl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_decl_2")) return false;
    tuple(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // COMMA infixtype (COMMA infixtype)*
  public static boolean tupletype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupletype")) return false;
    if (!nextTokenIs(b, COMMA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && infixtype(b, l + 1);
    r = r && tupletype_2(b, l + 1);
    exit_section_(b, m, TUPLETYPE, r);
    return r;
  }

  // (COMMA infixtype)*
  private static boolean tupletype_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupletype_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tupletype_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tupletype_2", c)) break;
    }
    return true;
  }

  // COMMA infixtype
  private static boolean tupletype_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupletype_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && infixtype(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // atomtype (CAP_ARROW type_)?
  public static boolean type_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_, "<type>");
    r = atomtype(b, l + 1);
    r = r && type__1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (CAP_ARROW type_)?
  private static boolean type__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type__1")) return false;
    type__1_0(b, l + 1);
    return true;
  }

  // CAP_ARROW type_
  private static boolean type__1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type__1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CAP_ARROW);
    r = r && type_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (IS type_)?
  public static boolean type_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl")) return false;
    Marker m = enter_section_(b, l, _NONE_, TYPE_DECL, "<type decl>");
    type_decl_0(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // IS type_
  private static boolean type_decl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IS);
    r = r && type_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // type_
  //   | literal
  //   | hash_term
  public static boolean typearg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typearg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPEARG, "<typearg>");
    r = type_(b, l + 1);
    if (!r) r = literal(b, l + 1);
    if (!r) r = hash_term(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LSQUARE typearg (COMMA typearg)* RSQUARE
  public static boolean typeargs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeargs")) return false;
    if (!nextTokenIs(b, LSQUARE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LSQUARE);
    r = r && typearg(b, l + 1);
    r = r && typeargs_2(b, l + 1);
    r = r && consumeToken(b, RSQUARE);
    exit_section_(b, m, TYPEARGS, r);
    return r;
  }

  // (COMMA typearg)*
  private static boolean typeargs_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeargs_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!typeargs_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "typeargs_2", c)) break;
    }
    return true;
  }

  // COMMA typearg
  private static boolean typeargs_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeargs_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && typearg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ID (TYPE_OP type_)? (ASSIGN typearg)?
  public static boolean typeparam(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparam")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && typeparam_1(b, l + 1);
    r = r && typeparam_2(b, l + 1);
    exit_section_(b, m, TYPEPARAM, r);
    return r;
  }

  // (TYPE_OP type_)?
  private static boolean typeparam_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparam_1")) return false;
    typeparam_1_0(b, l + 1);
    return true;
  }

  // TYPE_OP type_
  private static boolean typeparam_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparam_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE_OP);
    r = r && type_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ASSIGN typearg)?
  private static boolean typeparam_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparam_2")) return false;
    typeparam_2_0(b, l + 1);
    return true;
  }

  // ASSIGN typearg
  private static boolean typeparam_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparam_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && typearg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (LSQUARE | LSQUARE_NEW) typeparam (COMMA typeparam)* RSQUARE
  public static boolean typeparams(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparams")) return false;
    if (!nextTokenIs(b, "<typeparams>", LSQUARE, LSQUARE_NEW)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPEPARAMS, "<typeparams>");
    r = typeparams_0(b, l + 1);
    r = r && typeparam(b, l + 1);
    r = r && typeparams_2(b, l + 1);
    r = r && consumeToken(b, RSQUARE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LSQUARE | LSQUARE_NEW
  private static boolean typeparams_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparams_0")) return false;
    boolean r;
    r = consumeToken(b, LSQUARE);
    if (!r) r = consumeToken(b, LSQUARE_NEW);
    return r;
  }

  // (COMMA typeparam)*
  private static boolean typeparams_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparams_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!typeparams_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "typeparams_2", c)) break;
    }
    return true;
  }

  // COMMA typeparam
  private static boolean typeparams_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparams_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && typeparam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PIPE_OP type_
  public static boolean uniontype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uniontype")) return false;
    if (!nextTokenIs(b, PIPE_OP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PIPE_OP);
    r = r && type_(b, l + 1);
    exit_section_(b, m, UNIONTYPE, r);
    return r;
  }

  /* ********************************************************** */
  // USE use_alias (STRING | use_ffi) use_cond
  public static boolean use_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_")) return false;
    if (!nextTokenIs(b, USE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, USE);
    r = r && use_alias(b, l + 1);
    r = r && use__2(b, l + 1);
    r = r && use_cond(b, l + 1);
    exit_section_(b, m, USE_, r);
    return r;
  }

  // STRING | use_ffi
  private static boolean use__2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use__2")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = use_ffi(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (ID ASSIGN)?
  public static boolean use_alias(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_alias")) return false;
    Marker m = enter_section_(b, l, _NONE_, USE_ALIAS, "<use alias>");
    use_alias_0(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // ID ASSIGN
  private static boolean use_alias_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_alias_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, ASSIGN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (IF infix)?
  public static boolean use_cond(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_cond")) return false;
    Marker m = enter_section_(b, l, _NONE_, USE_COND, "<use cond>");
    use_cond_0(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // IF infix
  private static boolean use_cond_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_cond_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && infix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ffi_decl typeargs (LPAREN | LPAREN_NEW) params? RPAREN THROWS?
  public static boolean use_ffi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_ffi")) return false;
    if (!nextTokenIs(b, FFI_CHAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ffi_decl(b, l + 1);
    r = r && typeargs(b, l + 1);
    r = r && use_ffi_2(b, l + 1);
    r = r && use_ffi_3(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && use_ffi_5(b, l + 1);
    exit_section_(b, m, USE_FFI, r);
    return r;
  }

  // LPAREN | LPAREN_NEW
  private static boolean use_ffi_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_ffi_2")) return false;
    boolean r;
    r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, LPAREN_NEW);
    return r;
  }

  // params?
  private static boolean use_ffi_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_ffi_3")) return false;
    params(b, l + 1);
    return true;
  }

  // THROWS?
  private static boolean use_ffi_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_ffi_5")) return false;
    consumeToken(b, THROWS);
    return true;
  }

  /* ********************************************************** */
  // WHILE annotations rawseq DO rawseq (ELSE annotatedrawseq)? END
  public static boolean while_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_term")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && annotations(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, DO);
    r = r && rawseq(b, l + 1);
    r = r && while_term_5(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, WHILE_TERM, r);
    return r;
  }

  // (ELSE annotatedrawseq)?
  private static boolean while_term_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_term_5")) return false;
    while_term_5_0(b, l + 1);
    return true;
  }

  // ELSE annotatedrawseq
  private static boolean while_term_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_term_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // WITH annotations (withelem (COMMA withelem)*) DO rawseq (ELSE annotatedrawseq)? END
  public static boolean with_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "with_term")) return false;
    if (!nextTokenIs(b, WITH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WITH);
    r = r && annotations(b, l + 1);
    r = r && with_term_2(b, l + 1);
    r = r && consumeToken(b, DO);
    r = r && rawseq(b, l + 1);
    r = r && with_term_5(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, WITH_TERM, r);
    return r;
  }

  // withelem (COMMA withelem)*
  private static boolean with_term_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "with_term_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = withelem(b, l + 1);
    r = r && with_term_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA withelem)*
  private static boolean with_term_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "with_term_2_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!with_term_2_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "with_term_2_1", c)) break;
    }
    return true;
  }

  // COMMA withelem
  private static boolean with_term_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "with_term_2_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && withelem(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ELSE annotatedrawseq)?
  private static boolean with_term_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "with_term_5")) return false;
    with_term_5_0(b, l + 1);
    return true;
  }

  // ELSE annotatedrawseq
  private static boolean with_term_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "with_term_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // idseq ASSIGN rawseq
  public static boolean withelem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withelem")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, WITHELEM, "<withelem>");
    r = idseq(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    r = r && rawseq(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
