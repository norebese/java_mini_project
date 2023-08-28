package Game;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BattleController {
	Scanner sc=new Scanner(System.in);
	private Character me=new Character(30,30,0,0,0,3,0);
	private Monster mon=new Monster(100,100,0,0,"mon");
	private List<String> thisCard=new ArrayList<>();

	public void createCharacter() {
		String name=sc.next();
		me.name=name;
	}
	
	public void welcomeMessage() {
		System.out.println("환영합니다 "+me.name+"님 이곳은...");
	}
	
	public void showInfo() {
		System.out.println(me.name+":"+me);
		System.out.println(mon.name+":"+mon);
	}
	
	public void mon1() {
		System.out.println("몬스터가 공격하려고 합니다... 당신은 어떤 선택을...");
		int rannum=(int)(Math.random()*2+1);
		System.out.println(rannum);
		if(rannum==1) {
			mon.setDamage(8);
			System.out.println("의도 : 공격: "+mon.damage);
		}else if(rannum==2) {
			mon.setDamage(5);
			mon.setShield(4);
			System.out.println("의도 : 공격/수비: "+mon.damage+"/"+mon.shield);
		}
		
	}
	
	public void monTurn() {
		int finalDamage=(mon.damage+mon.strength)-me.getShield();
		if(finalDamage<0) {
			finalDamage=0;
		}
		me.setShield(me.getShield()-mon.damage);
		if(me.shield<0) {
			me.setShield(0);
			me.setHP(me.getHP()-finalDamage);
		}
		if(me.getHP()<=0) {
			System.out.println("사망");
			return;
		}
		System.out.println(me);
		mon1();
		selectCard();
	}
	
	public void shieldBreak() {
		
	}
	
	public void setCard() {
		me.setAllCard("1111");
		me.setAllCard("1111");
		me.setAllCard("1111");
		me.setAllCard("1111");
		me.setAllCard("1111");
		
		me.setAllCard("2222");
		
		me.setAllCard("3333");
		me.setAllCard("4444");
		me.setAllCard("5555");
	}
	
	public void card1() {
		int dm=(7+me.strength)-mon.getShield();
		if(dm<0) {
			dm=0;
		}
		mon.setShield(mon.getShield()-7);
		if(mon.shield<0) {
			mon.setShield(0);
			mon.setHP(mon.getHP()-dm);
		}
		me.setMana(me.getMana()-1);
	}
	public void card2() {
		me.setMana(me.getMana()-1);
	}
	public void card3() {
		me.setShield(me.getShield()+5);
		System.out.println(me);
		me.setMana(me.getMana()-1);
	}
	public void card4() {
		me.setMana(me.getMana()-1);
	}
	public void card5() {
		me.setMana(me.getMana()-1);
	}
	
	public void showCard() {
		
		for(int i=0;i<5;i++) {
			int rannum=(int)(Math.random()*me.AllCard.size());
			thisCard.add(me.AllCard.get(rannum));
			me.AllCard.remove(rannum);
			System.out.println(i+1+":"+thisCard.get(i));
			if(me.AllCard.size()==0) {
				setCard();
				System.out.println("카드를 섞었습니다");
			}
			
		}
		
	}
	public void selectCard() {
		showCard();
		me.setMana(3);
		while(me.getMana()!=0) {
			System.out.print("카드 선택(남은 마나:"+me.getMaxMana()+"/"+me.getMana()+") :");
			int cardNum=sc.nextInt();
			if(thisCard.get(cardNum-1).equals("1111")){
				card1();
				thisCard.remove(cardNum-1);
				System.out.println(mon.name+":"+mon);
				if(me.getMana()!=0) {
					for(int i=0;i<thisCard.size();i++) {
						System.out.println(i+1+":"+thisCard.get(i));
					}
				}
			}else if(thisCard.get(cardNum-1).equals("2222")) {
				card2();
				thisCard.remove(cardNum-1);
				if(me.getMana()!=0) {
					for(int i=0;i<thisCard.size();i++) {
						System.out.println(i+1+":"+thisCard.get(i));
					}
				}
			}else if(thisCard.get(cardNum-1).equals("3333")) {
				card3();
				thisCard.remove(cardNum-1);
				if(me.getMana()!=0) {
					for(int i=0;i<thisCard.size();i++) {
						System.out.println(i+1+":"+thisCard.get(i));
					}
				}
			}else if(thisCard.get(cardNum-1).equals("4444")) {
				card4();
				thisCard.remove(cardNum-1);
				if(me.getMana()!=0) {
					for(int i=0;i<thisCard.size();i++) {
						System.out.println(i+1+":"+thisCard.get(i));
					}
				}
			}else if(thisCard.get(cardNum-1).equals("5555")) {
				card5();
				thisCard.remove(cardNum-1);
				if(me.getMana()!=0) {
					for(int i=0;i<thisCard.size();i++) {
						System.out.println(i+1+":"+thisCard.get(i));
					}
				}
			}
		}
		thisCard.clear();
		monTurn();
	}
	
	
	
	
}
