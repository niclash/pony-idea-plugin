package org.hedhman.pony.idea.psi;

import com.intellij.psi.tree.IElementType;
import org.hedhman.pony.idea.PonyLanguage;
import org.jetbrains.annotations.NotNull;

public class PonyTokenType extends IElementType
{
    public PonyTokenType( @NotNull String debugName )
    {
        super( debugName, PonyLanguage.INSTANCE );
    }
}
