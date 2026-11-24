class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int val:piles){
            max = Math.max(max,val);
        }
        int minHourRate = max;
        int i = 1;
        while(i<=max){
            int mid = i+((max - i)/2);
            int countHours = 0;
            for(int j=0;j<piles.length;j++){
                countHours += Math.ceil((piles[j]+mid-1)/mid);
            }
            if(countHours<=h){
                minHourRate = Math.min(minHourRate,mid);
                max = mid - 1;
            }else{
                i = mid + 1;
            }
        }
        return minHourRate;
    }
}
