package brokerUtils;

import java.util.List;

public class ListProvidersResponse {

	private String message;
	private List<Result> result;
	private String status;
	
	
	
	
	public ListProvidersResponse() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Result> getResult() {
		return result;
	}
	public void setResult(List<Result> result) {
		this.result = result;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
