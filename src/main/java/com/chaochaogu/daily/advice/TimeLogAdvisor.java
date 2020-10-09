package com.chaochaogu.daily.advice;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.concurrent.TimeUnit;

/**
 * 耗时日志AOP
 *
 * @author chaochao Gu
 * @date 2020-03-21 12:42 下午
 */
@Aspect
@Component
@Slf4j
public class TimeLogAdvisor {

    @Autowired(required = false)
    private OvertimeHandler overTimeHandler;

    @Pointcut("@annotation(com.chaochaogu.daily.advice.TimeLog)")
    public void timeLogPointCut() {
    }

    @Around("timeLogPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        TimeLog timeLog = method.getAnnotation(TimeLog.class);
        boolean openHandle = timeLog.openHandle();
        long limit = timeLog.limit();
        boolean showArgs = timeLog.showArgs();
        Class<?> declaringClass = method.getDeclaringClass();
        String methodName = timeLog.methodName();
        if (StringUtils.isEmpty(methodName)) {
            String className = declaringClass.getName();
            methodName = className + "#" + method.getName();
        }
        Object[] args = point.getArgs();
        Parameter[] parameters = method.getParameters();
        String params = getParams(args, parameters);

        Stopwatch stopwatch = Stopwatch.createStarted();
        Object result = point.proceed();
        long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        if (log.isDebugEnabled()) {
            if (showArgs) {
                log.debug("method {} execute with params {}, cost time {} ms", methodName, params, elapsed);
            } else {
                log.debug("method {} finish, cost time {} ms", methodName, elapsed);
            }
        }

        if (openHandle && elapsed >= limit && overTimeHandler != null) {
            OverTimeEvent overTimeEvent = OverTimeEvent.builder()
                    .params(params)
                    .elapsed(elapsed)
                    .methodName(methodName)
                    .build();
            overTimeHandler.handle(overTimeEvent);
        }
        return result;
    }

    private String getParams(Object[] args, Parameter[] parameters) {
        StringBuilder paramBuilder = new StringBuilder();
        for (int i = 0; i < parameters.length; i++) {
            String name = parameters[i].getName();
            paramBuilder.append(name);
            paramBuilder.append(": ");
            paramBuilder.append(args[i]);
            paramBuilder.append(", ");
        }
        return paramBuilder.substring(0, paramBuilder.length() - 2);
    }

}
