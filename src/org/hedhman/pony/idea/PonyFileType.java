package org.hedhman.pony.idea;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import javax.swing.Icon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PonyFileType extends LanguageFileType
{
    public static final LanguageFileType PonySource = new PonyFileType();
    public static final String DEFAULT_EXTENSION = "pony";

    protected PonyFileType( @NotNull Language language )
    {
        super( language );
    }

    public PonyFileType()
    {
        super( PonyLanguage.INSTANCE );
    }

    @NotNull
    @Override
    public String getName()
    {
        return "Pony";
    }

    @NotNull
    @Override
    public String getDescription()
    {
        return "Pony source file";
    }

    @NotNull
    @Override
    public String getDefaultExtension()
    {
        return DEFAULT_EXTENSION;
    }

    @Nullable
    @Override
    public Icon getIcon()
    {
        return PonyIcon.icon;
    }
}
