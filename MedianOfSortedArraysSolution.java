package com.java.ds;

/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

Input: ar1[] = {-5, 3, 6, 12, 15}
        ar2[] = {-12, -10, -6, -3, 4, 10}
Output : The median is 3.
Explanation : The merged array is :
        ar3[] = {-12, -10, -6, -5 , -3,
                 3, 4, 6, 10, 12, 15},
       So the median of the merged array is 3

Input: ar1[] = {2, 3, 5, 8}
        ar2[] = {10, 12, 14, 16, 18, 20}
Output : The median is 11.
Explanation : The merged array is :
        ar3[] = {2, 3, 5, 8, 10, 12, 14, 16, 18, 20}
        if the number of the elements are even, 
        so there are two middle elements,
        take the average between the two :
        (10 + 12) / 2 = 11.
        
 */
public class MedianOfSortedArraysSolution {

	public static void main(String[] args) {

		int ar1[] = { 1, 2 }; // { 2, 3, 5, 8, 23 }; // { -5, 3, 6, 12, 15 };
		int ar2[] = { 3, 4 }; // { 10, 12, 14, 16, 18, 20 }; // { -12, -10, -6, -3, 4, 10 };

		int ar3[] = mergeSortedArrays(ar1, ar2);

		if (ar3.length % 2 == 1) {
			System.out.print((double) ar3[ar3.length / 2]);
		} else {
			System.out.print((double) (ar3[(ar3.length - 1) / 2] + ar3[(ar3.length + 1) / 2]) / 2);
		}
	}

	private static int[] mergeSortedArrays(int[] ar1, int[] ar2) {

		int n = 0;
		int m = 0;
		int l = 0;
		int ar3[] = new int[ar1.length + ar2.length];

		while (n < ar1.length || m < ar2.length) {

			if (n == ar1.length || (m != ar2.length && ar1[n] > ar2[m])) {
				ar3[l] = ar2[m];
				m++;
			} else {
				ar3[l] = ar1[n];
				n++;
			}
			l++;
		}

		return ar3;
	}

}
