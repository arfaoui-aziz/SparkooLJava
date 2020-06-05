package Entity;

public class Forum {

    private int id;
    private String auteur_id;
    private String title;
    private String type;
    private String subject;
    private String dateajout;
    private Byte etat;
    private Byte solved;
    private  int nbreponse;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuteur_id() {
        return auteur_id;
    }

    public void setAuteur_id(String auteur_id) {
        this.auteur_id = auteur_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDateajout() {
        return dateajout;
    }

    public void setDateajout(String dateajout) {
        this.dateajout = dateajout;
    }

    public Byte getEtat() {
        return etat;
    }

    public void setEtat(Byte etat) {
        this.etat = etat;
    }

    public Byte getSolved() {
        return solved;
    }

    public void setSolved(Byte solved) {
        this.solved = solved;
    }

    public int getNbreponse() {
        return nbreponse;
    }

    public void setNbreponse(int nbreponse) {
        this.nbreponse = nbreponse;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "id=" + id +
                ", auteur_id='" + auteur_id + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", subject='" + subject + '\'' +
                ", dateajout='" + dateajout + '\'' +
                ", etat=" + etat +
                ", solved=" + solved +
                ", nbreponse=" + nbreponse +
                '}';
    }

    public Forum(int id, String auteur_id, String title, String type, String subject, String dateajout, Byte etat, Byte solved, int nbreponse) {
        this.id = id;
        this.auteur_id = auteur_id;
        this.title = title;
        this.type = type;
        this.subject = subject;
        this.dateajout = dateajout;
        this.etat = etat;
        this.solved = solved;
        this.nbreponse = nbreponse;
    }

    public Forum(String title, String type, String subject, Byte etat, Byte solved) {
        this.title = title;
        this.type = type;
        this.subject = subject;
        this.etat = etat;
        this.solved = solved;
    }
}
