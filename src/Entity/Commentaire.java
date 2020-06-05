package Entity;

public class Commentaire {

    private int id;
    private String comentor_id;
    private int subject;
    private String commentaire;
    private String commentdate;

    public Commentaire(int id, String comentor_id, int subject, String commentaire, String commentdate) {
        this.id = id;
        this.comentor_id = comentor_id;
        this.subject = subject;
        this.commentaire = commentaire;
        this.commentdate = commentdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentor_id() {
        return comentor_id;
    }

    public void setComentor_id(String comentor_id) {
        this.comentor_id = comentor_id;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(String commentdate) {
        this.commentdate = commentdate;
    }

    @Override
    public String toString() {
        return "commentaire{" +
                "id=" + id +
                ", comentor_id='" + comentor_id + '\'' +
                ", subject=" + subject +
                ", commentaire='" + commentaire + '\'' +
                ", commentdate='" + commentdate + '\'' +
                '}';
    }
}
