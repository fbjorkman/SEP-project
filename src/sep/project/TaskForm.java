package sep.project;

/**
 *
 * @author harald
 */
public class TaskForm extends Form{
    public int projectReference;
    public String manager;
    public String assignTo;
    public String description;
    public String priority;
    public double budget;
  
    
    public TaskForm(String sender, String assignTo, int projectReference, String description, String priority, double budget){
        super(sender, assignTo, "TaskForm");
        this.manager = sender;
        this.projectReference = projectReference;
        this.description = description;
        this.assignTo = assignTo;
        this.priority = priority;
        this.budget = budget;
    }
    
    public void view(){
        GUIViewTaskForm gui = new GUIViewTaskForm(this);
        gui.setVisible(true);
    }
    
}
