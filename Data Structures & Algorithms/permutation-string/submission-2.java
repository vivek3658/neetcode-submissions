class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int M = s1.length();
        int N = s2.length();
        if(M>N) return false;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int i=0;i<M;i++){
            char ch = s1.charAt(i);
            arr1[ch - 'a']++;
            ch = s2.charAt(i);
            arr2[ch - 'a']++;
        }
        int matches = 0;
        for(int i=0;i<26;i++){
            if(arr1[i] == arr2[i]) matches++;
        }
        int left = 0;
        for(int i=M;i<N;i++){
            if(matches == 26) return true;
            char ch = s2.charAt(left);
            arr2[ch - 'a']--;
            if(arr1[ch - 'a'] == arr2[ch - 'a']){
                matches++;
            }else if(arr2[ch - 'a'] + 1 == arr1[ch - 'a']){
                matches--;
            }
            ch = s2.charAt(i);
            arr2[ch - 'a']++;
            if(arr1[ch - 'a'] == arr2[ch - 'a']){
                matches++;
            }else if(arr2[ch - 'a'] - 1 == arr1[ch - 'a']){
                matches--;
            }
            left++;
        }
        return matches == 26;
    }
}
