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

public class PonyAtomtypeImpl extends ASTWrapperPsiElement implements PonyAtomtype {

  public PonyAtomtypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitAtomtype(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PonyBarelambdatype getBarelambdatype() {
    return findChildByClass(PonyBarelambdatype.class);
  }

  @Override
  @Nullable
  public PonyCap getCap() {
    return findChildByClass(PonyCap.class);
  }

  @Override
  @Nullable
  public PonyInfixtype getInfixtype() {
    return findChildByClass(PonyInfixtype.class);
  }

  @Override
  @Nullable
  public PonyLambdatype getLambdatype() {
    return findChildByClass(PonyLambdatype.class);
  }

  @Override
  @Nullable
  public PonyNominal getNominal() {
    return findChildByClass(PonyNominal.class);
  }

  @Override
  @Nullable
  public PonyTupletype getTupletype() {
    return findChildByClass(PonyTupletype.class);
  }

  @Override
  @Nullable
  public PsiElement getLparenNew() {
    return findChildByType(LPAREN_NEW);
  }

}
