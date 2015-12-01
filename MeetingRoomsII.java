// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

// For example,
// Given [[0, 30],[5, 10],[15, 20]],
// return 2.


import java.util.*;

public class MeetingRoomsII{
	public int minMeetingRooms(Interval[] intervals){
		if(intervals == null || intervals.length == 0){
			return 0;
		}

		// sort intervals by start time
		Arrays.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval a, Interval b){
				return a.start - b.start;
			}
		});

		// use minimum heap to keep track of the earlies end time
		PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>(){
			@Override
			public int compare(Interval a, Interval b){
				return a.end - b.end;
			}
		});

		minHeap.offer(intervals[0]);
		for(int i=1; i<intervals.length; i++){
			Interval top = minHeap.poll();	// get the Interval with earliest end time
			if(top.end <= intervals[i].start){	// merge two intervals
				top.end = intervals[i].end;
			}
			else{
				minHeap.offer(intervals[i]);
			}
			minHeap.offer(top);		// DON'T forget to put the top back
		}

		return minHeap.size();
	}
}

class Interval{
	int start;
	int end;
	Interval(){
		start = 0;
		end = 0;
	}
	Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
}
