/* Copyright Niclas Hedhman, 2020. All rights reserved. Licensed under the Apache License, Version 2.0 (the "License"). See LICENSE.txt*/
package org.hedhman.pony.idea.generated.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyNextterm extends PsiElement {

  @Nullable
  PonyAnnotatedrawseq getAnnotatedrawseq();

  @Nullable
  PonyCap getCap();

  @NotNull
  List<PonyCaseexpr> getCaseexprList();

  @Nullable
  PonyElseif getElseif();

  @Nullable
  PonyElseifdef getElseifdef();

  @Nullable
  PonyElseiftype getElseiftype();

  @Nullable
  PonyIdseq getIdseq();

  @Nullable
  PonyIftype getIftype();

  @Nullable
  PonyInfix getInfix();

  @Nullable
  PonyNextpattern getNextpattern();

  @Nullable
  PonyPostfix getPostfix();

  @NotNull
  List<PonyRawseq> getRawseqList();

  @Nullable
  PonyTerm getTerm();

  @NotNull
  List<PonyWithelem> getWithelemList();

}