package hello.container;

import hello.servlet.HelloServlet;
import jakarta.servlet.ServletContext;

public class AppInitV1Servlet implements AppInit {
    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("AppInitV1.onStartup");
        servletContext.addServlet("hello", new HelloServlet())
                .addMapping("/hello");
    }
}
