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

public class PonyExprseqImpl extends ASTWrapperPsiElement implements PonyExprseq {

  public PonyExprseqImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitExprseq(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PonyAssignment getAssignment() {
    return findNotNullChildByClass(PonyAssignment.class);
  }

  @Override
  @Nullable
  public PonyNosemi getNosemi() {
    return findChildByClass(PonyNosemi.class);
  }

  @Override
  @Nullable
  public PonySemiexpr getSemiexpr() {
    return findChildByClass(PonySemiexpr.class);
  }

}