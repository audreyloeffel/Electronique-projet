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

	public UniteTraitementNumerique() {
	
	}

	public void startTraitement(){
		if(!isRunning){
			traitement();
			isRunning = true;
			System.out.println("traitement lancé");
		}
	}
	
	private void traitement(){
		new Thread(new Runnable() {
			public void run() {

				while (true) {
					calculVitesseInstantanee();
					calculAutonomie();
					calculConsoMoy();
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
			}}).start();
	}
	
	private void calculVitesseInstantanee(){
		vitesseInstantanee = Voiture.getInstance().getCapteurEffetHall().getVitesse();
	}
	
	private void calculVitesseMoyenneRAZ() {
		vitesseMoyenneRAZ = kilometreRAZ
				/ (Voiture.getInstance().getGestionTemps().getChronoRAZ() / (1000 * 3600));
	}

	private void calculVitesseMoyenneTotale() {
		vitesseMoyenneTotal = kilometreTotal
				/ (Voiture.getInstance().getGestionTemps().getChronoZero() / (1000 * 3600));
	}

	private void calculeKilometrageRAZ() {

	}

	private void calculeKilometrageTotal() {

	}

	private void calculConsoMoy() {
	}

	private void calculAutonomie() {

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
