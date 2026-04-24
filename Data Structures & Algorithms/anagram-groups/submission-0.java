class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        List<List<String>> ans=new ArrayList<>();
        for(String s: strs){
            char[] c=s.toCharArray();
            Arrays.sort(c);
            String key=new String(c);
            if(map.containsKey(key)){
                map.get(key).add(s);
            }else{
                map.put(key,new ArrayList<String>());
                map.get(key).add(s);
            }
        }
        for(Map.Entry<String,List<String>> he: map.entrySet()){
            ans.add(he.getValue());

        }
        return ans;

        
    }
}
