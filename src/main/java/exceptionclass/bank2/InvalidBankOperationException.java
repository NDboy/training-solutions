package exceptionclass.bank2;

import exceptionclass.bank.ErrorCode;

public class InvalidBankOperationException extends RuntimeException{
    private ErrorCode2 errorCode;

    public InvalidBankOperationException(ErrorCode2 errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public ErrorCode2 getErrorCode() {
        return errorCode;
    }
}
