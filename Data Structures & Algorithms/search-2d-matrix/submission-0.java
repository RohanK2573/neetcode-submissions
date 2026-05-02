class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0;
        int high=(matrix.length*matrix[0].length)-1;
        int n=matrix[0].length;
        while(low<=high){
            int mid=(low+high)/2;
            int row=mid/n;
            int col=mid%n;
            if(matrix[row][col]==target) return true;
            if(target>matrix[row][col]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }    
            return false;    
    }

}
