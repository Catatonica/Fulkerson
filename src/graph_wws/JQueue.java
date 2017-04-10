package graph_wws;

public class JQueue
{
	    private int[] array;//������ ��� �������� ���������
	    private int size;//���������� ��������� � �������
	    private int count;//������� ���������� ���������
	    private int begin;//�������, ������� ��������� � ������ �������
	    private int end;//�������, ������� ��������� � ����� �������
	    
	    public JQueue(int queueSize)
	    {
	        size = queueSize;
	        array = new int[size];
	        begin = 0;
	        end = -1;
	        count = 0;//��������� � ������� ���� ���
	    }
	    
	    public void insert(int value)//������� �������� � ����� �������
	    {
	        if(end == size - 1)
	            end = -1;
	        array[++end] = value;   
	        count++;
	    }
	    
	    public int pop()//���������� �������� �� ������ �������
	    {
	        int temp = array[begin++];
	        if(begin == size)
	            begin = 0;
	        count--;
	        return temp;
	    }
	    
	    public int size() //������ �������
	    {
	        return count;
	    }
	   
	    public boolean isEmpty() //��������, ����� �� ������� 
	    {
	        return (count == 0);
	    }
	 
}
