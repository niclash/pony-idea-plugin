# Pony Language Support for IntelliJ


## Current Status

Basic syntax highlighting works, and I have been working on to figure out how
code formatting works. In a round-about way, the whole AST is rebuilt with the
IntelliJ expected Block type, and that is a massive overkill, since I think one
is supposed to make decisions on what sections in the code are candidates for
formatting. But since I on one hand is a bit uncertain on what makes sense in 
Pony, and on the other hand not at all fluent in IntelliJ plugin development, 
I did the 'hard route', because at least that is what I understand.

Road map and open questions at the moment;

1. Formatter
    * How does the Alignment work?
    * How does Indentation work?
    * How does Wrap work?
    * Need to do formatter panel for users to create their own CodeStyle 
      settings.

1. Highlighter
    * Current highlighter works on tokens only. Is it possible to to create for
      elements (i.e. from ast rules)?
    * Customization panel should be provided.

1. Code Completion
    * Code Completion needs "Reference Contributions" as well as "Completion
      Contribution"
    * How does one parse the entire project and build up a Reference index?

1. Code Navigation
    * It seems that once the "Reference Contribution" is in place, code 
      navigation needs a "Go to Symbol Contributor"
    * That should include Ctrl-N (open file with type), Ctrl-B (go to 
      declaration), Alt-Ctrl-B (go to impls), Alt-F7 (find usage) and 
      Ctrl-F12 (nav to method in file)

1. Code Folding
    * Which are the Foldable sections? method body, use declarations, other?

1. Quick Fixes and Intentions
    * Not clear at the moment what is import, but editor assistance with 
      RefCaps is high on the priority.

1. Compilation Integration.
    * Call out to compiler to provide accurate errors when syntax problems 
      occur.
    * Build project with ponyc
    * Corral integration.

1. Debugger
    * uncertain of effort and possibilities, but since the ast is in the 
      editor, so we should be able to do this "right"

That is my long-term vision, and I will hack on this when I have time. Other 
Java devs with interested in creating a kick-ass IDE for Pony are welcome to
join in.
