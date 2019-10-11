package schedulegenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Course {

    private String name;
    public List<Section> sections = new ArrayList();

    public Course() {

    }

    public Course(String name) {
        this.name = name;
    }

    public Course(String name, Section a) {
        this(name);
        sections.add(a);
    }

    public void addSection(Section a) {
        sections.add(a);
    }

    public void setName(String s) {
        this.name = s;
    }

    public String getName() {
        return this.name;
    }

    public int getNumSections() {
        return sections.size();
    }

    public void printSectionDays() {
        for (int i = 0; i < sections.size(); i++) {
            sections.get(i).printSectionDays();
            System.out.println("");
        }
    }

}
