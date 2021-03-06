package gui;

import ground.Desert;
import ground.Field;
import ground.Grass;
import ground.Marble;
import ground.Water;
import java.awt.*;
import javax.swing.*;

public class SwingGui extends javax.swing.JFrame{

	


	/** Returns an ImageIcon, or null if the path was invalid. */
	protected ImageIcon createImageIcon(String path,
	                                           String description) {
	    java.net.URL imgURL = getClass().getResource(path);
	    if (imgURL != null) {
	        return new ImageIcon(imgURL, description);
	    } else {
	        System.err.println("Couldn't find file: " + path);
	        return null;
	    }
	}
	
	ImageIcon beraterIcon = createImageIcon("/img/berater.jpg","a pretty but meaningless splat");
	ImageIcon weltkartenIcon = createImageIcon("/img/karte.jpg", "test");
	
	static String info = "";
	// Buttoninitialisierung

	String infoPanelAusgabe;
	JButton Obstfarmbutton;
	JButton Getreidefarmbutton;
	JButton Olivenfarmbutton;
	JButton Weinbergbutton;
	JButton Ziehbrunnenbutton;
	JButton Zeltbutton;
	JButton Spezialkartenbutton;
	JButton Beraterbutton;
	JButton Weltkartenbutton;
	JLabel informationLabel;
	JTextArea centerText; // Textfeld, das sp�ter durch das eigentliche
									// Spielfeld ersetzt werden soll
	JMenuBar menuBar;
	JLabel moneyLabel;
	JLabel bevLabel;
	JLabel timeLabel;
	
	JMenuItem exit;
	JMenuItem open;
	JMenuItem save;
	JMenuItem neu;
	JFrame frame;
	
	Field [][] map;
	MiniMap minimap;
	static NilsPanel playField;
	static Field[][] testfield;
	static boolean baumode;
	

	public void fieldChange(String s){
		if (s.equals("obstfarm")){
			System.out.println("fieldchange obstfarm");
		}
		
	}

	public void createAndShowGUI() {
		frame = new JFrame("LayoutDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		Obstfarmbutton = new JButton("Obstfarm");
		Obstfarmbutton.addActionListener(new EventListener());
		Obstfarmbutton.setActionCommand("ActionCommandClickHelloWorld");

		Getreidefarmbutton = new JButton("Getreidefarm");
		Getreidefarmbutton.addActionListener(new EventListener());
		// Getreidefarm.setActionCommand("ActionCommandClickHelloWorld");

		Olivenfarmbutton = new JButton("Olivenfarm");
		Olivenfarmbutton.addActionListener(new EventListener());

		Weinbergbutton = new JButton("Weinberg");
		Weinbergbutton.addActionListener(new EventListener());

		Ziehbrunnenbutton = new JButton("Ziehbrunnen");
		Ziehbrunnenbutton.addActionListener(new EventListener());

		Zeltbutton = new JButton("Zelt");
		Zeltbutton.addActionListener(new EventListener());

		Container pane = frame.getContentPane();

		pane.setLayout(new BorderLayout());

		JPanel eastPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel();

		pane.add(eastPanel, BorderLayout.EAST);
		pane.add(centerPanel, BorderLayout.CENTER);
		pane.add(northPanel, BorderLayout.NORTH);
		pane.add(southPanel, BorderLayout.SOUTH);

		// /////////////InfoPanel oben//////////////

		northPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

		JPanel menuPanel = new JPanel();
		JPanel anzeigePanel = new JPanel();

		menuPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		anzeigePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 0));

		northPanel.add(menuPanel);
		northPanel.add(anzeigePanel);

		menuBar = new JMenuBar(); // Men� wird erstellt
		menuPanel.add(menuBar);

		// Men�punkte werden erstellt
		JMenu datei = new JMenu("Datei");
		JMenu optionen = new JMenu("Optionen");
		JMenu hilfe = new JMenu("Hilfe");
		JMenu berater = new JMenu("Berater");

		menuBar.add(datei);
		menuBar.add(optionen);
		menuBar.add(hilfe);
		menuBar.add(berater);

		// Men�unterpunkte werden erstellt
		exit = new JMenuItem("Beenden");
		open = new JMenuItem("�ffnen");
		save = new JMenuItem("Speichern");
		neu = new JMenuItem("Neu");
		
		datei.add(neu);
		datei.add(open);
		datei.add(save);
		datei.add(exit);
		open.addActionListener(new EventListener());
		save.addActionListener(new EventListener());
		exit.addActionListener(new EventListener());
		

		moneyLabel = new JLabel("Geld");
		bevLabel = new JLabel("Bevoelkerung");
		timeLabel = new JLabel("Zeit");

		anzeigePanel.add(moneyLabel);
		anzeigePanel.add(bevLabel);
		anzeigePanel.add(timeLabel);

		// ///////////////Men�panel auf der rechten Seite////////////////

		eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));

		JPanel optionenPanel = new JPanel();
		eastPanel.add(optionenPanel);

		JPanel bauoptionenPanel = new JPanel();
		eastPanel.add(bauoptionenPanel);

		// optionenPanel

		optionenPanel.setLayout(new BoxLayout(optionenPanel, BoxLayout.Y_AXIS));

		JPanel spezialkartenPanel = new JPanel(); // verschiedene Panel f�r die
													// optionen
		JPanel minikartenPanel = new JPanel();
		JPanel beraterWeltkartePanel = new JPanel();
		JPanel schnelloptionenPanel = new JPanel();

		optionenPanel.add(spezialkartenPanel);
		optionenPanel.add(minikartenPanel);
		optionenPanel.add(beraterWeltkartePanel);
		optionenPanel.add(schnelloptionenPanel);

		spezialkartenPanel.setLayout(new FlowLayout(FlowLayout.LEADING)); // die
																			// jeweils
																			// ein
																			// FlowLayout
																			// bekommen
		minikartenPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		beraterWeltkartePanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		schnelloptionenPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

		minimap = new MiniMap(new Field[2][2]);
		minimap.setPreferredSize(new Dimension (20, 20));
		minikartenPanel.add(minimap);
		
		Spezialkartenbutton = new JButton("Spezialkarten");
		spezialkartenPanel.add(Spezialkartenbutton);

		Beraterbutton = new JButton(beraterIcon);
		Beraterbutton.setBorder(BorderFactory.createEmptyBorder()); // Beraterbutton
																	// soll
																	// keinen
																	// Rand
																	// haben

		// Beraterbutton.setIcon(beraterIcon);
		Beraterbutton.addActionListener(new EventListener());

		Weltkartenbutton = new JButton(weltkartenIcon);
		Weltkartenbutton.setBorder(BorderFactory.createEmptyBorder());
		beraterWeltkartePanel.add(Beraterbutton);

		beraterWeltkartePanel.add(Weltkartenbutton);

		// BauoptionenPanel

		bauoptionenPanel.setLayout(new FlowLayout()); // Bauoptionen sollen in 3
														// Spalten angezeigt
														// werden

		JPanel bauoptionenPanelEins = new JPanel();
		JPanel bauoptionenPanelZwei = new JPanel();
		JPanel bauoptionenPanelDrei = new JPanel();

		bauoptionenPanel.add(bauoptionenPanelEins); // ...,die jeweils mehrere
													// Zeilen haben
		bauoptionenPanel.add(bauoptionenPanelZwei);
		bauoptionenPanel.add(bauoptionenPanelDrei);

		bauoptionenPanelEins.setLayout(new BoxLayout(bauoptionenPanelEins,
				BoxLayout.Y_AXIS)); // erste Spalte
		bauoptionenPanelZwei.setLayout(new BoxLayout(bauoptionenPanelZwei,
				BoxLayout.Y_AXIS)); // zweite Spalte
		bauoptionenPanelDrei.setLayout(new BoxLayout(bauoptionenPanelDrei,
				BoxLayout.Y_AXIS)); // dritte Spalte

		bauoptionenPanelEins.add(Obstfarmbutton);
		bauoptionenPanelEins.add(Getreidefarmbutton);
		bauoptionenPanelZwei.add(Weinbergbutton);
		bauoptionenPanelZwei.add(Olivenfarmbutton);
		bauoptionenPanelDrei.add(Ziehbrunnenbutton);
		bauoptionenPanelDrei.add(Zeltbutton);

		// /////////////////Zentrales Panel//////////////

		centerPanel.setLayout(new GridLayout(1, 0));
		testfield = new Field[200][200];
		testfield[0][0]=new Desert(0, 1); 
		testfield[0][200/200]=new Marble(0, 1); 
		testfield[0][400/200]=new Grass(0, 2); 
		testfield[0][600/200]=new Water(0, 3); 
		playField = new NilsPanel(testfield);
		playField.setPreferredSize(new Dimension (500, 500));
		centerPanel.add(playField);
				
		
		
		//JScrollPane scrollPane = new JScrollPane(playField); // Scrollbalken
		//centerPanel.add(scrollPane);
		//scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
 		
		/*centerText = new JTextArea("Dies ist das Brutus-Test-Programm!", 50, 80); // in
																					// dieses
																					// Textfeld
																					// werden
																					// die
																					// Nachrichten
																					// angezeit
		JScrollPane scrollPane = new JScrollPane(centerText); // Scrollbalken
		centerPanel.add(scrollPane);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		centerText.setEditable(false);*/

		// /////////////Infopanel unten////////////////
		southPanel.setLayout(new FlowLayout());
		informationLabel = new JLabel(info);
		southPanel.add(informationLabel);

		frame.pack();
		playField.ngl.canvas.addKeyListener(new InputKeyEvents());
		playField.setFocusable(true);
		playField.requestFocus(true);
		frame.setVisible(true);

	}
}


