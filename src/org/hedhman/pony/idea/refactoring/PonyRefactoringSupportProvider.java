package org.hedhman.pony.idea.refactoring;

import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import org.hedhman.pony.idea.generated.psi.PonyClassDef;
import org.hedhman.pony.idea.generated.psi.PonyFieldDecl;
import org.hedhman.pony.idea.generated.psi.PonyMethodDecl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PonyRefactoringSupportProvider extends RefactoringSupportProvider {
  @Override
  public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement elementToRename, @Nullable PsiElement context) {
    boolean result = elementToRename instanceof PonyClassDef;
    result = result | elementToRename instanceof PonyMethodDecl;
    result = result | elementToRename instanceof PonyFieldDecl;
    return result;
  }
}
