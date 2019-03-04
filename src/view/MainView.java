package view;

import jaco.mp3.player.MP3Player;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;

import controller.ButtonController;
import controller.DraggedController;
import controller.SaveController;
import controller.ViewController;

import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class MainView extends JFrame {
	
	public jaco.mp3.player.MP3Player player;
	public  File  songFile;
	public String cuurentDirectory = "home.user";
	public String currentPath;
	public String imagePath;
	public boolean repeat = false;
	public boolean windowCollapsed = false;
	public JButton btnSave;
	public JList list;
	public  int xMouse, yMouse;
	public final JPanel panel_1 = new JPanel();
	public JLabel btnStop;
	public JLabel btnReapet;
	public JLabel btnPlay;
	public JLabel btnPause;
	public JLabel btnOpen;
	public JLabel btnVolumDown;
	public JLabel btnVolumeUp;
	public JLabel btnVolumeFull;
	public JLabel btnMute;
	public JLabel btnSettings;
	public JLabel btnQuit;
	public JLabel lblAppTitle;
	public JLabel lblTitreChanson;
	public String fileName;
	public MainView(){
		
		this.setSize(600,300);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		getContentPane().setLayout(null);
		
		songFile = new File("C:\\Users\\FAVENNEC\\Downloads\\Music\\StephrambiMitia.mp3");
		fileName =songFile.getName();
		player = mp3Player();
		player.addToPlayList(songFile);
		currentPath = Paths.get(".").normalize().toString();
		imagePath = "\\images";
		
		
		JPanel appName = new JPanel();
		appName.setBackground(new Color(7, 63, 86));
		appName.setBounds(0, 0, 600, 300);
		getContentPane().add(appName);
		appName.setLayout(null);
		panel_1.setBackground(new Color(7, 63, 86));
		panel_1.setBounds(0, 225, 600, 75);
		appName.add(panel_1);
		panel_1.setLayout(null);
		
		btnReapet = new JLabel("");
		btnReapet.setIcon(new ImageIcon(MainView.class.getResource("/images/repeat.png")));
		btnReapet.setBounds(10, 20, 75, 44);
		panel_1.add(btnReapet);
		
		btnStop = new JLabel("");
		btnStop.setIcon(new ImageIcon(MainView.class.getResource("/images/stop.png")));
		btnStop.setBounds(86, 20, 75, 44);
		panel_1.add(btnStop);
		
		btnPlay = new JLabel("");
		btnPlay.setIcon(new ImageIcon(MainView.class.getResource("/images/play.png")));
		btnPlay.setBounds(139, 11, 110, 64);
		panel_1.add(btnPlay);
		
		btnPause = new JLabel("");
		btnPause.setIcon(new ImageIcon(MainView.class.getResource("/images/pause.png")));
		btnPause.setBounds(242, 20, 75, 44);
		panel_1.add(btnPause);
		
		btnOpen = new JLabel("");
		btnOpen.setIcon(new ImageIcon(MainView.class.getResource("/images/open.png")));
		btnOpen.setBounds(317, 20, 75, 44);
		panel_1.add(btnOpen);
		
		btnVolumDown = new JLabel("");
		btnVolumDown.setIcon(new ImageIcon(MainView.class.getResource("/images/volume_down.png")));
		btnVolumDown.setBounds(423, 20, 32, 44);
		panel_1.add(btnVolumDown);
		
		btnVolumeUp = new JLabel("");
		btnVolumeUp.setIcon(new ImageIcon(MainView.class.getResource("/images/volume_up.png")));
		btnVolumeUp.setBounds(454, 20, 32, 44);
		panel_1.add(btnVolumeUp);
		
		btnVolumeFull = new JLabel("");
		btnVolumeFull.setIcon(new ImageIcon(MainView.class.getResource("/images/volume_full.png")));
		btnVolumeFull.setBounds(488, 20, 32, 44);
		panel_1.add(btnVolumeFull);
		
		btnMute = new JLabel("");
		btnMute.setIcon(new ImageIcon(MainView.class.getResource("/images/mute.png")));
		btnMute.setBounds(522, 20, 32, 44);
		panel_1.add(btnMute);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(36, 93, 116));
		panel_2.setBounds(0, 0, 600, 60);
		appName.add(panel_2);
		panel_2.setLayout(null);
		
		btnSettings = new JLabel("");
		btnSettings.setBounds(500, 11, 40, 39);
		btnSettings.setIcon(new ImageIcon(MainView.class.getResource("/images/settings.png")));
		panel_2.add(btnSettings);
		
		btnQuit = new JLabel("");
		btnQuit.setBounds(550, 11, 40, 39);
		btnQuit.setIcon(new ImageIcon(MainView.class.getResource("/images/quit.png")));
		panel_2.add(btnQuit);
		
		lblAppTitle = new JLabel("APP TITLE");
		lblAppTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAppTitle.setForeground(new Color(34, 202, 237));
		lblAppTitle.setBounds(10, 11, 480, 38);
		panel_2.add(lblAppTitle);
		
		lblTitreChanson = new JLabel("Titre Chanson ...");
		lblTitreChanson.setLabelFor(this);
		lblTitreChanson.setBackground(new Color(240, 240, 240));
		lblTitreChanson.setForeground(new Color(34, 202, 237));
		lblTitreChanson.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitreChanson.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTitreChanson.setBounds(0, 71, 600, 39);
		appName.add(lblTitreChanson);
		
		btnSave = new JButton("Add to playlist");
		btnSave.setForeground(new Color(102, 204, 204));
		btnSave.setBackground(new Color(6,63,86));
		btnSave.setBounds(233, 110, 135, 23);
		appName.add(btnSave);
		
		list = new JList();
		list.setBounds(0, 138, 600, 89);
		appName.add(list);
		
		this.setVisible(true);
		
		this.init();
	}
	
	public void init(){
		lblTitreChanson.setText(fileName);
		
		ViewController viewController = new ViewController(this);
		DraggedController dragged = new DraggedController(this);
		lblAppTitle.addMouseMotionListener(dragged);
		lblAppTitle.addMouseListener(viewController);
		
		viewController.view();
		
		SaveController save = new SaveController(this);
		btnSave.addActionListener(save);
		
		ButtonController controller = new ButtonController(this);
		btnQuit.addMouseListener(controller);	
		btnPlay.addMouseListener(controller);
		btnStop.addMouseListener(controller);
		btnPause.addMouseListener(controller);
		btnReapet.addMouseListener(controller);
		btnSettings.addMouseListener(viewController);
		btnOpen.addMouseListener(controller);
		btnVolumDown.addMouseListener(controller);
		btnVolumeUp.addMouseListener(controller);
		btnVolumeFull.addMouseListener(controller);
		btnMute.addMouseListener(controller);
		
		
		
	}
	
	private MP3Player mp3Player(){
		MP3Player mp3Player = new MP3Player();
		return mp3Player;
	}
}