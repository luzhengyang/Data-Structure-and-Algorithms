// The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi],
// where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively,
// and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0.
// You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

// For instance, the dimensions of all buildings in Figure A are recorded as:
// [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

// The output is a list of "key points" (red dots in Figure B)
// in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline.
// A key point is the left endpoint of a horizontal line segment.
// Note that the last key point, where the rightmost building ends,
// is merely used to mark the termination of the skyline, and always has zero height.
// Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

// 如果按照一个矩形一个矩形来处理将会非常麻烦，我们可以把这些矩形拆成两个点，一个左上顶点，一个右上顶点。
// 将所有顶点按照横坐标排序后，我们开始遍历这些点。
// 遍历时，通过一个堆来得知当前图形的最高位置。
// 堆顶是所有顶点中最高的点，只要这个点没被移出堆，说明这个最高的矩形还没结束。
// 对于左顶点，我们将其加入堆中。对于右顶点，我们找出堆中其相应的左顶点，然后移出这个左顶点，同时也意味这这个矩形的结束。
// 具体代码中，为了在排序后的顶点列表中区分左右顶点，左顶点的值是正数，而右顶点值则存的是负数


import java.util.*;

public class SkylineProblem{
	public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        if(buildings == null || buildings.length == 0){
            return res;
        }
        List<int[]> height = new ArrayList<int[]>();
        for(int[] b : buildings){
            height.add(new int[]{b[0], -b[2]}); // b[0] is x1
            height.add(new int[]{b[1], b[2]});  // b[1] is x2
        }

        Collections.sort(height, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] != b[0]){
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        });

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(height.size(), new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b - a;           // sort from highest to lowest
            }
        });

        maxHeap.offer(0);   // the last point;
        int prev = 0;   // the previous height
        for(int[] h : height){      // h[] is {x1/x2, Hi}
            if(h[1] < 0){      // if it's x1 (Hi < 0), add to heap
                maxHeap.offer(-h[1]);
            }
            else{       // if it's x2 (Hi > 0), remove x1
                maxHeap.remove(h[1]);
            }
            int cur = maxHeap.peek();
            if(prev != cur){
                res.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return res;
    }

    public void test(){
    	int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
    	List<int[]> res = getSkyline(buildings);
    	for(int[] h : res){
    		for(int i=0; i<h.length; i++){
    			System.out.print(i+",");
    		}
    		System.out.println();
    	}
    }

    public static void main(String[] args) {
    	SkylineProblem sp = new SkylineProblem();
    	sp.test();
    }
}
