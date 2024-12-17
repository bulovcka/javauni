package prac10;

import java.util.Comparator;

public class SortBySpecialization implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return student1.getSpecialization().compareTo(student2.getSpecialization());
    }
}
