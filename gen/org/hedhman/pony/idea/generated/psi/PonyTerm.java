/* Copyright Niclas Hedhman, 2020. All rights reserved. Licensed under the Apache License, Version 2.0 (the "License"). See LICENSE.txt*/
package org.hedhman.pony.idea.generated.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyTerm extends PsiElement {

  @Nullable
  PonyConsumeTerm getConsumeTerm();

  @Nullable
  PonyForTerm getForTerm();

  @Nullable
  PonyHashTerm getHashTerm();

  @Nullable
  PonyIfTerm getIfTerm();

  @Nullable
  PonyIfdefTerm getIfdefTerm();

  @Nullable
  PonyIftypeTerm getIftypeTerm();

  @Nullable
  PonyMatchTerm getMatchTerm();

  @Nullable
  PonyPattern getPattern();

  @Nullable
  PonyRecoverTerm getRecoverTerm();

  @Nullable
  PonyRepeatTerm getRepeatTerm();

  @Nullable
  PonyTryTerm getTryTerm();

  @Nullable
  PonyWhileTerm getWhileTerm();

  @Nullable
  PonyWithTerm getWithTerm();

}
