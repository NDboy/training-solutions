package exceptionclass.bank;

public class InvalidBankOperationException extends RuntimeException{
    private ErrorCode errorCode;

    public InvalidBankOperationException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
