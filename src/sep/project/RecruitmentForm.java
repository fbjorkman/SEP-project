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
    
    public RecruitmentForm(String sender, String department, String experience, String jobTitle, String description){
        super(sender, "SeniorHRManager", "RecruitmentForm");
        this.requestor = sender;
        this.department = department;
        this.experience = experience;
        this.jobTitle = jobTitle;
        this.description = description;
    }
}
