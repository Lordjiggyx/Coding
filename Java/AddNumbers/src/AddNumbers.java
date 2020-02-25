public class  AddNumbers {
	public static void main (String[] args) {
	
	int a = 10;
	int b = 11;
	int c = 12;
	int d = 0;
	d = a + b + c;
	
	//Display intial result
	System.out.println("The initial result is " + " " +  d);
	
	//create a loop 
	for ( int i =1; i<=5; i++){
		d = d + 10;
	}
	System.out.println("The final result is " + " " +  d);
}
}