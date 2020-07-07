/* Copyright Niclas Hedhman, 2020. All rights reserved. Licensed under the Apache License, Version 2.0 (the "License"). See LICENSE.txt*/
package org.hedhman.pony.idea.generated.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyNextpostfix extends PsiElement {

  @NotNull
  List<PonyCall> getCallList();

  @NotNull
  List<PonyCallsite> getCallsiteList();

  @NotNull
  List<PonyChain> getChainList();

  @NotNull
  PonyNextatom getNextatom();

  @NotNull
  List<PonyTilde> getTildeList();

  @NotNull
  List<PonyTypeargs> getTypeargsList();

}
