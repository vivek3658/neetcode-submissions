class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int N = s2.length();
        int M = s1.length();
        if(M>N) return false;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int matches = 0;
        for(int j=0;j<s1.length();j++){
            arr1[s1.charAt(j) - 'a']++;
            arr2[s2.charAt(j) - 'a']++;
        }
        for(int i=0;i<26;i++){
            if(arr1[i] == arr2[i]){
                matches++;
            }
        }
        
        int l=0;
        for(int i=M;i<N;i++){
            if(matches == 26) return true;
            int index = s2.charAt(i) - 'a';
            arr2[index]++;
            if(arr2[index] == arr1[index]){
                matches++;
            }else if(arr1[index] + 1 == arr2[index]){
                matches--;
            }
            index = s2.charAt(l) - 'a';
            arr2[index]--;
            if(arr2[index] == arr1[index]){
                matches++;
            }else if(arr1[index] - 1 == arr2[index]){
                matches--;
            }
            l++;
        }
        return matches == 26;
    }
}
