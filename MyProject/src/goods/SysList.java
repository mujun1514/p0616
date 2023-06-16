package goods;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SysList {
	public static GoodDao dao = new GoodDao();
	public static Scanner scn = new Scanner(System.in);
	private static GoodVO gv;

	// 등록
	public void registerStart() {
		System.out.println("등록 창 입니다");
		System.out.println("===============================");
		System.out.println("상품이름>");
		String good_name = scn.next();
		System.out.println("가격(개당)>");
		String good_price = scn.next();
		System.out.println("내용>");
		String good_content = scn.next();
		System.out.println("개수>");
		String goods_number = scn.next();

		GoodVO good = new GoodVO();
		good.setGood_name(good_name);
		good.setGood_price(good_price);
		good.setGood_content(good_content);
		good.setGoods_number(goods_number);

		if (dao.register(good)) {
			System.out.println("등록완료");
		} else {
			System.out.println("등록실패");
		}
	}

	// 조회
	public void listStart() {
		try {
			List<GoodVO> list = dao.list();
			if (list.size() == 0) {
				System.out.println("목록없음");
			} else {
				for (GoodVO good : list) {
					System.out.println(good.toString());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 수정
	public void updateStart() {
		System.out.println("===============================");
		System.out.println("수정할 상품의 번호를 입력해주세요 (good_no)");
		String good1 = scn.next();
		System.out.println("이름 수정>");
		String name = scn.next();
		System.out.println("가격 수정>");
		String price = scn.next();
		System.out.println("내용 수정>");
		String content = scn.next();
		System.out.println("개수 수정>");
		String number = scn.next();

//		GoodVO good = new GoodVO();
//		good.setGood_name(name);
//		good.setGood_price(price);
//		good.setGood_content(content);
//		good.setGoods_number(number);

		gv = new GoodVO(good1, name, price, content, number);
		if (dao.update(gv)) {
			System.out.println("수정 완료");
		} else {
			System.out.println("번호 없음");
		}
	}

	public void removeStart() {
		System.out.println("삭제 창 입니다.");
		System.out.println("===============================");
		System.out.println("삭제할 상품의 번호를 입력해주세요");
		int good_no = scn.nextInt();

		if (dao.remove(good_no)) {
			System.out.println("삭제완료");
		} else {
			System.out.println("번호입력다름");
		}
	}

	public void searchStart() {
		System.out.println("조회 창 입니다.");
		System.out.println("===============================");

		System.out.println("번호입력");
		String good_no = scn.next();

		GoodVO good = dao.search(good_no);
		if (good == null) {
			System.out.println("조회된 결과가 없습니다");
		} else {
			System.out.println(good.toString());
		}
	}
}
