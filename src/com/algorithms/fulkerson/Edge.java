package com.algorithms.fulkerson;

class Edge
{
	private int capacity;
	private int flow;
	private int i_begin;
    private int i_end;
    private Boolean isDeleted=false;
	
	

	Edge(int i_begin, int i_end, int capacity, int flow)
	{
		this.setI_begin(i_begin);
		this.setI_end(i_end);
		this.capacity=capacity;
		this.flow=flow;
	}
	

	public int getI_begin() {	return i_begin;}

	public void setI_begin(int i_begin) {	this.i_begin = i_begin;	}

	public int getI_end() {	return i_end;	}

	public void setI_end(int i_end) {	this.i_end = i_end;}

	public void setCapacity(int capacity) {  this.capacity = capacity;  }

	public int getCapacity() {	return capacity; }
	
    public void setFlow(int flow) {	this.flow = flow;  }
    
	public int getFlow() {	return flow; }
	
	public Boolean getIsDeleted() {	return isDeleted;	}

	public void setIsDeleted(Boolean isDeleted) {	this.isDeleted = isDeleted;	}

	



}

