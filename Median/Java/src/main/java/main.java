
//1) Median of Two Sorted Arrays
//        Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
//        The overall run time complexity should be O(log (m+n)).
//
//        Example1:
//        Input:nums1 = [1,3], nums2 = [2]
//        Output:2.00000
//        Explanation: merged array = [1,2,3] and median is 2.
//
//        Example2:
//        Input:nums1 = [1,2], nums2 = [3,4]
//        Output:2.50000
//        Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
//
//        Constraints:
//
//
//        nums1.length == m
//
//        nums2.length == n
//
//        0 <= m <= 1000
//
//        0 <= n <= 1000
//
//        1 <= m + n <= 2000
//
//        -106 <= nums1[i], nums2[i] <= 106

public class main {

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};

        double result = findMedian(nums1, nums2);
        System.out.println(result);
        
    }

    public static double findMedian(int[] nums1, int[] nums2){
        double result = -200.00;

        if(nums1.length == 0)
            result = findMedianFromSingleArray(nums2);
        else if (nums2.length == 0)
            result = findMedianFromSingleArray(nums1);
        else {
            int[] mergedArray = mergeArrays(nums1,nums2);
            result = findMedianFromSingleArray(mergedArray);
        }
        return result;
    }

    public static int[] mergeArrays(int[] nums1, int[] nums2){
        int totalSize = nums1.length + nums2.length;
        int[] mergedArray = new int[totalSize];
        int nums1Iterator = 0;
        int nums2Iterator = 0;


        for(int i = 0; i < mergedArray.length; i++){
            if(nums1Iterator >= nums1.length) {
                mergedArray[i] = nums2[nums2Iterator];
                nums2Iterator++;
            } else if (nums2Iterator >= nums2.length){
                mergedArray[i] = nums1[nums1Iterator];
                nums1Iterator++;
            } else {
                if(nums1[nums1Iterator] > nums2[nums2Iterator]){
                    mergedArray[i] = nums2[nums2Iterator];
                    nums2Iterator++;
                }else {
                    mergedArray[i] = nums1[nums1Iterator];
                    nums1Iterator++;
                }
            }
        }

        return mergedArray;
    }

    public static double findMedianFromSingleArray(int[] nums){
        int median = nums.length/2;

        // taking into consideration if the list is an even or odd number.
        return nums.length % 2 == 0 ? ((double)(nums[median] + nums[median - 1]) / 2.0) : nums[median];

    }
}
