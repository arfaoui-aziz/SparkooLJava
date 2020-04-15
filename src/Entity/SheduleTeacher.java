package Entity;

public class SheduleTeacher {
    private int id;
    private String day;
    private String subject;
    private String szssion;

    private String classe;
    private String id_Teacher;

    public SheduleTeacher(int id, String day, String subject, String szssion, String classe, String id_Teacher) {
        this.id = id;
        this.day = day;
        this.subject = subject;
        this.szssion = szssion;
        this.classe = classe;
        this.id_Teacher = id_Teacher;
    }

    public SheduleTeacher(String subject, String classe) {
        this.subject = subject;
        this.classe = classe;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getSzssion() {
        return szssion;
    }

    public void setSzssion(String szssion) {
        this.szssion = szssion;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getId_Teacher() {
        return id_Teacher;
    }

    public void setId_Teacher(String id_Teacher) {
        this.id_Teacher = id_Teacher;
    }
}
