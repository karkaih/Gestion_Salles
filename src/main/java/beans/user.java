package beans;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;

public class user {
    private int id;
    private String fullName;
    private String username;
    private String password;
    private Date birthdate;
    private String email ;
    private String city;
    private String state ;
    private String level ;

    public user(int id, String fullName, String username, String password, String email, String city, String state,String level) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.city = city;
        this.state = state;
        this.level=level;
    }

    public user(String fullName, String username) {
        this.fullName = fullName;
        this.username = username;
    }

   

    public user(String fullName, String username, String password, String email, String city, String state,
			String level) {
		super();
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.city = city;
		this.state = state;
		this.level = level;
	}

	public user(String fullName, String username, Date birthdate) {
        this.fullName = fullName;
        this.username = username;
        this.birthdate = birthdate;
    }

    public user(int id, String fullName, String username, Date birthdate,String password,String level) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.birthdate = birthdate;
        this.password = password;
        this.level=level;   }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public static String MD5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            BigInteger bi = new BigInteger(1, md.digest(s.getBytes()));
            return bi.toString(16);
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
