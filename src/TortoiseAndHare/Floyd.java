package TortoiseAndHare;

/**
 * Floyd.java
 *
 * Reference: https://www.youtube.com/watch?v=pKO9UjSeLew
 *
 * Copyright 2020 Aiden Xie (siqixie@buffalo.edu)
 *
 * This work is licensed under the Creative Commons
 * Attribution-NonCommercial-ShareAlike 4.0 International License.
 * To view a copy of this license, visit
 * http://creativecommons.org/licenses/by-nc-sa/4.0/.
 *
 */

public class Floyd {
    public static void main(String args[]){
        int[] input = new int[]{3,4,2,5,6,1,2};
        System.out.println(findDuplicate(input));
    }

    public static int findDuplicate(int[] nums){
        int tort = nums[0];
        int hare = nums[0];

        while(true){
            tort = nums[tort];
            hare = nums[nums[hare]];
            if(tort == hare)
                break;
        }

        int ptr1 = nums[0];
        int ptr2 = tort;
        while(ptr1 != ptr2){
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }
}
