package torben3;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;

public class SwingGui extends javax.swing.JFrame {

	static String info ="";
	//Buttoninitialisierung
	
	static String infoPanelAusgabe;
	static JButton Obstfarmbutton;
	static JButton Getreidefarmbutton;
	static JButton Olivenfarmbutton;
	static JButton Weinbergbutton;
	static JButton Ziehbrunnenbutton;
	static JButton Zeltbutton;
	static JLabel informationLabel;
	static JTextArea centerText;				//Textfeld, das später durch das eigentliche Spielfeld ersetzt werden soll
	
	public void createAndShowGUI(){
		

		JFrame frame = new JFrame("LayoutDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		Obstfarmbutton = new JButton("Obstfarm");
		Obstfarmbutton.addActionListener(new EventListener());
		Obstfarmbutton.setActionCommand("ActionCommandClickHelloWorld");
		
		Getreidefarmbutton = new JButton("Getreidefarm");
		Getreidefarmbutton.addActionListener(new EventListener());
		//Getreidefarm.setActionCommand("ActionCommandClickHelloWorld");
		
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
		
		pane.add (eastPanel, BorderLayout.EAST);
		pane.add(centerPanel, BorderLayout.CENTER);
		pane.add (northPanel, BorderLayout.NORTH);
		pane.add (southPanel, BorderLayout.SOUTH);
		
		//InfoPanel oben
		northPanel.setLayout(new GridLayout(1,0));
		informationLabel = new JLabel(info);
		northPanel.add(informationLabel);
		
		
		//Menüpanel auf der rechten Seite
		JPanel bauoptionenPanel = new JPanel();
		JPanel optionenPanel = new JPanel();
		eastPanel.setLayout(new BorderLayout());
		
		eastPanel.add(optionenPanel, BorderLayout.NORTH);
		eastPanel.add(bauoptionenPanel, BorderLayout.CENTER);
		
		bauoptionenPanel.setLayout(new GridLayout(0,2));
		
		bauoptionenPanel.add(Obstfarmbutton);
		bauoptionenPanel.add(Getreidefarmbutton);
		bauoptionenPanel.add(Weinbergbutton);
		bauoptionenPanel.add(Olivenfarmbutton);
		bauoptionenPanel.add(Ziehbrunnenbutton);
		bauoptionenPanel.add(Zeltbutton);
		
		/*eastPanel.setLayout(new GridLayout(0, 2));

			eastPanel.add(Obstfarmbutton);
			eastPanel.add(Getreidefarmbutton);
			eastPanel.add(Weinbergbutton);
			eastPanel.add(Olivenfarmbutton);
			eastPanel.add(Ziehbrunnenbutton);
			eastPanel.add(Zeltbutton);*/
		
		//Zentrales Panel
		
		centerPanel.setLayout(new GridLayout(1, 3));
		centerText = new JTextArea("Dies ist das Brutus-Test-Programm!", 30, 1);	//in dieses Textfeld werden die Nachrichten angezeit
		//centerPanel.add(centerText);
		JScrollPane scrollPane = new JScrollPane(centerText);						// Scrollbalken
		centerPanel.add(scrollPane);
		centerText.setEditable(false);	
	
		
		//Infopanel unten (tut noch nichts)
		southPanel.setLayout(new GridLayout(1,0));
		southPanel.add(new JButton("southButton"));
		frame.pack();
		frame.setVisible(true);
	}
}
