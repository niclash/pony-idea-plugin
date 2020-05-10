package org.hedhman.pony.idea;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.Nullable;

public class PonyLanguage extends Language
{
    public static final PonyLanguage INSTANCE = new PonyLanguage();

    private static final String ID = "Pony";

    private PonyLanguage()
    {
        super( ID );
    }

    @Nullable
    @Override
    public LanguageFileType getAssociatedFileType()
    {
        return PonyFileType.PonySource;
    }
}
