package hello.boot;

import hello.spring.HelloConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.List;

public class MySpringApplication {

    public static void run(Class configClass, String[] args){
        System.out.println("MySpringApplication.main args = " + List.of(args));
        Tomcat tomcat = new Tomcat();
        Connector connector = new Connector();
        connector.setPort(8080);
        tomcat.setConnector(connector);

        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(configClass);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);
        Context context = tomcat.addContext("", "/");
        Tomcat.addServlet(context, "dispatcherServlet", dispatcherServlet);
        context.addServletMappingDecoded("/", "dispatcherServlet");

        try {
            tomcat.start();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
    }
}
