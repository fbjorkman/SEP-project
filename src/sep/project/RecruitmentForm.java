package sep.project;

/**
 *
 * @author harald
 */
public class RecruitmentForm extends Form{
    String requestor;
    String department;
    String experience;
    String jobTitle;
    String description;
    String contractType;
    
    public RecruitmentForm(String sender, String department, String experience, String jobTitle, String description, String contractType){
        super(sender, "SeniorHRManager", "RecruitmentForm");
        this.requestor = sender;
        this.department = department;
        this.experience = experience;
        this.jobTitle = jobTitle;
        this.description = description;
        this.contractType = contractType;
    }
    
    public void view(){
       new GUIViewRecruitmentRequest(this).setVisible(true); 
    }
}
