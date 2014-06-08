
public class UniteTraitementNumerique {
	private double vitesseInstantanee = 0;
	private double vitesseMoyenneRAZ = 0;
	private double vitesseMoyenneTotal = 0;
	private double kilometreRAZ = 0;
	private double kilometreTotal = 0;
	private double consomationIntantanee = 0;
	private double consomationMoyenneRAZ = 0;
	private double consomationMoyenneTotale = 0;
	private double volumeEssenceDisponible = 0;
	private double autonomie = 0;
	private double distTotale = 0;
	private double distParcourt = 0;
	private final int DELAY = 100;
	private boolean isRunning = false;
	private Voiture instanceVoiture = null;
	private double totalEssence = 0;
	private double totalRaz = 0;

	public UniteTraitementNumerique() {

	}

	public void startTraitement() {
		if (!isRunning) {
			traitement();
			isRunning = true;
			System.out.println("traitement lancé");
		}
	}

	private void traitement() {
		new Thread(new Runnable() {
			public void run() {
				instanceVoiture = Voiture.getInstance();
				while (isRunning) {
					calcul();
					try {
						Thread.sleep(DELAY);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	private void calcul() {

		// --- VITESSES en km/h ---
		vitesseInstantanee = instanceVoiture.getCapteurEffetHall().getVitesse();

		vitesseMoyenneTotal = kilometreTotal * (3600000)
				/ (instanceVoiture.getGestionTemps().getChronoZero());

		vitesseMoyenneRAZ = kilometreRAZ * (3600000)
				/ (instanceVoiture.getGestionTemps().getChronoRAZ());

		// --- KILOMETRAGE en km ---

		kilometreRAZ = kilometreRAZ + ((double) DELAY) / 3600000
				* vitesseInstantanee;

		kilometreTotal = kilometreTotal + ((double) DELAY) / 3600000
				* vitesseInstantanee;

		// --- CONSOMMATION en L/100km ---
		
		double essenceConsommee = instanceVoiture.getCapteurInjecteur().getVolumeInjecte()
				* DELAY / 1000000;	
		totalEssence = totalEssence + essenceConsommee ;
		totalRaz = totalRaz + essenceConsommee; 
		

		consomationMoyenneTotale = 100 * totalEssence / kilometreTotal;		

		consomationMoyenneRAZ = 100 * totalRaz / kilometreRAZ;

		consomationIntantanee = 360* instanceVoiture.getCapteurInjecteur().getVolumeInjecte()/(vitesseInstantanee);
				

		// --- JAUGE ESSENCE ---
		
		volumeEssenceDisponible = instanceVoiture.getCapteurJaugeEssence().getVolume();
		
		// --- AUTONOMIE en h ---

		autonomie = 100* volumeEssenceDisponible /  consomationIntantanee;

	
		
	}
	
	

	public synchronized void reset() {
		vitesseMoyenneRAZ = 0;
		consomationMoyenneRAZ = 0;
		kilometreRAZ = 0;
		totalRaz = 0;
	}

	public synchronized double getVitesseInstantanee() {
		return vitesseInstantanee;
	}

	public synchronized double getVitesseMoyenneRAZ() {
		return vitesseMoyenneRAZ;
	}

	public synchronized double getVitesseMoyenneTotal() {
		return vitesseMoyenneTotal;
	}

	public synchronized double getKilometreRAZ() {
		return kilometreRAZ;
	}

	public synchronized double getKilometreTotal() {
		return kilometreTotal;
	}

	public synchronized double getConsomationIntantanee() {
		return consomationIntantanee;
	}

	public synchronized double getConsomationMoyenneRAZ() {
		return consomationMoyenneRAZ;
	}

	public synchronized double getConsomationMoyenneTotale() {
		return consomationMoyenneTotale;
	}

	public synchronized double getVolumeEssenceDisponible() {
		return volumeEssenceDisponible;
	}

	public synchronized double getAutonomie() {
		return autonomie;
	}

	public synchronized double getDistTotale() {
		return distTotale;
	}

	public synchronized double getDistParcourt() {
		return distParcourt;
	}

}
