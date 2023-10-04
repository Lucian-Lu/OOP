package secondlab;

import secondlab.behavior.FileManager;

public class Main {

    public static void main(String[] args) {
        secondlab.behavior.ApplicationLoop app = new secondlab.behavior.ApplicationLoop();
        FileManager.load();
        app.run();
        FileManager.save();
        app.closeScanner();
    }
}

// nf/Computers, Informatics & Microelectronics/isa/SOFTWARE_ENGINEERING
// nf/Mechanics, Transport Engineering/mte/MECHANICAL_ENGINEERING
// df/SOFTWARE_ENGINEERING
// ns/isa/Lucian/Lupan/lucian.lupan@isa.utm.md/28/10/2002
// ns/isa/Mihail/Mihalachi/mihail.mihalachi@isa.utm.md/16/11/2003
// ns/isa/Catalin/Latcovschi/catalin.latcovschi@isa.utm.md/26/10/2003
// ns/mte/Mike/Ross/mike.ross@mte.utm.md/26/10/1990
