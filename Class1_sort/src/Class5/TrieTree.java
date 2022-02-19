package Class5;

import javax.management.loading.PrivateClassLoader;

public class TrieTree {
    public static class Node1{
        private int pass;
        private int end;
        private Node1[] nexts;

        public Node1(){
            pass=0;
            end=0;
            nexts=new Node1[26];//record path ：count and isEmpty

        }
    }
    public static class Trie1{
        private Node1 root;
        public Trie1(){
            root=new Node1();
        }
        public void insert(String word){
            if(word==null){
                return ;
            }
            char[] cha=word.toCharArray();
            Node1 node=root;//指针初始化指向根节点
            node.pass++;//到根节点也有路
            int path=0;
            for(int i=0;i<cha.length;i++){//遍历这个字符串的字符
                path=cha[i]-'a';//路号
                if(node.nexts[path]==null){//这条路为空,这个点不存在
                    node.nexts[path]=new Node1();
                }
                node=node.nexts[path];//指针跳到新的节点上
            }
            node.end++;//这个字符串录入完成
            
        }
        public int search(String word){
            if(word==null){
                return 0;
            }
            Node1 node=root;

            int path=0;
            char[] cha=word.toCharArray();
            for(int i=0;i<cha.length;i++){
                path=cha[i]-'a';
                if(node.nexts[path]==null){
                    return 0;//no path means no put before
                }
                node=node.nexts[path];//next one

                
            }//能遍历完，说明有这个数
            return node.end;//返回它的次数 
        }
        //查看以pre为前缀的字符串有几个
        //跟seach一样
        public int preCount(String pre){
            if(pre==null){
                return 0;
            }
            Node1 node=root;
            int path=0;
            char[] cha=pre.toCharArray();
            for(int i=0;i<cha.length;i++){
                path=cha[i]-'a';
                if(node.nexts[path]==null){
                    return 0;
                }
                node=node.nexts[path];
            }
            return node.pass;//经过了几次
        }
        public void delete(String word){
            if(search(word)!=0){//首先确定这个字符串存在
                char[] cha=word.toCharArray();
                Node1 node=root;//指到就--
                node.pass--;
                int path=0;
                for(int i=0;i<cha.length;i++){
                    path=cha[i]-'a';
                    //如果沿途有 子结点的pass值为零，那么后面的路都可以不要了
                    if(--node.nexts[path].pass==0){//子结点的pass为0
                        node.nexts[path]=null;//父节点指向空
                    }

                }//能走完，end--
                node.end--;
            }
        }
    }
    
}
