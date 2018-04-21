package blockchain;

public class Game {
	private char key;
	Game(Block bk)
	{
		key=bk.GetHashValue().charAt(0);
	}
	public boolean start()
	{
		
		return true;
	}
}
