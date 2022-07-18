package interfaces.project01.model.service;

import interfaces.project01.model.entities.Contract;
import interfaces.project01.model.entities.Installment;

import java.util.Calendar;
import java.util.Date;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months){
        double basicQuota = contract.getTotalValue() / months;
        for (int month = 1; month < months+1; month++){
            double updateQuota = basicQuota + onlinePaymentService.interest(basicQuota, month);
            double fullQuota = updateQuota + onlinePaymentService.paymentFee(updateQuota);
            Date dueDate = addMonths(contract.getDate(), month);
            contract.getInstallments().add(new Installment(dueDate, fullQuota));
        }
    }

    //FUNCTION TO ADD MONTHS TO A DATE
    private Date addMonths(Date date, int quantity){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, quantity);
        return calendar.getTime();
    }
}
