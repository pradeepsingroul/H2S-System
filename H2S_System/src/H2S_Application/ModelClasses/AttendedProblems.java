package H2S_Application.ModelClasses;

public class AttendedProblems {
	
	private int complainId;
	private String ProblemName;
	private String category;
	private String status;
	private String engineerId;
	
	
	public AttendedProblems(int complainId, String problemName, String category, String status, String engineerId) {
		super();
		this.complainId = complainId;
		ProblemName = problemName;
		this.category = category;
		this.status = status;
		this.engineerId = engineerId;
	}
	
	
	public int getComplainId() {
		return complainId;
	}
	public void setComplainId(int complainId) {
		this.complainId = complainId;
	}
	public String getProblemName() {
		return ProblemName;
	}
	public void setProblemName(String problemName) {
		ProblemName = problemName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEngineerId() {
		return engineerId;
	}
	public void setEngineerId(String engineerId) {
		this.engineerId = engineerId;
	}
	
	@Override
	public String toString() {
		return "Problem [complainId=" + complainId + ", ProblemName=" + ProblemName + ", category=" + category
				+ ", status=" + status + ", engineerId=" + engineerId + "]";
	}
	
	public AttendedProblems() {
		super();
	}

}
