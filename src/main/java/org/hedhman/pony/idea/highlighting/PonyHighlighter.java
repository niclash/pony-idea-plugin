/*
   Copyright 2020 Niclas Hedhman. All rights reserved.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package org.hedhman.pony.idea.highlighting;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import java.util.HashMap;
import java.util.Map;
import org.hedhman.pony.idea.parsing.PonyLexer;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class PonyHighlighter extends SyntaxHighlighterBase
{
    private static final Map<String, TextAttributesKey[]> TYPE_TO_KEYS = new HashMap<>();
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[ 0 ];

    static
    {
        TYPE_TO_KEYS.put( "CLASS_DEF", new TextAttributesKey[]{ createTextAttributesKey( "CLASS_DEF", DefaultLanguageHighlighterColors.CLASS_NAME ) } );
        TYPE_TO_KEYS.put( "ID", new TextAttributesKey[]{ createTextAttributesKey( "IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER ) } );
        TYPE_TO_KEYS.put( "STRING", new TextAttributesKey[]{ createTextAttributesKey( "STRING", DefaultLanguageHighlighterColors.STRING ) } );
        TYPE_TO_KEYS.put( "INT", new TextAttributesKey[]{ createTextAttributesKey( "NUMBER", DefaultLanguageHighlighterColors.NUMBER ) } );
        TYPE_TO_KEYS.put( "FLOAT", new TextAttributesKey[]{ createTextAttributesKey( "NUMBER", DefaultLanguageHighlighterColors.NUMBER ) } );
        TYPE_TO_KEYS.put( "USE", new TextAttributesKey[]{ createTextAttributesKey( "USE", DefaultLanguageHighlighterColors.KEYWORD ) } );
        TYPE_TO_KEYS.put( "USE_FFI", new TextAttributesKey[]{ createTextAttributesKey( "USE_FFI", DefaultLanguageHighlighterColors.CONSTANT ) } );
        TYPE_TO_KEYS.put( "FIELD", new TextAttributesKey[]{ createTextAttributesKey( "FIELD", DefaultLanguageHighlighterColors.INSTANCE_FIELD ) } );
        TYPE_TO_KEYS.put( "METHOD", new TextAttributesKey[]{ createTextAttributesKey( "METHOD", DefaultLanguageHighlighterColors.INSTANCE_METHOD ) } );
        TYPE_TO_KEYS.put( "JUMP", new TextAttributesKey[]{ createTextAttributesKey( "JUMP", DefaultLanguageHighlighterColors.KEYWORD ) } );
        TYPE_TO_KEYS.put( "BINOP", new TextAttributesKey[]{ createTextAttributesKey( "BIN_OP", DefaultLanguageHighlighterColors.OPERATION_SIGN ) } );
        TYPE_TO_KEYS.put( "ISOP", new TextAttributesKey[]{ createTextAttributesKey( "IS_OP", DefaultLanguageHighlighterColors.OPERATION_SIGN ) } );
        TYPE_TO_KEYS.put( "TERM", new TextAttributesKey[]{ createTextAttributesKey( "TERM", DefaultLanguageHighlighterColors.KEYWORD ) } );
        TYPE_TO_KEYS.put( "NEXTTERM", new TextAttributesKey[]{ createTextAttributesKey( "NEXT_TERM", DefaultLanguageHighlighterColors.KEYWORD ) } );
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer()
    {
        return new PonyLexer();
    }


    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights( IElementType tokenType )
    {
        System.out.println("Token Type:" + tokenType);
        TextAttributesKey[] keys = TYPE_TO_KEYS.get( tokenType.toString() );
        if( keys != null )
        {
            return keys;
        }
        return EMPTY_KEYS;
    }
}
