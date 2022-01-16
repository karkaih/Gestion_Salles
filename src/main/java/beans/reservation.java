package beans;

public class reservation {

    private int id;
    private String note;
    private String type;
    private int salle;
    private int client;
    private int creneaux;

    public reservation(int id, String note, String type, int salle, int client, int creneaux) {
        this.id = id;
        this.note = note;
        this.type = type;
        this.salle = salle;
        this.client = client;
        this.creneaux = creneaux;
    }

    public reservation( String note, String type, int client, int creneaux) {
        this.note = note;
        this.type = type;
        this.client = client;
        this.creneaux = creneaux;
    }

    public reservation(int id, String note, int salle, int client, int creneaux) {
        this.id = id;
        this.note = note;
        this.salle = salle;
        this.client = client;
        this.creneaux = creneaux;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getSalle() {
        return salle;
    }

    public void setSalle(int salle) {
        this.salle = salle;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public int getCreneaux() {
        return creneaux;
    }

    public void setCreneaux(int creneaux) {
        this.creneaux = creneaux;
    }
}
