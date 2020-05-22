/* Copyright Niclas Hedhman, 2020. All rights reserved. Licensed under the Apache License, Version 2.0 (the "License"). See LICENSE.txt*/
package org.hedhman.pony.idea.generated.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.hedhman.pony.idea.generated.parsing.PonyTypes.*;
import org.hedhman.pony.idea.references.PonyNamedElementImpl;
import org.hedhman.pony.idea.generated.psi.*;
import org.hedhman.pony.idea.references.PonyPsiImplUtil;

public class PonyMethodDeclImpl extends PonyNamedElementImpl implements PonyMethodDecl {

  public PonyMethodDeclImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitMethodDecl(this);
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
  public PonyCap getCap() {
    return findChildByClass(PonyCap.class);
  }

  @Override
  @Nullable
  public PonyDocString getDocString() {
    return findChildByClass(PonyDocString.class);
  }

  @Override
  @Nullable
  public PonyMethodBodyDecl getMethodBodyDecl() {
    return findChildByClass(PonyMethodBodyDecl.class);
  }

  @Override
  @NotNull
  public PonyMethodName getMethodName() {
    return findNotNullChildByClass(PonyMethodName.class);
  }

  @Override
  @NotNull
  public PonyMethodType getMethodType() {
    return findNotNullChildByClass(PonyMethodType.class);
  }

  @Override
  @Nullable
  public PonyParams getParams() {
    return findChildByClass(PonyParams.class);
  }

  @Override
  @Nullable
  public PonyType_ getType_() {
    return findChildByClass(PonyType_.class);
  }

  @Override
  @Nullable
  public PonyTypeparams getTypeparams() {
    return findChildByClass(PonyTypeparams.class);
  }

  @Override
  @Nullable
  public PsiElement getLparenNew() {
    return findChildByType(LPAREN_NEW);
  }

  @Override
  @Nullable
  public PsiElement getTypeOp() {
    return findChildByType(TYPE_OP);
  }

  @Override
  public String getMethod() {
    return PonyPsiImplUtil.getMethod(this);
  }

  @Override
  public String getMethodDecl() {
    return PonyPsiImplUtil.getMethodDecl(this);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return PonyPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return PonyPsiImplUtil.setName(this, newName);
  }

}
