package ii.tichatoolrecorder;

public class Student {
    String studentid;
    String Firstname;
    String Lastname;
    String Surname;
    String Classes;

    public Student() {

    }


    public Student(String studentid, String firstname, String lastname, String surname, String classes) {
        this.studentid = studentid;
        Firstname = firstname;
        Lastname = lastname;
        Surname = surname;
        Classes = classes;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getClasses() {
        return Classes;
    }

    public void setClasses(String classes) {
        Classes = classes;
    }
}
