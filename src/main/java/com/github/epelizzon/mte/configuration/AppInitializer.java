package com.github.epelizzon.mte.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        final AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(RootConfiguration.class);
        
        sc.addListener(new ContextLoaderListener(context));
        sc.addListener(new RequestContextListener());
        
        final AnnotationConfigWebApplicationContext jspContext = new AnnotationConfigWebApplicationContext();
        jspContext.register(JspDispatcher.class);

        final Dynamic servlet = sc.addServlet("view", new DispatcherServlet(jspContext));
        servlet.addMapping("*.htm");
        servlet.setLoadOnStartup(2);
    }
}
