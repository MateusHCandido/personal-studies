package interfaces.project01.model.service;

public class PaypalService implements OnlinePaymentService{

    private static double INTEREST_PER_INSTALLMENT = 0.01;
    private static double PAYMENT_RATE = 0.02;

    public PaypalService() {
    }

    @Override
    public Double paymentFee(Double amount) {
        return  amount * PAYMENT_RATE;
    }

    @Override
    public Double interest(Double amount, Integer months) {
        return amount * INTEREST_PER_INSTALLMENT * months;
    }


    public static Double getInterestPerInstallment() {
        return INTEREST_PER_INSTALLMENT;
    }

    public static void setInterestPerInstallment(Double interestPerInstallment) {
        INTEREST_PER_INSTALLMENT = interestPerInstallment;
    }

    public static Double getPaymentRate() {
        return PAYMENT_RATE;
    }

    public static void setPaymentRate(Double paymentRate) {
        PAYMENT_RATE = paymentRate;
    }
}
