class TimeMap {
    HashMap<String,List<List<String>>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<>());
        }
        map.get(key).add(List.of(value,Integer.toString(timestamp)));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        var values = map.get(key); 
        int l = 0,r = values.size() - 1;
        StringBuilder sb = new StringBuilder();
        while(l<=r){
            int m = l + (r-l)/2;
            if(Integer.parseInt(values.get(m).get(1)) <= timestamp){
                sb.setLength(0);
                sb.append(values.get(m).get(0));
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return sb.toString();
    }
}
