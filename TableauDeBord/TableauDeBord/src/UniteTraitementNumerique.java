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
	private long nbTourTotal = 0;
	private long nbTourRaz = 0;
	private final int DELAY = 500;
	private boolean isRunning = false;
	private Voiture instanceVoiture = null;

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

		// --- VITESSES ---
		vitesseInstantanee = instanceVoiture.getCapteurEffetHall().getVitesse();

		vitesseMoyenneRAZ = kilometreRAZ
				/ (instanceVoiture.getGestionTemps().getChronoRAZ() / (1000 * 3600));

		vitesseMoyenneRAZ = kilometreRAZ
				/ (instanceVoiture.getGestionTemps().getChronoRAZ() / (1000 * 3600));

		// --- KILOMETRAGE ---

		kilometreRAZ = kilometreRAZ + ((double) DELAY) / 3600000
				* vitesseInstantanee;

		kilometreTotal = kilometreTotal + ((double) DELAY) / 3600000
				* vitesseInstantanee;

		// --- CONSOMMATION ---

		consomationMoyenneTotale = instanceVoiture.getCapteurInjecteur()
				.getVolumeInjecte() / (vitesseMoyenneTotal * 1000 * 3600);

		consomationIntantanee = instanceVoiture.getCapteurInjecteur()
				.getVolumeInjecte() / (vitesseInstantanee * 1000 * 3600);

		consomationMoyenneRAZ = instanceVoiture.getCapteurInjecteur()
				.getVolumeInjecte() / (vitesseMoyenneRAZ * 1000 * 3600);

		// --- AUTONOMIE ---

		autonomie = consomationIntantanee
				/ instanceVoiture.getCapteurJaugeEssence().getVolume();

	}

	public synchronized void reset(){
		vitesseMoyenneRAZ = 0;
		consomationMoyenneRAZ = 0;
		kilometreRAZ = 0;
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
