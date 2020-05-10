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
import org.hedhman.pony.idea.generated.psi.PonyFieldDecl;
import org.hedhman.pony.idea.generated.psi.PonyMethodDecl;
import org.jetbrains.annotations.NotNull;

public class PonyReferenceContributor extends PsiReferenceContributor
{
    @Override
    public void registerReferenceProviders( @NotNull PsiReferenceRegistrar registrar )
    {
        registrar.registerReferenceProvider( PlatformPatterns.psiElement( PonyClassDef.class ), new PsiReferenceProvider()
        {
            @NotNull
            @Override
            public PsiReference[] getReferencesByElement( @NotNull PsiElement element,
                                                          @NotNull ProcessingContext context )
            {
                PonyClassDef classDef = (PonyClassDef) element;
                TextRange range = classDef.getClassName().getTextRangeInParent();
                return new PsiReference[]{ new PonyReference( element, range ) };
            }
        } );
        registrar.registerReferenceProvider( PlatformPatterns.psiElement( PonyMethodDecl.class ), new PsiReferenceProvider()
        {
            @NotNull
            @Override
            public PsiReference[] getReferencesByElement( @NotNull PsiElement element,
                                                          @NotNull ProcessingContext context )
            {
                PonyMethodDecl method = (PonyMethodDecl) element;
                TextRange range = method.getMethodName().getTextRangeInParent();
                return new PsiReference[]{ new PonyReference( element, range ) };
            }
        } );
        registrar.registerReferenceProvider( PlatformPatterns.psiElement( PonyFieldDecl.class ), new PsiReferenceProvider()
        {
            @NotNull
            @Override
            public PsiReference[] getReferencesByElement( @NotNull PsiElement element,
                                                          @NotNull ProcessingContext context )
            {
                PonyFieldDecl field = (PonyFieldDecl) element;
                TextRange range = field.getFieldName().getTextRangeInParent();
                return new PsiReference[]{ new PonyReference( element, range ) };
            }
        } );
    }
}
