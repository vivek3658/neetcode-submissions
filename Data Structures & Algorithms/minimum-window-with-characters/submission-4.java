class Solution {
    public String minWindow(String s, String t) {
        int M = s.length();
        int N = t.length();
        if(M<N) return "";
        Map<Character ,Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(int i=0;i<N;i++){
            countT.put(t.charAt(i),countT.getOrDefault(t.charAt(i),0)+1);
        }
        int need = countT.size();
        int have = 0;
        int l = 0;
        int start = 0,end = 0,length = Integer.MAX_VALUE;
        for(int r=0;r<M;r++){
            char ch = s.charAt(r);
            window.put(ch,window.getOrDefault(ch,0)+1);
            if(countT.containsKey(ch) && window.get(ch).equals(countT.get(ch))){
                have++;
            }
            while(have == need){
                if((r-l+1)<length){
                    length = r-l+1;
                    start = l;
                    end = r;
                }
                ch = s.charAt(l);
                window.put(ch,window.get(ch)-1);
                if(countT.containsKey(ch) && window.get(ch) < countT.get(ch)){
                    have--;
                }
                l++;
            }
        }
        return (length != Integer.MAX_VALUE)?s.substring(start,end+1):"";
    }
}
