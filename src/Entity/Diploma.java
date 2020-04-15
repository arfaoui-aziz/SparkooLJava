package Entity;

public class Diploma {
    private String id;
    private String intitule;
    private String ecole;
    private String specialite;
    private String niveau;
    private String date_obtentation;
    private  String idT;


    public Diploma( String intitule, String ecole, String specialite, String niveau, String date_obtentation, String idT) {

        this.intitule = intitule;
        this.ecole = ecole;
        this.specialite = specialite;
        this.niveau = niveau;
        this.date_obtentation = date_obtentation;
        this.idT = idT;
    }

    public Diploma(String id, String niveau) {
        this.id = id;
        this.niveau = niveau;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getEcole() {
        return ecole;
    }

    public void setEcole(String ecole) {
        this.ecole = ecole;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getDate_obtentation() {
        return date_obtentation;
    }

    public void setDate_obtentation(String date_obtentation) {
        this.date_obtentation = date_obtentation;
    }

    public String getIdT() {
        return idT;
    }

    public void setIdT(String idT) {
        this.idT = idT;
    }
}
