package fr.akirabane.akirabanemanagement.db.dao;

import java.util.List;

public interface IPlayerManager {

    public void createPlayer(String pseudo_player, String uuid_player, String password_player, boolean is_staff);

    public void updatePlayer(String pseudo_player, String uuid_player, String password_player, boolean is_staff);

    public void deletePlayer(String uuid_player);

    public List<String> getAllPlayers();

    public void getPlayer(String pseudo_player);

    public boolean playerExist(String uuid_player);
}
