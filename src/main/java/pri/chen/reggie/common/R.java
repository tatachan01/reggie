package pri.chen.reggie.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回结果类
 * @author long.chen1
 */
@Data
public class R<T> {

    /**
     * 1表示成功
     */
    private Integer code;

    private String msg;

    private T data;

    /**
     * 动态数据
     */
    private Map<Object, Object> map = new HashMap<>();

    public static <T> R<T> success(T object) {
        R<T> r = new R<T>();

        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> R<T> error(String msg) {
        R<T> r = new R<T>();
        r.msg = msg;
        r.code = 0;
        return r;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }
}
