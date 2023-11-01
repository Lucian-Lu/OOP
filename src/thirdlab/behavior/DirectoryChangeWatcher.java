package thirdlab.behavior;

import java.nio.file.*;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.List;

import thirdlab.models.DefaultFile;

public class DirectoryChangeWatcher {

    public static void watchDirectory(String directoryPath) {
        Path directoryToWatch = Paths.get(directoryPath);

        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            directoryToWatch.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

            ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

            executor.scheduleAtFixedRate(() -> {
                try {
                    WatchKey key = watchService.take();
                    List<WatchEvent<?>> events = key.pollEvents();

                    for (WatchEvent<?> event : events) {
                        if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                            System.out.println(event.context() + " - Created");
                        } else if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                            System.out.println(event.context() + " - Updated");
                        } else if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                            System.out.println(event.context() + " - Deleted");
                        }
                    }

                    key.reset();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, 0, 5, TimeUnit.SECONDS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
