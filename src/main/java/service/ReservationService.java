package service;

import beans.CalendarDTO;
import beans.creneaux;
import beans.reservation;
import beans.salle;
import connexion.Connexion;
import dao.IDao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationService implements IDao<reservation> {
    @Override
    public boolean create(reservation o) {
        String sql = "insert into reservation values (null, ?, ?, ?, ?, ?,?)";
        try {
            PreparedStatement ps = Connexion.PreparedSQLStatement(sql);
            ps.setString(1, o.getNote());
            ps.setString(2, o.getType());
            ps.setString(3, o.getSalle());
            ps.setInt(4, o.getClient());
            ps.setDate(5, new Date(o.getStartDate().getTime()));
            ps.setDate(6, new Date(o.getEndDate().getTime()));
          
           
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("create : erreur sql : " + e.getMessage());
        }
        return false;
    }
    public int createCreneaux(creneaux o) {
        String sql = "insert into creneaux values (null, ?, ?)";
        try {
            PreparedStatement ps = Connexion.PreparedSQLStatement(sql);
            ps.setDouble(1, o.getDateDebut());
            ps.setDouble(2, o.getDateFin());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println("create : erreur sql : " + e.getMessage());
        }
        return 0;
    }

    @Override
    public boolean delete(int o) {
        String sql = "delete from reservation where id  = ?";
        try {
            PreparedStatement ps = Connexion.PreparedSQLStatement(sql);
            ps.setInt(1, o);
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("delete : erreur sql : " + e.getMessage());

        }
        return false;
    }

    @Override
    public boolean update(reservation o) {

        String sql = "update reservation set salle  = ?  where id  = ?";
        try {
            PreparedStatement ps = Connexion.PreparedSQLStatement(sql);
            ps.setString(1, o.getSalle());
            ps.setInt(2, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("update : erreur sql : " + e.getMessage());
        }
        return false;
    }

    @Override
    public reservation findById(int id) {
        String sql = "select * from reservation where id  = ?";
        try {
            PreparedStatement ps = Connexion.PreparedSQLStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new reservation(rs.getInt("id"), rs.getString("note"),rs.getString("type"),
                        rs.getString("salle"),rs.getInt("client"),rs.getDate("startDate"),rs.getDate("endDate"));
            }

        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
    }

    public List<reservation>  findByClientId(int id) {
        List<reservation> reservationList = new ArrayList<reservation>();
        String sql = "select * from reservation where client  = ?";
        try {
            PreparedStatement ps = Connexion.PreparedSQLStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                reservationList.add( new reservation(rs.getInt("id"), rs.getString("note"),rs.getString("type"),
                        rs.getString("salle"),rs.getInt("client"),rs.getDate("startDate"),rs.getDate("endDate")));
            }
        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return reservationList;
    }

    @Override
    public List<reservation> findAll() {
        List<reservation> reservationList = new ArrayList<reservation>();

        String sql = "select * from reservation";
        try {
            PreparedStatement ps = Connexion.PreparedSQLStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                reservationList.add( new reservation(rs.getInt("id"), rs.getString("note"),rs.getString("type"),
                        rs.getString("salle"),rs.getInt("client"),rs.getDate("startDate"),rs.getDate("endDate")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return reservationList;
    }
    
    
    
    
    public List<salle> findAvailable() {
        List<salle> salles = new ArrayList<salle>();

        String sql = "select * from salle  where name not in (select salle from reservation) ";
        try {
        	
            PreparedStatement ps = Connexion.PreparedSQLStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                salles.add(new salle(rs.getInt("id"), rs.getString("name"),
                        rs.getString("capacity"),rs.getString("type"),rs.getInt("nReservation")));
            }

        } 
        catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        
        return salles;
        
    }
    
    public List<CalendarDTO> findBookingNByMonth() {
        List<CalendarDTO> calendarDTOArrayList = new ArrayList<CalendarDTO>();

        String sql = "select  count(*) as x,EXTRACT(MONTH FROM startDate) as y from reservation\n" +
                "group by EXTRACT(MONTH FROM startDate)";
        try {
            PreparedStatement ps = Connexion.PreparedSQLStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                calendarDTOArrayList.add(new CalendarDTO(rs.getInt("x"),getMountName(rs.getInt("y"))));
            }
            

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return calendarDTOArrayList;
    }
    
    
    public String getMountName(int i){
        if(i==1)
            return "Jan";
        else if(i==2)
            return "Feb";
        else if(i==3)
            return "Mar";
        else if(i==4)
            return "Apr";
        else if(i==5)
            return "May";
        else if(i==6)
            return "Jun";
        else if(i==7)
            return "Jul";
        else if(i==8)
            return "Aug";
        else if(i==9)
            return "Sep";
        else if(i==10)
            return "Oct";
        else if(i==11)
            return "No";
        else
            return "Dec";
    }
    
}


