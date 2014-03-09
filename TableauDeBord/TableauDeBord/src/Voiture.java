
public class Voiture {
	private final double rayonRoue = 0.3;
	private final double volumeReservoir = 70; //en litre
	private boolean depart0 = false;

	private static GestionTemps gestionTemps;
	private static TableauGUI interfaceGraphique;
	private static UniteTraitementNumerique uniteTraitement;
	
	//private boolean depart = false; ou c'est qu'on la met
	
	public static void main(String[] args){
		gestionTemps = GestionTemps.getIntance();
		interfaceGraphique = TableauGUI.getInstance();
		uniteTraitement = new UniteTraitementNumerique();
	}

}
