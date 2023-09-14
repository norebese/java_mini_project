package Game;

import java.util.Scanner;

public class BattleController {
	Scanner sc=new Scanner(System.in);
	private Character me=new Character(100,100,0,0,0,3,3);
	private Monster mon=new Monster(30,30,0,0,"mon");
	String thisCard[]=new String[5];

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
		System.out.println("몬스터를 조우했습니다... 당신은 어떤 선택을...");
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
		System.out.println(me);
	}
	
	public void shieldBreak() {
		
	}
	
	public void setCard() {
		me.setCard(0, "공7");
		me.setCard(1, "공2");
		me.setCard(2, "수5");
		me.setCard(3, "수2");
		me.setCard(4, "힘1");
	}
	
	public void card0() {
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
	public void card1() {
		
	}
	public void card2() {
		me.setShield(me.getShield()+5);
		System.out.println(me);
		me.setMana(me.getMana()-1);
	}
	public void card3() {
		
	}
	public void card4() {
		
	}
	
	public void showCard() {
		setCard();
		int j=0;
		while(j<5) {
			int rannum=(int)(Math.random()*4);
			if(!me.card[rannum].equals(null)) {
				thisCard[j]=me.card[rannum];
				j++;
			}else {
				continue;
			}
		}
		for(int i=0;i<thisCard.length;i++) {
			System.out.println(thisCard[i]);
		}
	}
	public void selectCard() {
		
		while(me.getMana()!=0) {
			showCard();
			System.out.print("카드 선택(남은 마나:"+me.getMana()+") :");
			int cardNum=sc.nextInt();
			if(thisCard[cardNum-1].equals(me.card[0])){
				card0();
				me.card[0]=null;
				System.out.println(mon.name+":"+mon);
			}else if(thisCard[cardNum-1].equals(me.card[1])) {
				card1();
				me.card[1]=null;
				
			}else if(thisCard[cardNum-1].equals(me.card[2])) {
				card2();
				me.card[1]=null;
				
			}else if(thisCard[cardNum-1].equals(me.card[3])) {
				card3();
				me.card[3]=null;
				
			}else if(thisCard[cardNum-1].equals(me.card[4])) {
				card4();
				me.card[4]=null;
				
			}
			
		}
		
		
		// selectcard에 반복문 붙이기
		
		
	}
	
	
	
	
}
