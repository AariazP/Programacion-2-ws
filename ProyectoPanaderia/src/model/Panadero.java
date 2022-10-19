package model;

public class Panadero implements Runnable{

	private Panaderia panaderia; 
	
	
	public Panadero() {
	}

	/**
	 * @return the panaderia
	 */
	public Panaderia getPanaderia() {
		return panaderia;
	}
	/**
	 * @param panaderia the panaderia to set
	 */
	public void setPanaderia(Panaderia panaderia) {
		this.panaderia = panaderia;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			hornear("Pan numero "+i);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void hornear(String masa) {
		while(panaderia.isDisponible()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		panaderia.setPan(masa);; 
		System.out.println("Panadero hornea: "+panaderia.getPan());
		panaderia.setDisponible(true);
		Panaderia.getHilo1().notify();
	}
	
	
}
