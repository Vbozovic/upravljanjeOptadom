
package brokerUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrokerRegisterRequest {

    private String name;
    private String username;
    private String password;
    private String email;
    private List<Object> permissions = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BrokerRegisterRequest() {
    }

    /**
     * 
     * @param username
     * @param email
     * @param name
     * @param permissions
     * @param password
     */
    public BrokerRegisterRequest(String name, String username, String password, String email, List<Object> permissions) {
        super();
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Object> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Object> permissions) {
        this.permissions = permissions;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
