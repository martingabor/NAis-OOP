package users;

public class Admin extends User{

	public Admin(int user_id, String nickname, String first_name, String last_name, int gender, String date_of_birth,
			String city, String address) {
		super(user_id, nickname, first_name, last_name, gender, date_of_birth, city, address);
	}
	
	public void print() {
		System.out.print("som admin");
	}

}
