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

public class PonyNextinfixImpl extends ASTWrapperPsiElement implements PonyNextinfix {

  public PonyNextinfixImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitNextinfix(this);
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
  public PonyNextterm getNextterm() {
    return findNotNullChildByClass(PonyNextterm.class);
  }

  @Override
  @NotNull
  public List<PonyType_> getType_List() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyType_.class);
  }

}
