import java.util.*;

public class UndirectedGraphNode{
	int label;
	List<UndirectedGraphNode> neighbors;
	public UndirectedGraphNode(int x){
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}
