package prac11;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
    public String name;
    public LocalDate dob;

    public Student(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }

    public String getFormattedDOB(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return dob.format(formatter);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}
