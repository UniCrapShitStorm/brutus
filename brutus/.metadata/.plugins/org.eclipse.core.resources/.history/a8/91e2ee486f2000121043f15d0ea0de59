import ground.Desert;
import ground.Field;
import ground.Grass;
import ground.Stones;
import ground.Water;
import ground.Wheat;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import build.Track;


public class FieldPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2621303484453659528L;
	public static final String[] POSSIBLE_SURFACES={"Gr","Wt","Wh","St","Ds"};
	private JComboBox cbSurface;
	private JCheckBox cStreet;
	
	public FieldPanel(int x,int y,int width,int height){
		super(new BorderLayout());
		super.add(getSurface(), BorderLayout.NORTH);
		super.add(getStreet(),BorderLayout.CENTER);
		super.setBounds(x, y, width, height);
		super.setVisible(true);
	}
	public FieldPanel(int x,int y,int width,int height,int selectedSurface,boolean street){
		super(new BorderLayout());
		super.add(getSurface(), BorderLayout.NORTH);
		super.add(getStreet(),BorderLayout.CENTER);
		super.setBounds(x, y, width, height);
		super.setVisible(true);
		getSurface().setSelectedIndex(selectedSurface);
		getStreet().setSelected(street);
	}
	
	private JComboBox getSurface(){
		if(cbSurface==null)
		{
			cbSurface=new JComboBox(POSSIBLE_SURFACES);
			cbSurface.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switch (cbSurface.getSelectedIndex()) {
					case 0: 
					case 2: 
					case 4: getStreet().setEnabled(true); break;
					case 1: 
					case 3: getStreet().setSelected(false);getStreet().setEnabled(false); break;
					}
					
				}
			});
		}
		return cbSurface;
	}
	private JCheckBox getStreet(){
		if(cStreet==null)
		{
			cStreet = new JCheckBox();
		}
		return cStreet;
	}
	public Field createSelectedField(int xPos,int yPos){
		Field f=null;
		switch (cbSurface.getSelectedIndex()) {
		case 0:f =new Grass(xPos, yPos);break;
		case 1:f=new Water(xPos, yPos);break;
		case 2:f=new Wheat(xPos, yPos);break;
		case 3:f=new Stones(xPos, yPos);break;
		case 4:f=new Desert(xPos, yPos);break;
		}
		if(cStreet.isSelected())
				f.setBuilding(new Track(f));
		return f;
	}
	
}
