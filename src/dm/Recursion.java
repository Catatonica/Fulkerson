package dm;

public class Recursion 
{
	public static int findBellsNumber(int n, int k) 
	{
		if(n==0&&k==0)
		{
			return 1;
		}
		    else if(n!=0&&k==0)
		   {
			return 0;
		   }
		    else if(k>0&&k<=n)
		      {
			   return findBellsNumber(n,k-1)+findBellsNumber(n-k,k);
		      }
		      else if(k>n)
		      {
		     	return findBellsNumber(n,n);
		      }
		
		return 0;
	}
}
