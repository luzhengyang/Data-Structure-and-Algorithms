class TrieNode {
    public char val; //当前结点的字符
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26]; //当前结点的26个孩子结点
    public TrieNode(){}
    TrieNode(char c){
        TrieNode node = new TrieNode();
        node.val = c;
    }
}

public class Trie {
    private TrieNode root;
    public Trie() {         //构造空的根节点
        root = new TrieNode();
    }

    public void insert(String word) {   //插入一个单词
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.children[c - 'a'] == null){       //如果当前字符不存在，则创建一个新结点保存这个字符
                cur.children[c - 'a'] = new TrieNode(c);
            }
            cur = cur.children[c - 'a']; //向下转
        }
        cur.isWord = true;   //完成后，在最后一个结点记录这已经是一个完整的单词了
    }

    public boolean search(String word) {    //搜索一个单词
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.children[c - 'a'] == null) return false;  //一旦发现某个字符不存在，则返回false
            cur = cur.children[c - 'a']; //向下转
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c : prefix.toCharArray()){
            if(cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return true;
    }
}
