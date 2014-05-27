public class CapteurInjecteur {

	private double volumeSeconde = 0;
	private final int DELAY = 100;
	private double x = 0;

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
					volumeSeconde = 1*Math.abs(Math.sin(x))+1;
					try {
						Thread.sleep(DELAY);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					x = x + 0.02;
					System.out.println("x: " + x);
				}
				volumeSeconde = 0;
				x = 0;
			}
		}).start();
	}

	public double getVolumeInjecte() {
		return volumeSeconde;
	}

}
