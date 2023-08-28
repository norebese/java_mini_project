package Game;

import java.util.Scanner;

public class gameMenu {
	Scanner sc=new Scanner(System.in);
	public BattleController a=new BattleController();
	
	
	public void GameStart() {
		System.out.println("1.게임 시작");
		System.out.println("2.종료");
		System.out.print("입력: ");
		int first=sc.nextInt();
		if(first==1) {
			System.out.print("캐릭터의 이름을 정해주세요: ");
			a.createCharacter();
			a.welcomeMessage();
			game1();
		}
	}
	
	public void game1() {
		a.mon1();
		a.setCard();
		a.selectCard();
		
	}
	
	

}
