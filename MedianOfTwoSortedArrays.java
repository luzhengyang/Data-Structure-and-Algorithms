// There are two sorted arrays nums1 and nums2 of size m and n respectively.
// Find the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).



// Don't know how to solve the problem with O(log(m+n))
// The solution here is O(n)

public class MedianOfTwoSortedArrays{
	public double findMedianSortedArrays(int[] nums1, int[] nums2){
		int total = nums1.length + nums2.length;
		if(total % 2 == 0){
			return findkth(nums1, nums2, total/2) + findkth(nums1, nums2, total/2+1);
		}
		else{
			return findkth(nums1, nums2, total/2+1);
		}
	}

	private int findkth(int[] a, int[] b, int k){
		int m = 0;
		int n = 0;
		for(int i=0; i<k-1; i++){
			if(m >= a.length && n < b.length){
				n++;
			}
			else if(n >= b.length && m < a.length){
				m++;
			}
			if(a[m] > b[n]){
				n++;
			}
			else{
				m++;
			}
		}
		if(m >= a.length){
			return b[n];
		}
		else if(n >= b.length){
			return a[m];
		}
		else if(a[m] > b[n]){
			return b[n];
		}
		else{
			return a[m];
		}
	}
}
