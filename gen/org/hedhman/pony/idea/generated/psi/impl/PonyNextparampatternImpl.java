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

public class PonyNextparampatternImpl extends ASTWrapperPsiElement implements PonyNextparampattern {

  public PonyNextparampatternImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitNextparampattern(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PonyNextpostfix getNextpostfix() {
    return findChildByClass(PonyNextpostfix.class);
  }

  @Override
  @Nullable
  public PonyParampattern getParampattern() {
    return findChildByClass(PonyParampattern.class);
  }

  @Override
  @Nullable
  public PsiElement getMinusNew() {
    return findChildByType(MINUS_NEW);
  }

  @Override
  @Nullable
  public PsiElement getMinusTildeNew() {
    return findChildByType(MINUS_TILDE_NEW);
  }

}
