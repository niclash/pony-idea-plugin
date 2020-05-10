package org.hedhman.pony.idea.psi;

import com.intellij.psi.tree.IElementType;
import org.hedhman.pony.idea.PonyLanguage;
import org.jetbrains.annotations.NotNull;

public class PonyElementType extends IElementType
{
    public PonyElementType( @NotNull String debugName )
    {
        super( debugName, PonyLanguage.INSTANCE );
    }
}
