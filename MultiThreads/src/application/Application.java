package application;


import model.MultiThread;

public class Application {

	public static void main(String[] args) {
		
		
		for (int i = 0; i < 5; i++) {
			Long t1 = System.currentTimeMillis(); 
			Thread myThread = new Thread(new MultiThread()); 
			myThread.start();
			Long t2 = System.currentTimeMillis(); 
			System.out.println((t2-t1)+" Segundos");
			try {
				myThread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
