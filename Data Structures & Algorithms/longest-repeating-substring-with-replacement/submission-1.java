class Solution {
    public int characterReplacement(String s, int k) {
        int[] chars = new int[26];
        int N = s.length();
        int window = 0;
        int maxFreq = 0;
        int l = 0;
        for(int r=0;r<N;r++){
            char ch = s.charAt(r);
            chars[ch - 'A'] += 1;
            maxFreq = Math.max(maxFreq,chars[ch - 'A']);
            if((r-l+1) - maxFreq > k){
                chars[s.charAt(l) - 'A']--; 
                l += 1;
            } 
            window = Math.max(window,r-l+1);
        }
        return window;
    }
}
