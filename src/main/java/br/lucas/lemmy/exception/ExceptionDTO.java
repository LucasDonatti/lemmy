package br.lucas.lemmy.exception;

public class ExceptionDTO {
	private String exceptionType;
	private String msg;
	
	public ExceptionDTO() {
	}
	
	public ExceptionDTO(String exceptionType, String msg) {
		super();
		this.exceptionType = exceptionType;
		this.msg = msg;
	}
	
	public String getExceptionType() {
		return exceptionType;
	}
	public void setExceptionType(String exceptionType) {
		this.exceptionType = exceptionType;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
