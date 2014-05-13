public class CapteurEffetHall {

	private double vitesse = 0;
	private double x = 0;
	private final int DELAY = 100;
	private final int VITESSEMAX = 120;
	private boolean isDriving = false;
	private long pulsesInDelay = 0;

	public CapteurEffetHall() {
		
	}

	public void start() {
		isDriving = true;
		traitement();
	}

	public void stop() {
		isDriving = false;
	}

	public double getVitesse(){
		return vitesse;
	}
	public long getPulsesInDelay(){
		return pulsesInDelay;
	}
	
	public int getDelay(){
		return DELAY;
	}
	
	
	private void traitement() {
		new Thread(new Runnable() {
			public void run() {
				while (isDriving) {
					vitesse = Math.abs(Math.sin(x)) * VITESSEMAX;
					x = x + 0.01;
					try {
						Thread.sleep(DELAY);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				vitesse = 0;
				x = 0;
			}
		}).start();

	}
}
