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

public class PonyInfixImpl extends ASTWrapperPsiElement implements PonyInfix {

  public PonyInfixImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitInfix(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PonyBinop> getBinopList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyBinop.class);
  }

  @Override
  @NotNull
  public List<PonyIsop> getIsopList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyIsop.class);
  }

  @Override
  @NotNull
  public PonyTerm getTerm() {
    return findNotNullChildByClass(PonyTerm.class);
  }

  @Override
  @NotNull
  public List<PonyType> getTypeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyType.class);
  }

}
