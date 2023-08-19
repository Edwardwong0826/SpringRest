package com.wongweiye.util;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class CopyPropertiesUtil {

    public void convertFromSourceToTarget(Object source, Object target) throws InvocationTargetException, IllegalAccessException {

        BeanUtils.copyProperties(target, source);
        System.out.println(target.toString());
        System.out.println(source.toString());

    }
}
