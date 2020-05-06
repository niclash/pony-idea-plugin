/* Copyright Niclas Hedhman, 2020. All rights reserved. Licensed under the Apache License, Version 2.0 (the "License"). See LICENSE.txt*/
package org.hedhman.pony.idea.generated.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyMethod extends PsiElement {

  @Nullable
  PonyCap getCap();

  @Nullable
  PonyDocString getDocString();

  @Nullable
  PonyParams getParams();

  @Nullable
  PonyRawseq getRawseq();

  @Nullable
  PonyType_ getType_();

  @Nullable
  PonyTypeparams getTypeparams();

  @Nullable
  PsiElement getLparenNew();

}
