package sep.project;

/**
 *
 * @author harald
 */
public class FinancialRequestForm extends Form {
    public String requestingDepartment;
    public int projectReference;   // event id
    public double amount;
    public String reason;
    public boolean approved;
    
    public FinancialRequestForm(String sender, String requestingDepartment, int projectReference, double amount, String reason){
        super(sender, "FinancialManager", "FinancialRequestForm");
        this.requestingDepartment = requestingDepartment;
        this.projectReference = projectReference;
        this.amount = amount;
        this.reason = reason;    
    }
    
    public void replyToRequest(String receiver, boolean decision){
        super.receiver = receiver;
        approved = decision;
    }
}
