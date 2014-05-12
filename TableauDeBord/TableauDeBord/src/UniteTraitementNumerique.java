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
				while (true) {
					calculVitesseInstantanee();
					calculAutonomie();
					calculConsoMoyRAZ();
					calculConsoInstantanee();
					calculConsoMoyTotal();
					calculeKilometrageRAZ();
					calculeKilometrageTotal();
					calculVitesseMoyenneRAZ();
					calculVitesseMoyenneTotale();
					try {
						Thread.sleep(DELAY);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	private void calculVitesseInstantanee() {
		vitesseInstantanee = instanceVoiture.getCapteurEffetHall().getVitesse();
	}

	private void calculVitesseMoyenneRAZ() {
		vitesseMoyenneRAZ = kilometreRAZ
				/ (instanceVoiture.getGestionTemps().getChronoRAZ() / (1000 * 3600));
	}

	private void calculVitesseMoyenneTotale() {
		vitesseMoyenneTotal = kilometreTotal
				/ (instanceVoiture.getGestionTemps().getChronoZero() / (1000 * 3600));
	}

	private void calculeKilometrageRAZ() {
		kilometreRAZ = instanceVoiture.getCapteurEffetHall().getPulsesInDelay()
				* 2 * Math.PI * instanceVoiture.getRayon()
				* instanceVoiture.getGestionTemps().getChronoRAZ()
				* instanceVoiture.getCapteurEffetHall().getDelay();
	}

	private void calculeKilometrageTotal() {
		kilometreTotal = instanceVoiture.getCapteurEffetHall().getPulsesInDelay()
				* 2 * Math.PI * instanceVoiture.getRayon()
				* instanceVoiture.getGestionTemps().getChronoZero()
				* instanceVoiture.getCapteurEffetHall().getDelay();

	}

	private void calculConsoMoyTotal() {
		consomationMoyenneTotale = instanceVoiture.getCapteurInjecteur().getVolumeInjecte() / (vitesseMoyenneTotal * 1000*3600);
	}
	private void calculConsoInstantanee() {

		consomationIntantanee = instanceVoiture.getCapteurInjecteur().getVolumeInjecte() / (vitesseInstantanee * 1000*3600);
	}
	private void calculConsoMoyRAZ() {

		consomationMoyenneRAZ = instanceVoiture.getCapteurInjecteur().getVolumeInjecte() / (vitesseMoyenneRAZ * 1000*3600);
	}

	private void calculAutonomie() {
		autonomie = consomationIntantanee / instanceVoiture.getCapteurJaugeEssence().getVolume();
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
