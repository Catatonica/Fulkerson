package dm;

import static java.lang.System.out;
import java.util.ArrayList;

public class Partition 
{
	public static void find(int n)
	{	 
		int amount=0;
		ArrayList<Integer> prev=new ArrayList<>();
		ArrayList<Integer> cur=new ArrayList<>();
	    
		prev.add(n);
		int t;
		
		out.println(n+"="+n); 
		amount++;
		
		while(prev.get(0)!=1)
		{
			amount++;	
		for( t=prev.size()-1; prev.get(t)==1; t--) {}
		
		for(int i=0;i<t; i++)	cur.add(prev.get(i));
		
		int sum=0;
		for(int k=t; k<prev.size(); k++)	sum+=prev.get(k);

		
		int l=prev.get(t)-1;
		for(int j=0; j<(sum/l); j++)	 cur.add(l); 
		
		
	     if(sum%l!=0)	cur.add(sum%l);
	
		
		String s = new String();
		s=n+"=";
		for(int el:cur)		s+=el+"+";	 
		
		s=s.substring(0,s.length()-1);
		out.println(s);
		prev.clear();
		prev.addAll(cur);
		cur.clear();
		}
		
		out.println("Количество разбиений числа "+n+"= "+amount);
		
	}
}
