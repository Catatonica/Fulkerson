package graph_wws;

public class Vertex
{
	public String value;
	public boolean isVisited;
	    
	public  Vertex(String label)
	    {
	        this.value = label;
	        isVisited = false;
	    }
	    
	public  void setValue(String value)          {   this.value = value; }
	public  String getValue()                    {   return value;   }
	public  void setVisited(boolean isVisited)   {   this.isVisited = isVisited;  }
	public  boolean isVisited()                  {  return isVisited;   }
	    
}