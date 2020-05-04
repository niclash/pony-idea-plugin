/* Copyright Niclas Hedhman, 2020. All rights reserved. Licensed under the Apache License, Version 2.0 (the "License"). See LICENSE.txt*/
package org.hedhman.pony.idea.generated.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyNextatom extends PsiElement {

  @Nullable
  PonyCap getCap();

  @Nullable
  PonyFfiDecl getFfiDecl();

  @Nullable
  PonyLambdacaptures getLambdacaptures();

  @Nullable
  PonyLambdaparams getLambdaparams();

  @Nullable
  PonyLiteral getLiteral();

  @Nullable
  PonyMembers getMembers();

  @Nullable
  PonyNamed getNamed();

  @Nullable
  PonyPositional getPositional();

  @Nullable
  PonyRawseq getRawseq();

  @Nullable
  PonyTuple getTuple();

  @Nullable
  PonyType getType();

  @Nullable
  PonyTypeargs getTypeargs();

  @Nullable
  PonyTypeparams getTypeparams();

  @Nullable
  PsiElement getId();

  @Nullable
  PsiElement getLparenNew();

  @Nullable
  PsiElement getLsquareNew();

}
