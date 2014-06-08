public class CapteurJaugeEssence {
	private double volume = 0;
	private final int DELAY = 100;
	private boolean isDriving = false;

	public CapteurJaugeEssence() {

	}

	public void setVolume(int vol) {
		volume = vol;
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

				volume = Voiture.getInstance().getVolumeEssence();
				while (isDriving) {
					volume = volume - 0.001;
					if (volume < 10) {
						volume = Voiture.getInstance().getVolumeEssence();
						System.out.println("Plein effectué");
					}
					try {
						Thread.sleep(DELAY);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
		volume = (int) Voiture.getInstance().getVolumeEssence();
			}
		}).start();
	}
	
	public synchronized double getVolume(){
		return volume;
	}
}
