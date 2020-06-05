package Entity;

public class Marks {

    private int id;
    private double CC;
    private double Exam;
    private String subject;
    private String student;

    public Marks(int id, double CC, double exam, String subject, String student) {
        this.id = id;
        this.CC = CC;
        Exam = exam;
        this.subject = subject;
        this.student = student;
    }

    public Marks() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCC() {
        return CC;
    }

    public void setCC(double CC) {
        this.CC = CC;
    }

    public double getExam() {
        return Exam;
    }

    public void setExam(double exam) {
        Exam = exam;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Marks{" +
                "id=" + id +
                ", CC=" + CC +
                ", Exam=" + Exam +
                ", subject='" + subject + '\'' +
                ", student='" + student + '\'' +
                '}';
    }
}
