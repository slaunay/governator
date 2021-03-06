package com.netflix.governator;

import javax.inject.Inject;

import com.google.inject.AbstractModule;

/**
 * Install this module to log a Provision report after the Injector is created.
 * 
 * @author elandau
 *
 */
public class ProvisionDebugModule extends AbstractModule {
    public static class StaticInitializer {
        @Inject
        public static LoggingProvisionMetricsLifecycleListener listener;
    }
    
    @Override
    protected void configure() {
        binder().requestStaticInjection(StaticInitializer.class);
        
        bind(LoggingProvisionMetricsLifecycleListener.class).asEagerSingleton();
        bind(ProvisionMetrics.class).to(SimpleProvisionMetrics.class);
    }
}
