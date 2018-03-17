package arvorebinaria;

public class HuffmanNodeInfo {
	private int frequency;
	private Character character;
	
	@Override
	public String toString() {
		return character+":"+frequency;
	}
	
	public HuffmanNodeInfo(int frequency, Character character) {
		this.frequency = frequency;
		this.character = character;
	}
	
	public HuffmanNodeInfo(int frequency) {
		this.frequency = frequency;
	}
	
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public Character getCharacter() {
		return character;
	}
	public void setCharacter(Character character) {
		this.character = character;
	}	
}
