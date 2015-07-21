package wenxin.leetcode;

import java.util.ArrayList;
import java.util.Collections;

class MinStack {
	   ArrayList<Integer> list = new ArrayList<Integer>();
	    int min = Integer.MAX_VALUE;
	    public void push(int x) {
	        list.add(new Integer(x));
	        if(x<min){
	            min = x;
	        }
	    }

	    public void pop() {
	        if(list.size()>0){
	            if(list.get(list.size()-1).intValue()==min){
	                list.remove(list.size()-1);
	                if(list.size()>0)
	                	min = Collections.min(list).intValue();
	                else
	                	min = 0;
	            }else{
	                list.remove(list.size()-1);
	            }
	        }
	    }

	    public int top() {
	        if(list.size()>0){
	            return list.get(list.size()-1).intValue();
	        }
	        return 0;
	    }

	    public int getMin() {
	    	return min;
	    }
	    //push(2147483646),push(2147483646),push(2147483647),top,pop,getMin,pop,getMin,pop,push(2147483647),top,getMin,push(-2147483648),top,getMin,pop,getMin
public static void main(String args[]){
	MinStack s = new MinStack();
	s.push(2147483646);
	s.push(2147483646);
	s.push(2147483647);
	s.top();
	s.pop();
	s.getMin();
	s.pop();
	s.getMin();
	s.pop();
	s.push(2147483647);
	s.top();
	s.getMin();
	s.push(-2147483648);
	s.top();
	s.getMin();
	s.pop();
	s.getMin();

}

}

/*
 * 
 */