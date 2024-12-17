package prac19_1;

import java.util.Arrays;

public class LabClassDriver {
    public static void main(String[] args) {
        Student student1 = new Student("Иванов Иван Иванович", 4.2);
        Student student2 = new Student("Петров Петр Петрович", 3.5);
        Student student3 = new Student("Сидоров Сидор Сидорович", 4.7);

        LabClass labClass = new LabClass(Arrays.asList(student1, student2, student3));
        LabClassUI ui = new LabClassUI(labClass);
        ui.start();
    }
}
