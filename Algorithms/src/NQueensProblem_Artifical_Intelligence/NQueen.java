package NQueensProblem_Artifical_Intelligence;

public class NQueen {
	private int row;
	private int column;
	
	public NQueen(int row, int column)
	{
		this.row = row;
		this.column = column;
	}
	
	public int getRow()
	{
		return row;
	}
	
	public int getColumn()
	{
		return column;
	}
	
	public void move()
	{
		row++;
	}
	
	public boolean ifConflict(NQueen q)
	{
		if(row == q.getRow() || column == q.getColumn())
			return true;
		// check diagonals
		else if(Math.abs(column - q.getColumn()) == Math.abs(row - q.getRow()))
			return true;
		return false;
	}
}
