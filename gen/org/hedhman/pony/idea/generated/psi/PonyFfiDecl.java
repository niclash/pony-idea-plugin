/* Copyright Niclas Hedhman, 2020. All rights reserved. Licensed under the Apache License, Version 2.0 (the "License"). See LICENSE.txt*/
package org.hedhman.pony.idea.generated.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyFfiDecl extends PsiElement {

  @Nullable
  PonyNamed getNamed();

  @Nullable
  PonyPositional getPositional();

  @Nullable
  PonyTypeargs getTypeargs();

  @Nullable
  PsiElement getId();

  @Nullable
  PsiElement getLparenNew();

  @Nullable
  PsiElement getString();

}
