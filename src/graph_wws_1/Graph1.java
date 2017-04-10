package graph_wws_1;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph1
{
	static int[][] matrix;//объявляем матрицу смежности
	static ArrayList<Vertex1> vertexList=new ArrayList<>();//объявляем список вершин
	Scanner keyboard=new Scanner(in);
	
	public void start()
    {
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
		vertexList.add(new Vertex1(label));	//заполняем список вершин
	} 
	
	makeMatrix(vertexList.size());//создаем МС нужного размера
		
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
        addEdge(i_a, i_b); //добавляем ребро
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			out.println("Ошибка: не существует вершины с индексом "+e.getMessage());
		}
	}
	boolean goodIn=false;
	int start=0;
	do{
		
		out.print("Введите индекс вершины, с которой требуется начать обход: ");
		try { start=keyboard.nextInt(); 
		goodIn=true;}
		catch(IndexOutOfBoundsException e)
		{
			out.println("Ошибка: не существует вершины с индексом "+e.getMessage());
		}
	} while(!goodIn);
	   
	wws(start);//начинаем обход с заданной вершины
	 vertexList.clear();
	out.println("\n Продолжить? [yes/no]");
	next=keyboard.next();
	
	}
		keyboard.close();
	}   
	
	
    public void makeMatrix(int size)//инициализируем МС, заполняя ее нулями
    {
          matrix = new int[size][size];
       
        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
                matrix[i][j] = 0;
    }
   
    public  void addEdge(int begin, int end) //добавляем ребро
    {
        matrix[begin][end] = 1;
        matrix[end][begin] = 1;
    } 
      
  static void wws(int s)//обход графа в ширину
   {
	JQueue1 queue = new JQueue1(vertexList.size());
    vertexList.get(s).isVisited = true;
    queue.insert(s);//добавляем в конец очереди исходную вершину
    System.out.print("\n Обход графа в ширину: ");
    System.out.print(vertexList.get(s).getValue());//выводим ее на экран
    
  while(!queue.isEmpty())//пока есть непройденные вершины
    {
    	int current=queue.pop();//извлекаем первую вершину из очереди
    	for(int i=0; i<vertexList.size(); i++)
			if(matrix[current][i]==1 && vertexList.get(i).isVisited == false)
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
