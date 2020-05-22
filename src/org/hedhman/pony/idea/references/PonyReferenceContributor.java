package org.hedhman.pony.idea.references;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceContributor;
import com.intellij.psi.PsiReferenceProvider;
import com.intellij.psi.PsiReferenceRegistrar;
import com.intellij.util.ProcessingContext;
import org.hedhman.pony.idea.generated.psi.PonyClassDef;
import org.hedhman.pony.idea.generated.psi.PonyDot;
import org.hedhman.pony.idea.generated.psi.PonyFieldDecl;
import org.hedhman.pony.idea.generated.psi.PonyMethodDecl;
import org.jetbrains.annotations.NotNull;

public class PonyReferenceContributor extends PsiReferenceContributor
{
    public PonyReferenceContributor()
    {
        System.out.println("Created: " + getClass().getSimpleName());
    }

    @Override
    public void registerReferenceProviders( @NotNull PsiReferenceRegistrar registrar )
    {
        registrar.registerReferenceProvider( PlatformPatterns.psiElement( PonyDot.class ), new PsiReferenceProvider()
        {
            @NotNull
            @Override
            public PsiReference[] getReferencesByElement( @NotNull PsiElement element,
                                                          @NotNull ProcessingContext context )
            {
                PonyDot dotRef = (PonyDot) element;
                TextRange range = dotRef.getTextRangeInParent();
                return new PsiReference[]{ new PonyReference( element, range ) };
            }
        } );
    }
}
