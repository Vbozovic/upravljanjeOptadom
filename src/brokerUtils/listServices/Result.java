
package brokerUtils.listServices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    private String host;
    private String id;
    private String name;
    private Integer port;
    private List<Service> services = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Result() {
    }

    /**
     * 
     * @param port
     * @param id
     * @param services
     * @param host
     * @param name
     */
    public Result(String host, String id, String name, Integer port, List<Service> services) {
        super();
        this.host = host;
        this.id = id;
        this.name = name;
        this.port = port;
        this.services = services;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
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

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
