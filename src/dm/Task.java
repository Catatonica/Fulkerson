package dm;
import static java.lang.System.out;
import static java.lang.System.in;
import java.util.Scanner;
import java.util.InputMismatchException;


 class Task 
{
	public static void main(String args[]) 
	{
		
	Scanner keyboard=new Scanner(in);
	int num=-1, key=-1;
	boolean bool=true;
	String next="yes";
	
	while(next.equals("yes"))
	{
		while(bool)
	{
			try
	  {
		
	   out.println("Введите натуральное число, которое требуется разбить на слагаемые\n");
	   num=keyboard.nextInt();
	   if(num>0)
	   {
        out.println("Введите 1 для нахождения разбиения\n"
		   + "Введите 2 для нахождения числа возможных разбиений: ");
	    key=keyboard.nextInt();
	    if(key==1||key==2) bool=false;
	      else out.println("Неправильный ввод, попробуйте еще раз"); 
	   }
	      else out.println("!Число должно быть натуральным ");
	  }
	  
	catch(InputMismatchException e) 
			{
		     out.println("Неправильный ввод, попробуйте еще раз ");
		    // next=keyboard.next();
		     keyboard.next();

		    }
	}
	
	switch(key)
	{
	   case 1:
	    
	       if(num>1)     Partition.find(num); 
	        else if(num==1)  out.println(num+"=1"); break;
	           
	  
	   case 2:	 out.println("Количество разбиений числа "+num+"= "+Recursion.findBellsNumber(num, num));
	             break;
	   
	}
	out.println("Продолжить? [yes/no]");
	next=keyboard.next();
	bool=true;
	}
	keyboard.close();
		
	}
}
