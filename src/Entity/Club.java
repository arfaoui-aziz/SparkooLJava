package Entity;


public class Club {

    int idClub;
    String nomClub;
    int members;
    String activity;
    float budget;
    String dateCreation;


    public Club(int idClub, String nomClub, int members, String activity, float budget, String dateCreation ) {
        this.idClub=idClub;
        this.nomClub=nomClub;
        this.members=members;
        this.activity=activity;
        this.budget=budget;
        this.dateCreation=dateCreation;


    }

    public Club( String nomClub, int members, String activity, float budget, String dateCreation ) {

        this.nomClub=nomClub;
        this.members=members;
        this.activity=activity;
        this.budget=budget;
        this.dateCreation=dateCreation;

    }

    public int getIdClub() {
        return idClub;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    public String getNomClub() {
        return nomClub;
    }

    public void setNomClub(String nomClub) {
        this.nomClub = nomClub;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "Club{" + "idClub=" + idClub + ", nomClub=" + nomClub + ", members=" + members + ", activity=" + activity + ", budget=" + budget + ", dateCreation=" + dateCreation + '}';
    }

}
