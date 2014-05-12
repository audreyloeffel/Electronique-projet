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
		}

		return instance;
	}

	private Voiture() {
		gestionTemps = new GestionTemps();
		System.out.println("gestionTemps cr�e");
		uniteTraitement = new UniteTraitementNumerique();
		System.out.println("unit� traitement cr�ee");
		interfaceGraphique = TableauGUI.getInstance();
		System.out.println("GUI cr��e");
		capteurHall = new CapteurEffetHall();
		capteurInjecteur = new CapteurInjecteur();
		capteurEssence = new CapteurJaugeEssence();

		uniteTraitement.startTraitement();
		System.out.println("Capteurs cr�es");

	}

	public void start() {
		if (!isDriving) {
			capteurInjecteur.start();
			capteurHall.start();
			capteurEssence.start();
			System.out.println("--- d�marrage de la voiture ---");
		}

		isDriving = true;

	}

	public void stop() {
		isDriving = false;
		capteurInjecteur.stop();
		capteurEssence.stop();
		capteurHall.stop();
		System.out.println("--- Arr�t de la voiture ---");
	}

	public void reset() {
		System.out.println("--- Remise � z�ro ---");
		gestionTemps.startChronoRAZ();
		
		
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

	public GestionTemps getGestionTemps() {
		return gestionTemps;
	}
	public CapteurEffetHall getCapteurEffetHall(){
		return capteurHall;
	}

}
