/* Copyright Niclas Hedhman, 2020. All rights reserved. Licensed under the Apache License, Version 2.0 (the "License"). See LICENSE.txt*/
package org.hedhman.pony.idea.generated.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import org.hedhman.pony.idea.references.PonyNamedElement;

public interface PonyClassDef extends PonyNamedElement {

  @NotNull
  PonyAnnotations getAnnotations();

  @Nullable
  PonyCap getCap();

  @NotNull
  PonyClassName getClassName();

  @NotNull
  PonyClassType getClassType();

  @Nullable
  PonyDocString getDocString();

  @NotNull
  PonyMembers getMembers();

  @NotNull
  PonyTypeDecl getTypeDecl();

  @Nullable
  PonyTypeparams getTypeparams();

  String getClassDef();

  PsiElement getNameIdentifier();

  PsiElement setName(String newName);

}
