package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//PREorder: ROOT|Left|Right
//INorder: Left|ROOT|Right
//POSTorder: Left|Right|ROOT

//https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/?envType=daily-question&envId=2024-08-12
public class TreePostOrderTravel {

    //stack approach, iterate tree, for each node, add val to the head of array
//    public List<Integer> postorder(Node root) {
//        List<Integer> list = new ArrayList<>();
//        if (root == null) {
//            return list;
//        }
//        Stack<Node> stack = new Stack<>();
//        stack.add(root);
//        while (!stack.empty()) {
//            Node cur = stack.pop();
//            stack.addAll(cur.children);
//            list.add(0, cur.val);
//        }
//        return list;
//    }

    //recursive approach
    public List<Integer> postorder(Node root) {
        List<Integer> integers = new ArrayList<>();
        recursiveOrder(root, integers);
        return integers;
    }

    public void recursiveOrder(Node node, List<Integer> integers) {
        if(node==null){
            return;
        }
        for (int i = 0; i< node.children.size(); i++) {
            recursiveOrder(node.children.get(i), integers);
        }
        integers.add(node.val);
    }


    public static void main(String[] args) {
        TreePostOrderTravel postOrderTravel = new TreePostOrderTravel();
        Node root = new Node(1);
        root.children.add(new Node(3));
        root.children.add(new Node(2));
        root.children.add(new Node(4));

        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));

        System.out.println(postOrderTravel.postorder(root));
    }
}


// Definition for a Node.
class Node {
    public int val;
    public List<Node> children = new ArrayList<>();

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}


//class Solution {
//    public List<Integer> postorder(Node root) {
//
//    }
//}

