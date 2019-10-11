package schedulegenerator;

import java.util.ArrayList;
import java.util.List;

public class Schedule {

    public void printSchedule(List<Course> a) {

        System.out.println("\t\t\tSunday\t   Monday\t  Tuesday\tWednesday\t\tThursday");

        for (int i = 0; i < (a.size()); i++) {

            for (int j = 0; j < a.get(i).sections.size(); j++) {
                System.out.print(a.get(i).getName() + " section: " + a.get(i).sections.get(j).getName() + "\t");
                a.get(i).sections.get(j).printSectionDays();
                System.out.println("");
            }
        }
    }
}
