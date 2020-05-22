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

public class PonyLambdaDeclImpl extends ASTWrapperPsiElement implements PonyLambdaDecl {

  public PonyLambdaDeclImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitLambdaDecl(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PonyAnnotations getAnnotations() {
    return findNotNullChildByClass(PonyAnnotations.class);
  }

  @Override
  @NotNull
  public List<PonyCap> getCapList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyCap.class);
  }

  @Override
  @Nullable
  public PonyLambdacaptures getLambdacaptures() {
    return findChildByClass(PonyLambdacaptures.class);
  }

  @Override
  @Nullable
  public PonyLambdaparams getLambdaparams() {
    return findChildByClass(PonyLambdaparams.class);
  }

  @Override
  @NotNull
  public PonyRawseq getRawseq() {
    return findNotNullChildByClass(PonyRawseq.class);
  }

  @Override
  @Nullable
  public PonyType_ getType_() {
    return findChildByClass(PonyType_.class);
  }

  @Override
  @Nullable
  public PonyTypeparams getTypeparams() {
    return findChildByClass(PonyTypeparams.class);
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
  public PsiElement getTypeOp() {
    return findChildByType(TYPE_OP);
  }

}
