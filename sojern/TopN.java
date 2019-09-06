/**
 * 
 * @author manish
 * 
 * Build a tree from the file. then traverse the right links to get to the highest node. 
 * We can do recursion as done for inorder traversal but following right,root and then left. 
 * stop printing after the size variable is exceeded. 
 *
 */

/*************************************RunTime************************
* 1. The tree.build_Tree runs for (log n) time average case and scanning input will take (n). 
* 2. Traversing in one of the branches looking for the right location.Hence it takes n*Log(n) time to build a tree and scanning.
* 3. while getting the required N nodes, we traverse along all the node so it takes n time. A total of O(n + n*Log(n)) in average case.
* 4. In worst case there may be the tree would be linear and the runtime would be O(n + n^2).
* Space complexity would be O(n), required to store the n data in the tree.
****************************Improvement******************************
* A self balancing tree guarantees that insertion happens in Log(n) time. Henece over all runtime would come to (n + n*Log(n))
* We can also do this with Heap data structure to store max_Heap. scanning all the n data in the array. will take O(n) time. Building heap will take 
* linear time case O(n). we can than swap the top root with the last element and remove it, then run heapify from the root. deleteing a element 
* is done in constant,heapify will take O(Log(n)). So total worst case Runtime O(2n + m*Log(n)) where m is the number of element to be deleted.
**/

import java.io.File;
import java.util.Scanner;

public class TopN {
	
	public TopN() {
		
	}
	
	private void build_Tree(Node<Double> root,Double val) {
			Node<Double> parent= null ;
			while(root!=null){
				parent = root;
				if(val<= root.val)
					root = root.left;
				else
					root = root.right;
			}
			
			Node<Double> current = new Node<Double>(val);
			if(val<=parent.val)
				parent.left = current;
			else
				parent.right = current;
	}
	
	private int largest(Node<Double> root, int n) {
		if(root == null)
			return n;

		n= largest(root.right,n);
		if(n>0) {
			System.out.print(root.val +" ");
			n=n-1;
		}
		return largest(root.left,n);		
	}

	public static void main(String[] args) {
		try {
		double number;
		Node<Double> root = null;
		TopN tree = new TopN();
		int size = Integer.parseInt(args[1]); 
		if(size<=0)
			return;
		File input = new File(args[0]);
		Scanner sc = new Scanner(input);
		while(sc.hasNextDouble()) {
			number = sc.nextDouble();
			if(root == null)
				root = new Node<Double>(number);
			else
				tree.build_Tree(root,number);
		}
		tree.largest(root,size);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
