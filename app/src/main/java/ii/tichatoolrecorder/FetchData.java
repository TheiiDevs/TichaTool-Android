package ii.tichatoolrecorder;

public class FetchData {
    String studentid;
    String studentSurname;
    String studentLastname;
    String studentFirstname;
    String studentClasses;


    public FetchData() {
    }

    public FetchData(String studentid, String studentSurname, String studentLastname, String studentFirstname, String studentClasses) {
        this.studentid = studentid;
        this.studentSurname = studentSurname;
        this.studentLastname = studentLastname;
        this.studentFirstname = studentFirstname;
        this.studentClasses = studentClasses;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public String getStudentLastname() {
        return studentLastname;
    }

    public void setStudentLastname(String studentLastname) {
        this.studentLastname = studentLastname;
    }

    public String getStudentFirstname() {
        return studentFirstname;
    }

    public void setStudentFirstname(String studentFirstname) {
        this.studentFirstname = studentFirstname;
    }

    public String getStudentClasses() {
        return studentClasses;
    }

    public void setStudentClasses(String studentClasses) {
        this.studentClasses = studentClasses;
    }
}
