package com.mo.sms.aspect;

import com.mo.sms.utils.BaseContextHandler;
import com.mo.sms.utils.NumberHelper;
import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * Created by mo on 2021/10/21
 * 通过切面方式，自定义注解，实现实体基础数据的注入（创建者、创建时间、修改者、修改时间）
 */
@Component
@Aspect
public class DefaultParamsAspect {

    @SneakyThrows
    @Before("@annotation(com.mo.sms.annotation.DefaultParams)")
    public void beforeEvent(JoinPoint point) {

        //自动注入基础属性（创建者、创建时间、修改者、修改时间）
        //从ThreadLocal中获得当前登录用户的id
        Long userId = BaseContextHandler.getUserId();
        if (userId == null) {
            userId = 0L;
        }

        //获得Controller方法的参数, 如save(@RequestBody SignatureEntity entity)
        Object[] args = point.getArgs();
        //变量参数
        for (int i = 0; i < args.length; i++) {
            //对于参数，通常是实体对象，例如SignatureEntity
            Object entity = args[i];
            //通过反射，获得参数类型,SignatureEntity.class
            Class<?> classes = entity.getClass();

            //获得实体中id属性值
            //获得getId方法对象, SignatureEntity中getId方法
            Method method = getMethod(classes, "getId", String.class);
            if (method != null) {
                //通过反射调用方法（getId）
                Object id = method.invoke(entity);
                if (id == null) {
                    //id为null, 当前进行的是新增操作，需要设置创建人createUser和创建时间createTime
                    //通过反射调用方法(setCreateUser)
                    method = getMethod(classes, "setCreateUser", String.class);
                    if (method != null) {
                        //通过反射调用方法 设置创建人
                        method.invoke(entity, userId.toString());
                    }

                    method = getMethod(classes, "setCreateTime", LocalDateTime.class);
                    if (method != null) {
                        //通过反射调用方法 设置创建时间
                        method.invoke(entity, LocalDateTime.now());
                    }
                }

                //id不为null,当前进行的是更新操作
                method = getMethod(classes, "setUpdateUser", String.class);
                if (method != null) {
                    method.invoke(entity, userId.toString());
                }

                method = getMethod(classes, "setUpdateTime", LocalDateTime.class);
                if (method != null) {
                    method.invoke(entity, LocalDateTime.now());
                }
            }
        }


    }

    /**
     * 获得方法对象
     *
     * @param classes 对象的参数类型
     * @param name    方法的名称
     * @param types   方法参数类型，若方法有重载，需要传入参数类型去获取对应的方法
     * @return
     */
    private Method getMethod(Class<?> classes, String name, Class... types) {
        try {
            return classes.getMethod(name, types);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

}
