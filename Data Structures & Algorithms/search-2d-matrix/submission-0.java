class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lr = 0,lc = 0,rr = matrix.length - 1,rc = matrix[0].length - 1;
        while(lr <= rr){
            int mr = lr + ((rr-lr)/2);
            if(matrix[mr][0] > target){
                rr = mr - 1;
            }else if (matrix[mr][rc] < target){
                lr = mr + 1;
            }else{
                while(lc<=rc){
                    int mc = lc + ((rc-lc)/2);
                    if(matrix[mr][mc] == target){
                        return true;
                    }else if(matrix[mr][mc] < target){
                        lc = mc + 1;
                    }else{
                        rc = mc - 1;
                    }

                }
            }
        }
        return false;
    }
}
