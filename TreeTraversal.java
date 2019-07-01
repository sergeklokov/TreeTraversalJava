import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

// ****************************************************************************
// Tree: Height of a Binary Tree
// Hacker Rank website do not have C# for this exercise, so I have to use Java
// And I used to program on Fortran too :) 
//
// https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
//
// Created by Serge Klokov 2019
// ****************************************************************************
class Solution {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static int height(Node root) {
            // Logic depends how we count depth/height. 
            // If we count from 0, then finish with -1
            // If we count from 1, then finish with  0
            if (root == null)
                return -1;  

            /* compute the   of each subtree */
            int lDepth = height(root.left);
            int rDepth = height(root.right);

            /* use the larger one */
            return lDepth > rDepth ? lDepth + 1 : rDepth + 1;
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}