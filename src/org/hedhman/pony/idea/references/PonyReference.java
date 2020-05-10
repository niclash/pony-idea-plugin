package org.hedhman.pony.idea.references;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.PsiPolyVariantReference;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.ResolveResult;
import java.util.ArrayList;
import java.util.List;
import org.hedhman.pony.idea.PonyIcon;
import org.hedhman.pony.idea.generated.psi.PonyClassDef;
import org.hedhman.pony.idea.util.PonyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PonyReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference
{
    private final String key;

    public PonyReference( @NotNull PsiElement element, TextRange textRange )
    {
        super( element, textRange );
        key = element.getText().substring( textRange.getStartOffset(), textRange.getEndOffset() );
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve( boolean incompleteCode )
    {
        Project project = myElement.getProject();
        final List<PonyClassDef> classDefs = PonyUtils.findClassDefs( project, key );
        List<ResolveResult> results = new ArrayList<>();
        for( PonyClassDef def : classDefs )
        {
            results.add( new PsiElementResolveResult( def ) );
        }
        return results.toArray( new ResolveResult[ results.size() ] );
    }

    @Nullable
    @Override
    public PsiElement resolve()
    {
        ResolveResult[] resolveResults = multiResolve( false );
        return resolveResults.length == 1 ? resolveResults[ 0 ].getElement() : null;
    }

    @NotNull
    @Override
    public Object[] getVariants()
    {
        Project project = myElement.getProject();
        List<PonyClassDef> classDefs = PonyUtils.findClassDefs( project );
        List<LookupElement> variants = new ArrayList<>();
        for( final PonyClassDef def : classDefs )
        {
            variants.add( LookupElementBuilder
                              .create( def ).withIcon( PonyIcon.icon )
                              .withTypeText( def.getContainingFile().getName() )
                        );
        }
        return variants.toArray();
    }
}
