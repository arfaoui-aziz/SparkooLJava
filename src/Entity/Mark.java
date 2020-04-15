package Entity;

public class Mark {


    private  int id;
    private String subject;
    private Double cc;
    private  Double exam;
    private String note;
    private String id_Student;
    private String id_Teacher;

    public Mark(int id, String subject, Double cc, Double exam, String note, String id_Student, String id_Teacher) {
        this.id = id;
        this.subject = subject;
        this.cc = cc;
        this.exam = exam;
        this.note = note;
        this.id_Student = id_Student;
        this.id_Teacher = id_Teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getCc() {
        return cc;
    }

    public void setCc(Double cc) {
        this.cc = cc;
    }

    public Double getExam() {
        return exam;
    }

    public void setExam(Double exam) {
        this.exam = exam;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getId_Student() {
        return id_Student;
    }

    public void setId_Student(String id_Student) {
        this.id_Student = id_Student;
    }

    public String getId_Teacher() {
        return id_Teacher;
    }

    public void setId_Teacher(String id_Teacher) {
        this.id_Teacher = id_Teacher;
    }
}
