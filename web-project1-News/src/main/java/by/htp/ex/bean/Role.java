package by.htp.ex.bean;

import java.io.Serializable;
import java.util.Objects;

public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nameofRole;
	private boolean adminProperte;
		
	public Role(){}

	public Role(String nameofRole, boolean adminProperte) {
		super();
		this.nameofRole = nameofRole;
		this.adminProperte=adminProperte;
	}

	public String getNameofRole() {
		return nameofRole;
	}

	public void setNameofRole(String nameofRole) {
		this.nameofRole = nameofRole;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nameofRole);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(nameofRole, other.nameofRole);
	}

	@Override
	public String toString() {
		return "Role [nameofRole=" + nameofRole + "]";
	}

	
}
