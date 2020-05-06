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

public class PonyTermImpl extends ASTWrapperPsiElement implements PonyTerm {

  public PonyTermImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitTerm(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PonyAnnotatedrawseq getAnnotatedrawseq() {
    return findChildByClass(PonyAnnotatedrawseq.class);
  }

  @Override
  @Nullable
  public PonyCap getCap() {
    return findChildByClass(PonyCap.class);
  }

  @Override
  @NotNull
  public List<PonyCaseexpr> getCaseexprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyCaseexpr.class);
  }

  @Override
  @Nullable
  public PonyElseif_ getElseif_() {
    return findChildByClass(PonyElseif_.class);
  }

  @Override
  @Nullable
  public PonyElseifdef getElseifdef() {
    return findChildByClass(PonyElseifdef.class);
  }

  @Override
  @Nullable
  public PonyElseiftype getElseiftype() {
    return findChildByClass(PonyElseiftype.class);
  }

  @Override
  @Nullable
  public PonyIdseq getIdseq() {
    return findChildByClass(PonyIdseq.class);
  }

  @Override
  @Nullable
  public PonyIftype_ getIftype_() {
    return findChildByClass(PonyIftype_.class);
  }

  @Override
  @Nullable
  public PonyInfix getInfix() {
    return findChildByClass(PonyInfix.class);
  }

  @Override
  @Nullable
  public PonyPattern getPattern() {
    return findChildByClass(PonyPattern.class);
  }

  @Override
  @Nullable
  public PonyPostfix getPostfix() {
    return findChildByClass(PonyPostfix.class);
  }

  @Override
  @NotNull
  public List<PonyRawseq> getRawseqList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyRawseq.class);
  }

  @Override
  @Nullable
  public PonyTerm getTerm() {
    return findChildByClass(PonyTerm.class);
  }

  @Override
  @NotNull
  public List<PonyWithelem> getWithelemList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyWithelem.class);
  }

}
