package graph_wws_1;

public class Vertex1 
{
	 String value;
	 boolean isVisited;
	    
	    public Vertex1(String label)
	    {
	        this.value = label;
	        isVisited = false;
	    }
	    
	    public void setValue(String value)          {   this.value = value; }
	    public String getValue()                    {   return value;   }
	    public void setVisited(boolean isVisited)   {   this.isVisited = isVisited;  }
	    public boolean isVisited()                  {  return isVisited;   }
}
