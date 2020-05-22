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

public class PonyAnnotatedrawseqImpl extends ASTWrapperPsiElement implements PonyAnnotatedrawseq {

  public PonyAnnotatedrawseqImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitAnnotatedrawseq(this);
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
  @Nullable
  public PonyExprseq getExprseq() {
    return findChildByClass(PonyExprseq.class);
  }

  @Override
  @Nullable
  public PonyJump getJump() {
    return findChildByClass(PonyJump.class);
  }

}
