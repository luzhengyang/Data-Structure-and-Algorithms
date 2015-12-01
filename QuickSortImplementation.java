import java.util.*;

public class QuickSortImplementation{
	public static void quickSort(Queue<Integer> S, Comparator<Integer> comp){
		int n = S.size();
		if(n < 2){
			return;
		}
		int pivot = S.peek();
		Queue<Integer> L = new LinkedList<Integer>();
		Queue<Integer> E = new LinkedList<Integer>();
		Queue<Integer> G = new LinkedList<Integer>();

		// divide
		while(!S.isEmpty()){
			int element = S.poll();
			int c = comp.compare(element, pivot);
			if(c < 0){
				L.offer(element);
			}
			else if(c == 0){
				E.offer(element);
			}
			else{
				G.offer(element);
			}
		}

		// conquer
		quickSort(L, comp);
		quickSort(G, comp);

		// concatenate results
		while(!L.isEmpty()){
			S.offer(L.poll());
		}
		while(!E.isEmpty()){
			S.offer(E.poll());
		}
		while(!G.isEmpty()){
			S.offer(G.poll());
		}
	}
}
