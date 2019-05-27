import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OracleConect {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.printf("Driver 이름이나 추가 여부를 확인하세요.\n");
			e.printStackTrace();
		}

		Connection con = null;

		Statement stmt = null;

		try {
			// Database 연결
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.100:1521/XE", "user04", "user04");

			// Statement 생성
			stmt = con.createStatement();

			ResultSet rsme = stmt.executeQuery("select * from member_tbl_02");

			List<Member> meList = new ArrayList<Member>();

			// 전체 Data 순회
			while (rsme.next() == true) {

				Member member = new Member();
				member.setCustno(rsme.getInt("custno"));
				member.setCustname(rsme.getString("custname"));
				member.setPhone(rsme.getString("phone"));
				member.setAddress(rsme.getString("address"));
				member.setJoindate(rsme.getDate("joindate"));
				member.setGrade(rsme.getString("grade"));
				member.setCity(rsme.getString("city"));

				meList.add(member);

			}

			rsme.close();

			for (Member member : meList) {
				System.out.printf("%s\n", member);
			}

			// SQL Table의 전체 Data를 읽어오는 SQL을 실행
			ResultSet rsmo = stmt.executeQuery("select * from money_tbl_02");

			// Table 전체의 Data를 저장하기 위한 자료구조를 생성
			List<Money> moList = new ArrayList<Money>();

			// 전체 Data 순회
			while (rsmo.next() == true) {

				Money money = new Money();
				money.setCustno(rsmo.getInt("custno"));
				money.setSalnol(rsmo.getInt("salenol"));
				money.setPcost(rsmo.getInt("pcost"));
				money.setAmount(rsmo.getInt("amount"));
				money.setPrice(rsmo.getInt("price"));
				money.setPcode(rsmo.getString("pcode"));
				money.setSdate(rsmo.getDate("sdate"));

				moList.add(money);

			}

			rsmo.close();

			for (Money money : moList) {
				System.out.printf("%s\n", money);
			}

		} catch (Exception e) {
			System.out.printf("접속 정보가 잘못되었습니다.\n");
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}