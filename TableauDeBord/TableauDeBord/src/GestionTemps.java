public class GestionTemps {
	private static GestionTemps instance = null;
	private long chronoZero;
	private long chronoRAZ;

	private GestionTemps() {

	}

	public static GestionTemps getIntance() {
		if (instance == null) {
			instance = new GestionTemps();
		}
		return instance;
	}

	public void startChronoZero() {
		chronoZero = java.lang.System.currentTimeMillis();
	}

	public void startChronoRAZ() {
		chronoRAZ = java.lang.System.currentTimeMillis();
	}

	public long getChronoZero() {
		return chronoZero - java.lang.System.currentTimeMillis();
	}

	public long getChronoRAZ() {
		return chronoRAZ - java.lang.System.currentTimeMillis();
	}

}
