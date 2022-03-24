package applicant.model.dto;

public class GkqrurDTO {
	
	private String applicant_id;
	private String name;
	private int sum;
	public GkqrurDTO() {
		super();
	}
	public GkqrurDTO(String applicant_id, String name, int sum) {
		super();
		this.applicant_id = applicant_id;
		this.name = name;
		this.sum = sum;
	}
	public String getApplicant_id() {
		return applicant_id;
	}
	public void setApplicant_id(String applicant_id) {
		this.applicant_id = applicant_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GkqrurDTO [applicant_id=");
		builder.append(applicant_id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", sum=");
		builder.append(sum);
		builder.append("]");
		return builder.toString();
	}

	
}
