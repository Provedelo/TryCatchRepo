package model.exceptions;

public class DomainException extends RuntimeException { //Com RuntimeException n necessita de add throws exceptions nos metodos do reservations
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) { //Pode instanciar o DomainException e permite adicionar uma mensagem
		super(msg); //permite instanciar a mensagem
	}

}
