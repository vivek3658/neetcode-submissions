class Solution {
    public int characterReplacement(String s, int k) {
        int[] chars = new int[26];
        int N = s.length();
        int maxFreq = 0;
        int left = 0;
        int right = 0;
        int window = 0;
        while(right<N){
            maxFreq = Math.max(maxFreq,++chars[s.charAt(right)-'A']);
            if((right-left+1) - maxFreq > k){
                
                --chars[s.charAt(left)-'A'];
                left++;
            }
            window = Math.max(window,right-left+1);
            right++;
        }
        return window;
    }
}
