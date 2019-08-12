package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //System.out.println(climbStairs(5));
        System.out.println(sumToZero(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static int climbStairs(int steps){ // 4 -> 22, 1111 , 2 1 1, 112, 121
        if(steps == 1){
            return 1;
        }
        if(steps==2){
            return 2;
        }
        return climbStairs(steps-1) + climbStairs(steps-2);
    }                           // 3                        2

    /*
    Given array nums = [-1, 0, 1, 2, -1, -4],   -4 -1, -1, 0 1 2 [-1, 0, 1, 2, -1, -4]

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
     */
    public static ArrayList<ArrayList<Integer>> sumToZero(int[] input){
        int j,k;
        Arrays.sort(input);
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int i=0;i<input.length;i++){
            j =i +1; k = input.length-1;
            while (j<k){
                if(input[i]+input[j]+input[k]==0){
                    ArrayList<Integer> output = new ArrayList<>();
                    output.add(input[i]);
                    output.add(input[j]);
                    output.add(input[k]);
                    if(!lists.contains(output))
                        lists.add(output);
                    j++;
                    k--;
                }else if(input[i]+input[j]+input[k]<0){
                    j++;
                }else if(input[i]+input[j]+input[k]>0){
                    k--;
                }
            }
        }
        return lists;
    }
    // 1 2 3 2 1   -

    public int intersectionOfLinkedLists(Link head1, Link head2){
       while (head2.next!=null){
            head1 = head1.next;
            head2
       }
    }

}
