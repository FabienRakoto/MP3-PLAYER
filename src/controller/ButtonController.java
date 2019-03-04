package controller;

import jaco.mp3.player.MP3Player;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import modele.SongModele;
import config.FileTypeFilter;
import dao.SongDao;
import view.MainView;

public class ButtonController implements MouseListener {
	MainView main;
	VolumeController volume = new VolumeController();
	
	SongModele songModele = new SongModele();
	String appName = "RAKOTO TECH - (MP3 Player)";

	public ButtonController(MainView mains){
		this.main = mains;
	
	}
	


	@Override
	public void mouseClicked(MouseEvent event) {
		Object sourceEvenement = event.getSource();
		if(sourceEvenement == main.btnQuit){
			main.dispose();
		}
		if(sourceEvenement == main.btnPlay){
			main.player.play();
		}
		if(sourceEvenement == main.btnStop){
			main.player.stop();
		}
		if(sourceEvenement==main.btnPause){
			main.player.pause();
		}
		if(sourceEvenement == main.btnReapet){
			if(main.repeat == false){
				main.repeat = true;
				
				main.player.setRepeat(main.repeat);
				main.btnReapet.setIcon(new ImageIcon(MainView.class.getResource("/images/repeat_enabled.png")));
				
			}else if(main.repeat == true){
				main.repeat = false;
				main.player.setRepeat(main.repeat);
				main.btnReapet.setIcon(new ImageIcon(MainView.class.getResource("/images/repeat.png")));
			}
		}
			if(sourceEvenement == main.btnOpen){
			
			
			JFileChooser openFileChooser = new JFileChooser(main.cuurentDirectory);
			
			openFileChooser.setFileFilter(new FileTypeFilter(".mp3","Seulement les fichier mp3"));
			int resultat = openFileChooser.showOpenDialog(null);
			
			if(resultat == JFileChooser.APPROVE_OPTION){
				main.songFile = openFileChooser.getSelectedFile();
				main.player.addToPlayList(main.songFile);
				main.player.skipForward();
				main.cuurentDirectory = main.songFile.getAbsolutePath();
				main.lblTitreChanson.setText("Bonne ecoute avec |"+ main.songFile.getName());	
				
			}
			
		}
		if(sourceEvenement == main.btnVolumDown){
			volume.volumeDownControl(0.1);
		}
		if(sourceEvenement == main.btnVolumeUp){
			volume.volumeUpControl(0.1);
		}
		if(sourceEvenement == main.btnVolumeFull){
			volume.volumeControl(1.0);
		}
		if(sourceEvenement == main.btnMute){
			volume.volumeControl(0.0);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

	
}
