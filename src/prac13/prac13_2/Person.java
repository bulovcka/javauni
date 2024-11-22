package prac13.prac13_2;

public class Person {
    String name;
    String surname;
    String middlename;

    public String getFullName(){
        StringBuilder fullName = new StringBuilder();

        if (surname != null && !surname.isEmpty()) {
            fullName.append(surname);
        }


        if (surname != null && !surname.isEmpty()) {
            fullName.append(" ");
            fullName.append(surname.toUpperCase().charAt(0)).append(".");
            if (middlename != null && !middlename.isEmpty()) {
                fullName.append(middlename.toUpperCase().charAt(0)).append(".");
            }
        }


        return fullName.toString().trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public Person(String name, String surname, String middlename) {
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
    }
}
