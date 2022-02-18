package tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//import tictactoe.Mark;
//import tictactoe.TicTacToeBoard;
//import tictactoe.TicTacToeBoardImpl_Kart;

public class RandomTestCase {
	@Test
	public void test()
	{
		TicTacToeBoard board = new TicTacToeBoardImpl_Cardenas();
		board.setMark(0, 0);
		board.setMark(0, 1);
		board.setMark(0, 2);
		board.setMark(1, 0);
		board.setMark(1, 1);
		board.setMark(1, 2);
		
		board.setMark(2, 1);
		board.setMark(2, 0);
		board.setMark(2, 2);
		
		assertEquals(board.getMark(0, 0), Mark.X);
		assertEquals(board.getMark(0, 1), Mark.O);
		assertEquals(board.getMark(0, 2), Mark.X);
		assertEquals(board.getMark(1, 0), Mark.O);
		assertEquals(board.getMark(1, 1), Mark.X);
		assertEquals(board.getMark(1, 2), Mark.O);

		assertEquals(board.getMark(2, 1), Mark.X);
		assertEquals(board.getMark(2, 0), Mark.O);
		assertEquals(board.getMark(2, 2), Mark.X);
		
		assertEquals(board.isGameOver(), true);
		assertEquals(board.getWinner(), Mark.X);
		assertEquals(board.getTurn(), null);
		
		System.out.println(board.toString());
	}
}
