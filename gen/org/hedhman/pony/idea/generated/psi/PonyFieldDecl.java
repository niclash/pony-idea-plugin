/* Copyright Niclas Hedhman, 2020. All rights reserved. Licensed under the Apache License, Version 2.0 (the "License"). See LICENSE.txt*/
package org.hedhman.pony.idea.generated.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import org.hedhman.pony.idea.completion.PonyNamedElement;

public interface PonyFieldDecl extends PonyNamedElement {

  @Nullable
  PonyDocString getDocString();

  @NotNull
  PonyFieldName getFieldName();

  @NotNull
  PonyFieldType getFieldType();

  @Nullable
  PonyInfix getInfix();

  @NotNull
  PonyType_ getType_();

  @Nullable
  PsiElement getAssign();

  @NotNull
  PsiElement getTypeOp();

  String getField();

  String getFieldDecl();

  PsiElement getNameIdentifier();

  PsiElement setName(String newName);

}
