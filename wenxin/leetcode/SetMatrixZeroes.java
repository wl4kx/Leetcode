package wenxin.leetcode;

import java.util.HashSet;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {

        HashSet<Integer> rowSet = new HashSet<Integer>();
        HashSet<Integer> columnSet = new HashSet<Integer>();
        
        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix[i].length;j++){
        		if(matrix[i][j]==0){
        			rowSet.add(i);
        			columnSet.add(j);
        		}	
        	}
        }
        
        for(Integer r: rowSet){
        	for(int i =0;i<matrix[r].length;i++){
        		matrix[r][i] = 0;
        	}
        }
        
        for(Integer c: columnSet){
        	for(int i =0;i<matrix.length;i++){
        		matrix[i][c] = 0;
        	}
        }
        
        
        
    
    }
}
