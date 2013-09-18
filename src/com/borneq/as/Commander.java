package com.borneq.as;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import javax.swing.*;
import com.borneq.awt.BordListLayout;
import java.awt.event.ActionEvent;

public class Commander extends JFrame {
	private static final long serialVersionUID = -6779403712513402695L;
	private JMenuBar menuBar;
	private JMenu menu, submenu;
	private JMenuItem menuItem;
	private JRadioButtonMenuItem rbMenuItem;
	private JCheckBoxMenuItem cbMenuItem;
	private JPanel fkeyPanel;
	private JPanel commandPanel;
	private JTable tableLeft, tableRight;
	private JSplitPane splitPanel;
	private JScrollPane scrollLeft, scrollRight;
	private FileModel model;

	public Commander(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initMenu();
		LayoutManager layout = new BordListLayout();
		setLayout(layout);
		fkeyPanel = new JPanel();
		fkeyPanel.add(new JButton("F3 View"));
		fkeyPanel.add(new JButton("F4 Edit"));
		fkeyPanel.add(new JButton("F5 Copy"));
		fkeyPanel.add(new JButton("F6 Move"));
		fkeyPanel.add(new JButton("F7 NewFolder"));
		fkeyPanel.add(new JButton("F8 Delete"));
		fkeyPanel.add(new JButton("Alt+F4 Exit"));

		commandPanel = new JPanel();
		commandPanel.add(new JLabel());
		commandPanel.add(new JTextField(20));

		add(fkeyPanel, BordListLayout.SOUTH);
		add(commandPanel, BordListLayout.SOUTH);

		model = new FileModel();
		tableLeft = new JTable(model);
		tableRight = new JTable(model);
		scrollLeft = new JScrollPane(tableLeft);
		scrollRight = new JScrollPane(tableRight);
		splitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
				scrollLeft, scrollRight);
		splitPanel.setResizeWeight(0.5);
		splitPanel.setContinuousLayout(true);
		splitPanel.setOneTouchExpandable(true);
		add(splitPanel, BordListLayout.CENTER);
	}

	private void initMenu() {
		menuBar = new JMenuBar();
		menu = new JMenu("A Menu");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
				"The only menu in this program that has menu items");
		menuBar.add(menu);

		// a group of JMenuItems
		menuItem = new JMenuItem("A text-only menu item", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"This doesn't really do anything");
		menu.add(menuItem);

		menuItem = new JMenuItem("Both text and icon", new ImageIcon(
				"images/middle.gif"));
		menuItem.setMnemonic(KeyEvent.VK_B);
		menu.add(menuItem);

		menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
		menuItem.setMnemonic(KeyEvent.VK_D);
		menu.add(menuItem);

		// a group of radio button menu items
		menu.addSeparator();
		ButtonGroup group = new ButtonGroup();
		rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
		rbMenuItem.setSelected(true);
		rbMenuItem.setMnemonic(KeyEvent.VK_R);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);

		rbMenuItem = new JRadioButtonMenuItem("Another one");
		rbMenuItem.setMnemonic(KeyEvent.VK_O);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);

		// a group of check box menu items
		menu.addSeparator();
		cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
		cbMenuItem.setMnemonic(KeyEvent.VK_C);
		menu.add(cbMenuItem);

		cbMenuItem = new JCheckBoxMenuItem("Another one");
		cbMenuItem.setMnemonic(KeyEvent.VK_H);
		menu.add(cbMenuItem);

		// a submenu
		menu.addSeparator();
		submenu = new JMenu("A submenu");
		submenu.setMnemonic(KeyEvent.VK_S);

		menuItem = new JMenuItem("An item in the submenu");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
				ActionEvent.ALT_MASK));
		submenu.add(menuItem);

		menuItem = new JMenuItem("Another item");
		submenu.add(menuItem);
		menu.add(submenu);

		// Build second menu in the menu bar.
		menu = new JMenu("Another Menu");
		menu.setMnemonic(KeyEvent.VK_N);
		menu.getAccessibleContext().setAccessibleDescription(
				"This menu does nothing");
		menuBar.add(menu);
		setJMenuBar(menuBar);
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
