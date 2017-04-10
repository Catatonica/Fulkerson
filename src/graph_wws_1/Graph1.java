package graph_wws_1;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph1
{
	static int[][] matrix;//��������� ������� ���������
	static ArrayList<Vertex1> vertexList=new ArrayList<>();//��������� ������ ������
	Scanner keyboard=new Scanner(in);
	
	public void start()
    {
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
		vertexList.add(new Vertex1(label));	//��������� ������ ������
	} 
	
	makeMatrix(vertexList.size());//������� �� ������� �������
		
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
        addEdge(i_a, i_b); //��������� �����
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			out.println("������: �� ���������� ������� � �������� "+e.getMessage());
		}
	}
	boolean goodIn=false;
	int start=0;
	do{
		
		out.print("������� ������ �������, � ������� ��������� ������ �����: ");
		try { start=keyboard.nextInt(); 
		goodIn=true;}
		catch(IndexOutOfBoundsException e)
		{
			out.println("������: �� ���������� ������� � �������� "+e.getMessage());
		}
	} while(!goodIn);
	   
	wws(start);//�������� ����� � �������� �������
	 vertexList.clear();
	out.println("\n ����������? [yes/no]");
	next=keyboard.next();
	
	}
		keyboard.close();
	}   
	
	
    public void makeMatrix(int size)//�������������� ��, �������� �� ������
    {
          matrix = new int[size][size];
       
        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
                matrix[i][j] = 0;
    }
   
    public  void addEdge(int begin, int end) //��������� �����
    {
        matrix[begin][end] = 1;
        matrix[end][begin] = 1;
    } 
      
  static void wws(int s)//����� ����� � ������
   {
	JQueue1 queue = new JQueue1(vertexList.size());
    vertexList.get(s).isVisited = true;
    queue.insert(s);//��������� � ����� ������� �������� �������
    System.out.print("\n ����� ����� � ������: ");
    System.out.print(vertexList.get(s).getValue());//������� �� �� �����
    
  while(!queue.isEmpty())//���� ���� ������������ �������
    {
    	int current=queue.pop();//��������� ������ ������� �� �������
    	for(int i=0; i<vertexList.size(); i++)
			if(matrix[current][i]==1 && vertexList.get(i).isVisited == false)
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
