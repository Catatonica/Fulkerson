package graph_wws_1;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;

public class Task1 
{
	static Graph1 g=new Graph1();
	public static void main(String[] args)
	{
		Scanner keyboard=new Scanner(in);
		
	out.println("������� 1 ��� �������� ������ �����");
	out.println("������� 2 ��� �������������� �����");
	out.println("������� 3 ��� ������ �� ���������");
	
		int num=keyboard.nextInt();
		
		switch(num)
		{
		case 1: g.start(); break;
		}
	keyboard.close();
	} 
	  
}
