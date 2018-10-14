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
    public int approved;
    
    public FinancialRequestForm(String sender, String requestingDepartment, int projectReference, double amount, String reason){
        super(sender, "FinancialManager", "FinancialRequestForm");
        this.requestingDepartment = requestingDepartment;
        this.projectReference = projectReference;
        this.amount = amount;
        this.reason = reason;    
    }
    
    public void view(){
        GUIViewFinancialRequest gui = new GUIViewFinancialRequest(this);
        gui.setVisible(true);
    }
    
    public void approve(){
        this.approved = 1;
    }
    
    public void reject(){
        this.approved = -1;
    }
}
