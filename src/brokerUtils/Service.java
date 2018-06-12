package brokerUtils;

public class Service {

	private String name;
	private String method;
	private String route;
	public Service() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	@Override
	public String toString() {
		return "Service [name=" + name + ", method=" + method + ", route=" + route + "]";
	}
	
	
	
}
