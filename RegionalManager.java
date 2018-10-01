public class RegionalManager extends Employee {
	
	// TWO. To String Method needs work. 
	
	private int RegionNum;
    public int getRegionNum() {
		return RegionNum;
	}

	public void setRegionNum(int regionNum) {
		RegionNum = regionNum;
	}

	public Employee[] getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(Employee[] subordinates) {
		this.subordinates = subordinates;
	}

	public int getMinimumTask() {
		return minimumTask;
	}

	public void setMinimumTask(int minimumTask) {
		this.minimumTask = minimumTask;
	}

	private Employee[] subordinates;
    private int minimumTask;
    
 
    RegionalManager(int IDNumber, String name, Task[] taskList, int RegionNum, Employee[] subordinates, int minimumTask){
    	super (IDNumber,name, taskList);
    	this.RegionNum=RegionNum; 
    	this.subordinates=subordinates; 
    	this.minimumTask=minimumTask; 
    }
    RegionalManager(int IDNumber, String name, Task[] taskList, int RegionNum, int minimumTask){
    //Note: Does not take an Employee array
    	super(IDNumber,name,taskList); 
    	this.RegionNum=RegionNum; 
    	this.minimumTask=minimumTask; 
    }
    
    public String toString(){
    	
    	String output="";
    	output+="Regional Manager"+"/n"; 
    	output+=("Name: "+getName()+"\n");
    	output+=("ID: "+getIDNumber()+"\n");
    	output+=("Task List: /n");
    	Task[] task=super.getTaskList(); 
		
		for( int j=0;j<super.getTaskList().length ; j++){
    			output +=(task[j].toString() +"\n");
			
		}
    	
    	output+=("Region Number: "+getRegionNum()+"\n");
    	output+=("Minimum Task Level: "+getMinimumTask()+"\n");
    	output+=("Employees: \n");
    	
    	for (int i=0;i<subordinates.length ; i++){
    		if (i==subordinates.length-1){	
    			output+=subordinates[i].toString();
    		}
    		else{
    			output+=subordinates[i].toString()+"\n"; 	
    		}
    	}
    	return output;
    	
    	}
    
	
	//equals method. Do not edit!
	public boolean equals(RegionalManager r){
		boolean equal = super.equals(r);
		equal = equal && (r.getRegionNum() == RegionNum);
		equal = equal && (r.getMinimumTask() == minimumTask);
		for(int i = 0; i < subordinates.length; i++){
			equal = equal && (subordinates[i].equals(r.getSubordinates()[i]));
		}
		return equal;
	}
}