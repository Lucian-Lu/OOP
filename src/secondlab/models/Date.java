package secondlab.models;


import secondlab.behavior.LogManager;

public class Date {
    private byte day;
    private byte month;
    private short year;

    public Date(byte day, byte month, short year) {
        if (isValidDate(day, month)) {
            this.day = day;
            this.month = month;
            this.year = year;
            LogManager.log("AUDIT: Created new date in construct");
        } else {
            System.out.println("Invalid date parameters");
            LogManager.log("ERROR: Invalid date parameters");
        }
    }

    private boolean isValidDate(byte day, byte month) {
        return (day >= 1 && day <= 31) && (month >= 1 && month <= 12);
    }

    public byte getDay() {
        return day;
    }

    public byte getMonth() {
        return month;
    }

    public short getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("%02d-%02d-%04d", day, month, year);
    }

}
