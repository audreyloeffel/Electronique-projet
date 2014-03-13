public class Voiture {
	private final double RAYON = 0.3;
	private final double VOLUMERESERVOIRE = 70; 
	
	private static GestionTemps gestionTemps;
	private static TableauGUI interfaceGraphique;
	private static UniteTraitementNumerique uniteTraitement;
	private static CapteurEffetHall capteurHall;
	private static CapteurInjecteur capteurInjecteur;
	private static CapteurJaugeEssence capteurEssence;
	private static Voiture instance = null;
	private static boolean isDriving = false;

	public static Voiture getInstance() {
		if (instance == null) {
			synchronized (Voiture.class) {
				if (instance == null) {
					instance = new Voiture();
					System.out.println("instance voiture cr��e");
				}
			}
		}
		return instance;
	}
	
	private Voiture(){
		interfaceGraphique = TableauGUI.getInstance();
		System.out.println("GUI cr��e");
		capteurHall = new CapteurEffetHall();
		capteurInjecteur = new CapteurInjecteur();
		capteurEssence = new CapteurJaugeEssence();
		System.out.println("Capteurs cr�es");
		gestionTemps = GestionTemps.getIntance();
		System.out.println("gestionTemps lanc�");
		uniteTraitement = new UniteTraitementNumerique();
		System.out.println("unit� traitement cr�ee");
	}

	public void start(){
		isDriving = true;
		capteurInjecteur.start();
		capteurHall.start();
		capteurEssence.start();
		System.out.println("tous les capteurs lanc�s");
	}
	
	public void stop(){
		isDriving = true;
		capteurInjecteur.stop();
		capteurEssence.stop();
		capteurHall.stop();
		System.out.println("tous les capteurs stop�s");
	}
	
	public static void main(String[] args) {
		Voiture.getInstance();
	}

	public void setDriving(boolean state){
		isDriving = state;
	}
	
	public boolean isDriving(){
		return isDriving;
	}
}
