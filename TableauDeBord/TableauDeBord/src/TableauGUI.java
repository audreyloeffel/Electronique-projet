import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class TableauGUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static TableauGUI instance = null;
	private JLabel vInstantText = null;
	
	private JPanel panelGlobal = new JPanel();
	
	private TableauGUI(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panelGlobal.setLayout(new BorderLayout());
		vInstantText = new JLabel("Vitesse instantanée: ?");
		panelGlobal.add(vInstantText);
		getContentPane().add(panelGlobal);
		setVisible(true);
		setResizable(false);
		
	}
	
	public static TableauGUI getInstance(){
		if( instance == null){
			instance = new TableauGUI();
		}
		return instance;
	}
}
