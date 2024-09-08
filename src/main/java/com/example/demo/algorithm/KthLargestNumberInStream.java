package com.example.demo.algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class KthLargestNumberInStream {

    private int[] data;
    private int k;


    public void KthLargest(int k, int[] nums) {
        this.data = nums;
        this.k = k;
    }

    public int add(int val) {
        int[] newData = new int[this.data.length + 1];
        for (int i = 0; i < this.data.length; i++) {
            newData[i] = this.data[i];
        }
        newData[this.data.length] = val;
        Arrays.sort(newData);
        this.data = newData;
        return newData[newData.length - this.k];
    }

    public static void main(String[] args) {
//        KthLargestNumberInStream obj = new KthLargestNumberInStream();
//        obj.KthLargest(3, new int[]{4, 5, 8, 2});
//        System.out.println(obj.add(3));
//        System.out.println(obj.add(5));
//        System.out.println(obj.add(10));
//        System.out.println(obj.add(9));
//        System.out.println(obj.add(4));

        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }

    public static class KthLargest {

        int k;
        PriorityQueue<Integer> pq;

        public KthLargest(int k, int[] a) {
            this.k = k;
            pq = new PriorityQueue<>(k);

            for (int n : a)
                add(n);
        }

        public int add(int n) {

            if (pq.size() < k)
                pq.offer(n);

            else if (pq.peek() < n) {
                pq.poll();
                pq.offer(n);
            }

            return pq.peek();
        }

        public static void main(String[] args) {

        }
    }
}
