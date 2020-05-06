/* Copyright Niclas Hedhman, 2020. All rights reserved. Licensed under the Apache License, Version 2.0 (the "License"). See LICENSE.txt*/
package org.hedhman.pony.idea.generated.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyField extends PsiElement {

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

}
