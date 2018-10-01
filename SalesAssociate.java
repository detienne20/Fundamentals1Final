public class SalesAssociate extends Employee{
	
	//Both Sales Associates and Receptionists have a minimum task level of 1.
	
	private int numClients;
    public int getNumClients() {
		return numClients;
	}



	public void setNumClients(int numClients) {
		this.numClients = numClients;
	}



	public String[] getProducts() {
		return products;
	}



	public void setProducts(String[] products) {
		this.products = products;
	}



	public RegionalManager getSupervisor() {
		return supervisor;
	}



	public void setSupervisor(RegionalManager supervisor) {
		this.supervisor = supervisor;
	}



	private String[] products;
    private RegionalManager supervisor;
 
	
    SalesAssociate(int IDNumber, String name, Task[] taskList, int numClients, String[] products, RegionalManager supervisor){
    	super.setIDNumber(IDNumber);
    	super.setName(name);
    	super.setTaskList(taskList);
    	this.numClients=numClients; 
    	this.products= products; 
    	this.supervisor= supervisor; 
    	
    }
    
    public String toString(){
    	String output=""; 
    	output+=("Sales Associate"+"\n");
    	output+=("Name: "+getName()+"\n");
    	output+=("ID: "+getIDNumber()+"\n");
    	output+=("Task List: \n");
    	Task[] task=super.getTaskList(); 
    	
    	for( int j=0;j<super.getTaskList().length ; j++){
			output +=(task[j].toString() +"\n");
			
		}
    	output+=("Regional Manager: " +getSupervisor().getName()+ "\n"); 
    	output+=("Number of clients: " +getNumClients()+"/n"); 
    	output+=("Products to sell: \n");
    	for (int i=0; i<products.length; i++){
    		if(i==products.length-1){
    			output+=("\t"+products[i].toString());
    		}
    		else{
    			//No extra line added for last product.
    		output+=("\t"+products[i].toString()+"\n");
    		}
    	}
    	return output; 

    }
    
	
	//equals method. Do not edit!
	public boolean equals(SalesAssociate s){
		boolean equal = super.equals(s);
		equal = equal && (s.getNumClients() == numClients);
		equal = equal && (s.getSupervisor().equals(supervisor));
		
		for(int i = 0; i < products.length; i++){
			equal = equal && (products[i].equals(s.getProducts()[i]));
		}
		return equal;
	}
	
}