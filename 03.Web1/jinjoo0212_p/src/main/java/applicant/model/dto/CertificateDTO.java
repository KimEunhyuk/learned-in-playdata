package applicant.model.dto;

public class CertificateDTO {
	private String applicant_id;
	private int sqld;
	private int adsp;
	private int dasp;
	private int bda;
	private int ipe;
	private int sum;
	public CertificateDTO() {
	}
	public CertificateDTO(String applicant_id, int sqld, int adsp, int dasp, int bda, int ipe, int sum) {
		this.applicant_id = applicant_id;
		this.sqld = sqld;
		this.adsp = adsp;
		this.dasp = dasp;
		this.bda = bda;
		this.ipe = ipe;
		this.sum = sum;
	}
	public String getApplicant_id() {
		return applicant_id;
	}
	public void setApplicant_id(String applicant_id) {
		this.applicant_id = applicant_id;
	}
	public int getSqld() {
		return sqld;
	}
	public void setSqld(int sqld) {
		this.sqld = sqld;
	}
	public int getAdsp() {
		return adsp;
	}
	public void setAdsp(int adsp) {
		this.adsp = adsp;
	}
	public int getDasp() {
		return dasp;
	}
	public void setDasp(int dasp) {
		this.dasp = dasp;
	}
	public int getBda() {
		return bda;
	}
	public void setBda(int bda) {
		this.bda = bda;
	}
	public int getIpe() {
		return ipe;
	}
	public void setIpe(int ipe) {
		this.ipe = ipe;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "CertificateDTO [applicant_id=" + applicant_id + ", sqld=" + sqld + ", adsp=" + adsp + ", dasp=" + dasp
				+ ", bda=" + bda + ", ipe=" + ipe + "]";
	}
	
	
	
}
