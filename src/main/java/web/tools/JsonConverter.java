package web.tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {

    /**
     * JSON转换辅助函数
     *
     * @param object 输入
     * @return JSON字符串结果
     * @throws JsonProcessingException
     */
    public static String jsonOfObject(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}
