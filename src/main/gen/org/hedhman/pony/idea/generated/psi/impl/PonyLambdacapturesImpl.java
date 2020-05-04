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

public class PonyLambdacapturesImpl extends ASTWrapperPsiElement implements PonyLambdacaptures {

  public PonyLambdacapturesImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitLambdacaptures(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PonyLambdacapture> getLambdacaptureList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyLambdacapture.class);
  }

  @Override
  @Nullable
  public PsiElement getLparenNew() {
    return findChildByType(LPAREN_NEW);
  }

}
