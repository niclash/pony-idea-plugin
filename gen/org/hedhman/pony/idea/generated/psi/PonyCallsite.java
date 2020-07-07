/* Copyright Niclas Hedhman, 2020. All rights reserved. Licensed under the Apache License, Version 2.0 (the "License"). See LICENSE.txt*/
package org.hedhman.pony.idea.generated.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyCallsite extends PsiElement {

  @NotNull
  PsiElement getCallOp();

  @NotNull
  PsiElement getId();

  //WARNING: getReferences(...) is skipped
  //matching getReferences(PonyCallsite, ...)
  //methods are not found in PonyPsiImplUtil

}
