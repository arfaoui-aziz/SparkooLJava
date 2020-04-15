package Entity;

public class Delay {

    private int id;
    private int duree;
    private String jour;
    private String id_Teacher;

    public Delay(int duree, String jour, String id_Teacher) {
        this.duree = duree;
        this.jour = jour;
        this.id_Teacher = id_Teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
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
