package tictactoe;

public class TicTacToeBoardImpl_Cardenas implements TicTacToeBoard
{
	// Symbolics:
	protected static final int NO_MOVE = -1;
	protected static final int NO_MATCH = -1;

	protected int[] movesArray;

	public TicTacToeBoardImpl_Cardenas()
	{
		final int CELL_COUNT = ROW_COUNT * COLUMN_COUNT;
		movesArray = new int[CELL_COUNT];
		for (int i = 0; i < CELL_COUNT; i++)
		{
			movesArray[i] = NO_MOVE;
		}
	}

	
	//part of pre 0 <= row < ROW_COUNT && 0 <= column < COLUMN_COUNT
	//part of post rv == null <==> the (row, column) spot on the board is empty
	public Mark getMark(int row, int column)
	{
		assert 0 <= row : "0 > " + row + " = row!";
		assert 0 <= column : "0 > " + column + " = column!";
		assert row < ROW_COUNT : "row = " + row + " >= " + ROW_COUNT + " = ROW_COUNT";
		assert column < COLUMN_COUNT : "column = " + column + " >= " + COLUMN_COUNT + " = COLUMN_COUNT";

		int index = TicTacToeBoardUtils_Cardenas.getGridIndex(row, column);
		int valueIndex = TicTacToeBoardUtils_Cardenas.getArrayIndex(movesArray, index);

		if (valueIndex != NO_MATCH)
		{
			return getArrayIndexMark(valueIndex);
		}
		return null;
	}

	
	
	//part of post: rv == null <==> it is neither player's turn (i.e. 
	 //   game is over) 
	 //part of post: “number of Marks on board is even” rv == Mark.X  
	 //part of post: “number of Marks on board is odd” rv == Mark.O 
	public Mark getTurn()
	{
		if (!isGameOver())
		{
			int index = TicTacToeBoardUtils_Cardenas.getArrayIndex(movesArray, NO_MOVE);
			return getArrayIndexMark(index);
		}
		return null;
	}

	
	
	//part of pre: isGameOver() 
	 //part of post: rv == null <==> neither player won (i.e. the game 
	 //   ended in a tie) 	
	public Mark getWinner()
	{
		assert isGameOver() == true : "Game is not OVER!";

		return hasWinner();
	}
	
	
	
	
	

	// rv: if current state has winner return winner else null
	private Mark hasWinner()
	{
		// top horizontal
		if (getMark(0, 0) == getMark(0, 1) && getMark(0, 0) == getMark(0, 2))
		{
			if (getMark(0, 0) != null)
			{
				return getMark(0, 0);
			}
		}

		// middle horizontal
		if (getMark(1, 0) == getMark(1, 1) && getMark(1, 0) == getMark(1, 2))
		{
			if (getMark(1, 0) != null)
			{
				return getMark(1, 0);
			}
		}

		// bottom horizontal
		if (getMark(2, 0) == getMark(2, 1) && getMark(2, 0) == getMark(2, 2))
		{
			if (getMark(2, 0) != null)
			{
				return getMark(2, 0);
			}
		}

		// middle vertical
		if (getMark(0, 1) == getMark(1, 1) && getMark(0, 1) == getMark(2, 1))
		{
			if (getMark(0, 1) != null)
			{
				return getMark(0, 1);
			}
		}

		// right vertical
		if (getMark(0, 2) == getMark(1, 2) && getMark(0, 2) == getMark(2, 2))
		{
			if (getMark(0, 2) != null)
			{
				return getMark(0, 2);
			}
		}

		// left vertical
		if (getMark(0, 0) == getMark(1, 0) && getMark(0, 0) == getMark(2, 0))
		{
			if (getMark(0, 0) != null)
			{
				return getMark(0, 0);
			}
		}

		// left to right diagonal - from top
		if (getMark(0, 0) == getMark(1, 1) && getMark(0, 0) == getMark(2, 2))
		{
			if (getMark(0, 0) != null)
			{
				return getMark(0, 0);
			}
		}

		// left to right diagonal - from bottom
		if (getMark(2, 0) == getMark(1, 1) && getMark(2, 0) == getMark(0, 2))
		{
			if (getMark(2, 0) != null)
			{
				return getMark(2, 0);
			}
		}
		return null;
	}

	
	
	
	
	// rv: Mark who is assigned to that index position
	private Mark getArrayIndexMark(int i)
	{
		assert i < movesArray.length : "i > movesArray.length! : " + i;

		if (i % 2 == 0)
		{
			return Mark.X;
		}
		return Mark.O;
	}
	
	

	
	//part of post: Left to student (see Tic-tac-toe rules in order  
	 //   to fill this out) 
	public boolean isGameOver()
	{
		if (isTie())
		{
			System.out.println("Tie Game");
			return true;
		}
		else if (hasWinner() != null)
		{
			return true;
		}
		return false;
	}
	
	
	

	// rv: true if game has no winner and if the board is filled
	private boolean isTie()
	{
		if (TicTacToeBoardUtils_Cardenas.getArrayIndex(movesArray, NO_MOVE) == NO_MATCH && hasWinner() == null)
		{
			return true;
		}
		return false;
	}

	
	
	//pre: mark !=null
	//pre getMark(row, column) == null
	//pre: !isGameOver();
	//pre: mark.equals(get.Turn());
	public void setMark(int row, int column)
	{
		assert 0 <= row : "0 > " + row + " = row!";
		assert 0 <= column : "0 > " + column + " = column!";
		assert row < ROW_COUNT : "row = " + row + " >= " + ROW_COUNT + " = ROW_COUNT";
		assert column < COLUMN_COUNT : "column = " + column + " >= " + COLUMN_COUNT + " = COLUMN_COUNT";

		assert !isGameOver() : "Game is over!";
		assert getMark(row, column) == null : "getMark(" + row + ", " + column + ") = " + getMark(row, column) + " is not null!";

		int gridIndex = TicTacToeBoardUtils_Cardenas.getGridIndex(row, column);
		int arrayIndex = TicTacToeBoardUtils_Cardenas.getArrayIndex(movesArray, gridIndex);
		assert arrayIndex == NO_MATCH : "arrayIndex = " + arrayIndex + "! : row = " + row + " column = " + column + " already occupied!";
		int firstNoMovesIndex = TicTacToeBoardUtils_Cardenas.getArrayIndex(movesArray, NO_MOVE);

		// part of pre:
		assert firstNoMovesIndex != NO_MATCH : "gridIndex = " + gridIndex + " already appears in movesArray at array index = " + firstNoMovesIndex + "!";

		movesArray[firstNoMovesIndex] = gridIndex;
	}
	

	public String toString() { 
		
		String stringToPrint = "";
		
		int row = 0;
		int column = 0;
		
		while (row < ROW_COUNT && column < COLUMN_COUNT) 
		{
			Mark mark = getMark(row,column);
		
			if (mark == null) 
			{
				stringToPrint += " ";
			}
			else 
			{
				stringToPrint += mark;
			}
			
			column++;
			
			if (column != COLUMN_COUNT) 
			{
				stringToPrint += "|";
			}
			
			if (column == COLUMN_COUNT) 
			{
				stringToPrint += "\n";
				column = 0;
				row ++;
				
				if (row != ROW_COUNT) 
				{ 
					stringToPrint += "-----" + "\n";
				}
			}
			
		}
	
        return stringToPrint;
     } 
	
}