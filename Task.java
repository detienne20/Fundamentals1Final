public class Task {
	//Task must be Immutable
	// Immutable: Once class is created class cannot be changed. 
	 private String name;
	 
     public String getName() {
		return name;
	}
	public int getLevel() {
		return level;
	}

	private int level;
     
     Task(String name, int level){
    	 this.name=name; 
    	 this.level=level; 
     }
     public String toString(){
    	 String output=("\t"+"Task: "+name+"\t" + "Level: "+level);
    	 return output; 		
     }
    
	
	//equals method. Do not edit!
	public boolean equals(Task t){
		return ((t.getLevel() == level) && (t.getName().equals(name)));
	}
}