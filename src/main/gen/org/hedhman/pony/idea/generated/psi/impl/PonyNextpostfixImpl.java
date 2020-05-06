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

public class PonyNextpostfixImpl extends ASTWrapperPsiElement implements PonyNextpostfix {

  public PonyNextpostfixImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitNextpostfix(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PonyCall> getCallList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyCall.class);
  }

  @Override
  @NotNull
  public List<PonyChain> getChainList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyChain.class);
  }

  @Override
  @NotNull
  public List<PonyDot> getDotList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyDot.class);
  }

  @Override
  @NotNull
  public PonyNextatom getNextatom() {
    return findNotNullChildByClass(PonyNextatom.class);
  }

  @Override
  @NotNull
  public List<PonyTilde> getTildeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyTilde.class);
  }

  @Override
  @NotNull
  public List<PonyTypeargs> getTypeargsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyTypeargs.class);
  }

}
