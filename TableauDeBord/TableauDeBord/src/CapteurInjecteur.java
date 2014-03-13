public class CapteurInjecteur {

	private int volumeSeconde = 0;
	private final int DELAY = 100;

	private boolean isDriving = false;

	public CapteurInjecteur() {

	}

	public void setVolumeSeconde(int vs) {
		volumeSeconde = vs;
	}

	public void start() {
		isDriving = true;
		traitement();
	}

	public void stop() {
		isDriving = false;
	}

	public void traitement() {
		new Thread(new Runnable() {
			public void run() {

				while (isDriving) {
					// TODO
					try {
						Thread.sleep(DELAY);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				//TODO reset capteur
			}
		}).start();
	}
}
