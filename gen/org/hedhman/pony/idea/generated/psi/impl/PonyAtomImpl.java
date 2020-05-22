/* Copyright Niclas Hedhman, 2020. All rights reserved. Licensed under the Apache License, Version 2.0 (the "License"). See LICENSE.txt*/
package org.hedhman.pony.idea.generated.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.hedhman.pony.idea.generated.parsing.PonyTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.hedhman.pony.idea.generated.psi.*;
import org.hedhman.pony.idea.references.PonyPsiImplUtil;

public class PonyAtomImpl extends ASTWrapperPsiElement implements PonyAtom {

  public PonyAtomImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitAtom(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PonyFfiDecl getFfiDecl() {
    return findChildByClass(PonyFfiDecl.class);
  }

  @Override
  @Nullable
  public PonyLambdaDecl getLambdaDecl() {
    return findChildByClass(PonyLambdaDecl.class);
  }

  @Override
  @Nullable
  public PonyLiteral getLiteral() {
    return findChildByClass(PonyLiteral.class);
  }

  @Override
  @Nullable
  public PonyNamed getNamed() {
    return findChildByClass(PonyNamed.class);
  }

  @Override
  @Nullable
  public PonyObjectDecl getObjectDecl() {
    return findChildByClass(PonyObjectDecl.class);
  }

  @Override
  @Nullable
  public PonyPositional getPositional() {
    return findChildByClass(PonyPositional.class);
  }

  @Override
  @Nullable
  public PonyRawseq getRawseq() {
    return findChildByClass(PonyRawseq.class);
  }

  @Override
  @Nullable
  public PonyTupleDecl getTupleDecl() {
    return findChildByClass(PonyTupleDecl.class);
  }

  @Override
  @Nullable
  public PonyType_ getType_() {
    return findChildByClass(PonyType_.class);
  }

  @Override
  @Nullable
  public PonyTypeargs getTypeargs() {
    return findChildByClass(PonyTypeargs.class);
  }

  @Override
  @Nullable
  public PsiElement getId() {
    return findChildByType(ID);
  }

  @Override
  @Nullable
  public PsiElement getLparenNew() {
    return findChildByType(LPAREN_NEW);
  }

  @Override
  @Nullable
  public PsiElement getLsquare() {
    return findChildByType(LSQUARE);
  }

  @Override
  @Nullable
  public PsiElement getLsquareNew() {
    return findChildByType(LSQUARE_NEW);
  }

  @Override
  @Nullable
  public PsiElement getRsquare() {
    return findChildByType(RSQUARE);
  }

  @Override
  @Nullable
  public PsiElement getTypeOp() {
    return findChildByType(TYPE_OP);
  }

}
