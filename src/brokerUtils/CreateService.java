package brokerUtils;

import java.util.LinkedList;
import java.util.List;

public class CreateService {

	private List<Service> services;

	public CreateService() {
		super();
		services = new LinkedList<>();
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}
	
	
	
	
}
