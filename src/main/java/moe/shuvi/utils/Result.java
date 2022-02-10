package moe.shuvi.utils;

/**
 * @ClassName Result
 * @Description TODO
 * @Author Administrator
 * @Date: 2021/12/9 16:55
 * @Version 1.0
 */
public class Result {
    public final static String MSG_SUCCESS = "success";
    public final static String MSG_ERROR = "error";
    public final static Integer CODE_SUCCESS = 20000;
    public final static Integer CODE_ERROR = 20001;
    public final static Integer CODE_LOGIN_FAILED = 30001;
    public final static String MSG_LOGIN_FAILED = "Authentication Failure";
    public final static Integer CODE_403 = 30002;
    public final static String MSG_403 = "Permission denied";
    public static final Integer CODE_LOGIN_NEEDED = 30003;
    public final static String MSG_LOGIN_NEEDED = "please login !!";


    private Integer code;
    private String msg;
    private Object data;
    private String token;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", token='" + token + '\'' +
                '}';
    }
}
