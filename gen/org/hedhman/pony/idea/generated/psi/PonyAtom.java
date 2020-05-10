/* Copyright Niclas Hedhman, 2020. All rights reserved. Licensed under the Apache License, Version 2.0 (the "License"). See LICENSE.txt*/
package org.hedhman.pony.idea.generated.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyAtom extends PsiElement {

  @Nullable
  PonyFfiDecl getFfiDecl();

  @Nullable
  PonyLambdaDecl getLambdaDecl();

  @Nullable
  PonyLiteral getLiteral();

  @Nullable
  PonyNamed getNamed();

  @Nullable
  PonyObjectDecl getObjectDecl();

  @Nullable
  PonyPositional getPositional();

  @Nullable
  PonyRawseq getRawseq();

  @Nullable
  PonyTupleDecl getTupleDecl();

  @Nullable
  PonyType_ getType_();

  @Nullable
  PonyTypeargs getTypeargs();

  @Nullable
  PsiElement getId();

  @Nullable
  PsiElement getLparenNew();

  @Nullable
  PsiElement getLsquare();

  @Nullable
  PsiElement getLsquareNew();

  @Nullable
  PsiElement getRsquare();

  @Nullable
  PsiElement getTypeOp();

}
