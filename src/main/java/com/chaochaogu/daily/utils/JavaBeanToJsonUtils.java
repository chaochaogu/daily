package com.chaochaogu.daily.utils;

import com.chaochaogu.model.GroupInputDTO;
import com.chaochaogu.model.GroupMember;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author chaochao Gu
 * @date 2019/7/17
 */
public class JavaBeanToJsonUtils {

    public static void main(String[] args) {
        GroupInputDTO groupInputDTO = new GroupInputDTO();
        groupInputDTO.setId(1);
        groupInputDTO.setArea("北京");
        GroupMember groupMember = new GroupMember();
        groupMember.setRegistCode("23wedf");
        groupInputDTO.setGroupMember(groupMember);
        ///System.out.println(JSON.toJSONString(groupInputDTO));
        String str = parseJavaBean(groupInputDTO);
        System.out.println(str);
    }

    public static String parseJavaBean(Object obj) {
        //接收传来的对象，获取其所有成员变量，输出json字符串
        Object o = null;
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder s = new StringBuilder();
        s.append("{");
        for (Field field : fields) {
            String fieldName = field.getName();
            String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            try {
                Method method = clazz.getMethod(getMethodName, new Class[]{});
                o = method.invoke(obj, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String fieldClassName = field.getType().getName();
            if (fieldClassName.startsWith("java")) {
                s.append("\"");
                s.append(fieldName);
                s.append("\"");
                s.append(":");
                if (o != null) {
                    s.append(o.toString());
                }
                s.append(",");
            }
            if (!fieldClassName.startsWith("java")) {
                //该成员变量为自定义对象，则将其实例化并获取其实例的成员变量
                s.append("\"");
                s.append(fieldName);
                s.append("\"");
                s.append(":");
                s.append("{");
                Class<?> fieldClass = field.getType();
                Field[] declaredFields = fieldClass.getDeclaredFields();
                //Class<? extends Field> fieldClass = field.getClass();
                //Field[] declaredFields = fieldClass.getDeclaredFields();
                for (Field declaredField : declaredFields) {
                    String declaredFieldName = declaredField.getName();
                    s.append("\"");
                    s.append(declaredFieldName);
                    s.append("\"");
                    s.append(":");
                    //判断该属性是否有值
                    //先拿到该属性的get方法，反射调用，判断值是否为空
                    String getFunctionName = "get" + declaredFieldName.substring(0, 1).toUpperCase() + declaredFieldName.substring(1);
                    try {
                        Method declaredMethod = fieldClass.getMethod(getFunctionName, new Class[]{});
                        //此处若fieldClass不进行实例化则会报异常
                        Object o1 = declaredMethod.invoke(fieldClass.newInstance(), null);
                        if (o1 != null) {
                            s.append(o1.toString());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    s.append(",");
                }
                s.append("}");
            }
        }
        s.append("}");
        String jsonStr = s.toString();
        return jsonStr;
    }
}
