package org.hedhman.pony.idea.parsing;

import com.intellij.lexer.FlexAdapter;
import java.io.Reader;
import org.hedhman.pony.idea.generated.parsing._PonyLexer;

public class PonyLexer extends FlexAdapter
{
    public PonyLexer()
    {
        super( new _PonyLexer() );
    }

    public PonyLexer( Reader reader )
    {
        super( new _PonyLexer( reader ) );
    }
}
