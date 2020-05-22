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

public class PonyFieldDeclImpl extends PonyNamedElementImpl implements PonyFieldDecl {

  public PonyFieldDeclImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitFieldDecl(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PonyDocString getDocString() {
    return findChildByClass(PonyDocString.class);
  }

  @Override
  @NotNull
  public PonyFieldName getFieldName() {
    return findNotNullChildByClass(PonyFieldName.class);
  }

  @Override
  @NotNull
  public PonyFieldType getFieldType() {
    return findNotNullChildByClass(PonyFieldType.class);
  }

  @Override
  @Nullable
  public PonyInfix getInfix() {
    return findChildByClass(PonyInfix.class);
  }

  @Override
  @NotNull
  public PonyType_ getType_() {
    return findNotNullChildByClass(PonyType_.class);
  }

  @Override
  @Nullable
  public PsiElement getAssign() {
    return findChildByType(ASSIGN);
  }

  @Override
  @NotNull
  public PsiElement getTypeOp() {
    return findNotNullChildByType(TYPE_OP);
  }

  @Override
  public String getField() {
    return PonyPsiImplUtil.getField(this);
  }

  @Override
  public String getFieldDecl() {
    return PonyPsiImplUtil.getFieldDecl(this);
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
