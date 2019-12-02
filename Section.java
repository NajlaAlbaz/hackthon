package schedulegenerator;

import java.util.Scanner;

public class Section extends Course {

    Scanner scan = new Scanner(System.in);
    private String sectionName;
    protected String[] periods = new String[5];
    protected int[] sectionDays;

    public Section() {
        this.sectionName = "Null";
    }

    public Section(String s) {
        this.sectionName = s;
    }

    public boolean contain(int[] a, int b) {
        for (int i = 0; i < a.length; i++) {
            if (b == a[i]) {
                return true;
            }
        }
        return false;
    }

    public void sectionDays() {

        int numDays;
        System.out.println("Please enter how many days section \"" + this.sectionName + "\" has: ");
        numDays = scan.nextInt();
        sectionDays = new int[numDays];

        System.out.println("Sunday = 1.\nMonday = 2.\nTuesday = 3.\nWednesday = 4.\nThursday = 5.");

        for (int i = 0; i < numDays; i++) {
            System.out.println("Please enter which day is day [" + (i + 1) + "] : ");
            sectionDays[i] = scan.nextInt() - 1;
        }

    }

    public void setPeriods() {

        for (int i = 0; i < periods.length; i++) {
            if (contain(sectionDays, i)) {

                System.out.println("Please enter starting period:");
                String period = scan.next();
                System.out.println("Please enter ending period:");
                period += ("~" + scan.next());

                periods[i] = period;
            } else {
                periods[i] = "";
            }

        }

    }

    public void printSectionDays() {

        for (int i = 0; i < periods.length; i++) {
            System.out.print(periods[i] + "\t|\t");
        }
    }

    public void setName(String name) {
        this.sectionName = name;
    }

    public String getName() {
        return this.sectionName;
    }
}
