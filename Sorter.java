public class Sorter{
//Contains only a static method sort(Employee []) and returns a reference to the sorted Employee [].
//The array must be sorted by the name of the employee in ascending alphabetical order.

	public static Employee[] sort( Employee[] employee){
		int length= employee.length; 
		
	for (int i=0; i< length;i++ ){	

		 for (int j=1; j< (length-i);j++ ){
				
				if (employee[j].getName().compareTo(employee[j-1].getName())<0){	 
					// Swaps them. 
					Employee Temporary = employee[j-1];
					employee[j-1]=employee[j];
					employee[j]=Temporary;
				
				}
			}
			}
	
	return employee; 
	}
	
	 
}
