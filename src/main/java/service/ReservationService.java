package service;

import beans.creneaux;
import beans.reservation;
import beans.salle;
import connexion.Connexion;
import dao.IDao;

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
            ps.setString(3, o.getStartDate());
            ps.setString(3, o.getEndDate());
          
           
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
            ps.setObject(1, o.getSalle());
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
        String sql = "select * from reservation where client  = ?";
        try {
            PreparedStatement ps = Connexion.PreparedSQLStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new reservation(rs.getInt("id"), rs.getString("note"),rs.getString("type"),
                        rs.getString("salle"),rs.getInt("client"),rs.getString("startDate"),rs.getString("endDate"));
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
                        rs.getString("salle"),rs.getInt("client"),rs.getString("startDate"),rs.getString("endDate")));
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
                        rs.getString("salle"),rs.getInt("client"),rs.getString("startDate"),rs.getString("endDate")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return reservationList;
    }
}

