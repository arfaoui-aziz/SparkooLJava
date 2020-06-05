package Entity;

public class Votes {
    private int id;
    private String voter;
    private int subjectvoted;
    private Byte status;

    public Votes(int id, String voter, int subjectvoted, Byte status) {
        this.id = id;
        this.voter = voter;
        this.subjectvoted = subjectvoted;
        this.status = status;
    }

    public Votes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoter() {
        return voter;
    }

    public void setVoter(String voter) {
        this.voter = voter;
    }

    public int getSubjectvoted() {
        return subjectvoted;
    }

    public void setSubjectvoted(int subjectvoted) {
        this.subjectvoted = subjectvoted;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Votes{" +
                "id=" + id +
                ", voter='" + voter + '\'' +
                ", subjectvoted=" + subjectvoted +
                ", status=" + status +
                '}';
    }
}
