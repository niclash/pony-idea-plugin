package org.hedhman.pony.idea.formatter;

import com.intellij.formatting.Alignment;

public interface Alignments
{
    Alignment root = Alignment.createAlignment();
    Alignment use = Alignment.createChildAlignment( root );
    Alignment member = Alignment.createChildAlignment( root );
    Alignment expression = Alignment.createChildAlignment( member );
}
