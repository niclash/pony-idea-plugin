package org.hedhman.pony.idea;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class PonyIcon
{
    public static final Icon icon = loadIcon();

    private static Icon loadIcon()
    {
        try
        {
            InputStream in = PonyFileType.class.getClassLoader().getResourceAsStream( "images/pony.png" );
            if( in != null )
            {
                BufferedImage image = ImageIO.read( in );
                return new ImageIcon( image );
            }
        }
        catch( IOException e )
        {
            // can't find image, internal error.
        }
        return new ImageIcon(); // no image
    }

}
