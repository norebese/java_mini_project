package Game;

public class Character extends BattleSystem {
	
	public String name;
	private int courage;
	private int maxMana;
	private int mana;
	private int num;
	public String[] card=new String[5];
	
	
	public Character(int maxHP, int HP, int shield, int strength,int courage, int maxMana, int mana) {
		super(maxHP,HP,shield,strength);
		this.courage=courage;
		this.maxMana=maxMana;
		this.mana=mana;
		this.num=num;
	}

	public void setCourage(int courage) {
		this.courage=courage;
	}
	public int getCourage() {
		return this.courage;
	}
	
	public void setMaxMana(int maxMana) {
		this.maxMana=maxMana;
	}
	public int getMaxMana() {
		return this.maxMana;
	}
	
	public void setMana(int mana) {
		this.mana=mana;
	}
	public int getMana() {
		return this.mana;
	}
	
	public void setCard(int num,String a) {
		this.card[num]=a;
	}
	
	public String toString() {
		return "체력:"+this.maxHP+"/"+this.HP+" | 쉴드:"+this.shield;
	}
	
}
