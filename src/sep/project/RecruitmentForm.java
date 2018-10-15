package sep.project;

/**
 *
 * @author harald
 */
public class RecruitmentForm extends Form {

    String requestor;
    String department;
    String experience;
    String jobTitle;
    String description;
    String contractType;
    String comment;
    boolean approved;

    public RecruitmentForm(String sender, String department, String experience, String jobTitle, String description, String contractType) {
        super(sender, "SeniorHRManager", "RecruitmentForm");
        this.requestor = sender;
        this.department = department;
        this.experience = experience;
        this.jobTitle = jobTitle;
        this.description = description;
        this.contractType = contractType;
    }

    public void view() {
        if (comment.isEmpty()) {
            new GUIViewRecruitmentRequest(this).setVisible(true);
        }
        else{
            new GUICommentRecruitmentRequest(this, true).setVisible(true);
        }
    }

    public boolean isApproved() {
        return approved;
    }

    public boolean isRejected() {
        return !isApproved();
    }
}
