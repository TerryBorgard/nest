package com.zhaofujun.nest.context;

import com.zhaofujun.nest.NestApplication;
import com.zhaofujun.nest.container.BeanFinder;

public class ServiceContext {

    private Class serviceClass;
    private ContextUnitOfWork contextUnitOfWork;
    private NestApplication application;


    public ServiceContext(Class serviceClass, NestApplication application) {
        this.serviceClass = serviceClass;
        this.contextUnitOfWork = new ContextUnitOfWork();
        this.application =application;
    }


    public Class getServiceClass() {
        return serviceClass;
    }

    public static ServiceContext getCurrent() {
        return ServiceContextManager.get();
    }

    public static ServiceContext newInstance(Class serviceClass, NestApplication application) {
        ServiceContext serviceContext = new ServiceContext(serviceClass,application);
        ServiceContextManager.set(serviceContext);

        serviceContext.getApplication().onServiceContextCreated(serviceContext);
        return serviceContext;
    }

    public ContextUnitOfWork getContextUnitOfWork() {
        return contextUnitOfWork;
    }


    public NestApplication getApplication() {
        return application;
    }
}

