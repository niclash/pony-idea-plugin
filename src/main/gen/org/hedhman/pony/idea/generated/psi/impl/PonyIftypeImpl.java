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

public class PonyIftypeImpl extends ASTWrapperPsiElement implements PonyIftype {

  public PonyIftypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitIftype(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PonyRawseq getRawseq() {
    return findNotNullChildByClass(PonyRawseq.class);
  }

  @Override
  @NotNull
  public List<PonyType> getTypeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyType.class);
  }

}
