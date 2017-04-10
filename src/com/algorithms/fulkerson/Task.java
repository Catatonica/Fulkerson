package com.algorithms.fulkerson;
import static java.lang.System.out;
import static java.lang.System.in;
import java.util.InputMismatchException;
import java.util.Scanner;
import graph_wws.Vertex;

class Task 
{
	
	public static void main(String[] args)
	{ 
		
		Scanner keyboard=new Scanner(in);
	    String next="yes";
	   
	  while(next.equals("yes"))
	  {
		Graph g=new Graph();//создаем экземпляр класса Граф
		Graph g_copy=new Graph();
	    out.println("Введите вершины графа");
	    out.println("Для обозначения конца ввода введите [end] ");
	
	    String label;
	    
	    for(int i=0; ; i++)
	      {
		   out.print(i+"-ая вершина: ");
		   label=keyboard.next();
		   if (label.equals("end")) break;
		   g.vertexList.add(new Vertex(label));	//заполняем список вершин
		   g_copy.vertexList.add(new Vertex(label));
	      } 
	
    	out.println("\nКакие вершины графа требуется соединить?[a b] ");
	    out.println("где a,b - индексы вершин");
	    out.println("Для обозначения конца ввода введите [-1] \n");
	
	    while(true)
	    {
	  	  try
		    {
		     out.print("ребро: ");
	         int i_b=keyboard.nextInt();
	         if(i_b==-1) break;
             int i_e=keyboard.nextInt();
             out.println("Введите пропускную способность ребра: ");
             int cap=keyboard.nextInt();
             g.edgeList.add(new Edge(i_b, i_e, cap, 0));
             g_copy.edgeList.add(new Edge(i_b, i_e, cap, 0));
		    }
		    catch(ArrayIndexOutOfBoundsException e)
		     {
			  out.println("Ошибка: не существует вершины с индексом "+e.getMessage());
		     }
	    	catch(InputMismatchException e)
			 {
				 out.println("Ошибка: введите целое число ");
				 keyboard.next();
			 }  
	   }
	    
	    g.makeMatrix(g.vertexList.size(), g.edgeList.size());//создаем МС нужного размера
	    g_copy.makeMatrix(g.vertexList.size(), g.edgeList.size());
	    
	    for(Edge ed: g.edgeList)
	    {
	    	g.addEdge(ed.getI_begin(), ed.getI_end());
	    	g_copy.addEdge(ed.getI_begin(), ed.getI_end());
	    }
	    g.showMatrix();
	    
	   
	 int max_flow=g_copy.Fulkerson();
	 out.println(max_flow);
	   
	  //----------------------------------------------------------- 
	  out.println("\n Начать сначала? [yes/no]");
	  next=keyboard.next();
	}
	keyboard.close();
 }

 } 

