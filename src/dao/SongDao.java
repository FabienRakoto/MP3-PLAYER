package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.AccesBdd;
import modele.SongModele;

public class SongDao {
	
	public static void insert(SongModele song){
		String sql = "INSERT INTO  song (song_name) VALUES ('"+song.getSong_name()+"')";
		AccesBdd acces = new AccesBdd();
		acces.loadDriver();
		acces.executeUpdate(sql);
		acces.closeConnection();	
	}
	
	public static List<SongModele> findAll() throws SQLException{
		String sql = "SELECT * FROM song";
		ArrayList<SongModele> list = new ArrayList<SongModele>();
		AccesBdd acces = new AccesBdd();
		acces.loadDriver();
		
		ResultSet resultat = acces.executeSelect(sql);
		
		while(resultat.next()){
			SongModele song = new SongModele();
			song.setSong_name(resultat.getString("song_name"));
			list.add(song);
		}
		
		return list;
	}
	
}
