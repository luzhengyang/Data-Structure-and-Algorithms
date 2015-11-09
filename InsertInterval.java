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

public class InsertInterval{
	public static void main(String[] args) {

	}

	public List<Interval> insert (List<Interval> intervals, Interval newInterval){
		List<Interval> result = new ArrayList<Interval>();

		for (Interval i : intervals) {
			if (i.end < newInterval.start) {
				result.add(i);
			}
			else if (i.start > newInterval.end) {
				result.add(newInterval);
				newInterval = i;
			}
			else if (i.end >= newInterval.start || i.start <= newInterval.end) {
				int newStart = Math.min(i.start, newInterval.start);
				int newEnd = Math.max(i.end, newInterval.end);
				newInterval = new Interval(newStart,newEnd);
			}
		}
		result.add(newInterval);
		return result;
	}
}
