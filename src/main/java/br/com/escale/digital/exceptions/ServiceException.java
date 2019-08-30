package br.com.escale.digital.exceptions;

import br.com.escale.digital.constants.Codigos;
import br.com.escale.digital.constants.ErrorMessages;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -6239592806146419000L;
	
	private final String errorCode;

	/**
	 * 
	 * ServiceException's constructor
	 *
	 * @param message
	 * @param cause
	 */
	public ServiceException(String message, Throwable cause, ErrorMessages errorCode) {
		super(message, cause);
		this.errorCode = errorCode.getErro();
	}
	
	public ServiceException(String message, ErrorMessages errorCode) {
		super(message);
		this.errorCode = errorCode.getErro();
	}
	
	public ServiceException(ErrorMessages message, Codigos errorCode) {
		super(message.getErro());
		this.errorCode = errorCode.getCodigo().toString();
	}
	
	/**
	 * 
	 * ServiceException's constructor
	 *
	 * @param e
	 */
	public ServiceException(ServiceException e) {
		super(e.getMessage(), e.getCause());
		this.errorCode = e.getErrorCode();
		this.setStackTrace(e.getStackTrace());
	}

	/**
	 * 
	 * ServiceException's constructor
	 *
	 * @param errorCode
	 */
	public ServiceException(ErrorMessages errorCode) {
		super();
		this.errorCode = errorCode.getErro();
	}
	
	/**
	 * 
	 * ServiceException's constructor
	 *
	 * @param cause
	 */
	public ServiceException(Throwable cause, ErrorMessages errorCode) {
		super(cause);
		this.errorCode = errorCode.getErro();
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	
}
