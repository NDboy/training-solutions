package exceptionclass.bank2;

public class InvalidAmountBankOperationException extends InvalidBankOperationException{

    public InvalidAmountBankOperationException() {
        super(ErrorCode2.INVALID_AMOUNT);
    }
}
