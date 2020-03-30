package Entity;

public class Subject {
    private int id ;
    private String SubjectName ;
    private int coefficient ;

    public Subject(String subjectName, int coefficient) {
        SubjectName = subjectName;
        this.coefficient = coefficient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", SubjectName='" + SubjectName + '\'' +
                ", coefficient=" + coefficient +
                '}';
    }
}
