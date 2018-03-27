package users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controllers.ScreenSwitcher;
import javafx.stage.Stage;

public class User implements ScreenSwitcher {
	private int user_id;
	private String first_name;
	private String last_name;
	private String nickname;
	private String gender;
	private String date_of_birth;
	private String city;
	private String address;
	
	public User(int user_id, String nickname, String first_name, String last_name, int gender, String date_of_birth, String city, String address) {
		this.setUser_id(user_id);
		this.setNickname(nickname);
		this.setFirst_name(first_name);
		this.setLast_name(last_name);
		if (gender == 1) {
			this.setGender("MALE");
		} else if (gender == 2) {
			this.setGender("FEMALE");
		}
		this.setDate_of_birth(date_of_birth);
		this.setCity(city);
		this.setAddress(address);
	}
	
	public User(Stage stage, String nickname, String password) {
		this.setNickname(nickname);
		logIn(stage, password);
		
	}
	
	private void logIn(Stage stage, String password) {
		if (checkLogin(this.nickname, password)) {
			switchToForumScreen(stage, this);
		} else {
			System.out.println("Wrong nickname or password!");
		}
	}
	
	private boolean checkLogin(String nickname, String password) {
		if (nickname.isEmpty() || password.isEmpty()) {
			return false;
		}
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/NAis", "postgres",
					"admin");
			Statement stmt = connection.createStatement();

			ResultSet rset = stmt.executeQuery(
					"select id, nickname, password, first_name, last_name, id_gender, date_of_birth, city, address from users where nickname = '"
							+ nickname + "'");
			if (rset.next()) {
				String currNickname = rset.getString("nickname");
				String currPassword = rset.getString("password");

				if (nickname.equals(currNickname) && password.equals(currPassword)) {
					this.setUser_id(rset.getInt("id"));
					this.setNickname(currNickname);
					this.setFirst_name(rset.getString("first_name"));
					this.setLast_name(rset.getString("last_name"));
					int gender = rset.getInt("id_gender");
					if (gender == 1) {
						this.setGender("MALE");
					} else if (gender == 2) {
						this.setGender("FEMALE");
					}
					this.setDate_of_birth(rset.getString("date_of_birth"));
					this.setCity(rset.getString("city"));
					this.setAddress(rset.getString("address"));
					
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public void print() {
		System.out.println("som user");
	}
	
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getDate_of_birth() {
		return date_of_birth;
	}


	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	
	
}
