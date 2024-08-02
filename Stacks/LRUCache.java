package Stacks;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
        //create a double linked list to store the nodes
        Node head=new Node(0,0);
        Node tail=new Node(0,0);
        Map<Integer,Node> map=new HashMap<>();
        int capacity;
        LRUCache(int capacity){
            head.next=tail;
            tail.prev=head;
            this.capacity=capacity;
        }


        public int get(int key){
           if(map.containsKey(key)){
               Node node=map.get(key);
               remove(node);
               insert(node);
               return node.value;
           }else{
               return -1;
           }
        }

        public void put(int key,int value){
            if(map.containsKey(key)){
                remove(map.get(key));
            }

            if(map.size()==capacity){  //if size is full then remove least recently used one and add the current
                remove(tail.prev);
            }

            insert(new Node(key,value));
        }

        private void remove(Node node){
            map.remove(node.key);
            node.prev.next=node.next;
            node.next.prev=node.prev;
        }

        private void insert(Node node){
            map.put(node.key,node);
            node.next=head.next;
            node.next.prev=node;
            head.next=node;
            node.prev=head;
        }
}



class Node{
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key,int value){
        this.key=key;
        this.value=value;
        this.prev=null;
        this.next=null;
    }
}
