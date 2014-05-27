public class GestionTemps {
	private static GestionTemps instance = null;
	private long chronoZero;
	private long chronoRAZ;

	public GestionTemps() {

	}

//	public static GestionTemps getIntance() {
//		if (instance == null) {
//			instance = new GestionTemps();
//		}
//		return instance;
//	}

	public void startChronoZero() {
		chronoZero = java.lang.System.currentTimeMillis();
	}

	public void startChronoRAZ() {
		chronoRAZ = java.lang.System.currentTimeMillis();
	}

	public long getChronoZero() {
		return java.lang.System.currentTimeMillis() - chronoZero;
	}

	public long getChronoRAZ() {
		return java.lang.System.currentTimeMillis() - chronoRAZ;
	}
	
	
}
