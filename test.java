package blockchain;

import java.util.*;

public class test {
	static ArrayList<Node> NodeList=new ArrayList<Node>();
	static LinkedList<Block> BlockList=new LinkedList<Block>();
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Node temp;
		Block tempblock1,tempblock2,tempblock3;
		
		temp=new test().MakeNode();
		System.out.println("running");
		tempblock1=new test().MakeBlock(temp);
		tempblock2=new test().MakeBlock(temp);
		tempblock3=new test().MakeBlock(temp);
		new test().TradeUpdate("abc");
		new test().TradeUpdate("abc");
		//new test().PrintNodeBlock(0);
		tempblock1.PrintBlockInfo();
		tempblock2.PrintBlockInfo();
		tempblock3.PrintBlockInfo();
	
	}
	
	public Node MakeNode() 
	{
		Node temp=new Node();
		NodeList.add(temp);
		return temp;
	}
	public Block MakeBlock(Node nd1) 
	{
		Block temp=new Block();
		if(BlockList.size()!=0)
		{
		Game g1=new Game(BlockList.getLast());
		System.out.println("Mining...");
		while(g1.start()==false){	}
		}
		if(BlockList.size()==0)
			temp.SetPreviousblockhash("0");
		else
			temp.SetPreviousblockhash(BlockList.get(BlockList.size()-1).GetHashValue());
			
		temp.SetHashValue();
		//¸¶Áö¸·
		temp.SetBlocknum();
		nd1.AddBlockList(temp);
		BlockList.add(temp);
		return temp;
	}
	public void TradeUpdate(String Info)
	{
		for(int i=0; i<BlockList.size(); i++)
		{
		BlockList.get(i).AddTrade(Info);
		BlockList.get(i).SetMerklehash(Info);
		BlockList.get(i).SetHashValue();
		if(i!=0)
		BlockList.get(i).SetPreviousblockhash(BlockList.get(i-1).GetHashValue());
		}
	}
	public void PrintNodeBlock(int i)
	{
		for(int j=0; j<NodeList.get(i).GetBlockList().size(); j++)
		NodeList.get(i).GetBlockList().get(j).GetBlockNumber();
	}
	

}
