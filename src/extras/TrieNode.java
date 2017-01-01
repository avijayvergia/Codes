package extras;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class TrieNode {
    private HashMap<Character, TrieNode> children;
    private boolean isWord;
    private String value;
    Random random=new Random();
    private ArrayList<String> list;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
        value=null;
    }

    public void add(String word) {
        TrieNode crawl = this;
        int n = word.length();
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(crawl.children.containsKey(ch)){
                crawl = crawl.children.get(ch);
            }
            else {
                crawl.children.put(ch, new TrieNode());
                TrieNode temp = crawl.children.get(ch);
                if(i == n-1){
                    temp.isWord = true;
                    temp.value=word;
                }
                crawl = temp;
            }
        }
    }

    public boolean isWord(String word) {
        TrieNode crawl = this;
        int n = word.length();
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(crawl.children.get(ch) == null){
                return false;
            }
            else {
                crawl = crawl.children.get(ch);
                if(i==n-1 && crawl.isWord){
                    return true;
                }

            }
        }
        return false;
    }

    public ArrayList<String> getAnyWordStartingWith(String prefix) {
        list=getWordsWithPrefix(prefix);
        return list;
    }

    public String getGoodWordStartingWith(String prefix) {
        return null;
    }


    public ArrayList<String> getWordsWithPrefix(String prefix) {
        ArrayList<String> results = new ArrayList<>();
        TrieNode x = get(this, prefix, 0);
        collect(x, new StringBuilder(prefix), results);
        return results;
    }

    private void collect(TrieNode x, StringBuilder prefix, ArrayList<String> results) {
        if (x == null) return;
        if (x.value != null) results.add(prefix.toString());
        for (Character c : x.children.keySet()) {
            prefix.append(c);
            collect(x.children.get(c), prefix, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    private TrieNode get(TrieNode x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.children.get(c), key, d+1);
    }
}
