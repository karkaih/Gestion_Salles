package beans;

import java.sql.Date;

public class salle {
    private int id;
    private String name;
    private String capacity;
    private String type ;
    private int nReservation;

   

	public salle(int id, String name, String capacity, String type) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.type = type;
    }

    public salle(String name, String capacity, String type) {
        this.name = name;
        this.capacity = capacity;
        this.type = type;
    }

    public salle(String name, String capacity, String type,int n) {
        this.name = name;
        this.capacity = capacity;
        this.type = type;
        this.nReservation=n;
    }
    public salle(int id,String name, String capacity, String type,int n) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.type = type;
        this.nReservation=n;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getnReservation() {
        return nReservation;
    }

    public void setnReservation(int nReservation) {
        this.nReservation = nReservation;
    }
}
