package thirdlab.behavior;

public class Main {
    public static void main(String[] args) {
        ApplicationLoop app = new ApplicationLoop();
        //FileChangeDetector.startFileChangeDetection(app);
        app.run();
        app.closeScanner();
        //FileChangeDetector.stopFileChangeDetection();
    }
}
