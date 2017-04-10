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
		
	out.println("Нажмите 1 для создания нового графа");
	out.println("Нажмите 2 для редактирования графа");
	out.println("Нажмите 3 для выхода из программы");
	
		int num=keyboard.nextInt();
		
		switch(num)
		{
		case 1: g.start(); break;
		}
	keyboard.close();
	} 
	  
}
