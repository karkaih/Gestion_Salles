package beans;

import java.util.Date;

public class reservation {

    private int id;
    private String note;
    private String type;
    private String salle;
    private int client;
    private Date startDate;
    private Date endDate;
    
    
    
	public reservation(String note, String type, String salle, int client, Date startDate, Date endDate) {
		
		super();
		
		this.note = note;
		this.type = type;
		this.salle = salle;
		this.client = client;
		this.startDate = startDate;
		this.endDate = endDate;
		
	}


	public reservation(int id, String note, String type, String salle, int client, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.note = note;
		this.type = type;
		this.salle = salle;
		this.client = client;
		this.startDate = startDate;
		this.endDate = endDate;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSalle() {
		return salle;
	}
	public void setSalle(String salle) {
		this.salle = salle;
	}
	public int getClient() {
		return client;
	}
	public void setClient(int client) {
		this.client = client;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
    
}
