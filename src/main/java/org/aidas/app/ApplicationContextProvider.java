package org.aidas.app;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class ApplicationContextProvider implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	
	private transient AutowireCapableBeanFactory beanFactory;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		 this.applicationContext = applicationContext;
		 this.beanFactory = this.applicationContext.getAutowireCapableBeanFactory();
	}
	
	public ApplicationContext getContext() {
        return applicationContext;
    }
	
	public AutowireCapableBeanFactory getAutowireCapableBeanFactory() {
        return beanFactory;
    }


}
