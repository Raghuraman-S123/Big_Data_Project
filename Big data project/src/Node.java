import java.util.*;
public class Node{
	
	private Node leftChild;
	private Node rightChild;
	private String hashValue;
	private int bucketID;
	private boolean isBucket;
	private String data;
	private TreeMap<Integer,String> bucket;
	
	public Node(Node leftChild, Node rightChild,String hashValue, int bucketID, boolean isBucket,String data,TreeMap<Integer,String> bucket)
	{
		this.leftChild=leftChild;
		this.rightChild=rightChild;
		this.hashValue=hashValue;
		this.bucketID=bucketID;
		this.isBucket=isBucket;
		this.data=data;
		this.bucket=bucket;
	}
	
	public Node getLeftChild()
	{
		return leftChild;
	}
	public void setLeftChild()
	{
		this.leftChild=leftChild;
	}
	
	public Node getRightChild()
	{
		return rightChild;
	}
	public void setRightChild()
	{
		this.rightChild=rightChild;
	}
	public String getHashValue()
	{
		return hashValue;
	}
	public void setHashValue()
	{
		this.hashValue=hashValue;
	}
	
	public boolean getIsBucket()
	{
		return isBucket;
	}
	public void setIsBucket()
	{
		this.isBucket=isBucket;
	}
	
	public int getBucketID()
	{
		return bucketID;
	}
	public void setBucketID()
	{
		this.bucketID=bucketID;
	}
	
	public String getData()
	{
		return data;
	}
	public void setData()
	{
		this.data=data;
	}
	
	public Set bucketValue()
	{
		return bucket.entrySet();
	}
	
}