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