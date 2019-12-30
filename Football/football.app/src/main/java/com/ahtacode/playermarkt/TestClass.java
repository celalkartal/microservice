package com.ahtacode.playermarkt;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String body ="<TransactionId>5754</TransactionId>";
		int start=body.indexOf("<TransactionId>");
		int end =body.indexOf("</TransactionId>");
		String TransactionId =body.substring(start+15, end);
		System.out.print(TransactionId);
	}

}
