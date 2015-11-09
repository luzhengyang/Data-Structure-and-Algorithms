import java.util.*;

class Interval{
	int start;
	int end;
	Interval(){
		start = 0;
		end = 0;
	}
	Interval(int s, int e){
		start = s;
		end = e;
	}
}

public class MergeIntervals{
	public static void main(String[] args) {

	}

	public static ArrayList<Interval> merge(ArrayList<Interval> intervals){
		if (intervals == null || intervals.size() == 0) {
			return intervals;
		}

		// sort intervals in the list
		Collections.sort(intervals, new InveralComparator());

		ArrayList<Interval> result = new ArrayList<Interval>();

		Interval prev = intervals.get(0);
		for (int i=1; i<intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (prev.end >= curr.start) {
				// merge
				Interval merged = new Interval(prev.start, Math.max(prev.end, curr.end));
				prev = merged;
			}
			else {
				// don't merge
				result.add(curr);
				prev = curr;
			}
		}
		return result;
	}
}

class InveralComparator implements Comparator<Interval>{
	public int compare(Interval i1,Interval i2){
		// compare the first numbers in two intervals
		// if i1 == i2, return 0
		// if i1 < i2, return a negative number
		// if i1 > i2, return a postive number
		return i1.start - i2.start;
	}

}
