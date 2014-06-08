import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * 
 * @author Audrey Loeffel
 * @author Léa Vliegen
 * 
 */
public class TableauGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static TableauGUI instance = null;
	private JTextArea text = new JTextArea("");
	private JTextArea timeText = new JTextArea("");
	private String measuresText = "";
	private UniteTraitementNumerique uniteTraitement = null;
	private final int DELAY = 500;

	private JPanel panelGlobal = new JPanel();
	int i = 0;

	private TableauGUI() {

	}

	public void initWindow() {
		uniteTraitement = Voiture.getInstance().getUniteTraitementNumerique();
		updateString();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panelGlobal.setLayout(new BorderLayout());
		JPanel control = createControlPanel();
		JPanel measure = createMeasurePanel();
		JPanel time = createTimePanel();
		panelGlobal.add(control, BorderLayout.NORTH);
		panelGlobal.add(measure, BorderLayout.CENTER);
		panelGlobal.add(time, BorderLayout.SOUTH);
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

	public JPanel createMeasurePanel() {
		JPanel measurePanel = new JPanel();
		measurePanel.add(text);
		return measurePanel;
	}
	
	public JPanel createTimePanel(){
		JPanel timePanel = new JPanel();
		timePanel.add(timeText);
		return timePanel;
	}

	public static TableauGUI getInstance() {
		if (instance == null) {
			instance = new TableauGUI();
		}
		return instance;
	}

	private synchronized void updateString() {
		new Thread(new Runnable() {
			public void run() {

				while (true) {
					measuresText = "Vitesse instantanée: "
							+ formatString(uniteTraitement.getVitesseInstantanee())
							+ " km/h \n"
							+ "Vitesse moyenne depuis 0: "
							+ formatString( uniteTraitement.getVitesseMoyenneTotal())
							+ " km/h \n"
							+ "Vitesse moyenne depuis RAZ: "
							+ formatString(uniteTraitement.getVitesseMoyenneRAZ())
							+ " km/h \n \n"
							+ "Kilomètrage depuis 0: "
							+ formatString(uniteTraitement.getKilometreTotal())
							+ " km \n"
							+ "Kilomètrage depuis RAZ: "
							+ formatString(uniteTraitement.getKilometreRAZ())
							+ " km \n \n"
							+ "Consommation instantanée: "
							+ formatString(uniteTraitement.getConsomationIntantanee())
							+ " l/100km \n"
							+ "Consommation moyenne depuis 0: "
							+ formatString(uniteTraitement
									.getConsomationMoyenneTotale())
							+ " l/100km \n"
							+ "Consommation moyenne depuis RAZ: "
							+ formatString(uniteTraitement.getConsomationMoyenneRAZ())
							+ " l/100km \n \n" 
							+ "Autonomie: "
							+ formatString(uniteTraitement.getAutonomie()) + " km \n"
							+ "Jauge essence: " + formatString(uniteTraitement.getVolumeEssenceDisponible())
							+ " litres restants";

					text.setText(measuresText);
					
					String timetxt = "Date: " + new Date(java.lang.System.currentTimeMillis()) + "\n"
							+ "Dernière remise à zéro il y a : " + Voiture.getInstance().getGestionTemps().getChronoRAZ()/1000 + " s \n";  
							
					
					timeText.setText(timetxt);
					
					try {
						Thread.sleep(DELAY);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
			

		}).start();

	}

	public String formatString(double n){
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(n);
		
	}
	
	@Override
	public synchronized void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
		case "Start": {
			Voiture.getInstance().start();
			break;
		}
		case "Stop": {
			Voiture.getInstance().stop();
			break;
		}
		case "Reset": {
			Voiture.getInstance().reset();
			break;
		}
		}

	}
}
