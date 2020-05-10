/* Copyright Niclas Hedhman, 2020. All rights reserved. Licensed under the Apache License, Version 2.0 (the "License"). See LICENSE.txt*/
package org.hedhman.pony.idea.generated.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import org.hedhman.pony.idea.completion.PonyNamedElement;

public interface PonyMethodDecl extends PonyNamedElement {

  @NotNull
  PonyAnnotations getAnnotations();

  @Nullable
  PonyCap getCap();

  @Nullable
  PonyDocString getDocString();

  @Nullable
  PonyMethodBodyDecl getMethodBodyDecl();

  @NotNull
  PonyMethodName getMethodName();

  @NotNull
  PonyMethodType getMethodType();

  @Nullable
  PonyParams getParams();

  @Nullable
  PonyType_ getType_();

  @Nullable
  PonyTypeparams getTypeparams();

  @Nullable
  PsiElement getLparenNew();

  @Nullable
  PsiElement getTypeOp();

  String getMethod();

  String getMethodDecl();

  PsiElement getNameIdentifier();

  PsiElement setName(String newName);

}
