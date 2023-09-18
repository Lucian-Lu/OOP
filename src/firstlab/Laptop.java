package firstlab;

public class Laptop {
    String processor = "Ryzen";
    static int architecture = 64;
    String gpu = "Integrated Graphics";
    int ram = 16;
    String os = "Linux";
    String applications = "Chrome, VSCode";

    public void viewSystemInfo(){
        System.out.println("Looking up system info. Please wait...");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("System info successfully loaded.");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("-----------------------");
        System.out.println("OS: " + os);
        System.out.println("Processor: " + processor);
        System.out.println("Architecture: " + architecture);
        System.out.println("GPU: " + gpu);
        System.out.println("RAM: " + ram);
        System.out.println("Installed applications: " + applications);
        System.out.println("-----------------------");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startComputer(){
        System.out.println("Laptop is starting...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Laptop is on.");
    }

    public void shutDownComputer(){
        System.out.println("Laptop is shutting down...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Laptop is turned off.");
    }
}