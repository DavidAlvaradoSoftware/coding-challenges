package main;

import java.util.*;
import java.util.stream.Collectors;

//2) Mergek Sorted Lists
//        You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
//        Merge all the linked-lists into one sorted linked-list and return it.
//
//        Example1:
//        Input: lists = [[1,4,5],[1,3,4],[2,6]]
//        Output:[1,1,2,3,4,4,5,6]
//        Explanation: The linked-lists are:
//        [
//        1->4->5,
//        1->3->4,
//        2->6
//        ]
//        merging them into one sorted list:
//        1->1->2->3->4->4->5->6
//
//        Example2:
//        Input: lists= []
//        Output: []
//
//        Example3:
//        Input: lists = [[]]
//        Output: []
//
//        Constraints:
//
//        k == lists.length
//
//        0 <= k <= 104
//
//        0 <= lists[i].length <= 500
//
//        -104 <= lists[i][j] <= 104
//
//        lists[i] is sorted in ascending order.
//
//        The sum of lists[i].length will not exceed 104.

/************************************
*   Time complexity for this solution:
 *   2 for (NOT NESTED) loops + Collection.sort(mergeSort): O(2n + nlog(n)) = O(nlog(n))
*
*********************************** */
public class MergeKList {

    public static void main(String[] args) {

        // Add desired input here
        Integer[][] lists = {{1,4,5},{1,3,4},{2,6}};

        //Convert 2D array into a linked list array.
        LinkedList<Integer>[] linkedListArray = convertToLinkedListArray(lists);

        // Turn LinkedListArray into a single linked list.
        LinkedList<Integer> singleList = convertToSingleLinkedList(linkedListArray);
        // Sort newly created list.
        Collections.sort(singleList);
        //print result.
        System.out.println(singleList);
    }

    //Method takes in a 2D array and converts it into a LinkedList array
    public static LinkedList<Integer>[] convertToLinkedListArray(Integer[][] inputList){
        LinkedList[] convertedList = new LinkedList[inputList.length];
        int iterator = 0;
        for(Integer[] currentArray : inputList){
            LinkedList<Integer> currentLinkedList = new LinkedList<Integer>(Arrays.asList(currentArray));
            convertedList[iterator] = currentLinkedList;
            iterator++;
        }
        return convertedList;
    }

    public static LinkedList<Integer> convertToSingleLinkedList(LinkedList<Integer>[] inputList){
        LinkedList<Integer> result = new LinkedList<>();
        for(LinkedList<Integer> currentList: inputList){
            result.addAll(currentList);
        }
        return result;
    }

}
