package app_files;

public class OperationNotAllowedException extends Exception {

	public OperationNotAllowedException(String errorMessage) {
		super(errorMessage);
	}

}