package com.video.edu.me.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class BeanLoader implements ApplicationContextAware {
    private static final Logger LOGGER = LoggerFactory.getLogger(BeanLoader.class);

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanLoader.applicationContext = applicationContext;
    }

    private static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static <T> T getBean(Class<T> c) {
        return (T) BeanFactoryUtils.beanOfTypeIncludingAncestors(getApplicationContext(), c);
    }
}