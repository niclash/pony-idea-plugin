package org.hedhman.pony.idea.usages;

import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.TokenSet;
import org.hedhman.pony.idea.generated.parsing.PonyTypes;
import org.hedhman.pony.idea.generated.psi.PonyClassName;
import org.hedhman.pony.idea.generated.psi.PonyFieldName;
import org.hedhman.pony.idea.generated.psi.PonyMethodDecl;
import org.hedhman.pony.idea.generated.psi.PonyMethodName;
import org.hedhman.pony.idea.parsing.PonyLexer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PonyFindUsagesProvider implements FindUsagesProvider
{
  @Nullable
  @Override
  public WordsScanner getWordsScanner() {
    return new DefaultWordsScanner( new PonyLexer(),
                                    TokenSet.create( PonyTypes.METHOD_NAME, PonyTypes.FIELD_NAME, PonyTypes.CLASS_NAME ),
                                    TokenSet.create(PonyTypes.LINE_COMMENT, PonyTypes.BLOCK_COMMENT),
                                    TokenSet.EMPTY);
  }

  @Override
  public boolean canFindUsagesFor(@NotNull PsiElement psiElement ) {
    return psiElement instanceof PsiNamedElement;
  }

  @Nullable
  @Override
  public String getHelpId(@NotNull PsiElement psiElement) {
    return null;
  }

  @NotNull
  @Override
  public String getType(@NotNull PsiElement element) {
    if (element instanceof PonyMethodName ) {
      return "method";
    } else if (element instanceof PonyFieldName ) {
      return "field";
    } else if (element instanceof PonyClassName ) {
      return "class";
    } else {
      return "";
    }
  }

  @NotNull
  @Override
  public String getDescriptiveName(@NotNull PsiElement element) {
    if (element instanceof PonyMethodName ) {
      return ((PonyMethodName)element).getId().getText();
    } else if (element instanceof PonyFieldName ) {
      return ((PonyFieldName)element).getId().getText();
    } else if (element instanceof PonyClassName ) {
      return ((PonyClassName)element).getId().getText();
    } else {
      return "";
    }
  }

  @NotNull
  @Override
  public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
    if (element instanceof PonyMethodName ) {
      return element.getTextRangeInParent().toString();
    } else if (element instanceof PonyFieldName ) {
      return element.getTextRangeInParent().toString();
    } else if (element instanceof PonyClassName ) {
      return element.getTextRangeInParent().toString();
    } else {
      return "";
    }
  }
}
