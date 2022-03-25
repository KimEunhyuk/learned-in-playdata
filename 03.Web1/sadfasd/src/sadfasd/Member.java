package sadfasd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Member {
	private String id;
	
	private String name;
	
	private int age;
	
	private String gender;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [ id = ");
		builder.append(id);
		builder.append(", 이름 = ");
		builder.append(name);
		builder.append(", 나이 = ");
		builder.append(age);
		builder.append(", 성별 = ");
		builder.append(gender);
		builder.append(" ]");
		return builder.toString();
	}


	

		
}
