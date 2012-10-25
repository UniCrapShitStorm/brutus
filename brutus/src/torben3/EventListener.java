package torben3;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventListener implements ActionListener {
	
	
	Main main = new Main();

	public void actionPerformed(ActionEvent event){
		
		Object src = event.getSource();
		
		if (src == SwingGui.Obstfarmbutton){
		//Farm.build(buildings, stats, 'g');
		// Main.information();								// soll bald eine Obstfarm bauen
		System.out.println("Obstfarm");
		Farm.build(Main.buildings, Main.stats, 'o');
		}
		if (src == SwingGui.Getreidefarmbutton){
			System.out.println("Getreidefarm");				//soll bald eine Getreidefarm bauen
			Farm.build(Main.buildings, Main.stats, 'g');
		}
		if (src == SwingGui.Weinbergbutton){
			System.out.println("Weinberg");	
			Farm.build(Main.buildings, Main.stats, 'w');
		}
		if (src == SwingGui.Olivenfarmbutton){
			System.out.println("Olivenfarm");
			Farm.build(Main.buildings, Main.stats, 'l');
		}
		if (src == SwingGui.Ziehbrunnenbutton){
			System.out.println("Ziehbrunnen");	
			Well.build(Main.buildings, Main.stats, Main.resources);
		}	
		if (src == SwingGui.Zeltbutton){
			System.out.println("Zelt");	
			Tent.build(Main.buildings, Main.stats);
		}		
	}
	

	
}
