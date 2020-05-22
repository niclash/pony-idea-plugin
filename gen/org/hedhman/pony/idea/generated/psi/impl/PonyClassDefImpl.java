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

public class PonyClassDefImpl extends PonyNamedElementImpl implements PonyClassDef {

  public PonyClassDefImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitClassDef(this);
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
  @NotNull
  public PonyClassName getClassName() {
    return findNotNullChildByClass(PonyClassName.class);
  }

  @Override
  @NotNull
  public PonyClassType getClassType() {
    return findNotNullChildByClass(PonyClassType.class);
  }

  @Override
  @Nullable
  public PonyDocString getDocString() {
    return findChildByClass(PonyDocString.class);
  }

  @Override
  @NotNull
  public PonyMembers getMembers() {
    return findNotNullChildByClass(PonyMembers.class);
  }

  @Override
  @NotNull
  public PonyTypeDecl getTypeDecl() {
    return findNotNullChildByClass(PonyTypeDecl.class);
  }

  @Override
  @Nullable
  public PonyTypeparams getTypeparams() {
    return findChildByClass(PonyTypeparams.class);
  }

  @Override
  public String getClassDef() {
    return PonyPsiImplUtil.getClassDef(this);
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
