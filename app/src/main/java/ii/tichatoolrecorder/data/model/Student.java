package ii.tichatoolrecorder.data.model;

public class Student {
    String studentid;
    String studentSurname;
    String studentLastname;
    String studentFirstname;
    String studentClasses;

    public Student(String id, String surname, String firstname, String middlename) {

    }

    public Student(String studentid, String studentSurname, String studentLastname, String studentFirstname, String studentClasses) {
        this.studentid = studentid;
        this.studentSurname = studentSurname;
        this.studentLastname = studentLastname;
        this.studentFirstname = studentFirstname;
        this.studentClasses = studentClasses;
    }

    public String getStudentid() {
        return studentid;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public String getStudentLastname() {
        return studentLastname;
    }

    public String getStudentFirstname() {
        return studentFirstname;
    }

    public String getStudentClasses() {
        return studentClasses;
    }
}