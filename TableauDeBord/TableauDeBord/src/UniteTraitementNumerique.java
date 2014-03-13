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

	public UniteTraitementNumerique() {

	}

	private void calculVitesseMoyenneRAZ() {
		vitesseMoyenneRAZ = kilometreRAZ
				/ (GestionTemps.getIntance().getChronoRAZ() / (1000 * 3600));
	}

	private void calculVitesseMoyenneTotale() {
		vitesseMoyenneTotal = kilometreTotal
				/ (GestionTemps.getIntance().getChronoZero() / (1000 * 3600));
	}

	private void calculConsoMoy() {
	}

	private void calculAutonomie() {

	}

}
