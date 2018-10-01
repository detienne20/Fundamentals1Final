public class AssistantRegionalManager extends Employee{
	
	private RegionalManager manager;
	
    public RegionalManager getManager() {
		return manager;
	}



	public void setManager(RegionalManager manager) {
		this.manager = manager;
	}



	public int getMinimumTask() {
		return minimumTask;
	}



	public void setMinimumTask(int minimumTask) {
		this.minimumTask = minimumTask;
	}



	private int minimumTask;  //Note: this cannot be higher than its regional manger

    AssistantRegionalManager(int IDNumber, String name, Task[] taskList, RegionalManager manager, int minimumTask){
    	this.manager=manager; 
    	this.minimumTask=minimumTask; 
    	super.setIDNumber(IDNumber);
    	super.setName(name);
    	super.setTaskList(taskList);
    }
    public String toString(){
    	String output=""; 
    	output+=("Assistant Regional Manager"+"\n"); 
    	output+=("Name: "+getName()+"\n"); 
    	output+=("ID: "+getIDNumber()+"\n"); 
    	output+=("Task List: /n");
    	Task[] task=super.getTaskList();
    	
		for( int j=0;j<super.getTaskList().length ; j++){
    			output +=(task[j].toString() +"\n");
		}
    	output+=("Regional Manager: "+getManager().getName()+"\n"); 
    	output+=("Minimum Task Level: "+getMinimumTask());
    	return output;
    	}
 
	
	//equals method. Do not edit!
	public boolean equals(AssistantRegionalManager r){
		boolean equal = super.equals(r);
		equal = equal && (r.getMinimumTask() == minimumTask);
		equal = equal && (r.getManager().equals(manager));
		return equal;
	}
}