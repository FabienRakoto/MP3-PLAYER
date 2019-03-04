package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import modele.SongModele;
import dao.SongDao;
import view.MainView;

public class SaveController implements ActionListener {
	MainView main;
	SongModele songModele = new SongModele();
	SongDao songDao = new SongDao();
	
	public SaveController(MainView mains){
		this.main = mains;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		
		Object sourceEvenement = event.getSource();
		
		if(sourceEvenement == main.btnSave){
			songModele.setSong_name(main.songFile.getName());
			songDao.insert(songModele);
			
			ArrayList <SongModele> listSong = new ArrayList<SongModele>();
			
		}
		
	}

}
