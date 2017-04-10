package graph_wws;
import static java.lang.System.out;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Task
{
	static ArrayList<Vertex> vertexList=new ArrayList<>();//объявляем список вершин
	static Graph g=new Graph();//создаем экземпляр класса Граф
	
	//-----------------------------------------------------------------------
	public static void main(String[] args)
	{
		Scanner keyboard=new Scanner(in);
	    String next="yes";
	    
	  while(next.equals("yes"))
	  {
	    out.println("Введите вершины графа");
	    out.println("Для обозначения конца ввода введите [end] ");
	
	    String label;
	    
	    for(int i=0; ; i++)
	      {
		   out.print(i+"-ая вершина: ");
		   label=keyboard.next();
		   if (label.equals("end")) break;
		   vertexList.add(new Vertex(label));	//заполняем список вершин
	      } 
	
	    g.makeMatrix(vertexList.size());//создаем МС нужного размера
		
    	out.println("\nКакие вершины графа требуется соединить?[a b] ");
	    out.println("где a,b - индексы вершин");
	    out.println("Для обозначения конца ввода введите [-1] \n");
	
	    while(true)
	    {
	  	  try
		    {
		     out.print("ребро: ");
	         int i_a=keyboard.nextInt();
	         if(i_a==-1) break;
             int i_b=keyboard.nextInt();
             g.addEdge(i_a, i_b); //добавляем ребро
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
	    
	   boolean goodIn=false;
	  String start ;
	  
	   do
	   {
		 out.print("Введите индекс вершины, с которой требуется начать обход: ");
		 try
		 { 
		  start=keyboard.next(); 
		  int st= Integer.parseInt(start);
		  goodIn=true;
		  wws(st);//начинаем обход с заданной вершины 
	     }
		  catch(IndexOutOfBoundsException e)
		  {
			out.println("Ошибка: не существует вершины с таким индексом ");
			goodIn=true;

		  }
		 catch(InputMismatchException e)
		 {
			 out.println("Ошибка: введите целое число ");
		 }
		 catch(NumberFormatException e)
		 {
			 out.println("Ошибка: введите целое число ");
		 }
	   } while(!goodIn);
	   
	  vertexList.clear();
	  out.println("\n Начать сначала? [yes/no]");
	  next=keyboard.next();
	}
	keyboard.close();
 }
	//-------------------------------------------------------------------------------
	
  static void wws(int s)//обход графа в ширину
  {
	    JQueue queue = new JQueue(vertexList.size());
	    vertexList.get(s).isVisited = true;
	    queue.insert(s);//добавляем в конец очереди исходную вершину
	    System.out.print("\n Обход графа в ширину: ");
	    System.out.print(vertexList.get(s).getValue());//выводим ее на экран
	        
	    while(!queue.isEmpty())//пока есть непройденные вершины
	      {
	        int current=queue.pop();//извлекаем первую вершину из очереди
	        for(int i=0; i<vertexList.size(); i++)
				if(g.matrix[current][i]==1 && vertexList.get(i).isVisited == false)
				//если есть вершины, смежные с текущей и еще не посещенные 	                                                               
	        	{
	        		queue.insert(i); //добавляем такую вершину в конец очереди
					vertexList.get(i).isVisited = true; //помечаем ее как посещенную
	        		System.out.print(" "+vertexList.get(i).getValue());//выводим ее на экран
	        	}
	      }
	   
	        for(int j = 0; j < vertexList.size(); j++) //сброс флагов
	        	vertexList.get(j).isVisited = false;
	    } 
}
