package by.htp.ex.bean;

import java.io.Serializable;
import java.util.Objects;

public class NewUserInfo implements Serializable {
private static final long serialVersionUID = 1L;
	
	private String userName;
	private String email;
	private String login;
	private String password;
	private Role role;
	
	public NewUserInfo() {};
	
	public NewUserInfo(String userName, String email, String login, String password) {
		super();
		this.userName=userName;
		this.email=email;
		this.login=login;
		this.password=password;		
	}
	public NewUserInfo(String userName, String email, String login, String password, Role role) {
		super();
		this.userName=userName;
		this.email=email;
		this.login=login;
		this.password=password;
		this.role=role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, login, password, role, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewUserInfo other = (NewUserInfo) obj;
		return Objects.equals(email, other.email) && Objects.equals(login, other.login)
				&& Objects.equals(password, other.password) && Objects.equals(role, other.role)
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "NewUserInfo [userName=" + userName + ", email=" + email + "]";
	}
	
	
	
}
