package fr.akirabane.akirabanemanagement.db.players;

import fr.akirabane.akirabanemanagement.db.DatabaseManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerManager {
    private int id;
    private String pseudo_player;
    private String uuid_player;
    private String password_player;
    private boolean is_staff;

    public PlayerManager(String pseudo_player, String uuid_player, String password_player, boolean is_staff) {
        this.pseudo_player = pseudo_player;
        this.uuid_player = uuid_player;
        this.password_player = password_player;
        this.is_staff = is_staff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo_player() {
        return pseudo_player;
    }

    public void setPseudo_player(String pseudo_player) {
        this.pseudo_player = pseudo_player;
    }

    public String getUuid_player() {
        return uuid_player;
    }

    public void setUuid_player(String uuid_player) {
        this.uuid_player = uuid_player;
    }

    public String getPassword_player() {
        return password_player;
    }

    public void setPassword_player(String password_player) {
        this.password_player = password_player;
    }

    public boolean isStaff() {
        return is_staff;
    }

    public void setStaff(boolean staff) {
        is_staff = staff;
    }

    public boolean playerExist(String uuid) {
        try {
            PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("SELECT pseudo_player FROM players WHERE uuid_player = ?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()) return true;
            preparedStatement.close();

            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void createPlayer(String pseudo_player, String uuid_player, String password_player, boolean isStaff) {
        try {
            PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("INSERT INTO players (pseudo_player, uuid_player, password_player, is_staff) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, pseudo_player);
            preparedStatement.setString(2, uuid_player);
            preparedStatement.setString(3, password_player);
            preparedStatement.setBoolean(4, isStaff);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
