package thirdlab;

import thirdlab.behavior.ApplicationLoop;
import thirdlab.behavior.DirectoryChangeWatcher;
import thirdlab.models.DefaultFile;

public class Main {
    public static void main(String[] args) {
        ApplicationLoop app = new ApplicationLoop();

        Thread appThread = new Thread(app::run);
        appThread.start();

        Thread watcherThread = new Thread(() -> {
            String directoryPath = DefaultFile.getFolderLocation();
            DirectoryChangeWatcher.watchDirectory(directoryPath);
        });
        watcherThread.start();

        try {
            appThread.join();
            watcherThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        app.closeScanner();
    }
}
