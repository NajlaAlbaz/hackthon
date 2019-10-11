package schedulegenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class ScheduleGenerator {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        CompareCourses compare = new CompareCourses();
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Course> approvedCourses = new ArrayList<>();
        ArrayList<Section> approvedSections = new ArrayList<Section>();
        ArrayList<Section> sections = new ArrayList<>();
        Schedule schedule = new Schedule();
        
        // entring Namber Of courses
        System.out.println("Please enter the number of courses: ");
        int numOfCourses = scan.nextInt();
        
        // entring Name for courses
        for (int i = 0; i < numOfCourses; i++) {
            System.out.println("Enter the name of course [" + (i + 1) + "]");
            Course temp = new Course(scan.next());
            courses.add(temp);
        }
        
        
        // entring number for sections for each couese and section name
        for (int i = 0; i < courses.size(); i++) {
            System.out.println("Please enter how many sections are avaliable for " + courses.get(i).getName() + " :");
            int numOfSections = scan.nextInt();
            for (int j = 0; j < numOfSections; j++) {
                Section temp = new Section();
                System.out.println("Enter the section's name:");
                temp.setName(scan.next());
                temp.sectionDays();
                temp.setPeriods();
                courses.get(i).addSection(temp);
            }
        }
        
        // **** Print All The Section And Courses ****
          schedule.printSchedule(courses);



       // compare section !!!!!!!!
       
       System.out.println("\nConflictions: \n\t\t\tSunday\t   Monday\t  Tuesday\tWednesday\t\tThursday");
    for(int i = 0; i < courses.size(); i++){
        for(int j = 0; j < courses.size(); j++){
          if(i<j){
        approvedCourses = compare.isNotConflict(courses.get(i), courses.get(j), approvedCourses);
          }
        }
    }

//send comber section to print it out 
       System.out.println("\nPossible Schedule:");
     schedule.printSchedule(approvedCourses);
     
 
 
        // we change this to class (((( Schedule )))) 
        
//        for (int i = 0; i < courses.size(); i++) {
//            for (int j = 0; j < courses.get(i).sections.size(); j++) {
//                courses.get(i).sections.get(j).printSectionDays();
//                System.out.println("");
//            }
//        }



    }

}
