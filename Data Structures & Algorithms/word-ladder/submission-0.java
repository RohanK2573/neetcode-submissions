class Pair{
    String word;
    int level;
    Pair(String word,int level){
        this.word=word;
        this.level=level;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        HashSet<String> visited=new HashSet<>();
        for(String word:wordList){
            set.add(word);
        }
        Queue<Pair> que=new ArrayDeque<>();
        que.add(new Pair(beginWord,1));
        visited.add(beginWord);
        while(!que.isEmpty()){
            Pair currentWord=que.poll();
            char[] word=currentWord.word.toCharArray();
            int level=currentWord.level;
            int i=0;
            while(i<word.length){
                int j=0;
                char replacement='a';
                char original=word[i];
                while(j<26){
                    word[i]=replacement;
                    String temp = new String(word);
                   
                    if(set.contains(temp) && !visited.contains(temp)) {
                         if (temp.equals(endWord)) return level + 1;
                        que.add(new Pair(temp,level+1));
                        visited.add(temp);
                    }
                    replacement++;
                    j++;
                }
                word[i]=original;
                i++;

            }


        } 
        return 0;
        
    }
}
