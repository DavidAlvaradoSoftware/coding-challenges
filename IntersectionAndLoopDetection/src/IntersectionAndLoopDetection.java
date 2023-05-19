import java.util.HashMap;

/*
   a) Intersection: Given two (singly) linked lists, determine if the two lists intersect.
       Return the intersecting node.
       - Note that the intersection is defined based on reference, not value. That is, if the kth node
       of the first linked list is the exact same node (by reference) as the jth node of the second linked list,
       then they are intersecting.
    b) Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
    DEFINITION:
    Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node,
    so as to make a loop in the linked list.
    EXAMPLE
    Input: A -> B -> C -> D -> E -> C [the same C as earlier]
    Output: C

* */
public class IntersectionAndLoopDetection {
    public static void main(String[] args){
        //Intersecting list flow
        MyNode<Integer>[] intersectingLists = getIntersectingLists();
        MyNode<Integer> firstList = intersectingLists[0];
        MyNode<Integer> secondList = intersectingLists[1];

        System.out.println(getIntersectingNode(firstList,secondList));

        //Looped list flow
        MyNode<Integer> loopedList = getLoopList();
        System.out.println(getInitialLoopNode(loopedList));


    }

    // Solution involves populating a hashmap with one of the lists
    // using the following key and value pair: <node, valueInsideNode>
    // Then the second list is iterated through, and it checks if the key
    // is already in the hashmap.
    // If the key is in the hashmap, the loop saves the current node and breaks.
    // Since 2 loops are used, you will have a time complexity of O(n+m) for this solution.
    public static MyNode<Integer> getIntersectingNode(MyNode<Integer> listOne, MyNode<Integer> listTwo){
        MyNode<Integer> result = null;
        HashMap<MyNode<Integer>, Integer> nodeBank = new HashMap<>();

        while(listOne != null){
            nodeBank.put(listOne, listOne.getValue());
            listOne = listOne.getNext();
        }

        while(listTwo != null){
            if(nodeBank.containsKey(listTwo)){
                result = listTwo;
                break;
            }
            listTwo = listTwo.getNext();
        }

        return result;
    }

    // Solution involves populating a hashmap with potential looped list
    // using the following key and value pair: <node, valueInsideNode>
    // During this process, we check if the key (which is the node) is in the map.
    // If it is, it means that we've seen that node before therefore
    // we must break the loop and return the node.
    // Since only 1 loop is used, the time complexity is O(n)
    public static MyNode<Integer> getInitialLoopNode(MyNode<Integer> list){
        MyNode<Integer> result = null;
        HashMap<MyNode<Integer>, Integer> nodeBank = new HashMap<>();

        while(list != null){
            if(nodeBank.containsKey(list)) {
                result = list;
                break;
            }
            nodeBank.put(list, list.getValue());
            list = list.getNext();}
            return result;
    }

    public static MyNode<Integer>[] getIntersectingLists(){
        MyNode<Integer> firstList = new MyNode<>(0);
        MyNode<Integer> secondList = new MyNode<>(0);
        MyNode<Integer> currentNode = firstList;
        MyNode<Integer> intersectingNode;

        for(int i = 0; i < 10; i++){
            MyNode<Integer> newNode = new MyNode<>(i+1);
            currentNode.setNext(newNode);
            currentNode = currentNode.getNext();
        }

        intersectingNode = currentNode;
        currentNode = secondList;
        for(int j = 0; j < 15; j+=3){
            MyNode<Integer> newNode = new MyNode<>(j+2);
            currentNode.setNext(newNode);
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(intersectingNode);
        MyNode<Integer>[] result = new MyNode[]{firstList,secondList};
        return result;
    }

    public static MyNode<Integer> getLoopList(){
        MyNode<Integer> loopedList = new MyNode<>(0);
        MyNode<Integer> currentNode = loopedList;
        MyNode<Integer> loopedNode = null;

        for(int i = 5; i < 15; i++){
            if(i == 10) loopedNode = currentNode;
            MyNode<Integer> newNode = new MyNode<>(i);
            currentNode.setNext(newNode);
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(loopedNode);
        return loopedList;

    }
}

