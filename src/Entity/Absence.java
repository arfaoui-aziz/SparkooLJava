package Entity;

public class Absence {

    private int id;
    private String semaine;
    private String annee_univ;
    private String jour;
    private String id_Teacher;

    public Absence(String semaine, String annee_univ, String jour, String id_Teacher) {
        this.semaine = semaine;
        this.annee_univ = annee_univ;
        this.jour = jour;
        this.id_Teacher = id_Teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSemaine() {
        return semaine;
    }

    public void setSemaine(String semaine) {
        this.semaine = semaine;
    }

    public String getAnnee_univ() {
        return annee_univ;
    }

    public void setAnnee_univ(String annee_univ) {
        this.annee_univ = annee_univ;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getId_Teacher() {
        return id_Teacher;
    }

    public void setId_Teacher(String id_Teacher) {
        this.id_Teacher = id_Teacher;
    }
}
