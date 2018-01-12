package com.arun;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {

	private List<Block> blockchains = new ArrayList<>();

	public BlockChain() {
		blockchains.add(createGenesisBlock());
	}

	private Block createGenesisBlock() {
		return new Block(0, "03/07/1991", "My Birthday", "0000");
	}

	private Block getLatestBlock() {
		return blockchains.get(blockchains.size() - 1);

	}

	public List<Block> getBlocks() {
		return blockchains;

	}

	public boolean addBlock(Block newBlock) {
		newBlock.previousHash = getLatestBlock().hash;
		newBlock.hash = newBlock.createNewHash();
		blockchains.add(newBlock);
		return false;

	}

	public boolean isChainValid() {
		for (int i = 1; i < blockchains.size(); i++) {
			if (!(blockchains.get(i).hash.equals(blockchains.get(i).createNewHash()))) {
				return false;
			}
			
			if (!(blockchains.get(i).hash.equals(blockchains.get(i-1).previousHash))) {
				return false;
			}
		}
		return true;
	}
}
