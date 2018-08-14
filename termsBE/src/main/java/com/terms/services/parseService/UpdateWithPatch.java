package com.terms.services.parseService;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@Service
public class UpdateWithPatch {

    private Object object;
    public UpdateWithPatch(Object object, Map<String,Object> params) {

        params.forEach((key,value) -> {
            if (!key.equals("id")){
            Field field = ReflectionUtils.findField(object.getClass(),key);
            field.setAccessible(true);
            ReflectionUtils.setField(field,object,value);
            }
        });

        this.object = object;
    }

    public Object getObject() {
        return object;
    }
    public  UpdateWithPatch(){}
}
