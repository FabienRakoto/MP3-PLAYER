package controller;

import java.awt.event.MouseMotionListener;

import org.w3c.dom.events.MouseEvent;

import view.MainView;

public class DraggedController implements MouseMotionListener {

	MainView main;
	
	public DraggedController(MainView mains){
		this.main = mains;
	}
	
	@Override
	public void mouseDragged(java.awt.event.MouseEvent event) {
		
		Object sourceEvenement = event.getSource();
		if(sourceEvenement == main.lblAppTitle){
			int x = event.getXOnScreen();
			int y = event.getYOnScreen();
			
			main.setLocation(x-main.xMouse, y-main.yMouse);
		}
	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
