package exceptionclass.bank2;

public class LowBalanceBankOperationException extends InvalidBankOperationException{
    public LowBalanceBankOperationException() {
        super(ErrorCode2.LOW_BALANCE);
    }
}
