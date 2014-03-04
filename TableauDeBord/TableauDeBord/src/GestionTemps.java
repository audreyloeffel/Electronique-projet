import java.util.Date;



public class GestionTemps {
	private static GestionTemps instance = null;
	private Date depart = null;
	private Date RAZ = null;
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
	
	public Date getDepart() {
		return depart;
	}

	public Date getRAZ() {
		return RAZ;
	}

	public Date getDateActuelle() {
		return dateActuelle;
	}

	public Date getChrono() {
		return chrono;
	}
	public long getTempsParcours(){
		return java.lang.System.currentTimeMillis() - chrono;
	}
}
