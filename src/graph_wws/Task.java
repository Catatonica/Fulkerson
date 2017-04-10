package graph_wws;
import static java.lang.System.out;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Task
{
	static ArrayList<Vertex> vertexList=new ArrayList<>();//��������� ������ ������
	static Graph g=new Graph();//������� ��������� ������ ����
	
	//-----------------------------------------------------------------------
	public static void main(String[] args)
	{
		Scanner keyboard=new Scanner(in);
	    String next="yes";
	    
	  while(next.equals("yes"))
	  {
	    out.println("������� ������� �����");
	    out.println("��� ����������� ����� ����� ������� [end] ");
	
	    String label;
	    
	    for(int i=0; ; i++)
	      {
		   out.print(i+"-�� �������: ");
		   label=keyboard.next();
		   if (label.equals("end")) break;
		   vertexList.add(new Vertex(label));	//��������� ������ ������
	      } 
	
	    g.makeMatrix(vertexList.size());//������� �� ������� �������
		
    	out.println("\n����� ������� ����� ��������� ���������?[a b] ");
	    out.println("��� a,b - ������� ������");
	    out.println("��� ����������� ����� ����� ������� [-1] \n");
	
	    while(true)
	    {
	  	  try
		    {
		     out.print("�����: ");
	         int i_a=keyboard.nextInt();
	         if(i_a==-1) break;
             int i_b=keyboard.nextInt();
             g.addEdge(i_a, i_b); //��������� �����
		    }
		    catch(ArrayIndexOutOfBoundsException e)
		     {
			  out.println("������: �� ���������� ������� � �������� "+e.getMessage());
		     }
	    	catch(InputMismatchException e)
			 {
				 out.println("������: ������� ����� ����� ");
				 keyboard.next();
			 }
	  	  
	   }
	    
	   boolean goodIn=false;
	  String start ;
	  
	   do
	   {
		 out.print("������� ������ �������, � ������� ��������� ������ �����: ");
		 try
		 { 
		  start=keyboard.next(); 
		  int st= Integer.parseInt(start);
		  goodIn=true;
		  wws(st);//�������� ����� � �������� ������� 
	     }
		  catch(IndexOutOfBoundsException e)
		  {
			out.println("������: �� ���������� ������� � ����� �������� ");
			goodIn=true;

		  }
		 catch(InputMismatchException e)
		 {
			 out.println("������: ������� ����� ����� ");
		 }
		 catch(NumberFormatException e)
		 {
			 out.println("������: ������� ����� ����� ");
		 }
	   } while(!goodIn);
	   
	  vertexList.clear();
	  out.println("\n ������ �������? [yes/no]");
	  next=keyboard.next();
	}
	keyboard.close();
 }
	//-------------------------------------------------------------------------------
	
  static void wws(int s)//����� ����� � ������
  {
	    JQueue queue = new JQueue(vertexList.size());
	    vertexList.get(s).isVisited = true;
	    queue.insert(s);//��������� � ����� ������� �������� �������
	    System.out.print("\n ����� ����� � ������: ");
	    System.out.print(vertexList.get(s).getValue());//������� �� �� �����
	        
	    while(!queue.isEmpty())//���� ���� ������������ �������
	      {
	        int current=queue.pop();//��������� ������ ������� �� �������
	        for(int i=0; i<vertexList.size(); i++)
				if(g.matrix[current][i]==1 && vertexList.get(i).isVisited == false)
				//���� ���� �������, ������� � ������� � ��� �� ���������� 	                                                               
	        	{
	        		queue.insert(i); //��������� ����� ������� � ����� �������
					vertexList.get(i).isVisited = true; //�������� �� ��� ����������
	        		System.out.print(" "+vertexList.get(i).getValue());//������� �� �� �����
	        	}
	      }
	   
	        for(int j = 0; j < vertexList.size(); j++) //����� ������
	        	vertexList.get(j).isVisited = false;
	    } 
}
