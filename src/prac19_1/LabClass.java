package prac19_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LabClass {
    private List<Student> students = new ArrayList<>();

    public LabClass(List<Student> students) {
        this.students = students;
    }

    public Student findStudentByName(String name) throws StudentNotFoundException, EmptyStringException {
        if (name == null || name.trim().isEmpty()) {
            throw new EmptyStringException("Имя не может быть пустым.");
        }

        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }

        throw new StudentNotFoundException("Студент с именем " + name + " не найден.");
    }


    public void sortStudentsByAverageGrade() {
        students.sort(Comparator.comparingDouble(Student::getGpa).reversed());
    }

    public List<Student> getStudents() {
        return students;
    }
}
