// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.example.demoapi.data.model;
import java.util.List;

public class GetSignUpUserdata {
    private List<String> message;
    private String error;
    private long statusCode;

    public List<String> getMessage() { return message; }
    public void setMessage(List<String> value) { this.message = value; }

    public String getError() { return error; }
    public void setError(String value) { this.error = value; }

    public long getStatusCode() { return statusCode; }
    public void setStatusCode(long value) { this.statusCode = value; }
}
