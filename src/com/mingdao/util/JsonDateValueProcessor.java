package com.mingdao.util;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangjia on 14-6-13.
 */
public class JsonDateValueProcessor implements JsonValueProcessor {

    private String format = "yyyy-MM-dd HH:mm:ss";

    public JsonDateValueProcessor() {
        super();
    }

    public JsonDateValueProcessor(String format) {
        super();
        this.format = format;
    }

    @Override
    public Object processArrayValue(Object paramObject, JsonConfig paramJsonConfig) {
        return process(paramObject);
    }

    @Override
    public Object processObjectValue(String paramString, Object paramObject, JsonConfig paramJsonConfig) {
        return process(paramObject);
    }


    private Object process(Object value) {
        if (value instanceof Date) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(value);
        }
//        if(value!=null){
//            Class<?> clazz = value.getClass();
//            if (clazz.equals(int.class) || clazz.equals(long.class)
//                    || clazz.equals(double.class) || clazz.equals(float.class)
//                    || clazz.equals(long.class)) {
//                if (value == null) {
//                    return -1;
//                }
//            } else if (value instanceof Integer || value instanceof Long ||
//                    value instanceof Double || value instanceof Short
//                    || value instanceof Float || value instanceof Byte) {
//                if (value == null) {
//                    return -1;
//                }
//            }
//        }
        return value;
    }
}
