package org.hedhman.pony.idea.completion;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.hedhman.pony.idea.PonyLanguage;
import org.hedhman.pony.idea.generated.parsing.PonyTypes;
import org.jetbrains.annotations.NotNull;

// TODO: Not triggered now, so come back when I figure out how to trigger completion. Probably related to resolver not working.
public class PonyCompletionContributor extends CompletionContributor
{

    public PonyCompletionContributor()
    {
        extend( CompletionType.BASIC,
                PlatformPatterns.psiElement( PonyTypes.CALLSITE ).withLanguage( PonyLanguage.INSTANCE ),
                new CompletionProvider<CompletionParameters>()
                {
                    public void addCompletions( @NotNull CompletionParameters parameters,
                                                @NotNull ProcessingContext context,
                                                @NotNull CompletionResultSet resultSet )
                    {
                        resultSet.addElement( LookupElementBuilder.create( "Hello" ) );
                    }
                }
              );
    }
}
