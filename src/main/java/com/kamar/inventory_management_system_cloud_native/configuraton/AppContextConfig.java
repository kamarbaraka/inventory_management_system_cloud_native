package com.kamar.inventory_management_system_cloud_native.configuraton;

/*import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;*/
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.eclipse.birt.report.engine.api.IReportEngine;

/**
 * configuration for this application.
 * @author kamar baraka.*/


@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.kamar.inventory_management_system_cloud_native.components"})
@EntityScan(basePackages = {"com.kamar.inventory_management_system_cloud_native.components.persistence.entities"})
@EnableHypermediaSupport(type = {EnableHypermediaSupport.HypermediaType.HAL, EnableHypermediaSupport.HypermediaType.COLLECTION_JSON})
public class AppContextConfig {

    /*@Bean
    public IReportEngine reportEngine() throws Exception{

        EngineConfig engineConfig = new EngineConfig();
        engineConfig.setBIRTHome("C:\\Program Files\\birt designer");
        Platform.startup(engineConfig);

        IReportEngineFactory factory = (IReportEngineFactory) Platform.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
        IReportEngine engine = factory.createReportEngine(engineConfig);

        return engine;
    }*/
}
