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

public class PonySyntaxHighlighter extends SyntaxHighlighterBase
{
    private static final Map<String, TextAttributesKey[]> TYPE_TO_KEYS = new HashMap<>();
    public static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[ 0 ];
    public static final TextAttributesKey KEYWORD = createTextAttributesKey( "KEYWORD", DefaultLanguageHighlighterColors.KEYWORD );
    public static final TextAttributesKey IDENTIFIER = createTextAttributesKey( "IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER );
    public static final TextAttributesKey STRING = createTextAttributesKey( "STRING", DefaultLanguageHighlighterColors.STRING );
    public static final TextAttributesKey NUMBER = createTextAttributesKey( "NUMBER", DefaultLanguageHighlighterColors.NUMBER );
    public static final TextAttributesKey LINE_COMMENT = createTextAttributesKey( "LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT );
    public static final TextAttributesKey BLOCK_COMMENT = createTextAttributesKey( "BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT );

    static
    {
        TYPE_TO_KEYS.put( "KEYWORD", new TextAttributesKey[]{KEYWORD} );
        TYPE_TO_KEYS.put( "ID", new TextAttributesKey[]{IDENTIFIER} );
        TYPE_TO_KEYS.put( "STRING", new TextAttributesKey[]{STRING} );
        TYPE_TO_KEYS.put( "INT", new TextAttributesKey[]{ NUMBER } );
        TYPE_TO_KEYS.put( "FLOAT", new TextAttributesKey[]{ NUMBER } );
        TYPE_TO_KEYS.put( "LINE_COMMENT", new TextAttributesKey[]{ LINE_COMMENT } );
        TYPE_TO_KEYS.put( "BLOCK_COMMENT", new TextAttributesKey[]{ BLOCK_COMMENT } );
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
        String token = tokenType.toString();
        System.out.println( "Token Type:" + token );
        if( Character.isLowerCase( token.charAt( 0 ) ) )
        {
            return TYPE_TO_KEYS.get( "KEYWORD" );
        }
        TextAttributesKey[] keys = TYPE_TO_KEYS.get( tokenType.toString() );
        if( keys == null )
        {
            return EMPTY_KEYS;
        }
        return keys;
    }
}
