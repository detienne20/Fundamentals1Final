import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TheOffice {
	
	private Employee[] workers;
	
	public Employee[] getWorkers() {
		return workers;
	}


	public void setWorkers(Employee[] workers) {
		this.workers = workers;
	}


	//Constructor
	TheOffice(){}
	
	
	TheOffice(String fileLoc) throws TaskLevelException{
		
		//This is used to read a file, do NOT edit!!!
		Scanner fs = null;
		File f = null;
		
		//Try Catch on file
		try{ 
			f = new File(fileLoc); 
			fs = new Scanner(f); 
		}
		catch(FileNotFoundException e){ 
			System.out.println("FileNotFoundException: The file \""+ fileLoc + "\" could not be found.");
		}
		
		
		//First Line is number of employees
		int size = Integer.parseInt(fs.nextLine());
		
		workers = new Employee[size];
				
		//This might be useful, feel free to delete, or not use these		
		RegionalManager manager = null;
		int supremum = 0;
		AssistantRegionalManager assistantManager = null;
		int ATRM = 0; 
		
		//Loops through file
		for(int i = 0; i < size; i++){
			//Sets temp variables for all possible member variables
			int IDNumber = -1;
			String name = null;
			Task[] taskList = null; 
			int RegionNum = -1; 
			int minimumTask = -1;
			int numClients = -1;
			String[] products = null;
			int maxTaskComplexityLevel = -1;
			
			//Check which type of employee
			String type = fs.nextLine().trim();
			
			//Get Standard information (id, name)
			IDNumber = Integer.parseInt(fs.nextLine().trim());
			name =  fs.nextLine();
			
			//Gets number of tasks and makes a task array based on the size
			int tasks = Integer.parseInt(fs.nextLine().trim());
			taskList = new Task[tasks];
				
			//Fills up Task List
			for(int j = 0; j < tasks; j++){
				//Gets information for task
				String work = fs.nextLine();
				int num = Integer.parseInt(fs.nextLine().trim());
				
				//Sets task at array spot
				taskList[j] = new Task(work, num); 
			}
			
			//Scanner read for Regional Manager. Use this as an example to do the other 3 types
			if(type.equals("RegionalManager")){
				//Gets Region Number and Minimum Task Level
				RegionNum = Integer.parseInt(fs.nextLine().trim());
				minimumTask = Integer.parseInt(fs.nextLine().trim());
				
				//Loop through the Task list
				for(int j = 0; j < taskList.length; j++ ){
					//If a task is below the minimum task level, throw exception
					if(taskList[j].getLevel() < minimumTask){
						throw new TaskLevelException(taskList[j].getLevel());
					}
				}	
				//RegionalManager manager = null;
				
				//set manager to new regional manager
				manager = new RegionalManager(IDNumber, name, taskList, RegionNum, minimumTask);
				
				//set workers[i] to regional manager
				workers[i] = manager;
				
				//Set supremum (Might be useful)
				supremum = minimumTask;
			}

			
			else if(type.equals("AssistantRegionalManager")){
				minimumTask = Integer.parseInt(fs.nextLine().trim());
			
				for(int j = 0; j < taskList.length; j++ ){
					
					if(minimumTask>supremum){
						// If a task is above the minimum task level of the Regional Manger, throw exception
						throw new TaskLevelException(taskList[j].getLevel());
						
					}
					if(taskList[j].getLevel() < minimumTask){
						//If a task is below the minimum task level, throw exception
						throw new TaskLevelException(taskList[j].getLevel());
					}
				}
				
				//set Assistant regional manager to new assistant manager
				assistantManager = new AssistantRegionalManager(IDNumber, name,taskList, manager, minimumTask);
				
				//set workers[i] to assistant manager
				workers[i] = assistantManager;
				
				ATRM++;// What would we use this for?

				
			}
			else if(type.equals("SalesAssociate")){
				numClients = Integer.parseInt(fs.nextLine().trim());		
				products= new String[Integer.parseInt(fs.nextLine().trim())];
				
				// To fix the product line. 
				for (int k=0; k<products.length; k++){
					products[k]=(fs.nextLine().trim()); 
					
				}
				
				SalesAssociate NewAssociate = new SalesAssociate(IDNumber, name,taskList, numClients, products,manager);
				workers[i]= NewAssociate; 
	
			}
			else if(type.equals("Receptionist")){	
				
				maxTaskComplexityLevel = Integer.parseInt(fs.nextLine().trim());
				assistantManager= new AssistantRegionalManager(0,workers[1].getName(),null,null,maxTaskComplexityLevel);
			
				
				for(int j = 0; j < taskList.length; j++ ){
					//If a task is below the minimum task level, throw exception
					if(taskList[j].getLevel() < minimumTask){
						throw new TaskLevelException(taskList[j].getLevel());
					}
				}	
				 
				Receptionist NewReceptionist= new Receptionist(IDNumber, name, taskList, assistantManager,maxTaskComplexityLevel);
				
				workers[i]=NewReceptionist; 
			
				
			}
		}
		
		//Set up Employee Arrays for regional manager
		Employee[] a = new Employee[size -1];
		for(int i = 0, j = 0; i < workers.length; i++){
			if(!(workers[i] instanceof RegionalManager)){
				a[j++] = workers[i];
			}
		}
		
		//If there is a manager, set the subordinate array
		if(manager != null){
			manager.setSubordinates(a);
		}
	}

	// to String method calls toString Method for Regional Managers only. 
	public String toString(){
		String output="";
		for (int j=0; j<workers.length; j++){
			if (workers[j] instanceof RegionalManager){
				output+=workers[j].toString(); 
			}
		}
		
		return output; 
	}
	
	//levelDisplay method
	
	public String levelDisplay (){
		String Display= ""; 
		for (int i=0; i<workers.length ;i++ ){	
			Display=( Display + "Name:  "+ workers[i].getName() +"\tLevel: ");
			if(workers[i] instanceof RegionalManager){
				Display += (((RegionalManager) workers[i]).getMinimumTask()); 
			}
			else if (workers[i] instanceof AssistantRegionalManager){
				Display += (((AssistantRegionalManager) workers[i]).getMinimumTask());
				
			}
			else {
				Display +="1";
			}
			if (i<(workers.length-1)){
				Display+="\n";	
			}
		}
		return Display; 
	}

	
	
	public static void main(String[] args) throws TaskLevelException{
		//Gets location for file
		TheOffice o = new TheOffice((args[0]+".txt"));
		
		//Prints office, then the current level display
		System.out.println(o + "\n\n\n" + o.levelDisplay());
		
		//Sorts(by name) the employee array
		Sorter.sort(o.getWorkers());
		
		//Prints the sorted(by name) level display
		System.out.println("\n\n\n" + o.levelDisplay());
	}
	
}