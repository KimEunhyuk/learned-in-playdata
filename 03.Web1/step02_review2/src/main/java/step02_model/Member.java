package step02_model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Member {
	
	private String name;
	private int age;
	private String gender;
	private String id;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("| name : ");
		builder.append(name);
		builder.append(" | age : ");
		builder.append(age);
		builder.append(" | gender : ");
		builder.append(gender);
		builder.append(" | id : ");
		builder.append(id);
		builder.append(" |");
		return builder.toString();
	}
		
}
