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
		
	   out.println("������� ����������� �����, ������� ��������� ������� �� ���������\n");
	   num=keyboard.nextInt();
	   if(num>0)
	   {
        out.println("������� 1 ��� ���������� ���������\n"
		   + "������� 2 ��� ���������� ����� ��������� ���������: ");
	    key=keyboard.nextInt();
	    if(key==1||key==2) bool=false;
	      else out.println("������������ ����, ���������� ��� ���"); 
	   }
	      else out.println("!����� ������ ���� ����������� ");
	  }
	  
	catch(InputMismatchException e) 
			{
		     out.println("������������ ����, ���������� ��� ��� ");
		    // next=keyboard.next();
		     keyboard.next();

		    }
	}
	
	switch(key)
	{
	   case 1:
	    
	       if(num>1)     Partition.find(num); 
	        else if(num==1)  out.println(num+"=1"); break;
	           
	  
	   case 2:	 out.println("���������� ��������� ����� "+num+"= "+Recursion.findBellsNumber(num, num));
	             break;
	   
	}
	out.println("����������? [yes/no]");
	next=keyboard.next();
	bool=true;
	}
	keyboard.close();
		
	}
}
