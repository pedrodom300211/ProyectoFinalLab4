package Excepciones;

public class CuentaInvalidaException extends RuntimeException{
	
	public CuentaInvalidaException() {
			
		}

	@Override
	public String getMessage() {
		
		return "Cuenta Invalida";
	}
	
	
}
