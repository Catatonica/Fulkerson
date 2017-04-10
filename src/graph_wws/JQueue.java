package graph_wws;

public class JQueue
{
	    private int[] array;//массив для хранения элементов
	    private int size;//количество элементов в очереди
	    private int count;//текущее количество элементов
	    private int begin;//элемент, который находится в начале очереди
	    private int end;//элемент, который находится в конце очереди
	    
	    public JQueue(int queueSize)
	    {
	        size = queueSize;
	        array = new int[size];
	        begin = 0;
	        end = -1;
	        count = 0;//элементов в очереди пока нет
	    }
	    
	    public void insert(int value)//вставка элемента в конец очереди
	    {
	        if(end == size - 1)
	            end = -1;
	        array[++end] = value;   
	        count++;
	    }
	    
	    public int pop()//извлечение элемента из начала очереди
	    {
	        int temp = array[begin++];
	        if(begin == size)
	            begin = 0;
	        count--;
	        return temp;
	    }
	    
	    public int size() //размер очереди
	    {
	        return count;
	    }
	   
	    public boolean isEmpty() //проверка, пуста ли очередь 
	    {
	        return (count == 0);
	    }
	 
}
