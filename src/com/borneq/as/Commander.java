package com.borneq.as;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Commander extends JFrame {

	public Commander(String string) {
		// TODO Auto-generated constructor stub
	}
	protected static void createAndShowGUI() {
		final Commander frame = new Commander("As Commander");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
			}
		});
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
