package exceptionclass.bank2;

public class InvalidAccountNumberBankOperationException extends InvalidBankOperationException{
//    private ErrorCode2 errorCode;

    public InvalidAccountNumberBankOperationException() {
        super(ErrorCode2.INVALID_ACCOUNTNUMBER);
    }
}
