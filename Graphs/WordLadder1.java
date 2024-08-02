package Graphs;

import java.util.*;

public class WordLadder1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Queue<Pair<String,Integer>> q=new LinkedList<>();

            Set<String> st=new HashSet<>();
            int n=wordList.size();
            //add all the elements into the set for efficient insertion and deletion
            for(int i=0;i<n;i++){
                st.add(wordList.get(i));
            }

            q.add(new Pair<>(beginWord,1));
            st.remove(beginWord);

            while(!q.isEmpty()){
                String word=q.peek().first;
                int steps=q.peek().second;
                q.poll();

                if(word.equals(endWord)) return steps;

                for(int i=0;i<word.length();i++){
                    for(char ch='a';ch<='z';ch++){
                        StringBuilder sb=new StringBuilder(word);
                        sb.setCharAt(i,ch);
                        String newWord=sb.toString();
                        if(st.contains(newWord)){
                            q.add(new Pair<>(newWord,steps+1));
                            st.remove(newWord);
                        }
                    }
                }
            }
            return 0;
    }
}
