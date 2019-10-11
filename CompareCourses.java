package schedulegenerator;

import java.util.ArrayList;
import java.util.List;

// this class for finding confliction but it dose NOT work 

public class CompareCourses {

//    public void confliction(List<Course> a, List<Course> b) {
//        int perA[] = new int[2], perB[] = new int[2];
//        String periodsA = "";
//        String periodsB = "";
//        String[] splittedA, splittedB;
//        for (int i = 0; i < a.size(); i++) {
//            for (int j = 0; j < a.get(i).sections.size(); j++) {
//                for (int k = a.size() - 1; k > 0; k--) {
//                    for (int l = 0; l < a.get(k).sections.size(); l++) {
//                        if (a.get(i).sections.get(j).sectionDays == a.get(k).sections.get(l).sectionDays) {
//                            for (int m = 0; m < 5; m++) {
//                                if (a.get(i).sections.get(j).periods[m] != "") {
//                                    periodsA += a.get(i).sections.get(j).periods[m];
//                                }
//                                if (a.get(k).sections.get(l).periods[m] != "") {
//                                    periodsB += a.get(i).sections.get(j).periods[m];
//                                }
//                            }
//                            System.out.println(periodsA + ", " + periodsB);
//                            splittedA = periodsA.split("~");
//                            splittedB = periodsB.split("~");
//
//                            perA[0] = Integer.parseInt(splittedA[0]);
//                            perA[1] = Integer.parseInt(splittedA[1]);
//
//                            perB[0] = Integer.parseInt(splittedA[0]);
//                            perB[1] = Integer.parseInt(splittedA[1]);
//                        }
//                    }
//                }
//            }
//        }
//    }
    public ArrayList<Course> isNotConflict( Course a, Course b, ArrayList<Course> c) {
        
        int perA[] = new int[2], perB[] = new int [2];
        String[] periodsA = new String[3];
        String[] periodsB = new String[3];
        c = new ArrayList<>();
        Course temp;
        ArrayList<Course> c1 = new ArrayList<>();
        int count = 0;
        
        for (int i = 0; i < a.sections.size(); i++) {
            for (int j = 0; j < b.sections.size(); j++) {
                for (int q = 0; q < a.sections.get(i).sectionDays.length; q++) {
                    for (int p = 0; p < b.sections.get(j).sectionDays.length; p++) {
                        if (a.sections.get(i).sectionDays[q] == b.sections.get(j).sectionDays[p]) {
                            count++;
                            periodsA = a.sections.get(i).periods[a.sections.get(i).sectionDays[q]].split("~");

                            perA[0] = Integer.parseInt(periodsA[0]);
                            perA[1] = Integer.parseInt(periodsA[1]);

                            periodsB = b.sections.get(j).periods[b.sections.get(j).sectionDays[p]].split("~");

                            perB[0] = Integer.parseInt(periodsB[0]);
                            perB[1] = Integer.parseInt(periodsB[1]);

                            if((perA[0] > perB[1])||(perA[1] < perB[0])){
                                temp = new Course();
                                temp.setName(a.getName());
                                temp.addSection(a.sections.get(i));
                                c.add(temp);
                                temp = new Course();
                                temp.setName(b.getName());
                                temp.addSection(b.sections.get(j));
                                c.add(temp);
                            }else {
                                temp = new Course();
                                temp.setName(a.getName());
                                temp.addSection(a.sections.get(i));
                                c1.add(temp);
                                temp = new Course();
                                temp.setName(b.getName());
                                temp.addSection(b.sections.get(j));
                                c1.add(temp);
                            }
                        }
                    }
                }
                    if(count==0){
                        temp = new Course();
                        temp.setName(a.getName());
                        temp.addSection(a.sections.get(i));
                        c.add(temp);
                        temp = new Course();
                        temp.setName(b.getName());
                        temp.addSection(b.sections.get(j));
                        c.add(temp);
                    }
            }
        }
        
        for (int x = 0; x < c1.size(); x++) {
            for(int z = 0; z < c1.get(x).sections.size(); z++){
                System.out.print(c1.get(x).getName() + " section: " + c1.get(x).sections.get(z).getName()+ "\t");
                c1.get(x).sections.get(z).printSectionDays();
                System.out.println("");
            }
        }
        
        return c;
    }
}

        
         

//        System.out.println("\t\t\tSunday\t   Monday\t  Tuesday\tWednesday\t\tThursday");
//
//        for (int i = 0; i < (c.size()); i++) {
//
//            for (int j = 0; j < c.get(i).sections.size(); j++) {
//                System.out.print(c.get(i).getName() + " section: " + c.get(i).sections.get(j).getName() + "\t");
//                c.get(i).sections.get(j).printSectionDays();
//                System.out.println("");
//            }
//        }
    
        
        
        
    




