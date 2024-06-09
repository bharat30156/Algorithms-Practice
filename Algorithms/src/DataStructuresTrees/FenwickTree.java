package DataStructuresTrees;

public class FenwickTree {
	
	int n;
	private int[] fen_t;
	
	
	// constructor which takes the size of the array as a parameter
	public FenwickTree(int n) {
		this.n = n;
		this.fen_t = new int[n + 1]; 
	}
	
	// A function which will add the element val at index i
	
	public void update(int i , int val) {
		//As index starts from 0, increment the index by 1 
		i += 1;
		while(i <= n) {
			fen_t[i] += val;
			i += i & (-i);
		}
	}
	
	// A function which will return the  s index
	public int query(int i) {
		//As index starts from 0, increment the index 1
		i += 1;
		int cumSum = 0;
		while(i > 0) {
			cumSum += fen_t[i];
			i -= i & (-i);
		}
		return cumSum;
	}
}
