package tictactoe;

public class TicTacToeBoardUtils_Cardenas
{
	TicTacToeBoard board = new TicTacToeBoardImpl_Cardenas();
	

	
	
	// convert coordinates to single value array index
	public static int getGridIndex(int row, int column)
	{
		assert row >= 0 : "row = " + row + " < 0!";
		assert row < TicTacToeBoardImpl_Cardenas.ROW_COUNT : "row = " + row + " >= " + TicTacToeBoardImpl_Cardenas.ROW_COUNT + " = NUM_ROWS!";
		assert column >= 0 : "column = " + column + " < 0!";
		assert column < TicTacToeBoardImpl_Cardenas.ROW_COUNT : "column = " + column + " >= " + TicTacToeBoardImpl_Cardenas.COLUMN_COUNT + " = NUM_COLUMNS!";

		return row * TicTacToeBoardImpl_Cardenas.COLUMN_COUNT + column;
	}
	
	
	// return array index where the key is first matched
	public static int getArrayIndex(int[] intArray, int key)
	{
		int i = 0;
		boolean foundMatch = false;
		while (!foundMatch && i < intArray.length)
		{
			foundMatch = (intArray[i] == key);
			if (!foundMatch)
			{
				i++;
			}
		}

		if (!foundMatch)
		{
			return TicTacToeBoardImpl_Cardenas.NO_MATCH;
		}
		else
		{
			return i;
		}
	}
	


}
