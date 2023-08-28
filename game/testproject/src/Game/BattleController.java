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
		System.out.println("환영합니다 "+me.name+"님");
		System.out.println("게임규칙: 카드배틀 게임으로, 플레이어는 주어진 카드들을 이용해 조우하는 몬스터를 쓰러뜨리는 방식입니다.");
		
	}
	
	public void showInfo() {
		System.out.println(me.name+":"+me);
		System.out.println(mon.name+":"+mon);
	}
	
	public void mon1() {
		
		int rannum=(int)(Math.random()*2+1);
		System.out.println(rannum);
		if(rannum==1) {
			mon.setDamage(8);
			System.out.println("몬스터가 "+mon.damage+"만큼의 피해를 입히려고 합니다");
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
		System.out.println("몬스터에게 "+finalDamage+"만큼의 데미지를 받았습니다 (남은 체력: "+me.getHP()+")");
		mon1();
		selectCard();
	}
	
	public void shieldBreak() {
		
	}
	
	public void setCard() {
		me.setAllCard("공격[1] : 7의 데미지를 준다");
		me.setAllCard("공격[1] : 7의 데미지를 준다");
		me.setAllCard("공격[1] : 7의 데미지를 준다");
		me.setAllCard("공격[1] : 7의 데미지를 준다");
		
		me.setAllCard("강타[2] : 12의 데미지를 준다");
		
		me.setAllCard("방어[1] : 5만큼 방어한다");
		me.setAllCard("방어[1] : 5만큼 방어한다");
		me.setAllCard("방어[1] : 5만큼 방어한다");
		
		me.setAllCard("용기[0] : 용기를 1만큼 얻는다");
		me.setAllCard("분노[1] : 힘을 1만큼 얻는다");
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
		System.out.println("몬스터에게 7(+"+me.strength+")만큼의 데미지를 주었습니다. (남은체력:"+mon.getHP()+")");
	}
	public void card2() {
		int dm=(12+me.strength)-mon.getShield();
		if(dm<0) {
			dm=0;
		}
		mon.setShield(mon.getShield()-12);
		if(mon.shield<0) {
			mon.setShield(0);
			mon.setHP(mon.getHP()-dm);
		}
		me.setMana(me.getMana()-2);
		System.out.println("몬스터에게 "+dm+"만큼의 데미지를 주었습니다. (남은체력:"+mon.getHP()+")");
	}
	
	public void card3() {
		me.setShield(me.getShield()+5);
		System.out.println(me);
		me.setMana(me.getMana()-1);
	}
	public void card4() {
		me.setCourage(me.getCourage()+1);
		me.setMana(me.getMana()-1);
	}
	public void card5() {
		me.setStrength(me.getStrength()+1);
		System.out.println(me.getStrength());
		me.setMana(me.getMana()-1);
	}
	
	public void showCard() {
		
		for(int i=0;i<5;i++) {
			int rannum=(int)(Math.random()*me.AllCard.size());
			thisCard.add(me.AllCard.get(rannum));
			me.AllCard.remove(rannum);
			System.out.println(i+1+"."+thisCard.get(i));
			if(me.AllCard.size()==0) {
				setCard();
				System.out.println("카드를 섞었습니다");
			}
			
		}
		
	}
	public void selectCard() {
		showCard();
		me.setMana(3+me.getCourage());
		if(me.getCourage()>0) {
			me.setCourage(me.getCourage()-1);
		}
		while(me.getMana()!=0) {
			System.out.print("카드 선택(남은 마나:"+me.getMaxMana()+"/"+me.getMana()+") :");
			int cardNum=sc.nextInt();
			if(thisCard.get(cardNum-1).equals("공격[1] : 7의 데미지를 준다")){
				card1();
				thisCard.remove(cardNum-1);
				
				if(me.getMana()!=0) {
					for(int i=0;i<thisCard.size();i++) {
						System.out.println(i+1+"."+thisCard.get(i));
					}
				}
			}else if(thisCard.get(cardNum-1).equals("강타[2] : 12의 데미지를 준다")) {
				if(me.getMana()<2) {
					System.out.println("마나가 부족합니다");
					continue;
				}else {
					card2();
					thisCard.remove(cardNum-1);
					if(me.getMana()!=0) {
						for(int i=0;i<thisCard.size();i++) {
							System.out.println(i+1+"."+thisCard.get(i));
						}
					}
				}
			}else if(thisCard.get(cardNum-1).equals("방어[1] : 5만큼 방어한다")) {
				card3();
				thisCard.remove(cardNum-1);
				if(me.getMana()!=0) {
					for(int i=0;i<thisCard.size();i++) {
						System.out.println(i+1+"."+thisCard.get(i));
					}
				}
			}else if(thisCard.get(cardNum-1).equals("용기[1] : 용기를 1만큼 얻는다")) {
				card4();
				thisCard.remove(cardNum-1);
				if(me.getMana()!=0) {
					for(int i=0;i<thisCard.size();i++) {
						System.out.println(i+1+"."+thisCard.get(i));
					}
				}
			}else if(thisCard.get(cardNum-1).equals("분노[1] : 힘을 1만큼 얻는다")) {
				card5();
				thisCard.remove(cardNum-1);
				if(me.getMana()!=0) {
					for(int i=0;i<thisCard.size();i++) {
						System.out.println(i+1+"."+thisCard.get(i));
					}
				}
			}
		}
		thisCard.clear();
		System.out.println("-----------------------------------------------------");
		monTurn();
	}
	
	
	//용기 카드 사용하면 카드가 안나옴 고쳐야됨
	
}
