/* Copyright Niclas Hedhman, 2020. All rights reserved. Licensed under the Apache License, Version 2.0 (the "License"). See LICENSE.txt*/
package org.hedhman.pony.idea.generated.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyBarelambdatype extends PsiElement {

  @NotNull
  List<PonyCap> getCapList();

  @Nullable
  PonyGencap getGencap();

  @NotNull
  List<PonyType_> getType_List();

  @Nullable
  PonyTypeparams getTypeparams();

  @Nullable
  PsiElement getId();

  @Nullable
  PsiElement getLparenNew();

  @Nullable
  PsiElement getTypeOp();

}
