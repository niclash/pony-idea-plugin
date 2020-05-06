/* Copyright Niclas Hedhman, 2020. All rights reserved. Licensed under the Apache License, Version 2.0 (the "License"). See LICENSE.txt*/
package org.hedhman.pony.idea.generated.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyAtomtype extends PsiElement {

  @Nullable
  PonyBarelambdatype getBarelambdatype();

  @Nullable
  PonyCap getCap();

  @Nullable
  PonyInfixtype getInfixtype();

  @Nullable
  PonyLambdatype getLambdatype();

  @Nullable
  PonyNominal getNominal();

  @Nullable
  PonyTupletype getTupletype();

  @Nullable
  PsiElement getLparenNew();

}
