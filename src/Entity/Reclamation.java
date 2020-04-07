package Entity;

public class Reclamation {
    private int id;
    private String type;
    private String datecree;
    private String message;
    private int etat;
    private int id_Parent;
    private String reponse;

    public Reclamation(int id, String type, String datecree, String message, int etat, int id_Parent, String reponse) {
        this.id = id;
        this.type = type;
        this.datecree = datecree;
        this.message = message;
        this.etat = etat;
        this.id_Parent = id_Parent;
        this.reponse = reponse;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDatecree() {
        return datecree;
    }

    public void setDatecree(String datecree) {
        this.datecree = datecree;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getId_Parent() {
        return id_Parent;
    }

    public void setId_Parent(int id_Parent) {
        this.id_Parent = id_Parent;
    }
}
