package Entity;

public class Event {

    int id;
    String nomEvent;
    String typeEvent;
    String description;
    String dateEvent;
    String placeEvent;
    int nbParticipants;
    String theme;
    String destination;
    float award;
    float budget;
    float price;

    public Event(int id, String nomEvent, String typeEvent, String description, String dateEvent, String placeEvent, int nbParticipants, String theme, String destination, float award, float budget, float price) {
        this.id=id;
        this.nomEvent = nomEvent;
        this.typeEvent = typeEvent;
        this.description = description;
        this.dateEvent = dateEvent;
        this.placeEvent = placeEvent;
        this.nbParticipants = nbParticipants;
        this.theme = theme;
        this.destination = destination;
        this.award = award;
        this.budget = budget;
        this.price = price;
    }

    public Event(String nomEvent, String typeEvent, String description, String dateEvent, String placeEvent, int nbParticipants, String theme, String destination, float award, float budget, float price) {
        this.nomEvent = nomEvent;
        this.typeEvent = typeEvent;
        this.description = description;
        this.dateEvent = dateEvent;
        this.placeEvent = placeEvent;
        this.nbParticipants = nbParticipants;
        this.theme = theme;
        this.destination = destination;
        this.award = award;
        this.budget = budget;
        this.price = price;
    }

    public Event(String nomEvent, String typeEvent, String description, String dateEvent, String placeEvent, int nbParticipants, float budget, float price) {
        this.nomEvent = nomEvent;
        this.typeEvent = typeEvent;
        this.description = description;
        this.dateEvent = dateEvent;
        this.placeEvent = placeEvent;
        this.nbParticipants = nbParticipants;
        this.budget = budget;
        this.price = price;
    }

    public Event(String nomEvent, String typeEvent, String description, String dateEvent, String placeEvent, int nbParticipants, String theme, float budget) {
        this.nomEvent = nomEvent;
        this.typeEvent = typeEvent;
        this.description = description;
        this.dateEvent = dateEvent;
        this.placeEvent = placeEvent;
        this.nbParticipants = nbParticipants;
        this.theme = theme;
        this.budget = budget;

    }
    public Event(String nomEvent, String typeEvent, String description, String dateEvent, int nbParticipants, String destination, float budget, float price) {
        this.nomEvent = nomEvent;
        this.typeEvent = typeEvent;
        this.description = description;
        this.dateEvent = dateEvent;
        this.nbParticipants = nbParticipants;
        this.destination = destination;
        this.budget = budget;
        this.price = price;
    }
    public Event(String nomEvent, String typeEvent, String description, String dateEvent, String placeEvent, int nbParticipants, String theme, float award, float budget, float price) {
        this.nomEvent = nomEvent;
        this.typeEvent = typeEvent;
        this.description = description;
        this.dateEvent = dateEvent;
        this.placeEvent = placeEvent;
        this.nbParticipants = nbParticipants;
        this.theme = theme;
        this.award = award;
        this.budget = budget;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomEvent() {
        return nomEvent;
    }

    public void setNomEvent(String nomEvent) {
        this.nomEvent = nomEvent;
    }

    public String getTypeEvent() {
        return typeEvent;
    }

    public void setTypeEvent(String typeEvent) {
        this.typeEvent = typeEvent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }

    public String getPlaceEvent() {
        return placeEvent;
    }

    public void setPlaceEvent(String placeEvent) {
        this.placeEvent = placeEvent;
    }

    public int getNbParticipants() {
        return nbParticipants;
    }

    public void setNbParticipants(int nbParticipants) {
        this.nbParticipants = nbParticipants;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public float getAward() {
        return award;
    }

    public void setAward(float award) {
        this.award = award;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "event{" + "id=" + id + ", nomEvent='" + nomEvent + '\'' + ", typeEvent='" + typeEvent + '\'' + ", description='" + description + '\'' + ", dateEvent='" + dateEvent + '\'' + ", placeEvent='" + placeEvent + '\'' + ", nbParticipants=" + nbParticipants + ", theme='" + theme + '\'' + ", destination='" + destination + '\'' + ", award='" + award + '\'' + ", budget=" + budget + ", price=" + price + '}';
    }
}