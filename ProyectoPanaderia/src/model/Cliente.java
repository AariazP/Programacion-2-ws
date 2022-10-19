package model;

public class Cliente implements Runnable{

	private Panaderia panaderia; 
	
	public Cliente() {
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
		while(true) {
			consumir();
			System.out.println("Run");
		}
	}
	
	public synchronized String consumir() {
		while(!panaderia.isDisponible()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		
		System.out.println("Cliente se come el pan: " + panaderia.getPan());
		panaderia.setDisponible(false);
		Panaderia.getHilo2().notify(); 
		return panaderia.getPan(); 
	}

}
