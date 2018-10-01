
public abstract class Employee {	
	// First class worked on. 
	
	
	    
	private int IDNumber;
	private String name;
    private Task[] taskList;
    
    public Employee(){
		// Explicitly calling default constructor. Required any time the parent class lacks a no
		//argument constructor. 
	    	
    }
    Employee(int IDNumber, String name, Task[] taskList){
    	this.IDNumber=IDNumber; 
    	this.name= name;
    	this.taskList=taskList; 
    }
    public int getIDNumber() {
		return IDNumber;
	}


	public void setIDNumber(int newiDNumber) {
		IDNumber = newiDNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Task[] getTaskList() {
		return taskList;
	}


	public void setTaskList(Task[] newTaskList) {
		taskList=newTaskList;  
	}



    
    	
public String toString(){
	String output=""; 
	output+=("Name: "+ name +"\n"); 
	output+=("ID: "+IDNumber+"\n"); 
	output+=("Task List: \n");
	for( int j=0;j<taskList.length ; j++){
		output+=("\t"+"Task: "+taskList[j].getName() +"\t"+"Level: "+taskList[j].getLevel());
		if (j==(getTaskList().length-1)){
		}
		else{
			output+=("\n");
		}
	}
	return output;
	}
	
	//equals method. Do not edit!
	public boolean equals(Employee e){
		boolean equal = true;
		equal = equal && (e.getIDNumber() == IDNumber);
		equal = equal && (e.getName().equals(name));
		for(int i = 0; i < taskList.length; i++){
			equal = equal && (taskList[i].equals(e.getTaskList()[i])); 
		}
		return equal;
	}
}