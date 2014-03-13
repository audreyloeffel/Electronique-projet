import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 
 * @author Audrey Loeffel 
 * @author Léa Vliegen 
 *
 */
public class TableauGUI extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	private static TableauGUI instance = null;
	private JLabel vInstantText = null;
	private JPanel panelGlobal = new JPanel();

	private TableauGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panelGlobal.setLayout(new BorderLayout());
		JPanel control = createControlPanel();
		JPanel measure = createMeasurePanel();
		panelGlobal.add(control, BorderLayout.NORTH);
		panelGlobal.add(measure, BorderLayout.CENTER);
		getContentPane().add(panelGlobal);
		setVisible(true);
		setTitle("Tableau de bord");
		setSize(500, 500);
		setResizable(false);

	}

	public JPanel createControlPanel() {
		JPanel controlPanel = new JPanel();
		JButton buttonStart = new JButton("Start");
		buttonStart.addActionListener(this);
		JButton buttonStop = new JButton("Stop");
		buttonStop.addActionListener(this);
		JButton buttonReset = new JButton("Reset");
		buttonReset.addActionListener(this);
		controlPanel.add(buttonStart);
		controlPanel.add(buttonStop);
		controlPanel.add(buttonReset);
		controlPanel.setVisible(true);
		return controlPanel;
	}
	
	public JPanel createMeasurePanel(){
		JPanel measurePanel = new JPanel();
		vInstantText = new JLabel("Vitesse instantanée: ?");
		measurePanel.add(vInstantText);
		return measurePanel;
	}

	public static TableauGUI getInstance() {
		if (instance == null) {
			instance = new TableauGUI();
		}
		return instance;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch(event.getActionCommand()){
		case "Start" : {
			Voiture.getInstance().start();
			break;
		}
		case "Stop" : {
			Voiture.getInstance().stop();
			break;
		}
		case "Reset" : {
			break;
		}
		}
		
	}
}
