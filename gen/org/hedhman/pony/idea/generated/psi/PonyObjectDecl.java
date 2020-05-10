/* Copyright Niclas Hedhman, 2020. All rights reserved. Licensed under the Apache License, Version 2.0 (the "License"). See LICENSE.txt*/
package org.hedhman.pony.idea.generated.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyObjectDecl extends PsiElement {

  @NotNull
  PonyAnnotations getAnnotations();

  @Nullable
  PonyCap getCap();

  @NotNull
  PonyMembers getMembers();

  @NotNull
  PonyTypeDecl getTypeDecl();

}
