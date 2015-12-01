// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

// For example,
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


// The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.


public class TrappingRainWater{
	public static int trap(int[] height){
		// 1. find the highest bar
		// 2. from left to highest, compute water
		// 3. from right to highest, compute water

		if(height == null || height.length == 0){
			return 0;
		}

		int water = 0;

		int hmax = 0;	// the index of the highest bar
		for(int i=0; i<height.length; i++){
			if(height[i] > height[hmax]){
				hmax = i;
			}
		}

		// from left to highest bar
		int edge = 0;	// current highest bar from left
		for(int i=0; i<hmax; i++){
			if(height[i] < height[edge]){
				water += height[edge] - height[i];
			}
			else{
				edge = i;
			}
		}

		// from right to highest bar
		edge = height.length-1;		// current highest bar from right
		for(int i=height.length-2; i>hmax; i--){
			if(height[i] < height[edge]){
				water += height[edge] - height[i];
			}
			else{
				edge = i;
			}
		}

		return water;
	}

	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));
	}
}
