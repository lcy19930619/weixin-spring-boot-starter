package net.jlxxw.wechat.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author chunyang.leng
 * @date 2021-04-23 9:49 上午
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {
    ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 根据类型获取 Spring bean 实例对象
     * @param clazz 指定的类型
     * @param <T> 指定的类型
     * @return Spring bean 实例对象
     */
    public <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    /**
     * 根据名字和类型获取 Spring bean 实例对象
     * @param clazz 指定的类型
     * @param <T> 指定的类型
     * @param beanName 指定名字
     * @return Spring bean 实例对象
     */
    public <T> T getBean(Class<T> clazz, String beanName) {
        return applicationContext.getBean(clazz, beanName);
    }

    /**
     * 发布一个事件
     *
     * @param applicationEvent
     */
    public void publishEvent(ApplicationEvent applicationEvent) {
        applicationContext.publishEvent(applicationEvent);
    }
}
