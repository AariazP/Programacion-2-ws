package aplication;


public class Error extends RuntimeException{

	private String nomError; 
	public Error() {
		super();
	}
	
	public Error(String nomError) {
		super(nomError);
	}
	
	
	public String getNomError() {
		return nomError;
	}

	public void setNomError(String nomError) {
		this.nomError = nomError;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1748740546520683537L;

	
}
