package org.hedhman.pony.idea;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PonyFileType extends LanguageFileType
{
    public static final LanguageFileType PonySource = new PonyFileType();
    public static final String DEFAULT_EXTENSION = "pony";
    private static final Icon icon = loadIcon();

    protected PonyFileType( @NotNull Language language )
    {
        super( language );
    }

    public PonyFileType()
    {
        super( PonyLanguage.INSTANCE );
    }

    @NotNull
    @Override
    public String getName()
    {
        return "Pony";
    }

    @NotNull
    @Override
    public String getDescription()
    {
        return "Pony source file";
    }

    @NotNull
    @Override
    public String getDefaultExtension()
    {
        return DEFAULT_EXTENSION;
    }

    @Nullable
    @Override
    public Icon getIcon()
    {
        return icon;
    }

    private static Icon loadIcon()
    {
        try
        {
            InputStream in = PonyFileType.class.getClassLoader().getResourceAsStream( "images/pony.png" );
            if( in != null )
            {
                BufferedImage image = ImageIO.read( in );
                return new ImageIcon( image.getScaledInstance( 16,16, 0 ) );
            }
        }
        catch( IOException e )
        {
            // can't find image, internal error.
        }
        return new ImageIcon(); // no image
    }
}
