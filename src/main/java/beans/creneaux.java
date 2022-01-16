package beans;

import java.util.Date;

public class creneaux {
    private  int id;
    private double dateDebut;
    private double dateFin;

    public creneaux(int id, double dateDebut, double dateFin) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public creneaux(double dateDebut, double dateFin) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(double dateDebut) {
        this.dateDebut = dateDebut;
    }

    public double getDateFin() {
        return dateFin;
    }

    public void setDateFin(double dateFin) {
        this.dateFin = dateFin;
    }
}
