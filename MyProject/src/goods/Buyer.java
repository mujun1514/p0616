package goods;

import java.util.Scanner;
import java.util.function.LongToIntFunction;

public class Buyer {
	private Login log;
	public void BuyerMethod() {
		int selno = 0;
		SysList syl = new SysList();
		Scanner scn = new Scanner(System.in);
		Login logg =new Login();
		while (true) {
			System.out.println("=========================================");
			System.out.println("1상품조회 & 구매 || 2포인트충전 || 3프로그램 종료");
			System.out.println("====================================");
			selno = scn.nextInt();

			if (selno == 1) {
				syl.listStart();

				System.out.println("구매할 음식의 이름을 입력해주세요");
				// 이름 입력
				System.out.println("구매할 개수를 입력해주세요");
				// 개수*가격 보여주고
				System.out.println("구매확정 하겠습니까? (Y/N)");
				// y .- n : 다시리턴
			} else if (selno == 2) {
				
				System.out.println("얼마를 충전하시겠습니까?");
				String point = scn.next();
				String id = logg.pp;
				
				BuyerSys sys = new BuyerSys();
				sys.pointPlus(point,id);
				
				
			}else if(selno == 3) {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
}
