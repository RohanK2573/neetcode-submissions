class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();

        for(String s:strs){
            int len=s.length();
            sb.append(len);
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();

    }

    public List<String> decode(String str) {
      
         int i = 0;

        List<String> ans = new ArrayList<>();

        while (i < str.length()) {

            int j = i;

            while (str.charAt(j) != '#') {

                j++;

            }

            int len = Integer.parseInt(str.substring(i, j));

            StringBuilder sb = new StringBuilder();

            int start = j + 1;

            int end = start + len;

            while (start < end) {

                sb.append(str.charAt(start));

                start++;

            }

            ans.add(sb.toString());

            i = end;

        }

        return ans;
    }
}
