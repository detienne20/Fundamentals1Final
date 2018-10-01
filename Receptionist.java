public class Receptionist extends Employee{
	
	//Both Sales Associates and Receptionists have a minimum task level of 1.
	
	private AssistantRegionalManager supervisor;
	
    public AssistantRegionalManager getSupervisor() {
		return supervisor;
	}


	public void setSupervisor(AssistantRegionalManager supervisor) {
		this.supervisor = supervisor;
	}


	public int getMaxTaskComplexityLevel() {
		return maxTaskComplexityLevel;
	}


	public void setMaxTaskComplexityLevel(int maxTaskComplexityLevel) {
		this.maxTaskComplexityLevel = maxTaskComplexityLevel;
	}


	private int maxTaskComplexityLevel;
	
	Receptionist(int IDNumber, String name, Task[] taskList, AssistantRegionalManager supervisor, int maxTaskComplexityLevel){
		this.supervisor=supervisor; 
		this.maxTaskComplexityLevel=maxTaskComplexityLevel; 
		this.setIDNumber(IDNumber);
		this.setName(name);
		this.setTaskList(taskList);
		
	}
	public String toString(){
		// Maybe put the N's at the beginning ? for the formatting?
		String output="";
		output+=("Receptionist\n"); 
		output+=("Name: "+getName()+"\n"); 
		output+=("ID: "+getIDNumber()+"\n"); 
		output+=("Task List: "+ "\n");
		Task[] task=super.getTaskList(); 
		
		for( int j=0;j<super.getTaskList().length ; j++){
			output +=(task[j].toString() +"\n");
			
		}
		output+=("Assistant Regional Manager: "+getSupervisor().getName()+"\n");
		output+=("Max Task Level: "+getMaxTaskComplexityLevel()); 
		return output;
		
	}
	
	
	//equals method. Do not edit!
	public boolean equals(Receptionist r){
		boolean equal = super.equals(r);
		equal = equal && (r.getSupervisor().equals(supervisor));
		equal = equal && (r.getMaxTaskComplexityLevel() == maxTaskComplexityLevel);
		return equal;
	}
}