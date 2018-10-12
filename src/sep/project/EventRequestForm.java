package sep.project;

public class EventRequestForm extends sep.project.Form {
    public int id;
    private int recNum;
    private String clientName;
    private String eventType;
    private String startDate;
    private String endDate;
    private int expNumAttend;
    private boolean decor;
    private boolean parties;
    private boolean photo;
    private boolean food;
    private boolean drinks;
    private double expBudget;
    public EventRequestForm(int recNum, String clientName, String eventType,
                            String startDate, String endDate, int expNumAttend,
                            boolean decor, boolean parties, boolean photo, boolean food, boolean drinks,
                            double expBudget){
        super("GUISeniorCS", "FinancialManager", "EventRequestForm");

        this.recNum = recNum;
        this.clientName = clientName;
        this.eventType = eventType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.expNumAttend = expNumAttend;
        this.decor = decor;
        this.parties = parties;
        this.photo = photo;
        this.food = food;
        this.drinks = drinks;
        this.expBudget = expBudget;
    }

    public int getRecNum(){
        return recNum;
    }

    @Override
    public String toString() {
        return ("Event #" + recNum);
    }
}
