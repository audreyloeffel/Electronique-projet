import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private String measuresText = "";
	private UniteTraitementNumerique uniteTraitement = null;
	private final int DELAY = 500;
	private double nbTourTotal = 0;
	private double nbTourRaz = 0;

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

	public JPanel createMeasurePanel() {
		JPanel measurePanel = new JPanel();
		// text = new JTextArea(measuresText);
		measurePanel.add(text);
		return measurePanel;
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
							+ (int) uniteTraitement.getVitesseInstantanee()
							+ " km/h \n"
							+ "Vitesse moyenne depuis 0: "
							+ (int) uniteTraitement.getVitesseMoyenneTotal()
							+ " km/h \n"
							+ "Vitesse moyenne depuis RAZ: "
							+ (int) uniteTraitement.getVitesseMoyenneRAZ()
							+ " km/h \n"
							+ "Kilomètrage depuis 0: "
							+ uniteTraitement.getKilometreTotal()
							+ " km \n"
							+ "Kilomètrage depuis RAZ: "
							+ uniteTraitement.getKilometreRAZ()
							+ " km \n"
							+ "Consommation instantanée: "
							+ (int) uniteTraitement.getConsomationIntantanee()
							+ " l/100km \n"
							+ "Consommation moyenne depuis 0: "
							+ (int) uniteTraitement
									.getConsomationMoyenneTotale()
							+ " l/100km \n"
							+ "Consommation moyenne depuis RAZ: "
							+ (int) uniteTraitement.getConsomationMoyenneRAZ()
							+ " l/100km \n" + "Autonomie: "
							+ (int) uniteTraitement.getAutonomie() + " km \n"
							+ "..." + i;

					text.setText(measuresText);
					// System.out.println(i);
					// i++;

					try {
						Thread.sleep(DELAY);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
			// TODO reset capteur

		}).start();

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
