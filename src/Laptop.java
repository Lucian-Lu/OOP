public class Laptop {
    String Processor = "Ryzen";
    static int Architecture = 64;
    String GPU = "Integrated Graphics";
    int RAM = 16;
    String OS = "Linux";
    String Applications = "Chrome, VSCode";

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
        System.out.println("OS: " + OS);
        System.out.println("Processor: " + Processor);
        System.out.println("Architecture: " + Architecture);
        System.out.println("GPU: " + GPU);
        System.out.println("RAM: " + RAM);
        System.out.println("Installed applications: " + Applications);
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