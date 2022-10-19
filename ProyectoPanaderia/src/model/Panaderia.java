package model;


public class Panaderia {
	
	private static Runnable hilo1, hilo2; 
	private String pan; 
	private boolean disponible; 
	private Cliente cliente; 
	private Panadero panadero; 
	
	public Panaderia() {
		cliente = new Cliente(); 
		panadero = new Panadero(); 
		cliente.setPanaderia(this);
		panadero.setPanaderia(this);
	}

	
	public void start() {
		hilo1 = getCliente(); 
		hilo2 = getPanadero(); 
		
		Thread h1 = new Thread(hilo1); 
		Thread h2 = new Thread(hilo2);
		
		h2.start();
		h1.start();
		
		try {
			h1.join();
			h2.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		while (true) {
			try {
				System.out.println("Hilo 1: "+h1.getState());
				Thread.sleep(3000);
				System.out.println("Hilo 2: "+h2.getState());
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	
	/**
	 * @return the hilo1
	 */
	public static Runnable getHilo1() {
		return hilo1;
	}

	/**
	 * @param hilo1 the hilo1 to set
	 */
	public static void setHilo1(Runnable hilo1) {
		Panaderia.hilo1 = hilo1;
	}

	/**
	 * @return the hilo2
	 */
	public static Runnable getHilo2() {
		return hilo2;
	}

	/**
	 * @param hilo2 the hilo2 to set
	 */
	public static void setHilo2(Runnable hilo2) {
		Panaderia.hilo2 = hilo2;
	}
	/**
	 * @return the pan
	 */
	public String getPan() {
		return pan;
	}

	/**
	 * @param pan the pan to set
	 */
	public void setPan(String pan) {
		this.pan = pan;
	}

	/**
	 * @return the disponible
	 */
	public boolean isDisponible() {
		return disponible;
	}

	/**
	 * @param disponible the disponible to set
	 */
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the panadero
	 */
	public Panadero getPanadero() {
		return panadero;
	}

	/**
	 * @param panadero the panadero to set
	 */
	public void setPanadero(Panadero panadero) {
		this.panadero = panadero;
	}
	
}
