package com.lrchao.store.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Map工具类
 *
 * @author liuranchao
 * @date 15/11/23 下午2:19
 */
public class MapUtils {

    /**
     * 生成url的参数字符串
     *
     * @param map HashMap<String, Object>
     * @return e.g. : ?param1=1&param2=2
     */
    public static String getUrlParams(Map<String, Object> map) {

        if (map == null || map.size() <= 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();

        int index = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {

            // 第一个加上问号
            if (index == 0) {
                sb.append("?");
            }

            sb.append(entry.getKey() + "=" + entry.getValue());
            // 最后一个不加&
            if (index < map.size() - 1) {
                sb.append("&");
            }
            index++;
        }

        return sb.toString();
    }

    /**
     * 转换map
     * @param map Map<String, Object>
     * @return HashMap<String, String>
     */
    public static Map<String, String> convert(Map<String, Object> map) {

        Map<String, String> result = null;
        if (map != null && map.size() > 0) {
            result = new HashMap<>(map.size());

            for (Map.Entry<String, Object> entry : map.entrySet()) {

                String key = entry.getKey();
                Object value = entry.getValue();
                result.put(key, String.valueOf(value));
            }

        }
        return result;
    }




}
