
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
	
	private void calculVitesseMoyenne(){ // attention au valeurs!!!!
		vitesseMoyenneRAZ = distParcourt;///chronoParcourt;
		vitesseMoyenneTotal = distTotale;///crhonovoiture
	}
	
	private void calculConsoMoy(){
		consomationMoyenneRAZ = 1;
		consomationMoyenneTotale = 1;
	}
	
	private void calculAutonomie(){ 
		autonomie = 1;
	}
	
	
}
