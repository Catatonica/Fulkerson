package com.algorithms.fulkerson;

import static java.lang.System.out;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.InputMismatchException;
//import java.util.InputMismatchException;
//import java.util.Scanner;
import java.util.Scanner;

import graph_wws.JQueue;
//import graph_wws.JQueue;
import graph_wws.Vertex;

class Graph
{
	private int[][] matrix;//��������� ������� ���������
	private int st=0; 
	private int a;
	private int b;
	 
	ArrayList<Vertex> vertexList=new ArrayList<>();//��������� ������ ������
    ArrayList<Edge> edgeList=new ArrayList<>();
	 
	  void makeMatrix(int ver, int ed)//�������������� ��, �������� �� ������
	    {
		   a=ver; b=ed;
	          matrix = new int[ver][ed];
	       
	        for(int i = 0; i < ver; i++)
	            for(int j = 0; j < ed; j++)
	                matrix[i][j] = 0;    
	    }
	   
	    void addEdge(int begin, int end) //��������� �����
	    {
			matrix[begin][st] = -1;
	        matrix[end][st] = 1;
	        st++;
	    } 
	    
    void showMatrix()
	    {
	        for(int i = 0; i < a; i++)
	        {
	        	 System.out.println();
	            for(int j = 0; j < b; j++)
	               System.out.print("\t"+ matrix[i][j]);
	        }   
	    }
	    
	  
	  	     ArrayList<Integer> wws(int s, int t)//����� ����� � ������
	    {
	  	    JQueue queue = new JQueue(vertexList.size());
	  	    vertexList.get(s).isVisited = true;
	  	    queue.insert(s);//��������� � ����� ������� �������� �������
	  	   // System.out.print("\n ����: ");
	  	   // System.out.print(vertexList.get(s).getValue());//������� �� �� �����
	  	    ArrayList<Integer> ind_ed []=new ArrayList[b];
	  	    int[] prev = new int[a];
	  	    
	  	    while(!queue.isEmpty())//���� ���� ������������ �������
	  	      {
	  	        int current=queue.pop();//��������� ������ ������� �� �������
	  	        for(int i=0; i<b; i++)
	  	        {
	  	        	if(matrix[current][i]==-1) 
	  	        		for(int j=0; j<vertexList.size(); j++)
	  				          if(matrix[j][i]==1 && vertexList.get(j).isVisited == false)
	  				      //���� ���� �������, ������� � ������� � ��� �� ���������� 	                                                               
	  	        	    {
	  	        		   queue.insert(j); //��������� ����� ������� � ����� �������
	  					   vertexList.get(j).isVisited = true; //�������� �� ��� ����������
	  					   prev[j] = current;
	  					   for(Edge ed:edgeList)
	  					   {
	  						   if(!ed.getIsDeleted()&&ed.getI_begin()==current&&ed.getI_end()==j)
	  						   {
	  							 // ind_ed.add(edgeList.indexOf(ed));
	  							   ind_ed[edgeList.indexOf(ed)]=new ArrayList<Integer>();
	  							   for(Edge e:edgeList)
	  							   	 if(!e.getIsDeleted()&&e.getI_end()==current && e.getI_begin()==prev[current])
	  								 {
	  									ind_ed[edgeList.indexOf(ed)].addAll(ind_ed[edgeList.indexOf(e)]);
	  									break;
	  							     }
	  							 ind_ed[edgeList.indexOf(ed)].add(edgeList.indexOf(ed));
	  							 
	  							   
	  						   }
	  					   }
	  	        		 //  System.out.print(" "+vertexList.get(j).getValue());//������� �� �� �����
	  	        		   if(j==t)
	  	        		   {
	  	        			 for(int k = 0; k < vertexList.size(); k++) //����� ������
	  	   	  	        	 vertexList.get(k).isVisited = false;
	  	        			for(Edge e:edgeList)
 								 if(e.getI_end()==j && e.getI_begin()==current)
 								 {
 									return ind_ed[edgeList.indexOf(e)];
 							     }
	  	        		
	  	        		   }
	  	        	    }
	  	        }   
	  	      }
	  	    return null;
	  	   
	  	        
	    }
	    
	     int Fulkerson()
	    {
	  	  boolean goodIn=false;
	  	  String s, t ;
	  	  ArrayList<Integer> way=new ArrayList<>();
	  	  Scanner keyboard=new Scanner(in);
	  	int source=0;
	  	int target=0;
	  	  
	  	   do
	  	   {
	  		 out.print("������� ������� ������ ������ � ����� [s t]: ");
	  		 try
	  		 { 
	  		  s=keyboard.next(); 
	  		  t=keyboard.next();
	  		  source= Integer.parseInt(s);
	  		  target=Integer.parseInt(t);
	  		  goodIn=true;
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
	  	   
	  	  while(true)
  		  {
  			   way=wws(source, target);
  			   out.println(way);
  			   if(way==null)
  			   {
  				   int max_flow=0;
  				   for(Edge ed: edgeList)
  					   if(ed.getI_begin()==source)
  					   {
  						  max_flow+= ed.getFlow();
  					   }
  				   return max_flow;
  			   }
  		  
	  	   
	  	   
	  	  //����� ���� , ������
	  	  
	  	   int[] mas_cap=new int[way.size()];
	  	 int min_cap=edgeList.get(way.get(0)).getCapacity();;
	  	   out.println("��");
	  	   for(int i=0; i<mas_cap.length; i++)
	  	   {
	  		 mas_cap[i]=edgeList.get(way.get(i)).getCapacity();   
	  		 if(mas_cap[i]<min_cap) min_cap=mas_cap[i];
	  		 //  out.println(mas_cap[i]+" ");
	  	   }
	  	   
	  	   for(int e: way)
	  	   {
	  		   edgeList.get(e).setFlow(edgeList.get(e).getFlow()+min_cap);
	  		   if(edgeList.get(e).getFlow()==edgeList.get(e).getCapacity())
	  			{
	  			   edgeList.get(e).setIsDeleted(true);
	  			   for(int i=0; i<a; i++)     matrix[i][e]=0;
	  			}
	  		   
	  		   for(Edge ed: edgeList)
	  		   {
	  			   if(ed.getI_begin()==edgeList.get(e).getI_end()&&
	  					 ed.getI_end()==edgeList.get(e).getI_begin())
	  				 ed.setFlow(ed.getFlow()-min_cap);
	  		   }
	  	   }
	  	   
  		  }
	    }
	 
	    
}    

