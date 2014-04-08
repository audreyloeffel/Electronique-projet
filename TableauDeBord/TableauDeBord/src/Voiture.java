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
			instance = new Voiture();
			System.out.println("instance voiture créée--------------------------------------------------------------");
			System.out.println("instance voiture = " + instance.toString());
		}

		return instance;
	}

	private Voiture() {
		gestionTemps = new GestionTemps();
		System.out.println("gestionTemps crée");
		uniteTraitement = new UniteTraitementNumerique();
		System.out.println("unité traitement créee");
		interfaceGraphique = TableauGUI.getInstance();
		System.out.println("GUI créée");
		capteurHall = new CapteurEffetHall();
		capteurInjecteur = new CapteurInjecteur();
		capteurEssence = new CapteurJaugeEssence();
		System.out.println("Capteurs crées");

	}

	public void start() {
		isDriving = true;
		capteurInjecteur.start();
		capteurHall.start();
		capteurEssence.start();
		System.out.println("tous les capteurs lancés");
	}

	public void stop() {
		isDriving = true;
		capteurInjecteur.stop();
		capteurEssence.stop();
		capteurHall.stop();
		System.out.println("tous les capteurs stopés");
	}

	public static void main(String[] args) {
		Voiture.getInstance();
		interfaceGraphique.initWindow();
	}

	public void setDriving(boolean state) {
		isDriving = state;
	}

	public boolean isDriving() {
		return isDriving;
	}

	public double getRayon() {
		return RAYON;
	}

	public UniteTraitementNumerique getUniteTraitementNumerirque() {
		return uniteTraitement;
	}
	
	public GestionTemps getGestionTemps(){
		return gestionTemps;
	}

}
