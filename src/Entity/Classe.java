package Entity;

public class Classe {
    private int classId;
    private String className;
    private int classNbr ;

    public Classe(int classId, String className, int classNbr) {
        this.classId = classId;
        this.className = className;
        this.classNbr = classNbr;
    }

    public Classe(String className, int classNbr) {
        this.className = className;
        this.classNbr = classNbr;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassNbr() {
        return classNbr;
    }

    public void setClassNbr(int classNbr) {
        this.classNbr = classNbr;
    }

    @Override
    public String toString() {
        return "Classe{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", classNbr='" + classNbr + '\'' +
                '}';
    }
}
