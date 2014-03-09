


public class GestionTemps {
	private static GestionTemps instance = null;
	private long depart = 0;
	private long RAZ = 0;
	private long dateActuelle = 0;
	private long chrono = 0;
	
	private GestionTemps(){
		long chrono = java.lang.System.currentTimeMillis();
	}
	
	public static GestionTemps getIntance(){
		if (instance == null) {
			instance = new GestionTemps();
		}
		return instance;
	}
	
	public long getDepart() {
		return depart;
	}

	public long getRAZ() {
		return RAZ;
	}

	public long getDateActuelle() {
		return dateActuelle;
	}

	public long getChrono() {
		return chrono;
	}
	public long getTempsParcours(){
		return java.lang.System.currentTimeMillis() - chrono;
	}
}
