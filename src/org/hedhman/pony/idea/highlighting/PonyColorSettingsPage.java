package org.hedhman.pony.idea.highlighting;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import java.util.Map;
import javax.swing.Icon;
import org.hedhman.pony.idea.PonyIcon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PonyColorSettingsPage
    implements ColorSettingsPage
{
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
        new AttributesDescriptor("Numbers", PonySyntaxHighlighter.NUMBER),
        new AttributesDescriptor("Strings", PonySyntaxHighlighter.STRING),
        new AttributesDescriptor("Identifiers", PonySyntaxHighlighter.IDENTIFIER),
        new AttributesDescriptor("Line Comments", PonySyntaxHighlighter.LINE_COMMENT),
        new AttributesDescriptor("Block Comments", PonySyntaxHighlighter.BLOCK_COMMENT)
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return PonyIcon.icon;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new PonySyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "use \"http\"\n\n" +
               "actor Main\n" +
               "\"Documentation comment\"\n\n" +
               "  new create(env:Env) =>\n" +
               "      env.out.print(\"Hello World\")\n\n" +
               "  be process(arg1:F64, arg2:I32)? =>\n" +
               "      if( arg2 > 100 ) then error end\n\n" +
               "  fun \\myannotation\\ dosomething(arg1:F64, arg2:I32):F64? =>\n" +
               "      if( arg2 > 100 ) then error end\n" +
               "      arg1 * arg2.f64()\n\n";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Pony";
    }
}
