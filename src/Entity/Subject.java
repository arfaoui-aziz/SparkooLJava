package Entity;

public class Subject {
    private int id ;
    private String SubjectName ;
    private int coefficient ;
    private String SubjectByClasse ;

    public Subject(String subjectName, int coefficient) {
        this.SubjectName = subjectName;
        this.coefficient = coefficient;
    }
    public Subject(int id ,String subjectName, int coefficient , String SubjectByClasse) {
        this.id = id ;
        this.SubjectName = subjectName;
        this.coefficient = coefficient;
        this.SubjectByClasse = SubjectByClasse ;
    }
    public Subject(String subjectName, int coefficient , String SubjectByClasse) {

        this.SubjectName = subjectName;
        this.coefficient = coefficient;
        this.SubjectByClasse = SubjectByClasse ;
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

    public String getSubjectByClasse() {
        return SubjectByClasse;
    }

    public void setSubjectByClasse(String subjectByClasse) {
        SubjectByClasse = subjectByClasse;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", SubjectName='" + SubjectName + '\'' +
                ", coefficient=" + coefficient +
                ", SubjectByClasse='" + SubjectByClasse + '\'' +
                '}';
    }
}
