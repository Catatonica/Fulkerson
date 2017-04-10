package graph_wws;

 class Graph 
{ 
	   int[][] matrix;//объ€вл€ем матрицу смежности
	   
	   void makeMatrix(int size)//инициализируем ћ—, заполн€€ ее нул€ми
	    {
	          matrix = new int[size][size];
	       
	        for(int i = 0; i < size; i++)
	            for(int j = 0; j < size; j++)
	                matrix[i][j] = 0;
	    }
	   
	    void addEdge(int begin, int end) //добавл€ем ребро
	    {
	        matrix[begin][end] = 1;
	        matrix[end][begin] = 1;
	    } 
}
