/****
 * 
 * @author manish
 * 
 * look for minimum size of the two list. keep comparing one by one if still equal 
 * then iterate through rest of the larger of the list.If we got any number greater than zero
 * return accordingly.
 ******************************************Runtime************************
 * The spliting the string across "." can be done in O(n). The checker function runs in O(n) time.
 * Depending on which string list is longest. The worst case runtime would be O(n).
 * Space complexity would be space taken to store the two list min and max.  
 *
 */

public class Versions {
	
	public int checker(String [] first,String [] second) {
		String [] min = (first.length - second.length) >= 0? second:first;
		String [] max = (first.length - second.length) < 0? second:first;
		
		for(int i=0;i<min.length;i++) {
			int a = Integer.parseInt(first[i]);
			int b = Integer.parseInt(second[i]);
			if((a-b) < 0)
				return -1;
			else if((a - b) > 0)
				return 1;
			else
				continue;
		}
		if(max.length != min.length) {
			for(int i=min.length;i<max.length;i++) {
				if(Integer.parseInt(max[i])>0) {
					if(first.length == max.length)
						return 1;
					else
						return -1;
				}		
					
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		String [] first = args[0].split("\\.");
		String [] second = args[1].split("\\.");
		Versions version = new Versions();
		int c = version.checker(first, second);
		System.out.println(c);
	}

}
