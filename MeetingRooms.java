// Given an array of meeting time intervals consisting of start and end times
// [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

// For example,
// Given [[0, 30],[5, 10],[15, 20]],
// return false.

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms{
	public static boolean canAttend(Interval[] intervals){
		Arrays.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval a, Interval b){
				return a.start - b.start;
			}
		});

		for(int i=0; i<intervals.length-1; i++){
			if(intervals[i].end > intervals[i+1].start){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Interval interval1 = new Interval(0,30);
		Interval interval2 = new Interval(5,10);
		Interval interval3 = new Interval(15,20);
		Interval[] intervals = {interval1,interval2,interval3};
		System.out.println(canAttend(intervals));
	}
}

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
