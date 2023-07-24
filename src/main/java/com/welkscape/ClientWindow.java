package com.welkscape;

import java.net.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

import com.welkscape.features.settings.InformationFile;

public class ClientWindow extends Client implements ActionListener {

	private static final long serialVersionUID = -6978617783576386732L;

	private InformationFile informationFile = new InformationFile();
	
	String userNameFrameTitle;
	
	public void initUI() {
		try {
			informationFile.read();
			String playerName = informationFile.getStoredUsername();
			//System.out.print("Name:" + playerName.substring(0, 1).toUpperCase() + playerName.substring(1)  + ": \n");
			if(!playerName.equalsIgnoreCase("")) {
				userNameFrameTitle = " - [" + playerName.substring(0, 1).toUpperCase() + playerName.substring(1) + "]";
			} else {
				userNameFrameTitle = "";
			}
				
			icon = new ImageIcon(new URL("https://i.stack.imgur.com/KSnus.gif")).getImage();
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			JPopupMenu.setDefaultLightWeightPopupEnabled(false);
			frame = new JFrame(Configuration.CLIENT_TITLE + userNameFrameTitle);
			frame.setLayout(new BorderLayout());
			setFocusTraversalKeysEnabled(false);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel gamePanel = new JPanel();
			gamePanel.setLayout(new BorderLayout());
			gamePanel.add(this);
			gamePanel.setPreferredSize(new Dimension(765, 503));
			frame.getContentPane().add(gamePanel, BorderLayout.CENTER);
			frame.pack();
			insets = frame.getInsets();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ClientWindow(String args[]) {
		super();
		try {
			initUI();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public URL getCodeBase() {
		try {
			return new URL("http://" + server + "/overlays");
		} catch (Exception e) {
			return super.getCodeBase();
		}
	}

	@Override
	public URL getDocumentBase() {
		return getCodeBase();
	}

	public void loadError(String s) {
		System.out.println("loadError: " + s);
	}

	@Override
	public String getParameter(String key) {
		return "";
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
	}
	
	private static JFrame frame;
	
	public static JFrame getFrame() {
		return frame;
	}
	
	private static Insets insets;
	
	public static Insets getInset() {
		return insets;
	}

}