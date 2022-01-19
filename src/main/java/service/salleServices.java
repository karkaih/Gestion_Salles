package service;

import beans.salle;
import beans.user;
import connexion.Connexion;
import dao.IDao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class salleServices implements IDao<salle> {

    @Override
    public boolean create(salle o) {
        String sql = "insert into salle values (null, ?, ?, ?,?)";
        try {
            PreparedStatement ps = Connexion.PreparedSQLStatement(sql);
            ps.setString(1, o.getName());
            ps.setString(2, o.getCapacity());
            ps.setString(3, o.getType());
            ps.setInt(4, o.getnReservation());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("create : erreur sql : " + e.getMessage());

        }
        return false;
    }

    @Override
    public boolean delete(int o) {
        String sql = "delete from salle where id  = ?";
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
    public boolean update(salle o) {

        String sql = "update salle set name  = ? , capacity = ?, type = ? where id  = ?";
        try {
            PreparedStatement ps = Connexion.PreparedSQLStatement(sql);
            ps.setString(1, o.getName());
            ps.setString(2, o.getCapacity());
            ps.setString(3, o.getType());
            ps.setInt(4, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("update : erreur sql : " + e.getMessage());

        }
        return false;
    }

    @Override
    public salle findById(int id) {
        salle m = null;
        String sql = "select * from salle where id  = ?";
        try {
            PreparedStatement ps = Connexion.PreparedSQLStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new salle(rs.getInt("id"), rs.getString("name"),
                        rs.getString("capacity"),rs.getString("type"));
            }

        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
    }

    public salle findByNumberReservation() {
        try {
            PreparedStatement pr = Connexion.PreparedSQLStatement("select MAX(nReservation) as N ,id, name , capacity , type from salle ");
            assert pr != null;
            ResultSet resultSet = pr.executeQuery();
            if (resultSet.next())
                return new salle(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("capacity"),resultSet.getString("type"),resultSet.getInt("N"));
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<salle> findAll() {
        List<salle> salles = new ArrayList<salle>();

        String sql = "select * from salle";
        try {
            PreparedStatement ps = Connexion.PreparedSQLStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                salles.add(new salle(rs.getInt("id"), rs.getString("name"),
                        rs.getString("capacity"),rs.getString("type"),rs.getInt("nReservation")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return salles;
    }


}
