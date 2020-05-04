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
  // ('\' ID (',' ID)* '\')? (exprseq | jump)
  public static boolean annotatedrawseq(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotatedrawseq")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ANNOTATEDRAWSEQ, "<annotatedrawseq>");
    r = annotatedrawseq_0(b, l + 1);
    r = r && annotatedrawseq_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean annotatedrawseq_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotatedrawseq_0")) return false;
    annotatedrawseq_0_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean annotatedrawseq_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotatedrawseq_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && annotatedrawseq_0_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean annotatedrawseq_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotatedrawseq_0_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!annotatedrawseq_0_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "annotatedrawseq_0_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean annotatedrawseq_0_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotatedrawseq_0_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
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
  // infix ('=' assignment)?
  public static boolean assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT, "<assignment>");
    r = infix(b, l + 1);
    r = r && assignment_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('=' assignment)?
  private static boolean assignment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_1")) return false;
    assignment_1_0(b, l + 1);
    return true;
  }

  // '=' assignment
  private static boolean assignment_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "=");
    r = r && assignment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ID
  //   | 'this'
  //   | literal
  //   | ('(' | LPAREN_NEW) rawseq tuple? ')'
  //   | ('[' | LSQUARE_NEW) ('as' type ':')? rawseq? ']'
  //   | 'object' ('\' ID (',' ID)* '\')? cap? ('is' type)? members 'end'
  //   | '{' ('\' ID (',' ID)* '\')? cap? ID? typeparams? ('(' | LPAREN_NEW) lambdaparams? ')' lambdacaptures? (':' type)? '?'? '=>' rawseq '}' cap?
  //   | '@{' ('\' ID (',' ID)* '\')? cap? ID? typeparams? ('(' | LPAREN_NEW) lambdaparams? ')' lambdacaptures? (':' type)? '?'? '=>' rawseq '}' cap?
  //   | ffi_decl typeargs? ('(' | LPAREN_NEW) positional? named? ')' '?'?
  //   | '__loc'
  public static boolean atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOM, "<atom>");
    r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, "this");
    if (!r) r = literal(b, l + 1);
    if (!r) r = atom_3(b, l + 1);
    if (!r) r = atom_4(b, l + 1);
    if (!r) r = atom_5(b, l + 1);
    if (!r) r = atom_6(b, l + 1);
    if (!r) r = atom_7(b, l + 1);
    if (!r) r = atom_8(b, l + 1);
    if (!r) r = consumeToken(b, "__loc");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('(' | LPAREN_NEW) rawseq tuple? ')'
  private static boolean atom_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = atom_3_0(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && atom_3_2(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' | LPAREN_NEW
  private static boolean atom_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    if (!r) r = consumeToken(b, LPAREN_NEW);
    exit_section_(b, m, null, r);
    return r;
  }

  // tuple?
  private static boolean atom_3_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_3_2")) return false;
    tuple(b, l + 1);
    return true;
  }

  // ('[' | LSQUARE_NEW) ('as' type ':')? rawseq? ']'
  private static boolean atom_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = atom_4_0(b, l + 1);
    r = r && atom_4_1(b, l + 1);
    r = r && atom_4_2(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  // '[' | LSQUARE_NEW
  private static boolean atom_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "[");
    if (!r) r = consumeToken(b, LSQUARE_NEW);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('as' type ':')?
  private static boolean atom_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_4_1")) return false;
    atom_4_1_0(b, l + 1);
    return true;
  }

  // 'as' type ':'
  private static boolean atom_4_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_4_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "as");
    r = r && type(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // rawseq?
  private static boolean atom_4_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_4_2")) return false;
    rawseq(b, l + 1);
    return true;
  }

  // 'object' ('\' ID (',' ID)* '\')? cap? ('is' type)? members 'end'
  private static boolean atom_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "object");
    r = r && atom_5_1(b, l + 1);
    r = r && atom_5_2(b, l + 1);
    r = r && atom_5_3(b, l + 1);
    r = r && members(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean atom_5_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_5_1")) return false;
    atom_5_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean atom_5_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_5_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && atom_5_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean atom_5_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_5_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!atom_5_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "atom_5_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean atom_5_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_5_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // cap?
  private static boolean atom_5_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_5_2")) return false;
    cap(b, l + 1);
    return true;
  }

  // ('is' type)?
  private static boolean atom_5_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_5_3")) return false;
    atom_5_3_0(b, l + 1);
    return true;
  }

  // 'is' type
  private static boolean atom_5_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_5_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "is");
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '{' ('\' ID (',' ID)* '\')? cap? ID? typeparams? ('(' | LPAREN_NEW) lambdaparams? ')' lambdacaptures? (':' type)? '?'? '=>' rawseq '}' cap?
  private static boolean atom_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "{");
    r = r && atom_6_1(b, l + 1);
    r = r && atom_6_2(b, l + 1);
    r = r && atom_6_3(b, l + 1);
    r = r && atom_6_4(b, l + 1);
    r = r && atom_6_5(b, l + 1);
    r = r && atom_6_6(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && atom_6_8(b, l + 1);
    r = r && atom_6_9(b, l + 1);
    r = r && atom_6_10(b, l + 1);
    r = r && consumeToken(b, "=>");
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, "}");
    r = r && atom_6_14(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean atom_6_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_6_1")) return false;
    atom_6_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean atom_6_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_6_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && atom_6_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean atom_6_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_6_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!atom_6_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "atom_6_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean atom_6_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_6_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // cap?
  private static boolean atom_6_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_6_2")) return false;
    cap(b, l + 1);
    return true;
  }

  // ID?
  private static boolean atom_6_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_6_3")) return false;
    consumeToken(b, ID);
    return true;
  }

  // typeparams?
  private static boolean atom_6_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_6_4")) return false;
    typeparams(b, l + 1);
    return true;
  }

  // '(' | LPAREN_NEW
  private static boolean atom_6_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_6_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    if (!r) r = consumeToken(b, LPAREN_NEW);
    exit_section_(b, m, null, r);
    return r;
  }

  // lambdaparams?
  private static boolean atom_6_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_6_6")) return false;
    lambdaparams(b, l + 1);
    return true;
  }

  // lambdacaptures?
  private static boolean atom_6_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_6_8")) return false;
    lambdacaptures(b, l + 1);
    return true;
  }

  // (':' type)?
  private static boolean atom_6_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_6_9")) return false;
    atom_6_9_0(b, l + 1);
    return true;
  }

  // ':' type
  private static boolean atom_6_9_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_6_9_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ":");
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '?'?
  private static boolean atom_6_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_6_10")) return false;
    consumeToken(b, "?");
    return true;
  }

  // cap?
  private static boolean atom_6_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_6_14")) return false;
    cap(b, l + 1);
    return true;
  }

  // '@{' ('\' ID (',' ID)* '\')? cap? ID? typeparams? ('(' | LPAREN_NEW) lambdaparams? ')' lambdacaptures? (':' type)? '?'? '=>' rawseq '}' cap?
  private static boolean atom_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "@{");
    r = r && atom_7_1(b, l + 1);
    r = r && atom_7_2(b, l + 1);
    r = r && atom_7_3(b, l + 1);
    r = r && atom_7_4(b, l + 1);
    r = r && atom_7_5(b, l + 1);
    r = r && atom_7_6(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && atom_7_8(b, l + 1);
    r = r && atom_7_9(b, l + 1);
    r = r && atom_7_10(b, l + 1);
    r = r && consumeToken(b, "=>");
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, "}");
    r = r && atom_7_14(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean atom_7_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_7_1")) return false;
    atom_7_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean atom_7_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_7_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && atom_7_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean atom_7_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_7_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!atom_7_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "atom_7_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean atom_7_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_7_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // cap?
  private static boolean atom_7_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_7_2")) return false;
    cap(b, l + 1);
    return true;
  }

  // ID?
  private static boolean atom_7_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_7_3")) return false;
    consumeToken(b, ID);
    return true;
  }

  // typeparams?
  private static boolean atom_7_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_7_4")) return false;
    typeparams(b, l + 1);
    return true;
  }

  // '(' | LPAREN_NEW
  private static boolean atom_7_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_7_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    if (!r) r = consumeToken(b, LPAREN_NEW);
    exit_section_(b, m, null, r);
    return r;
  }

  // lambdaparams?
  private static boolean atom_7_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_7_6")) return false;
    lambdaparams(b, l + 1);
    return true;
  }

  // lambdacaptures?
  private static boolean atom_7_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_7_8")) return false;
    lambdacaptures(b, l + 1);
    return true;
  }

  // (':' type)?
  private static boolean atom_7_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_7_9")) return false;
    atom_7_9_0(b, l + 1);
    return true;
  }

  // ':' type
  private static boolean atom_7_9_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_7_9_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ":");
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '?'?
  private static boolean atom_7_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_7_10")) return false;
    consumeToken(b, "?");
    return true;
  }

  // cap?
  private static boolean atom_7_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_7_14")) return false;
    cap(b, l + 1);
    return true;
  }

  // ffi_decl typeargs? ('(' | LPAREN_NEW) positional? named? ')' '?'?
  private static boolean atom_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ffi_decl(b, l + 1);
    r = r && atom_8_1(b, l + 1);
    r = r && atom_8_2(b, l + 1);
    r = r && atom_8_3(b, l + 1);
    r = r && atom_8_4(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && atom_8_6(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // typeargs?
  private static boolean atom_8_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_8_1")) return false;
    typeargs(b, l + 1);
    return true;
  }

  // '(' | LPAREN_NEW
  private static boolean atom_8_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_8_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    if (!r) r = consumeToken(b, LPAREN_NEW);
    exit_section_(b, m, null, r);
    return r;
  }

  // positional?
  private static boolean atom_8_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_8_3")) return false;
    positional(b, l + 1);
    return true;
  }

  // named?
  private static boolean atom_8_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_8_4")) return false;
    named(b, l + 1);
    return true;
  }

  // '?'?
  private static boolean atom_8_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_8_6")) return false;
    consumeToken(b, "?");
    return true;
  }

  /* ********************************************************** */
  // 'this'
  //   | cap
  //   | ('(' | LPAREN_NEW) infixtype tupletype? ')'
  //   | nominal
  //   | lambdatype
  //   | barelambdatype
  public static boolean atomtype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomtype")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOMTYPE, "<atomtype>");
    r = consumeToken(b, "this");
    if (!r) r = cap(b, l + 1);
    if (!r) r = atomtype_2(b, l + 1);
    if (!r) r = nominal(b, l + 1);
    if (!r) r = lambdatype(b, l + 1);
    if (!r) r = barelambdatype(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('(' | LPAREN_NEW) infixtype tupletype? ')'
  private static boolean atomtype_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomtype_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = atomtype_2_0(b, l + 1);
    r = r && infixtype(b, l + 1);
    r = r && atomtype_2_2(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' | LPAREN_NEW
  private static boolean atomtype_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomtype_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    if (!r) r = consumeToken(b, LPAREN_NEW);
    exit_section_(b, m, null, r);
    return r;
  }

  // tupletype?
  private static boolean atomtype_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomtype_2_2")) return false;
    tupletype(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '@{' cap? ID? typeparams? ('(' | LPAREN_NEW) (type (',' type)*)? ')' (':' type)? '?'? '}' (cap | gencap)? ('^' | '!')?
  public static boolean barelambdatype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BARELAMBDATYPE, "<barelambdatype>");
    r = consumeToken(b, "@{");
    r = r && barelambdatype_1(b, l + 1);
    r = r && barelambdatype_2(b, l + 1);
    r = r && barelambdatype_3(b, l + 1);
    r = r && barelambdatype_4(b, l + 1);
    r = r && barelambdatype_5(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && barelambdatype_7(b, l + 1);
    r = r && barelambdatype_8(b, l + 1);
    r = r && consumeToken(b, "}");
    r = r && barelambdatype_10(b, l + 1);
    r = r && barelambdatype_11(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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

  // '(' | LPAREN_NEW
  private static boolean barelambdatype_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    if (!r) r = consumeToken(b, LPAREN_NEW);
    exit_section_(b, m, null, r);
    return r;
  }

  // (type (',' type)*)?
  private static boolean barelambdatype_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_5")) return false;
    barelambdatype_5_0(b, l + 1);
    return true;
  }

  // type (',' type)*
  private static boolean barelambdatype_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    r = r && barelambdatype_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' type)*
  private static boolean barelambdatype_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_5_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!barelambdatype_5_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "barelambdatype_5_0_1", c)) break;
    }
    return true;
  }

  // ',' type
  private static boolean barelambdatype_5_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_5_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (':' type)?
  private static boolean barelambdatype_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_7")) return false;
    barelambdatype_7_0(b, l + 1);
    return true;
  }

  // ':' type
  private static boolean barelambdatype_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ":");
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '?'?
  private static boolean barelambdatype_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_8")) return false;
    consumeToken(b, "?");
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

  // ('^' | '!')?
  private static boolean barelambdatype_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_11")) return false;
    barelambdatype_11_0(b, l + 1);
    return true;
  }

  // '^' | '!'
  private static boolean barelambdatype_11_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_11_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "^");
    if (!r) r = consumeToken(b, "!");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ('and' | 'or' | 'xor' | '+' | '-' | '*' | '/' | '%' | '%%' | '+~' | '-~' | '*~' | '/~' | '%~' | '%%~' | '<<' | '>>' | '<<~' | '>>~' | '==' | '!=' | '<' | '<=' | '>=' | '>' | '==~' | '!=~' | '<~' | '<=~' | '>=~' | '>~') '?'? term
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

  // 'and' | 'or' | 'xor' | '+' | '-' | '*' | '/' | '%' | '%%' | '+~' | '-~' | '*~' | '/~' | '%~' | '%%~' | '<<' | '>>' | '<<~' | '>>~' | '==' | '!=' | '<' | '<=' | '>=' | '>' | '==~' | '!=~' | '<~' | '<=~' | '>=~' | '>~'
  private static boolean binop_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binop_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "and");
    if (!r) r = consumeToken(b, "or");
    if (!r) r = consumeToken(b, "xor");
    if (!r) r = consumeToken(b, "+");
    if (!r) r = consumeToken(b, "-");
    if (!r) r = consumeToken(b, "*");
    if (!r) r = consumeToken(b, "/");
    if (!r) r = consumeToken(b, "%");
    if (!r) r = consumeToken(b, "%%");
    if (!r) r = consumeToken(b, "+~");
    if (!r) r = consumeToken(b, "-~");
    if (!r) r = consumeToken(b, "*~");
    if (!r) r = consumeToken(b, "/~");
    if (!r) r = consumeToken(b, "%~");
    if (!r) r = consumeToken(b, "%%~");
    if (!r) r = consumeToken(b, "<<");
    if (!r) r = consumeToken(b, ">>");
    if (!r) r = consumeToken(b, "<<~");
    if (!r) r = consumeToken(b, ">>~");
    if (!r) r = consumeToken(b, "==");
    if (!r) r = consumeToken(b, "!=");
    if (!r) r = consumeToken(b, "<");
    if (!r) r = consumeToken(b, "<=");
    if (!r) r = consumeToken(b, ">=");
    if (!r) r = consumeToken(b, ">");
    if (!r) r = consumeToken(b, "==~");
    if (!r) r = consumeToken(b, "!=~");
    if (!r) r = consumeToken(b, "<~");
    if (!r) r = consumeToken(b, "<=~");
    if (!r) r = consumeToken(b, ">=~");
    if (!r) r = consumeToken(b, ">~");
    exit_section_(b, m, null, r);
    return r;
  }

  // '?'?
  private static boolean binop_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binop_1")) return false;
    consumeToken(b, "?");
    return true;
  }

  /* ********************************************************** */
  // '(' positional? named? ')' '?'?
  public static boolean call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CALL, "<call>");
    r = consumeToken(b, "(");
    r = r && call_1(b, l + 1);
    r = r && call_2(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && call_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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

  // '?'?
  private static boolean call_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_4")) return false;
    consumeToken(b, "?");
    return true;
  }

  /* ********************************************************** */
  // 'iso'
  //   | 'trn'
  //   | 'ref'
  //   | 'val'
  //   | 'box'
  //   | 'tag'
  public static boolean cap(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cap")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CAP, "<cap>");
    r = consumeToken(b, "iso");
    if (!r) r = consumeToken(b, "trn");
    if (!r) r = consumeToken(b, "ref");
    if (!r) r = consumeToken(b, "val");
    if (!r) r = consumeToken(b, "box");
    if (!r) r = consumeToken(b, "tag");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '|' ('\' ID (',' ID)* '\')? pattern? ('if' rawseq)? ('=>' rawseq)?
  public static boolean caseexpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseexpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CASEEXPR, "<caseexpr>");
    r = consumeToken(b, "|");
    r = r && caseexpr_1(b, l + 1);
    r = r && caseexpr_2(b, l + 1);
    r = r && caseexpr_3(b, l + 1);
    r = r && caseexpr_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean caseexpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseexpr_1")) return false;
    caseexpr_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean caseexpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseexpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && caseexpr_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean caseexpr_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseexpr_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!caseexpr_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "caseexpr_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean caseexpr_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseexpr_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // pattern?
  private static boolean caseexpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseexpr_2")) return false;
    pattern(b, l + 1);
    return true;
  }

  // ('if' rawseq)?
  private static boolean caseexpr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseexpr_3")) return false;
    caseexpr_3_0(b, l + 1);
    return true;
  }

  // 'if' rawseq
  private static boolean caseexpr_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseexpr_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "if");
    r = r && rawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('=>' rawseq)?
  private static boolean caseexpr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseexpr_4")) return false;
    caseexpr_4_0(b, l + 1);
    return true;
  }

  // '=>' rawseq
  private static boolean caseexpr_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseexpr_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "=>");
    r = r && rawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '.>' ID
  public static boolean chain(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chain")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CHAIN, "<chain>");
    r = consumeToken(b, ".>");
    r = r && consumeToken(b, ID);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ('type' | 'interface' | 'trait' | 'primitive' | 'struct' | 'class' | 'actor') ('\' ID (',' ID)* '\')? '@'? cap? ID typeparams? ('is' type)? doc_string? members
  public static boolean class_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_DEF, "<class def>");
    r = class_def_0(b, l + 1);
    r = r && class_def_1(b, l + 1);
    r = r && class_def_2(b, l + 1);
    r = r && class_def_3(b, l + 1);
    r = r && consumeToken(b, ID);
    r = r && class_def_5(b, l + 1);
    r = r && class_def_6(b, l + 1);
    r = r && class_def_7(b, l + 1);
    r = r && members(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'type' | 'interface' | 'trait' | 'primitive' | 'struct' | 'class' | 'actor'
  private static boolean class_def_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "type");
    if (!r) r = consumeToken(b, "interface");
    if (!r) r = consumeToken(b, "trait");
    if (!r) r = consumeToken(b, "primitive");
    if (!r) r = consumeToken(b, "struct");
    if (!r) r = consumeToken(b, "class");
    if (!r) r = consumeToken(b, "actor");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean class_def_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_1")) return false;
    class_def_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean class_def_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && class_def_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean class_def_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!class_def_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "class_def_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean class_def_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // '@'?
  private static boolean class_def_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_2")) return false;
    consumeToken(b, "@");
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

  // ('is' type)?
  private static boolean class_def_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_6")) return false;
    class_def_6_0(b, l + 1);
    return true;
  }

  // 'is' type
  private static boolean class_def_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "is");
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // doc_string?
  private static boolean class_def_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_7")) return false;
    doc_string(b, l + 1);
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
  // '.' ID
  public static boolean dot(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dot")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DOT, "<dot>");
    r = consumeToken(b, ".");
    r = r && consumeToken(b, ID);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'elseif' ('\' ID (',' ID)* '\')? rawseq 'then' rawseq (elseif | ('else' annotatedrawseq))?
  public static boolean elseif(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseif")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELSEIF, "<elseif>");
    r = consumeToken(b, "elseif");
    r = r && elseif_1(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, "then");
    r = r && rawseq(b, l + 1);
    r = r && elseif_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean elseif_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseif_1")) return false;
    elseif_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean elseif_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseif_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && elseif_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean elseif_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseif_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!elseif_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "elseif_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean elseif_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseif_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // (elseif | ('else' annotatedrawseq))?
  private static boolean elseif_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseif_5")) return false;
    elseif_5_0(b, l + 1);
    return true;
  }

  // elseif | ('else' annotatedrawseq)
  private static boolean elseif_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseif_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elseif(b, l + 1);
    if (!r) r = elseif_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'else' annotatedrawseq
  private static boolean elseif_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseif_5_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'elseif' ('\' ID (',' ID)* '\')? infix 'then' rawseq (elseifdef | ('else' annotatedrawseq))?
  public static boolean elseifdef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseifdef")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELSEIFDEF, "<elseifdef>");
    r = consumeToken(b, "elseif");
    r = r && elseifdef_1(b, l + 1);
    r = r && infix(b, l + 1);
    r = r && consumeToken(b, "then");
    r = r && rawseq(b, l + 1);
    r = r && elseifdef_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean elseifdef_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseifdef_1")) return false;
    elseifdef_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean elseifdef_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseifdef_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && elseifdef_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean elseifdef_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseifdef_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!elseifdef_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "elseifdef_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean elseifdef_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseifdef_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // (elseifdef | ('else' annotatedrawseq))?
  private static boolean elseifdef_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseifdef_5")) return false;
    elseifdef_5_0(b, l + 1);
    return true;
  }

  // elseifdef | ('else' annotatedrawseq)
  private static boolean elseifdef_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseifdef_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elseifdef(b, l + 1);
    if (!r) r = elseifdef_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'else' annotatedrawseq
  private static boolean elseifdef_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseifdef_5_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'elseif' ('\' ID (',' ID)* '\')? iftype (elseiftype | ('else' annotatedrawseq))?
  public static boolean elseiftype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseiftype")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELSEIFTYPE, "<elseiftype>");
    r = consumeToken(b, "elseif");
    r = r && elseiftype_1(b, l + 1);
    r = r && iftype(b, l + 1);
    r = r && elseiftype_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean elseiftype_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseiftype_1")) return false;
    elseiftype_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean elseiftype_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseiftype_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && elseiftype_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean elseiftype_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseiftype_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!elseiftype_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "elseiftype_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean elseiftype_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseiftype_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // (elseiftype | ('else' annotatedrawseq))?
  private static boolean elseiftype_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseiftype_3")) return false;
    elseiftype_3_0(b, l + 1);
    return true;
  }

  // elseiftype | ('else' annotatedrawseq)
  private static boolean elseiftype_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseiftype_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elseiftype(b, l + 1);
    if (!r) r = elseiftype_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'else' annotatedrawseq
  private static boolean elseiftype_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseiftype_3_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
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
  // '@' (ID | STRING)
  public static boolean ffi_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ffi_decl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FFI_DECL, "<ffi decl>");
    r = consumeToken(b, "@");
    r = r && ffi_decl_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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

  /* ********************************************************** */
  // ('var' | 'let' | 'embed') ID ':' type ('=' infix)? doc_string?
  public static boolean field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD, "<field>");
    r = field_0(b, l + 1);
    r = r && consumeToken(b, ID);
    r = r && consumeToken(b, ":");
    r = r && type(b, l + 1);
    r = r && field_4(b, l + 1);
    r = r && field_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'var' | 'let' | 'embed'
  private static boolean field_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "var");
    if (!r) r = consumeToken(b, "let");
    if (!r) r = consumeToken(b, "embed");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('=' infix)?
  private static boolean field_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_4")) return false;
    field_4_0(b, l + 1);
    return true;
  }

  // '=' infix
  private static boolean field_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "=");
    r = r && infix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // doc_string?
  private static boolean field_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_5")) return false;
    doc_string(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '#read'
  //   | '#send'
  //   | '#share'
  //   | '#alias'
  //   | '#any'
  public static boolean gencap(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gencap")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GENCAP, "<gencap>");
    r = consumeToken(b, "#read");
    if (!r) r = consumeToken(b, "#send");
    if (!r) r = consumeToken(b, "#share");
    if (!r) r = consumeToken(b, "#alias");
    if (!r) r = consumeToken(b, "#any");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ID
  //   | ('(' | LPAREN_NEW) idseq_in_seq (',' idseq_in_seq)* ')'
  public static boolean idseq(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDSEQ, "<idseq>");
    r = consumeToken(b, ID);
    if (!r) r = idseq_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('(' | LPAREN_NEW) idseq_in_seq (',' idseq_in_seq)* ')'
  private static boolean idseq_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = idseq_1_0(b, l + 1);
    r = r && idseq_in_seq(b, l + 1);
    r = r && idseq_1_2(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' | LPAREN_NEW
  private static boolean idseq_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    if (!r) r = consumeToken(b, LPAREN_NEW);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' idseq_in_seq)*
  private static boolean idseq_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq_1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!idseq_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "idseq_1_2", c)) break;
    }
    return true;
  }

  // ',' idseq_in_seq
  private static boolean idseq_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && idseq_in_seq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ID
  //   | ('(' | LPAREN_NEW) idseq_in_seq (',' idseq_in_seq)* ')'
  public static boolean idseq_in_seq(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq_in_seq")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDSEQ_IN_SEQ, "<idseq in seq>");
    r = consumeToken(b, ID);
    if (!r) r = idseq_in_seq_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('(' | LPAREN_NEW) idseq_in_seq (',' idseq_in_seq)* ')'
  private static boolean idseq_in_seq_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq_in_seq_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = idseq_in_seq_1_0(b, l + 1);
    r = r && idseq_in_seq(b, l + 1);
    r = r && idseq_in_seq_1_2(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' | LPAREN_NEW
  private static boolean idseq_in_seq_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq_in_seq_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    if (!r) r = consumeToken(b, LPAREN_NEW);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' idseq_in_seq)*
  private static boolean idseq_in_seq_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq_in_seq_1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!idseq_in_seq_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "idseq_in_seq_1_2", c)) break;
    }
    return true;
  }

  // ',' idseq_in_seq
  private static boolean idseq_in_seq_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq_in_seq_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && idseq_in_seq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // type '<::=' type 'then' rawseq
  public static boolean iftype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iftype")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IFTYPE, "<iftype>");
    r = type(b, l + 1);
    r = r && consumeToken(b, "<::=");
    r = r && type(b, l + 1);
    r = r && consumeToken(b, "then");
    r = r && rawseq(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // term (binop | isop | ('as' type))*
  public static boolean infix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INFIX, "<infix>");
    r = term(b, l + 1);
    r = r && infix_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (binop | isop | ('as' type))*
  private static boolean infix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infix_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!infix_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "infix_1", c)) break;
    }
    return true;
  }

  // binop | isop | ('as' type)
  private static boolean infix_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infix_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binop(b, l + 1);
    if (!r) r = isop(b, l + 1);
    if (!r) r = infix_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'as' type
  private static boolean infix_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infix_1_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "as");
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // type (uniontype | isecttype)*
  public static boolean infixtype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infixtype")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INFIXTYPE, "<infixtype>");
    r = type(b, l + 1);
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
  // '&' type
  public static boolean isecttype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "isecttype")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ISECTTYPE, "<isecttype>");
    r = consumeToken(b, "&");
    r = r && type(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ('is' | 'isnt') term
  public static boolean isop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "isop")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ISOP, "<isop>");
    r = isop_0(b, l + 1);
    r = r && term(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'is' | 'isnt'
  private static boolean isop_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "isop_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "is");
    if (!r) r = consumeToken(b, "isnt");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ('return' | 'break' | 'continue' | 'error' | 'compile_intrinsic' | 'compile_error') rawseq?
  public static boolean jump(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jump")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, JUMP, "<jump>");
    r = jump_0(b, l + 1);
    r = r && jump_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'return' | 'break' | 'continue' | 'error' | 'compile_intrinsic' | 'compile_error'
  private static boolean jump_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jump_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "return");
    if (!r) r = consumeToken(b, "break");
    if (!r) r = consumeToken(b, "continue");
    if (!r) r = consumeToken(b, "error");
    if (!r) r = consumeToken(b, "compile_intrinsic");
    if (!r) r = consumeToken(b, "compile_error");
    exit_section_(b, m, null, r);
    return r;
  }

  // rawseq?
  private static boolean jump_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jump_1")) return false;
    rawseq(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ID (':' type)? ('=' infix)?
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

  // (':' type)?
  private static boolean lambdacapture_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacapture_1")) return false;
    lambdacapture_1_0(b, l + 1);
    return true;
  }

  // ':' type
  private static boolean lambdacapture_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacapture_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ":");
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('=' infix)?
  private static boolean lambdacapture_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacapture_2")) return false;
    lambdacapture_2_0(b, l + 1);
    return true;
  }

  // '=' infix
  private static boolean lambdacapture_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacapture_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "=");
    r = r && infix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ('(' | LPAREN_NEW) (lambdacapture | 'this') (',' (lambdacapture | 'this'))* ')'
  public static boolean lambdacaptures(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacaptures")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LAMBDACAPTURES, "<lambdacaptures>");
    r = lambdacaptures_0(b, l + 1);
    r = r && lambdacaptures_1(b, l + 1);
    r = r && lambdacaptures_2(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '(' | LPAREN_NEW
  private static boolean lambdacaptures_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacaptures_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    if (!r) r = consumeToken(b, LPAREN_NEW);
    exit_section_(b, m, null, r);
    return r;
  }

  // lambdacapture | 'this'
  private static boolean lambdacaptures_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacaptures_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = lambdacapture(b, l + 1);
    if (!r) r = consumeToken(b, "this");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' (lambdacapture | 'this'))*
  private static boolean lambdacaptures_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacaptures_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!lambdacaptures_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lambdacaptures_2", c)) break;
    }
    return true;
  }

  // ',' (lambdacapture | 'this')
  private static boolean lambdacaptures_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacaptures_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && lambdacaptures_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // lambdacapture | 'this'
  private static boolean lambdacaptures_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacaptures_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = lambdacapture(b, l + 1);
    if (!r) r = consumeToken(b, "this");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ID (':' type)? ('=' infix)?
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

  // (':' type)?
  private static boolean lambdaparam_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaparam_1")) return false;
    lambdaparam_1_0(b, l + 1);
    return true;
  }

  // ':' type
  private static boolean lambdaparam_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaparam_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ":");
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('=' infix)?
  private static boolean lambdaparam_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaparam_2")) return false;
    lambdaparam_2_0(b, l + 1);
    return true;
  }

  // '=' infix
  private static boolean lambdaparam_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaparam_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "=");
    r = r && infix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // lambdaparam (',' lambdaparam)*
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

  // (',' lambdaparam)*
  private static boolean lambdaparams_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaparams_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!lambdaparams_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lambdaparams_1", c)) break;
    }
    return true;
  }

  // ',' lambdaparam
  private static boolean lambdaparams_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaparams_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && lambdaparam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '{' cap? ID? typeparams? ('(' | LPAREN_NEW) (type (',' type)*)? ')' (':' type)? '?'? '}' (cap | gencap)? ('^' | '!')?
  public static boolean lambdatype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LAMBDATYPE, "<lambdatype>");
    r = consumeToken(b, "{");
    r = r && lambdatype_1(b, l + 1);
    r = r && lambdatype_2(b, l + 1);
    r = r && lambdatype_3(b, l + 1);
    r = r && lambdatype_4(b, l + 1);
    r = r && lambdatype_5(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && lambdatype_7(b, l + 1);
    r = r && lambdatype_8(b, l + 1);
    r = r && consumeToken(b, "}");
    r = r && lambdatype_10(b, l + 1);
    r = r && lambdatype_11(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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

  // '(' | LPAREN_NEW
  private static boolean lambdatype_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    if (!r) r = consumeToken(b, LPAREN_NEW);
    exit_section_(b, m, null, r);
    return r;
  }

  // (type (',' type)*)?
  private static boolean lambdatype_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_5")) return false;
    lambdatype_5_0(b, l + 1);
    return true;
  }

  // type (',' type)*
  private static boolean lambdatype_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    r = r && lambdatype_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' type)*
  private static boolean lambdatype_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_5_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!lambdatype_5_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lambdatype_5_0_1", c)) break;
    }
    return true;
  }

  // ',' type
  private static boolean lambdatype_5_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_5_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (':' type)?
  private static boolean lambdatype_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_7")) return false;
    lambdatype_7_0(b, l + 1);
    return true;
  }

  // ':' type
  private static boolean lambdatype_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ":");
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '?'?
  private static boolean lambdatype_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_8")) return false;
    consumeToken(b, "?");
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

  // ('^' | '!')?
  private static boolean lambdatype_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_11")) return false;
    lambdatype_11_0(b, l + 1);
    return true;
  }

  // '^' | '!'
  private static boolean lambdatype_11_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_11_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "^");
    if (!r) r = consumeToken(b, "!");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'true'
  //   | 'false'
  //   | NUMBER
  //   | FLOAT
  //   | STRING
  public static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL, "<literal>");
    r = consumeToken(b, "true");
    if (!r) r = consumeToken(b, "false");
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // field* method*
  public static boolean members(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "members")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MEMBERS, "<members>");
    r = members_0(b, l + 1);
    r = r && members_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // field*
  private static boolean members_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "members_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!field(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "members_0", c)) break;
    }
    return true;
  }

  // method*
  private static boolean members_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "members_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!method(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "members_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ('fun' | 'be' | 'new') ('\' ID (',' ID)* '\')? (cap | '@')? ID typeparams? ('(' | LPAREN_NEW) params? ')' (':' type)? '?'? doc_string? ('=>' rawseq)?
  public static boolean method(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD, "<method>");
    r = method_0(b, l + 1);
    r = r && method_1(b, l + 1);
    r = r && method_2(b, l + 1);
    r = r && consumeToken(b, ID);
    r = r && method_4(b, l + 1);
    r = r && method_5(b, l + 1);
    r = r && method_6(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && method_8(b, l + 1);
    r = r && method_9(b, l + 1);
    r = r && method_10(b, l + 1);
    r = r && method_11(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'fun' | 'be' | 'new'
  private static boolean method_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "fun");
    if (!r) r = consumeToken(b, "be");
    if (!r) r = consumeToken(b, "new");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean method_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_1")) return false;
    method_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean method_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && method_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean method_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!method_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "method_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean method_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // (cap | '@')?
  private static boolean method_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_2")) return false;
    method_2_0(b, l + 1);
    return true;
  }

  // cap | '@'
  private static boolean method_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = cap(b, l + 1);
    if (!r) r = consumeToken(b, "@");
    exit_section_(b, m, null, r);
    return r;
  }

  // typeparams?
  private static boolean method_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_4")) return false;
    typeparams(b, l + 1);
    return true;
  }

  // '(' | LPAREN_NEW
  private static boolean method_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    if (!r) r = consumeToken(b, LPAREN_NEW);
    exit_section_(b, m, null, r);
    return r;
  }

  // params?
  private static boolean method_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_6")) return false;
    params(b, l + 1);
    return true;
  }

  // (':' type)?
  private static boolean method_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_8")) return false;
    method_8_0(b, l + 1);
    return true;
  }

  // ':' type
  private static boolean method_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_8_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ":");
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '?'?
  private static boolean method_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_9")) return false;
    consumeToken(b, "?");
    return true;
  }

  // doc_string?
  private static boolean method_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_10")) return false;
    doc_string(b, l + 1);
    return true;
  }

  // ('=>' rawseq)?
  private static boolean method_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_11")) return false;
    method_11_0(b, l + 1);
    return true;
  }

  // '=>' rawseq
  private static boolean method_11_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_11_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "=>");
    r = r && rawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // doc_string? use* class_def*
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

  // use*
  private static boolean module_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!use(b, l + 1)) break;
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
  // 'where' namedarg (',' namedarg)*
  public static boolean named(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMED, "<named>");
    r = consumeToken(b, "where");
    r = r && namedarg(b, l + 1);
    r = r && named_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' namedarg)*
  private static boolean named_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!named_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "named_2", c)) break;
    }
    return true;
  }

  // ',' namedarg
  private static boolean named_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && namedarg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ID '=' rawseq
  public static boolean namedarg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namedarg")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && consumeToken(b, "=");
    r = r && rawseq(b, l + 1);
    exit_section_(b, m, NAMEDARG, r);
    return r;
  }

  /* ********************************************************** */
  // nextinfix ('=' assignment)?
  public static boolean nextassignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextassignment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NEXTASSIGNMENT, "<nextassignment>");
    r = nextinfix(b, l + 1);
    r = r && nextassignment_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('=' assignment)?
  private static boolean nextassignment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextassignment_1")) return false;
    nextassignment_1_0(b, l + 1);
    return true;
  }

  // '=' assignment
  private static boolean nextassignment_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextassignment_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "=");
    r = r && assignment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ID
  //   | 'this'
  //   | literal
  //   | LPAREN_NEW rawseq tuple? ')'
  //   | LSQUARE_NEW ('as' type ':')? rawseq? ']'
  //   | 'object' ('\' ID (',' ID)* '\')? cap? ('is' type)? members 'end'
  //   | '{' ('\' ID (',' ID)* '\')? cap? ID? typeparams? ('(' | LPAREN_NEW) lambdaparams? ')' lambdacaptures? (':' type)? '?'? '=>' rawseq '}' cap?
  //   | '@{' ('\' ID (',' ID)* '\')? cap? ID? typeparams? ('(' | LPAREN_NEW) lambdaparams? ')' lambdacaptures? (':' type)? '?'? '=>' rawseq '}' cap?
  //   | ffi_decl typeargs? ('(' | LPAREN_NEW) positional? named? ')' '?'?
  //   | '__loc'
  public static boolean nextatom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NEXTATOM, "<nextatom>");
    r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, "this");
    if (!r) r = literal(b, l + 1);
    if (!r) r = nextatom_3(b, l + 1);
    if (!r) r = nextatom_4(b, l + 1);
    if (!r) r = nextatom_5(b, l + 1);
    if (!r) r = nextatom_6(b, l + 1);
    if (!r) r = nextatom_7(b, l + 1);
    if (!r) r = nextatom_8(b, l + 1);
    if (!r) r = consumeToken(b, "__loc");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LPAREN_NEW rawseq tuple? ')'
  private static boolean nextatom_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN_NEW);
    r = r && rawseq(b, l + 1);
    r = r && nextatom_3_2(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // tuple?
  private static boolean nextatom_3_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_3_2")) return false;
    tuple(b, l + 1);
    return true;
  }

  // LSQUARE_NEW ('as' type ':')? rawseq? ']'
  private static boolean nextatom_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LSQUARE_NEW);
    r = r && nextatom_4_1(b, l + 1);
    r = r && nextatom_4_2(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('as' type ':')?
  private static boolean nextatom_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_4_1")) return false;
    nextatom_4_1_0(b, l + 1);
    return true;
  }

  // 'as' type ':'
  private static boolean nextatom_4_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_4_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "as");
    r = r && type(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // rawseq?
  private static boolean nextatom_4_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_4_2")) return false;
    rawseq(b, l + 1);
    return true;
  }

  // 'object' ('\' ID (',' ID)* '\')? cap? ('is' type)? members 'end'
  private static boolean nextatom_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "object");
    r = r && nextatom_5_1(b, l + 1);
    r = r && nextatom_5_2(b, l + 1);
    r = r && nextatom_5_3(b, l + 1);
    r = r && members(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean nextatom_5_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_5_1")) return false;
    nextatom_5_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean nextatom_5_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_5_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && nextatom_5_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean nextatom_5_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_5_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nextatom_5_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nextatom_5_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean nextatom_5_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_5_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // cap?
  private static boolean nextatom_5_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_5_2")) return false;
    cap(b, l + 1);
    return true;
  }

  // ('is' type)?
  private static boolean nextatom_5_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_5_3")) return false;
    nextatom_5_3_0(b, l + 1);
    return true;
  }

  // 'is' type
  private static boolean nextatom_5_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_5_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "is");
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '{' ('\' ID (',' ID)* '\')? cap? ID? typeparams? ('(' | LPAREN_NEW) lambdaparams? ')' lambdacaptures? (':' type)? '?'? '=>' rawseq '}' cap?
  private static boolean nextatom_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "{");
    r = r && nextatom_6_1(b, l + 1);
    r = r && nextatom_6_2(b, l + 1);
    r = r && nextatom_6_3(b, l + 1);
    r = r && nextatom_6_4(b, l + 1);
    r = r && nextatom_6_5(b, l + 1);
    r = r && nextatom_6_6(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && nextatom_6_8(b, l + 1);
    r = r && nextatom_6_9(b, l + 1);
    r = r && nextatom_6_10(b, l + 1);
    r = r && consumeToken(b, "=>");
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, "}");
    r = r && nextatom_6_14(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean nextatom_6_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_6_1")) return false;
    nextatom_6_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean nextatom_6_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_6_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && nextatom_6_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean nextatom_6_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_6_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nextatom_6_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nextatom_6_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean nextatom_6_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_6_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // cap?
  private static boolean nextatom_6_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_6_2")) return false;
    cap(b, l + 1);
    return true;
  }

  // ID?
  private static boolean nextatom_6_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_6_3")) return false;
    consumeToken(b, ID);
    return true;
  }

  // typeparams?
  private static boolean nextatom_6_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_6_4")) return false;
    typeparams(b, l + 1);
    return true;
  }

  // '(' | LPAREN_NEW
  private static boolean nextatom_6_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_6_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    if (!r) r = consumeToken(b, LPAREN_NEW);
    exit_section_(b, m, null, r);
    return r;
  }

  // lambdaparams?
  private static boolean nextatom_6_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_6_6")) return false;
    lambdaparams(b, l + 1);
    return true;
  }

  // lambdacaptures?
  private static boolean nextatom_6_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_6_8")) return false;
    lambdacaptures(b, l + 1);
    return true;
  }

  // (':' type)?
  private static boolean nextatom_6_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_6_9")) return false;
    nextatom_6_9_0(b, l + 1);
    return true;
  }

  // ':' type
  private static boolean nextatom_6_9_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_6_9_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ":");
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '?'?
  private static boolean nextatom_6_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_6_10")) return false;
    consumeToken(b, "?");
    return true;
  }

  // cap?
  private static boolean nextatom_6_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_6_14")) return false;
    cap(b, l + 1);
    return true;
  }

  // '@{' ('\' ID (',' ID)* '\')? cap? ID? typeparams? ('(' | LPAREN_NEW) lambdaparams? ')' lambdacaptures? (':' type)? '?'? '=>' rawseq '}' cap?
  private static boolean nextatom_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "@{");
    r = r && nextatom_7_1(b, l + 1);
    r = r && nextatom_7_2(b, l + 1);
    r = r && nextatom_7_3(b, l + 1);
    r = r && nextatom_7_4(b, l + 1);
    r = r && nextatom_7_5(b, l + 1);
    r = r && nextatom_7_6(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && nextatom_7_8(b, l + 1);
    r = r && nextatom_7_9(b, l + 1);
    r = r && nextatom_7_10(b, l + 1);
    r = r && consumeToken(b, "=>");
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, "}");
    r = r && nextatom_7_14(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean nextatom_7_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_7_1")) return false;
    nextatom_7_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean nextatom_7_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_7_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && nextatom_7_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean nextatom_7_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_7_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nextatom_7_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nextatom_7_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean nextatom_7_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_7_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // cap?
  private static boolean nextatom_7_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_7_2")) return false;
    cap(b, l + 1);
    return true;
  }

  // ID?
  private static boolean nextatom_7_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_7_3")) return false;
    consumeToken(b, ID);
    return true;
  }

  // typeparams?
  private static boolean nextatom_7_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_7_4")) return false;
    typeparams(b, l + 1);
    return true;
  }

  // '(' | LPAREN_NEW
  private static boolean nextatom_7_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_7_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    if (!r) r = consumeToken(b, LPAREN_NEW);
    exit_section_(b, m, null, r);
    return r;
  }

  // lambdaparams?
  private static boolean nextatom_7_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_7_6")) return false;
    lambdaparams(b, l + 1);
    return true;
  }

  // lambdacaptures?
  private static boolean nextatom_7_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_7_8")) return false;
    lambdacaptures(b, l + 1);
    return true;
  }

  // (':' type)?
  private static boolean nextatom_7_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_7_9")) return false;
    nextatom_7_9_0(b, l + 1);
    return true;
  }

  // ':' type
  private static boolean nextatom_7_9_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_7_9_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ":");
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '?'?
  private static boolean nextatom_7_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_7_10")) return false;
    consumeToken(b, "?");
    return true;
  }

  // cap?
  private static boolean nextatom_7_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_7_14")) return false;
    cap(b, l + 1);
    return true;
  }

  // ffi_decl typeargs? ('(' | LPAREN_NEW) positional? named? ')' '?'?
  private static boolean nextatom_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ffi_decl(b, l + 1);
    r = r && nextatom_8_1(b, l + 1);
    r = r && nextatom_8_2(b, l + 1);
    r = r && nextatom_8_3(b, l + 1);
    r = r && nextatom_8_4(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && nextatom_8_6(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // typeargs?
  private static boolean nextatom_8_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_8_1")) return false;
    typeargs(b, l + 1);
    return true;
  }

  // '(' | LPAREN_NEW
  private static boolean nextatom_8_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_8_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    if (!r) r = consumeToken(b, LPAREN_NEW);
    exit_section_(b, m, null, r);
    return r;
  }

  // positional?
  private static boolean nextatom_8_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_8_3")) return false;
    positional(b, l + 1);
    return true;
  }

  // named?
  private static boolean nextatom_8_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_8_4")) return false;
    named(b, l + 1);
    return true;
  }

  // '?'?
  private static boolean nextatom_8_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextatom_8_6")) return false;
    consumeToken(b, "?");
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
  // nextterm (binop | isop | ('as' type))*
  public static boolean nextinfix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextinfix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NEXTINFIX, "<nextinfix>");
    r = nextterm(b, l + 1);
    r = r && nextinfix_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (binop | isop | ('as' type))*
  private static boolean nextinfix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextinfix_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nextinfix_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nextinfix_1", c)) break;
    }
    return true;
  }

  // binop | isop | ('as' type)
  private static boolean nextinfix_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextinfix_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binop(b, l + 1);
    if (!r) r = isop(b, l + 1);
    if (!r) r = nextinfix_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'as' type
  private static boolean nextinfix_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextinfix_1_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "as");
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ('not' | 'addressof' | MINUS_NEW | MINUS_TILDE_NEW | 'digestof') parampattern
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

  // ('not' | 'addressof' | MINUS_NEW | MINUS_TILDE_NEW | 'digestof') parampattern
  private static boolean nextparampattern_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextparampattern_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nextparampattern_0_0(b, l + 1);
    r = r && parampattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'not' | 'addressof' | MINUS_NEW | MINUS_TILDE_NEW | 'digestof'
  private static boolean nextparampattern_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextparampattern_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "not");
    if (!r) r = consumeToken(b, "addressof");
    if (!r) r = consumeToken(b, MINUS_NEW);
    if (!r) r = consumeToken(b, MINUS_TILDE_NEW);
    if (!r) r = consumeToken(b, "digestof");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ('var' | 'let' | 'embed') ID (':' type)?
  //   | nextparampattern
  public static boolean nextpattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextpattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NEXTPATTERN, "<nextpattern>");
    r = nextpattern_0(b, l + 1);
    if (!r) r = nextparampattern(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('var' | 'let' | 'embed') ID (':' type)?
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

  // 'var' | 'let' | 'embed'
  private static boolean nextpattern_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextpattern_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "var");
    if (!r) r = consumeToken(b, "let");
    if (!r) r = consumeToken(b, "embed");
    exit_section_(b, m, null, r);
    return r;
  }

  // (':' type)?
  private static boolean nextpattern_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextpattern_0_2")) return false;
    nextpattern_0_2_0(b, l + 1);
    return true;
  }

  // ':' type
  private static boolean nextpattern_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextpattern_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ":");
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // nextatom (dot | tilde | chain | typeargs | call)*
  public static boolean nextpostfix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextpostfix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NEXTPOSTFIX, "<nextpostfix>");
    r = nextatom(b, l + 1);
    r = r && nextpostfix_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (dot | tilde | chain | typeargs | call)*
  private static boolean nextpostfix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextpostfix_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nextpostfix_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nextpostfix_1", c)) break;
    }
    return true;
  }

  // dot | tilde | chain | typeargs | call
  private static boolean nextpostfix_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextpostfix_1_0")) return false;
    boolean r;
    r = dot(b, l + 1);
    if (!r) r = tilde(b, l + 1);
    if (!r) r = chain(b, l + 1);
    if (!r) r = typeargs(b, l + 1);
    if (!r) r = call(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'if' ('\' ID (',' ID)* '\')? rawseq 'then' rawseq (elseif | ('else' annotatedrawseq))? 'end'
  //   | 'ifdef' ('\' ID (',' ID)* '\')? infix 'then' rawseq (elseifdef | ('else' annotatedrawseq))? 'end'
  //   | 'iftype' ('\' ID (',' ID)* '\')? iftype (elseiftype | ('else' annotatedrawseq))? 'end'
  //   | 'match' ('\' ID (',' ID)* '\')? rawseq caseexpr* ('else' annotatedrawseq)? 'end'
  //   | 'while' ('\' ID (',' ID)* '\')? rawseq 'do' rawseq ('else' annotatedrawseq)? 'end'
  //   | 'repeat' ('\' ID (',' ID)* '\')? rawseq 'until' annotatedrawseq ('else' annotatedrawseq)? 'end'
  //   | 'for' ('\' ID (',' ID)* '\')? idseq 'in' rawseq 'do' rawseq ('else' annotatedrawseq)? 'end'
  //   | 'with' ('\' ID (',' ID)* '\')? (withelem (',' withelem)*) 'do' rawseq ('else' annotatedrawseq)? 'end'
  //   | 'try' ('\' ID (',' ID)* '\')? rawseq ('else' annotatedrawseq)? ('then' annotatedrawseq)? 'end'
  //   | 'recover' ('\' ID (',' ID)* '\')? cap? rawseq 'end'
  //   | 'consume' cap? term
  //   | nextpattern
  //   | '#' postfix
  public static boolean nextterm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NEXTTERM, "<nextterm>");
    r = nextterm_0(b, l + 1);
    if (!r) r = nextterm_1(b, l + 1);
    if (!r) r = nextterm_2(b, l + 1);
    if (!r) r = nextterm_3(b, l + 1);
    if (!r) r = nextterm_4(b, l + 1);
    if (!r) r = nextterm_5(b, l + 1);
    if (!r) r = nextterm_6(b, l + 1);
    if (!r) r = nextterm_7(b, l + 1);
    if (!r) r = nextterm_8(b, l + 1);
    if (!r) r = nextterm_9(b, l + 1);
    if (!r) r = nextterm_10(b, l + 1);
    if (!r) r = nextpattern(b, l + 1);
    if (!r) r = nextterm_12(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'if' ('\' ID (',' ID)* '\')? rawseq 'then' rawseq (elseif | ('else' annotatedrawseq))? 'end'
  private static boolean nextterm_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "if");
    r = r && nextterm_0_1(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, "then");
    r = r && rawseq(b, l + 1);
    r = r && nextterm_0_5(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean nextterm_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_0_1")) return false;
    nextterm_0_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean nextterm_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && nextterm_0_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean nextterm_0_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_0_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nextterm_0_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nextterm_0_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean nextterm_0_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_0_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // (elseif | ('else' annotatedrawseq))?
  private static boolean nextterm_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_0_5")) return false;
    nextterm_0_5_0(b, l + 1);
    return true;
  }

  // elseif | ('else' annotatedrawseq)
  private static boolean nextterm_0_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_0_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elseif(b, l + 1);
    if (!r) r = nextterm_0_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'else' annotatedrawseq
  private static boolean nextterm_0_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_0_5_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'ifdef' ('\' ID (',' ID)* '\')? infix 'then' rawseq (elseifdef | ('else' annotatedrawseq))? 'end'
  private static boolean nextterm_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "ifdef");
    r = r && nextterm_1_1(b, l + 1);
    r = r && infix(b, l + 1);
    r = r && consumeToken(b, "then");
    r = r && rawseq(b, l + 1);
    r = r && nextterm_1_5(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean nextterm_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_1_1")) return false;
    nextterm_1_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean nextterm_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && nextterm_1_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean nextterm_1_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_1_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nextterm_1_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nextterm_1_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean nextterm_1_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_1_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // (elseifdef | ('else' annotatedrawseq))?
  private static boolean nextterm_1_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_1_5")) return false;
    nextterm_1_5_0(b, l + 1);
    return true;
  }

  // elseifdef | ('else' annotatedrawseq)
  private static boolean nextterm_1_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_1_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elseifdef(b, l + 1);
    if (!r) r = nextterm_1_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'else' annotatedrawseq
  private static boolean nextterm_1_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_1_5_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'iftype' ('\' ID (',' ID)* '\')? iftype (elseiftype | ('else' annotatedrawseq))? 'end'
  private static boolean nextterm_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "iftype");
    r = r && nextterm_2_1(b, l + 1);
    r = r && iftype(b, l + 1);
    r = r && nextterm_2_3(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean nextterm_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_2_1")) return false;
    nextterm_2_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean nextterm_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_2_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && nextterm_2_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean nextterm_2_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_2_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nextterm_2_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nextterm_2_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean nextterm_2_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_2_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // (elseiftype | ('else' annotatedrawseq))?
  private static boolean nextterm_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_2_3")) return false;
    nextterm_2_3_0(b, l + 1);
    return true;
  }

  // elseiftype | ('else' annotatedrawseq)
  private static boolean nextterm_2_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_2_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elseiftype(b, l + 1);
    if (!r) r = nextterm_2_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'else' annotatedrawseq
  private static boolean nextterm_2_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_2_3_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'match' ('\' ID (',' ID)* '\')? rawseq caseexpr* ('else' annotatedrawseq)? 'end'
  private static boolean nextterm_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "match");
    r = r && nextterm_3_1(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && nextterm_3_3(b, l + 1);
    r = r && nextterm_3_4(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean nextterm_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_3_1")) return false;
    nextterm_3_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean nextterm_3_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_3_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && nextterm_3_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean nextterm_3_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_3_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nextterm_3_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nextterm_3_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean nextterm_3_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_3_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // caseexpr*
  private static boolean nextterm_3_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_3_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!caseexpr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nextterm_3_3", c)) break;
    }
    return true;
  }

  // ('else' annotatedrawseq)?
  private static boolean nextterm_3_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_3_4")) return false;
    nextterm_3_4_0(b, l + 1);
    return true;
  }

  // 'else' annotatedrawseq
  private static boolean nextterm_3_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_3_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'while' ('\' ID (',' ID)* '\')? rawseq 'do' rawseq ('else' annotatedrawseq)? 'end'
  private static boolean nextterm_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "while");
    r = r && nextterm_4_1(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, "do");
    r = r && rawseq(b, l + 1);
    r = r && nextterm_4_5(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean nextterm_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_4_1")) return false;
    nextterm_4_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean nextterm_4_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_4_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && nextterm_4_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean nextterm_4_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_4_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nextterm_4_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nextterm_4_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean nextterm_4_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_4_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('else' annotatedrawseq)?
  private static boolean nextterm_4_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_4_5")) return false;
    nextterm_4_5_0(b, l + 1);
    return true;
  }

  // 'else' annotatedrawseq
  private static boolean nextterm_4_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_4_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'repeat' ('\' ID (',' ID)* '\')? rawseq 'until' annotatedrawseq ('else' annotatedrawseq)? 'end'
  private static boolean nextterm_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "repeat");
    r = r && nextterm_5_1(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, "until");
    r = r && annotatedrawseq(b, l + 1);
    r = r && nextterm_5_5(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean nextterm_5_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_5_1")) return false;
    nextterm_5_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean nextterm_5_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_5_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && nextterm_5_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean nextterm_5_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_5_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nextterm_5_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nextterm_5_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean nextterm_5_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_5_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('else' annotatedrawseq)?
  private static boolean nextterm_5_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_5_5")) return false;
    nextterm_5_5_0(b, l + 1);
    return true;
  }

  // 'else' annotatedrawseq
  private static boolean nextterm_5_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_5_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'for' ('\' ID (',' ID)* '\')? idseq 'in' rawseq 'do' rawseq ('else' annotatedrawseq)? 'end'
  private static boolean nextterm_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "for");
    r = r && nextterm_6_1(b, l + 1);
    r = r && idseq(b, l + 1);
    r = r && consumeToken(b, "in");
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, "do");
    r = r && rawseq(b, l + 1);
    r = r && nextterm_6_7(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean nextterm_6_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_6_1")) return false;
    nextterm_6_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean nextterm_6_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_6_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && nextterm_6_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean nextterm_6_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_6_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nextterm_6_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nextterm_6_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean nextterm_6_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_6_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('else' annotatedrawseq)?
  private static boolean nextterm_6_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_6_7")) return false;
    nextterm_6_7_0(b, l + 1);
    return true;
  }

  // 'else' annotatedrawseq
  private static boolean nextterm_6_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_6_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'with' ('\' ID (',' ID)* '\')? (withelem (',' withelem)*) 'do' rawseq ('else' annotatedrawseq)? 'end'
  private static boolean nextterm_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "with");
    r = r && nextterm_7_1(b, l + 1);
    r = r && nextterm_7_2(b, l + 1);
    r = r && consumeToken(b, "do");
    r = r && rawseq(b, l + 1);
    r = r && nextterm_7_5(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean nextterm_7_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_7_1")) return false;
    nextterm_7_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean nextterm_7_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_7_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && nextterm_7_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean nextterm_7_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_7_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nextterm_7_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nextterm_7_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean nextterm_7_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_7_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // withelem (',' withelem)*
  private static boolean nextterm_7_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_7_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = withelem(b, l + 1);
    r = r && nextterm_7_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' withelem)*
  private static boolean nextterm_7_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_7_2_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nextterm_7_2_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nextterm_7_2_1", c)) break;
    }
    return true;
  }

  // ',' withelem
  private static boolean nextterm_7_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_7_2_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && withelem(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('else' annotatedrawseq)?
  private static boolean nextterm_7_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_7_5")) return false;
    nextterm_7_5_0(b, l + 1);
    return true;
  }

  // 'else' annotatedrawseq
  private static boolean nextterm_7_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_7_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'try' ('\' ID (',' ID)* '\')? rawseq ('else' annotatedrawseq)? ('then' annotatedrawseq)? 'end'
  private static boolean nextterm_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "try");
    r = r && nextterm_8_1(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && nextterm_8_3(b, l + 1);
    r = r && nextterm_8_4(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean nextterm_8_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_8_1")) return false;
    nextterm_8_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean nextterm_8_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_8_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && nextterm_8_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean nextterm_8_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_8_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nextterm_8_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nextterm_8_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean nextterm_8_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_8_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('else' annotatedrawseq)?
  private static boolean nextterm_8_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_8_3")) return false;
    nextterm_8_3_0(b, l + 1);
    return true;
  }

  // 'else' annotatedrawseq
  private static boolean nextterm_8_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_8_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('then' annotatedrawseq)?
  private static boolean nextterm_8_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_8_4")) return false;
    nextterm_8_4_0(b, l + 1);
    return true;
  }

  // 'then' annotatedrawseq
  private static boolean nextterm_8_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_8_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "then");
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'recover' ('\' ID (',' ID)* '\')? cap? rawseq 'end'
  private static boolean nextterm_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "recover");
    r = r && nextterm_9_1(b, l + 1);
    r = r && nextterm_9_2(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean nextterm_9_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_9_1")) return false;
    nextterm_9_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean nextterm_9_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_9_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && nextterm_9_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean nextterm_9_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_9_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nextterm_9_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nextterm_9_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean nextterm_9_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_9_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // cap?
  private static boolean nextterm_9_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_9_2")) return false;
    cap(b, l + 1);
    return true;
  }

  // 'consume' cap? term
  private static boolean nextterm_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_10")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "consume");
    r = r && nextterm_10_1(b, l + 1);
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // cap?
  private static boolean nextterm_10_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_10_1")) return false;
    cap(b, l + 1);
    return true;
  }

  // '#' postfix
  private static boolean nextterm_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextterm_12")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "#");
    r = r && postfix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ID ('.' ID)? typeargs? (cap | gencap)? ('^' | '!')?
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

  // ('.' ID)?
  private static boolean nominal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nominal_1")) return false;
    nominal_1_0(b, l + 1);
    return true;
  }

  // '.' ID
  private static boolean nominal_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nominal_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ".");
    r = r && consumeToken(b, ID);
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

  // ('^' | '!')?
  private static boolean nominal_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nominal_4")) return false;
    nominal_4_0(b, l + 1);
    return true;
  }

  // '^' | '!'
  private static boolean nominal_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nominal_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "^");
    if (!r) r = consumeToken(b, "!");
    exit_section_(b, m, null, r);
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
  // ID ':' type ('=' infix)?
  public static boolean param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && consumeToken(b, ":");
    r = r && type(b, l + 1);
    r = r && param_3(b, l + 1);
    exit_section_(b, m, PARAM, r);
    return r;
  }

  // ('=' infix)?
  private static boolean param_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_3")) return false;
    param_3_0(b, l + 1);
    return true;
  }

  // '=' infix
  private static boolean param_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "=");
    r = r && infix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ('not' | 'addressof' | '-' | '-~' | MINUS_NEW | MINUS_TILDE_NEW | 'digestof') parampattern
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

  // ('not' | 'addressof' | '-' | '-~' | MINUS_NEW | MINUS_TILDE_NEW | 'digestof') parampattern
  private static boolean parampattern_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parampattern_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parampattern_0_0(b, l + 1);
    r = r && parampattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'not' | 'addressof' | '-' | '-~' | MINUS_NEW | MINUS_TILDE_NEW | 'digestof'
  private static boolean parampattern_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parampattern_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "not");
    if (!r) r = consumeToken(b, "addressof");
    if (!r) r = consumeToken(b, "-");
    if (!r) r = consumeToken(b, "-~");
    if (!r) r = consumeToken(b, MINUS_NEW);
    if (!r) r = consumeToken(b, MINUS_TILDE_NEW);
    if (!r) r = consumeToken(b, "digestof");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (param | '...') (',' (param | '...'))*
  public static boolean params(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMS, "<params>");
    r = params_0(b, l + 1);
    r = r && params_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // param | '...'
  private static boolean params_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = param(b, l + 1);
    if (!r) r = consumeToken(b, "...");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' (param | '...'))*
  private static boolean params_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!params_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "params_1", c)) break;
    }
    return true;
  }

  // ',' (param | '...')
  private static boolean params_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && params_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // param | '...'
  private static boolean params_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = param(b, l + 1);
    if (!r) r = consumeToken(b, "...");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ('var' | 'let' | 'embed') ID (':' type)?
  //   | parampattern
  public static boolean pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN, "<pattern>");
    r = pattern_0(b, l + 1);
    if (!r) r = parampattern(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('var' | 'let' | 'embed') ID (':' type)?
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

  // 'var' | 'let' | 'embed'
  private static boolean pattern_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "var");
    if (!r) r = consumeToken(b, "let");
    if (!r) r = consumeToken(b, "embed");
    exit_section_(b, m, null, r);
    return r;
  }

  // (':' type)?
  private static boolean pattern_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_0_2")) return false;
    pattern_0_2_0(b, l + 1);
    return true;
  }

  // ':' type
  private static boolean pattern_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ":");
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // rawseq (',' rawseq)*
  public static boolean positional(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "positional")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, POSITIONAL, "<positional>");
    r = rawseq(b, l + 1);
    r = r && positional_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' rawseq)*
  private static boolean positional_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "positional_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!positional_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "positional_1", c)) break;
    }
    return true;
  }

  // ',' rawseq
  private static boolean positional_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "positional_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && rawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // atom (dot | tilde | chain | typeargs | call)*
  public static boolean postfix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, POSTFIX, "<postfix>");
    r = atom(b, l + 1);
    r = r && postfix_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (dot | tilde | chain | typeargs | call)*
  private static boolean postfix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfix_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!postfix_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "postfix_1", c)) break;
    }
    return true;
  }

  // dot | tilde | chain | typeargs | call
  private static boolean postfix_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfix_1_0")) return false;
    boolean r;
    r = dot(b, l + 1);
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
  // ';' (exprseq | jump)
  public static boolean semiexpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "semiexpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SEMIEXPR, "<semiexpr>");
    r = consumeToken(b, ";");
    r = r && semiexpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // 'if' ('\' ID (',' ID)* '\')? rawseq 'then' rawseq (elseif | ('else' annotatedrawseq))? 'end'
  //   | 'ifdef' ('\' ID (',' ID)* '\')? infix 'then' rawseq (elseifdef | ('else' annotatedrawseq))? 'end'
  //   | 'iftype' ('\' ID (',' ID)* '\')? iftype (elseiftype | ('else' annotatedrawseq))? 'end'
  //   | 'match' ('\' ID (',' ID)* '\')? rawseq caseexpr* ('else' annotatedrawseq)? 'end'
  //   | 'while' ('\' ID (',' ID)* '\')? rawseq 'do' rawseq ('else' annotatedrawseq)? 'end'
  //   | 'repeat' ('\' ID (',' ID)* '\')? rawseq 'until' annotatedrawseq ('else' annotatedrawseq)? 'end'
  //   | 'for' ('\' ID (',' ID)* '\')? idseq 'in' rawseq 'do' rawseq ('else' annotatedrawseq)? 'end'
  //   | 'with' ('\' ID (',' ID)* '\')? (withelem (',' withelem)*) 'do' rawseq ('else' annotatedrawseq)? 'end'
  //   | 'try' ('\' ID (',' ID)* '\')? rawseq ('else' annotatedrawseq)? ('then' annotatedrawseq)? 'end'
  //   | 'recover' ('\' ID (',' ID)* '\')? cap? rawseq 'end'
  //   | 'consume' cap? term
  //   | pattern
  //   | '#' postfix
  public static boolean term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TERM, "<term>");
    r = term_0(b, l + 1);
    if (!r) r = term_1(b, l + 1);
    if (!r) r = term_2(b, l + 1);
    if (!r) r = term_3(b, l + 1);
    if (!r) r = term_4(b, l + 1);
    if (!r) r = term_5(b, l + 1);
    if (!r) r = term_6(b, l + 1);
    if (!r) r = term_7(b, l + 1);
    if (!r) r = term_8(b, l + 1);
    if (!r) r = term_9(b, l + 1);
    if (!r) r = term_10(b, l + 1);
    if (!r) r = pattern(b, l + 1);
    if (!r) r = term_12(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'if' ('\' ID (',' ID)* '\')? rawseq 'then' rawseq (elseif | ('else' annotatedrawseq))? 'end'
  private static boolean term_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "if");
    r = r && term_0_1(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, "then");
    r = r && rawseq(b, l + 1);
    r = r && term_0_5(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean term_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_0_1")) return false;
    term_0_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean term_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && term_0_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean term_0_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_0_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!term_0_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "term_0_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean term_0_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_0_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // (elseif | ('else' annotatedrawseq))?
  private static boolean term_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_0_5")) return false;
    term_0_5_0(b, l + 1);
    return true;
  }

  // elseif | ('else' annotatedrawseq)
  private static boolean term_0_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_0_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elseif(b, l + 1);
    if (!r) r = term_0_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'else' annotatedrawseq
  private static boolean term_0_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_0_5_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'ifdef' ('\' ID (',' ID)* '\')? infix 'then' rawseq (elseifdef | ('else' annotatedrawseq))? 'end'
  private static boolean term_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "ifdef");
    r = r && term_1_1(b, l + 1);
    r = r && infix(b, l + 1);
    r = r && consumeToken(b, "then");
    r = r && rawseq(b, l + 1);
    r = r && term_1_5(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean term_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_1_1")) return false;
    term_1_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean term_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && term_1_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean term_1_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_1_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!term_1_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "term_1_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean term_1_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_1_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // (elseifdef | ('else' annotatedrawseq))?
  private static boolean term_1_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_1_5")) return false;
    term_1_5_0(b, l + 1);
    return true;
  }

  // elseifdef | ('else' annotatedrawseq)
  private static boolean term_1_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_1_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elseifdef(b, l + 1);
    if (!r) r = term_1_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'else' annotatedrawseq
  private static boolean term_1_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_1_5_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'iftype' ('\' ID (',' ID)* '\')? iftype (elseiftype | ('else' annotatedrawseq))? 'end'
  private static boolean term_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "iftype");
    r = r && term_2_1(b, l + 1);
    r = r && iftype(b, l + 1);
    r = r && term_2_3(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean term_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_2_1")) return false;
    term_2_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean term_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_2_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && term_2_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean term_2_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_2_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!term_2_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "term_2_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean term_2_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_2_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // (elseiftype | ('else' annotatedrawseq))?
  private static boolean term_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_2_3")) return false;
    term_2_3_0(b, l + 1);
    return true;
  }

  // elseiftype | ('else' annotatedrawseq)
  private static boolean term_2_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_2_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elseiftype(b, l + 1);
    if (!r) r = term_2_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'else' annotatedrawseq
  private static boolean term_2_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_2_3_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'match' ('\' ID (',' ID)* '\')? rawseq caseexpr* ('else' annotatedrawseq)? 'end'
  private static boolean term_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "match");
    r = r && term_3_1(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && term_3_3(b, l + 1);
    r = r && term_3_4(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean term_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_3_1")) return false;
    term_3_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean term_3_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_3_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && term_3_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean term_3_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_3_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!term_3_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "term_3_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean term_3_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_3_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // caseexpr*
  private static boolean term_3_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_3_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!caseexpr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "term_3_3", c)) break;
    }
    return true;
  }

  // ('else' annotatedrawseq)?
  private static boolean term_3_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_3_4")) return false;
    term_3_4_0(b, l + 1);
    return true;
  }

  // 'else' annotatedrawseq
  private static boolean term_3_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_3_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'while' ('\' ID (',' ID)* '\')? rawseq 'do' rawseq ('else' annotatedrawseq)? 'end'
  private static boolean term_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "while");
    r = r && term_4_1(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, "do");
    r = r && rawseq(b, l + 1);
    r = r && term_4_5(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean term_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_4_1")) return false;
    term_4_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean term_4_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_4_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && term_4_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean term_4_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_4_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!term_4_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "term_4_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean term_4_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_4_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('else' annotatedrawseq)?
  private static boolean term_4_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_4_5")) return false;
    term_4_5_0(b, l + 1);
    return true;
  }

  // 'else' annotatedrawseq
  private static boolean term_4_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_4_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'repeat' ('\' ID (',' ID)* '\')? rawseq 'until' annotatedrawseq ('else' annotatedrawseq)? 'end'
  private static boolean term_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "repeat");
    r = r && term_5_1(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, "until");
    r = r && annotatedrawseq(b, l + 1);
    r = r && term_5_5(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean term_5_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_5_1")) return false;
    term_5_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean term_5_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_5_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && term_5_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean term_5_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_5_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!term_5_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "term_5_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean term_5_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_5_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('else' annotatedrawseq)?
  private static boolean term_5_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_5_5")) return false;
    term_5_5_0(b, l + 1);
    return true;
  }

  // 'else' annotatedrawseq
  private static boolean term_5_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_5_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'for' ('\' ID (',' ID)* '\')? idseq 'in' rawseq 'do' rawseq ('else' annotatedrawseq)? 'end'
  private static boolean term_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "for");
    r = r && term_6_1(b, l + 1);
    r = r && idseq(b, l + 1);
    r = r && consumeToken(b, "in");
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, "do");
    r = r && rawseq(b, l + 1);
    r = r && term_6_7(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean term_6_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_6_1")) return false;
    term_6_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean term_6_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_6_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && term_6_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean term_6_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_6_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!term_6_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "term_6_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean term_6_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_6_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('else' annotatedrawseq)?
  private static boolean term_6_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_6_7")) return false;
    term_6_7_0(b, l + 1);
    return true;
  }

  // 'else' annotatedrawseq
  private static boolean term_6_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_6_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'with' ('\' ID (',' ID)* '\')? (withelem (',' withelem)*) 'do' rawseq ('else' annotatedrawseq)? 'end'
  private static boolean term_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "with");
    r = r && term_7_1(b, l + 1);
    r = r && term_7_2(b, l + 1);
    r = r && consumeToken(b, "do");
    r = r && rawseq(b, l + 1);
    r = r && term_7_5(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean term_7_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_7_1")) return false;
    term_7_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean term_7_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_7_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && term_7_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean term_7_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_7_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!term_7_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "term_7_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean term_7_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_7_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // withelem (',' withelem)*
  private static boolean term_7_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_7_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = withelem(b, l + 1);
    r = r && term_7_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' withelem)*
  private static boolean term_7_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_7_2_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!term_7_2_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "term_7_2_1", c)) break;
    }
    return true;
  }

  // ',' withelem
  private static boolean term_7_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_7_2_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && withelem(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('else' annotatedrawseq)?
  private static boolean term_7_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_7_5")) return false;
    term_7_5_0(b, l + 1);
    return true;
  }

  // 'else' annotatedrawseq
  private static boolean term_7_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_7_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'try' ('\' ID (',' ID)* '\')? rawseq ('else' annotatedrawseq)? ('then' annotatedrawseq)? 'end'
  private static boolean term_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "try");
    r = r && term_8_1(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && term_8_3(b, l + 1);
    r = r && term_8_4(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean term_8_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_8_1")) return false;
    term_8_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean term_8_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_8_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && term_8_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean term_8_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_8_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!term_8_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "term_8_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean term_8_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_8_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('else' annotatedrawseq)?
  private static boolean term_8_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_8_3")) return false;
    term_8_3_0(b, l + 1);
    return true;
  }

  // 'else' annotatedrawseq
  private static boolean term_8_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_8_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('then' annotatedrawseq)?
  private static boolean term_8_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_8_4")) return false;
    term_8_4_0(b, l + 1);
    return true;
  }

  // 'then' annotatedrawseq
  private static boolean term_8_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_8_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "then");
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'recover' ('\' ID (',' ID)* '\')? cap? rawseq 'end'
  private static boolean term_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "recover");
    r = r && term_9_1(b, l + 1);
    r = r && term_9_2(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('\' ID (',' ID)* '\')?
  private static boolean term_9_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_9_1")) return false;
    term_9_1_0(b, l + 1);
    return true;
  }

  // '\' ID (',' ID)* '\'
  private static boolean term_9_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_9_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && term_9_1_0_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ID)*
  private static boolean term_9_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_9_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!term_9_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "term_9_1_0_2", c)) break;
    }
    return true;
  }

  // ',' ID
  private static boolean term_9_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_9_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // cap?
  private static boolean term_9_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_9_2")) return false;
    cap(b, l + 1);
    return true;
  }

  // 'consume' cap? term
  private static boolean term_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_10")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "consume");
    r = r && term_10_1(b, l + 1);
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // cap?
  private static boolean term_10_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_10_1")) return false;
    cap(b, l + 1);
    return true;
  }

  // '#' postfix
  private static boolean term_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_12")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "#");
    r = r && postfix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '~' ID
  public static boolean tilde(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tilde")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TILDE, "<tilde>");
    r = consumeToken(b, "~");
    r = r && consumeToken(b, ID);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ',' rawseq (',' rawseq)*
  public static boolean tuple(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TUPLE, "<tuple>");
    r = consumeToken(b, ",");
    r = r && rawseq(b, l + 1);
    r = r && tuple_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' rawseq)*
  private static boolean tuple_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tuple_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tuple_2", c)) break;
    }
    return true;
  }

  // ',' rawseq
  private static boolean tuple_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && rawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ',' infixtype (',' infixtype)*
  public static boolean tupletype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupletype")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TUPLETYPE, "<tupletype>");
    r = consumeToken(b, ",");
    r = r && infixtype(b, l + 1);
    r = r && tupletype_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' infixtype)*
  private static boolean tupletype_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupletype_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tupletype_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tupletype_2", c)) break;
    }
    return true;
  }

  // ',' infixtype
  private static boolean tupletype_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupletype_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && infixtype(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // atomtype ('->' type)?
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = atomtype(b, l + 1);
    r = r && type_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('->' type)?
  private static boolean type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_1")) return false;
    type_1_0(b, l + 1);
    return true;
  }

  // '->' type
  private static boolean type_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "->");
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // type
  //   | literal
  //   | '#' postfix
  public static boolean typearg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typearg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPEARG, "<typearg>");
    r = type(b, l + 1);
    if (!r) r = literal(b, l + 1);
    if (!r) r = typearg_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '#' postfix
  private static boolean typearg_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typearg_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "#");
    r = r && postfix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '[' typearg (',' typearg)* ']'
  public static boolean typeargs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeargs")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPEARGS, "<typeargs>");
    r = consumeToken(b, "[");
    r = r && typearg(b, l + 1);
    r = r && typeargs_2(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' typearg)*
  private static boolean typeargs_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeargs_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!typeargs_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "typeargs_2", c)) break;
    }
    return true;
  }

  // ',' typearg
  private static boolean typeargs_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeargs_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && typearg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ID (':' type)? ('=' typearg)?
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

  // (':' type)?
  private static boolean typeparam_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparam_1")) return false;
    typeparam_1_0(b, l + 1);
    return true;
  }

  // ':' type
  private static boolean typeparam_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparam_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ":");
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('=' typearg)?
  private static boolean typeparam_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparam_2")) return false;
    typeparam_2_0(b, l + 1);
    return true;
  }

  // '=' typearg
  private static boolean typeparam_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparam_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "=");
    r = r && typearg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ('[' | LSQUARE_NEW) typeparam (',' typeparam)* ']'
  public static boolean typeparams(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparams")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPEPARAMS, "<typeparams>");
    r = typeparams_0(b, l + 1);
    r = r && typeparam(b, l + 1);
    r = r && typeparams_2(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '[' | LSQUARE_NEW
  private static boolean typeparams_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparams_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "[");
    if (!r) r = consumeToken(b, LSQUARE_NEW);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' typeparam)*
  private static boolean typeparams_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparams_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!typeparams_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "typeparams_2", c)) break;
    }
    return true;
  }

  // ',' typeparam
  private static boolean typeparams_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparams_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && typeparam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '|' type
  public static boolean uniontype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uniontype")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNIONTYPE, "<uniontype>");
    r = consumeToken(b, "|");
    r = r && type(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'use' (ID '=')? (STRING | use_ffi) ('if' infix)?
  public static boolean use(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, USE, "<use>");
    r = consumeToken(b, "use");
    r = r && use_1(b, l + 1);
    r = r && use_2(b, l + 1);
    r = r && use_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (ID '=')?
  private static boolean use_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_1")) return false;
    use_1_0(b, l + 1);
    return true;
  }

  // ID '='
  private static boolean use_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && consumeToken(b, "=");
    exit_section_(b, m, null, r);
    return r;
  }

  // STRING | use_ffi
  private static boolean use_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_2")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = use_ffi(b, l + 1);
    return r;
  }

  // ('if' infix)?
  private static boolean use_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_3")) return false;
    use_3_0(b, l + 1);
    return true;
  }

  // 'if' infix
  private static boolean use_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "if");
    r = r && infix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ffi_decl typeargs ('(' | LPAREN_NEW) params? ')' '?'?
  public static boolean use_ffi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_ffi")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, USE_FFI, "<use ffi>");
    r = ffi_decl(b, l + 1);
    r = r && typeargs(b, l + 1);
    r = r && use_ffi_2(b, l + 1);
    r = r && use_ffi_3(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && use_ffi_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '(' | LPAREN_NEW
  private static boolean use_ffi_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_ffi_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    if (!r) r = consumeToken(b, LPAREN_NEW);
    exit_section_(b, m, null, r);
    return r;
  }

  // params?
  private static boolean use_ffi_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_ffi_3")) return false;
    params(b, l + 1);
    return true;
  }

  // '?'?
  private static boolean use_ffi_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_ffi_5")) return false;
    consumeToken(b, "?");
    return true;
  }

  /* ********************************************************** */
  // idseq '=' rawseq
  public static boolean withelem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withelem")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, WITHELEM, "<withelem>");
    r = idseq(b, l + 1);
    r = r && consumeToken(b, "=");
    r = r && rawseq(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
