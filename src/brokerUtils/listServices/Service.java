
package brokerUtils.listServices;

import java.util.HashMap;
import java.util.Map;

public class Service {

    private String id;
    private String method;
    private String name;
    private String permissions;
    private String route;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Service() {
    }

    /**
     * 
     * @param id
     * @param route
     * @param name
     * @param permissions
     * @param method
     */
    public Service(String id, String method, String name, String permissions, String route) {
        super();
        this.id = id;
        this.method = method;
        this.name = name;
        this.permissions = permissions;
        this.route = route;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
