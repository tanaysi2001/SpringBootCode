package com.example.mvcDemo;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.example.mvcDemo.config.WebConfig;

@SpringBootApplication
public class MvcDemoApplication {

    public static void main(String[] args) throws Exception {

        // Create Tomcat
        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);
        tomcat.getConnector();

        // Create Tomcat web application context
        String contextPath = "";
        String baseDoc = new File(".").getAbsolutePath();

        Context context =
                tomcat.addContext(contextPath, baseDoc);

        // Create Spring ApplicationContext
        AnnotationConfigWebApplicationContext springContext =
                new AnnotationConfigWebApplicationContext();

        springContext.register(WebConfig.class);

        // Create DispatcherServlet
        DispatcherServlet dispatcherServlet =
                new DispatcherServlet(springContext);

        // Register DispatcherServlet with Tomcat
        tomcat.addServlet(
                context,
                "dispatcherServlet",
                dispatcherServlet
        );

        // Map all requests to DispatcherServlet
        context.addServletMappingDecoded(
                "/",
                "dispatcherServlet"
        );

        // Start Tomcat
        tomcat.start();

        System.out.println("Tomcat started on port 8080");

        // Keep server running
        tomcat.getServer().await();
    }
}