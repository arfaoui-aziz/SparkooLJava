package Entity;

public class Classe {
    private int classId;
    private String className;
    private String classNbr ;

    public Classe(String className, String classNbr) {
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

    public String getClassNbr() {
        return classNbr;
    }

    public void setClassNbr(String classNbr) {
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
