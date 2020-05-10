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
import org.hedhman.pony.idea.util.PonyPsiImplUtil;

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
  public PonyConsumeTerm getConsumeTerm() {
    return findChildByClass(PonyConsumeTerm.class);
  }

  @Override
  @Nullable
  public PonyForTerm getForTerm() {
    return findChildByClass(PonyForTerm.class);
  }

  @Override
  @Nullable
  public PonyHashTerm getHashTerm() {
    return findChildByClass(PonyHashTerm.class);
  }

  @Override
  @Nullable
  public PonyIfTerm getIfTerm() {
    return findChildByClass(PonyIfTerm.class);
  }

  @Override
  @Nullable
  public PonyIfdefTerm getIfdefTerm() {
    return findChildByClass(PonyIfdefTerm.class);
  }

  @Override
  @Nullable
  public PonyIftypeTerm getIftypeTerm() {
    return findChildByClass(PonyIftypeTerm.class);
  }

  @Override
  @Nullable
  public PonyMatchTerm getMatchTerm() {
    return findChildByClass(PonyMatchTerm.class);
  }

  @Override
  @Nullable
  public PonyPattern getPattern() {
    return findChildByClass(PonyPattern.class);
  }

  @Override
  @Nullable
  public PonyRecoverTerm getRecoverTerm() {
    return findChildByClass(PonyRecoverTerm.class);
  }

  @Override
  @Nullable
  public PonyRepeatTerm getRepeatTerm() {
    return findChildByClass(PonyRepeatTerm.class);
  }

  @Override
  @Nullable
  public PonyTryTerm getTryTerm() {
    return findChildByClass(PonyTryTerm.class);
  }

  @Override
  @Nullable
  public PonyWhileTerm getWhileTerm() {
    return findChildByClass(PonyWhileTerm.class);
  }

  @Override
  @Nullable
  public PonyWithTerm getWithTerm() {
    return findChildByClass(PonyWithTerm.class);
  }

}
