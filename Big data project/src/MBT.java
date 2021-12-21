import java.io.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import org.bouncycastle.*;
import org.bouncycastle.jcajce.provider.digest.Keccak;
import org.bouncycastle.util.encoders.Hex;
import java.nio.charset.StandardCharsets;

public class MBT {
	
	public static void lookup(int key,Node node)
	{
		if(node==null)
		{
			return ;
		}
		if(node.getBucketID()==key && node.getLeftChild()==null && node.getRightChild()==null)
		{
			System.out.println("This is the value of key"+key+" " +node.getData()+ " and this is its hashvalue "+node.getHashValue());
		}
		//System.out.println(node.getData());
		lookup(key,node.getLeftChild());
		lookup(key,node.getRightChild());
		
	}
	
	public static String hashComputation(String data)
	{
		Keccak.Digest256 digest = new Keccak.Digest256();
        byte[] byteArray = digest.digest(
                data.getBytes(StandardCharsets.UTF_8));
        return new String(Hex.encode(byteArray));
		
	}
	
	public static void printPreorder(Node node)
	{
		if(node==null)
		{
			return;
		}
		
		System.out.println(node.getBucketID()+" "+node.getData()+ " "+node.getIsBucket()+" "+node.getHashValue()+" "+node.bucketValue());
		printPreorder(node.getLeftChild());
		printPreorder(node.getRightChild());
	}
	
	public static void createMBT(TreeMap<Integer,String> data,int lookupkey)
	{
		TreeMap<Integer, String> t=new TreeMap<Integer,String >();
		ArrayList<Node> children=new ArrayList<>();
		ArrayList<Node> parent=new ArrayList<>();
		for(int i=0;i<data.size();i++)
		{
			t.put(i+1,data.get(i+1));
			children.add(new Node(null,null,hashComputation(data.get(i+1)),i+1,true,data.get(i+1),t));
			t=new TreeMap<Integer,String>();
		}
		
		while(children.size()>1)
		{
			int index=0;
			int len=children.size();
			while(index<len-1)
			{
			Node lc=children.get(index);
			Node rc=children.get(index+1);
			parent.add(new Node(lc,rc,hashComputation(lc.getData()+rc.getData()),0,false,null,new TreeMap<Integer, String>()));
			index=index+2;
			}
			children=parent;
			parent=new ArrayList<>();
			
		}
		
		Node root=children.get(0);
		
		//Printing of tree in preorder traversal
		printPreorder(root);
		System.out.println("\n");
		lookup(lookupkey,root);
		
		System.out.println(Integer.parseInt(hashComputation("1"))%4);
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		TreeMap<Integer, String> input=new TreeMap<Integer, String>();
		
		input.put(1,"Bitcoin");
		input.put(2,"Ethereum");
		input.put(3,"Solana");
		input.put(4,"XRP");
		
		System.out.println("Enter lookup key");
		int index=sc.nextInt();
		createMBT(input,index);
		

}
}
