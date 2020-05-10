package org.hedhman.pony.idea;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
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
