
package brokerUtils;

import java.util.HashMap;
import java.util.Map;

public class BrokerRegisterResponse {

    private String message;
    private Result result;
    private String status;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BrokerRegisterResponse() {
    }

    /**
     * 
     * @param message
     * @param result
     * @param status
     */
    public BrokerRegisterResponse(String message, Result result, String status) {
        super();
        this.message = message;
        this.result = result;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
