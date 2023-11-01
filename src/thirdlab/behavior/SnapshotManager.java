package thirdlab.behavior;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SnapshotManager {
    private LocalDateTime snapshot;

    public void setSnapshot(LocalDateTime snapshot) {
        this.snapshot = snapshot;
    }

    public LocalDateTime getSnapShot() {
        return snapshot;
    }

    public void updateSnapshot() {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS");
        LocalDateTime formattedTime = LocalDateTime.parse(currentTime.format(formatter));
        setSnapshot(formattedTime);
    }

}
