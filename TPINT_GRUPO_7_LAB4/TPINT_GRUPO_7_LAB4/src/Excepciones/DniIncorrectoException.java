package Excepciones;

public class DniIncorrectoException extends RuntimeException  {
	
	public DniIncorrectoException() {
		
	}

	@Override
	public String getMessage() {
		
		return "Dni Incorrecto";
	}
	
	

}
