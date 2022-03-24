package applicant.model.dto;

public class ApplicantDTO {
	
	private String id;
	private String password;
	private String name;
	private String phone;

	public ApplicantDTO() {}
	
	public ApplicantDTO(String id, String password, String name, String phone) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("1. 지원자 applicant_id : ");
		builder.append(id);
		builder.append(" 2. 비밀번호 : ");
		builder.append(password);
		builder.append(" 3. 이름 : ");
		builder.append(name);
		builder.append(" 4. 핸드폰 번호 : ");
		builder.append(phone);
		
		return builder.toString();
	}
}
