package controller;

import jaco.mp3.player.MP3Player;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.nio.file.Paths;

import view.MainView;

public class ViewController implements MouseListener {
	
	MainView main;
	String appName = "RAKOTO TECH - (MP3 Player)";
	public ViewController(MainView mains) {
		this.main = mains;
	}
	
	public void view(){
		main.lblAppTitle.setText(appName);
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		Object sourceEvenement = event.getSource();
		if(sourceEvenement == main.btnSettings){
			if(main.windowCollapsed ==false){
					main.windowCollapsed = true;
					main.setSize(new Dimension(600,60));
					main.lblAppTitle.setFont(new Font("Century Gothic", 0,12));
					main.lblAppTitle.setText("Bonne ecoute avec |"+ main.songFile.getName());
					int xMouse =0;
					int yMouse =0;
					
					main.setLocation(xMouse, yMouse);
					
				}else if(main.windowCollapsed==true){
					main.windowCollapsed = false;
					main.setSize(new Dimension(600,300));
					main.lblAppTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
					main.lblAppTitle.setText(appName);
			
			}
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
	public void mousePressed(MouseEvent event) {
		
		Object sourceEvenement = event.getSource();
		if(sourceEvenement == main.lblAppTitle){
			main.xMouse = event.getX();
			main.yMouse = event.getY();
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
