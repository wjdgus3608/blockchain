package blockchain;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Node //노드 클래스
{
	private int Nodenumber=0;//노드 번호
	private ArrayList<Block> BlockList=new ArrayList<Block>();
	Node()//생성시 노드 번호 증가 및 출력
	{
		this.Nodenumber++;
		System.out.println("Nodenum :"+this.Nodenumber);
	}
	public void AddBlockList(Block bk)
	{
		BlockList.add(bk);
	}
	public ArrayList<Block> GetBlockList()
	{
		return BlockList;
	}

}
