package blockchain;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Node //��� Ŭ����
{
	private int Nodenumber=0;//��� ��ȣ
	private ArrayList<Block> BlockList=new ArrayList<Block>();
	Node()//������ ��� ��ȣ ���� �� ���
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
