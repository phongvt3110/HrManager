package castisvn.commons;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ResponseData<T> implements Serializable {
    private int code;
    private String message;
    private T data;
    private LocalDateTime timestamp;

    public ResponseData(){
        this.timestamp = LocalDateTime.now();
    }

    public ResponseData<T> success(T data){
        this.code = 0;
        this.message = "Success!";
        this.data = data;
        return this;
    }

    public ResponseData<T> error(int code, String message){
        this.code = code;
        this.message = message;
        return this;
    }

    public ResponseData<T> error(int code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
        return this;
    }

    public int getCode() {
        return code;
    }
    public String getMessage(){
        return message;
    }
    public T getData(){
        return data;
    }
    public String getTimestamp(){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(timestamp);
    }
}
