package BinaryTrees;

import java.util.Scanner;

public class BinaryTree {

   //inner class having a structure of  node
    private static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
        }
    }

    //reference to root node
    private Node root;

    public void construct(Scanner sc){
        System.out.println("Enter the root node: ");
        int value=sc.nextInt();
        root=new Node(value);
        construct(sc,root);
    }

    private void construct(Scanner sc,Node root){
        System.out.println("Do you want to enter the left node of "+root.data);
        boolean left=sc.nextBoolean();
        if(left){
            System.out.println("Enter the value of left node: ");
            int data=sc.nextInt();
            root.left=new Node(data);
            construct(sc,root.left);
        }

        System.out.println("Do you want to enter the right node of "+root.data);
        boolean right=sc.nextBoolean();
        if(right){
            System.out.println("Enter the value of right node: ");
            int data=sc.nextInt();
            root.right=new Node(data);
            construct(sc,root.right);
        }
    }


    public void display(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.data+" ");
        display(root.left);
        display(root.right);
    }

    public void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder(Node root){
        if(root==null) return;

        inorder(root.left);
        System.out.println(root.data+" ");
        inorder(root.right);
    }

    public void postorder(Node root){
        if(root==null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data+" ");
    }
}
