package com.arun;

import java.util.List;

public class Test {

	public static void main(String[] args) {

		BlockChain blockChain = new BlockChain();

		Block newBlock = new Block(1, "10/05/1991", "Certificate ");
		blockChain.addBlock(newBlock);

		newBlock = new Block(2, "10/07/1997", "LL Birthday");
		blockChain.addBlock(newBlock);

		newBlock = new Block(3, "21/06/1999", "KK Birthday");
		blockChain.addBlock(newBlock);
		
		newBlock = new Block(3, "21/06/1999", "KK Birthday");
		blockChain.addBlock(newBlock);

		System.out.println(blockChain.isChainValid());
		
		List<Block> blocks = blockChain.getBlocks();
		for (Block block : blocks) {
			System.out.println(block.index);
			System.out.println(block.date);
			System.out.println(block.info);
			System.out.println(block.previousHash);
			System.out.println(block.hash);
			System.out.println();
		}
	}

}
