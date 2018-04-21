package blockchain;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

public class Block {
	private static int counter=0;
	private int Blocknumber=0; //��� ��ȣ
	private String HashValue="";//���� ��� �ؽ���
	private ArrayList<String> TradeList=new ArrayList<String>();
	private ArrayList<etc> etcList=new ArrayList<etc>();
	//����κ�
	private String Version="";//����Ʈ���� ��������
	private String Previousblockhash="";//������� �ؽ���
	private String Merklehash="";//�ŷ����� �ؽ���
	private String Time="";//�����ð�
	private String Bits="";//���̵�
	private String Nonce="1";
	
	public void SetBlocknum()
	{
		this.Blocknumber=counter++;
	}
	public class etc
	{
		
	}
	public void AddTrade(String tf)
	{
		TradeList.add(tf);
	}
	public int GetBlockNumber()
	{
		return Blocknumber;
	}
	public void SetVersion()
	{
		Version="1.0.0";
	}
	public void SetHashValue()
	{
		this.HashValue=new Block().getSHA256(this.Version+
	this.Previousblockhash+this.Merklehash+this.Time+this.Bits+this.Nonce);
	}
	public void SetPreviousblockhash(String Previousblockhash)
	{
		this.Previousblockhash=Previousblockhash;
	}
	public void SetMerklehash(String Merklehash)
	{
		this.Merklehash="";
		for(int i=0; i<TradeList.size(); i++)
		{
		this.Merklehash+=TradeList.get(i);
		}
		this.Merklehash=this.getSHA256(this.Merklehash);
	}
	public void SetTime(String Time)
	{
		this.Time=Time;
	}
	public void SetBits(String Bits)
	{
		this.Bits=Bits;
	}
	public void SetNonce(String Nonce)
	{
		this.Nonce=Nonce;
	}
	public String GetHashValue()
	{
		return HashValue;
	}

	public void PrintBlockInfo()
	{
		System.out.println("Blocknumber :"+Blocknumber);
		System.out.println("HashValue :"+HashValue);
		System.out.println("Version :"+Version);
		System.out.println("Previousblockhash :"+Previousblockhash);
		System.out.println("Merklehash :"+Merklehash);
		System.out.println("Time :"+Time);
		System.out.println("Bits :"+Bits);
		System.out.println("Nonce :"+Nonce);
		System.out.println("TradeList :");
		for(int i=0;i<TradeList.size();i++)
		{
			System.out.println(TradeList.get(i));
		}
		System.out.println("etcList :");
		for(int i=0;i<etcList.size();i++)
		{
			System.out.println(etcList.get(i));
		}
		System.out.println();
	}
	public static String getSHA256(String input){

		String toReturn = null;
		try {
		    MessageDigest digest = MessageDigest.getInstance("SHA-256");
		    digest.reset();
		    digest.update(input.getBytes("utf8"));
		    toReturn = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		return toReturn;
	    }
}
