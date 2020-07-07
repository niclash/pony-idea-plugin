package org.hedhman.pony.idea;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.ParserDefinition;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiReference;
import org.jetbrains.annotations.NotNull;

public class PonyFile extends PsiFileBase
{
    public PonyFile(@NotNull FileViewProvider viewProvider)
    {
        super(viewProvider, PonyLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType()
    {
        return PonyFileType.PonySource;
    }

}
