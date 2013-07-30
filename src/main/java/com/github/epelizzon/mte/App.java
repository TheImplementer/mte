package com.github.epelizzon.mte;

import java.io.File;
import javax.servlet.ServletException;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {

    public static final String WEBAPP_DIR = "src/main/webapp";
    public static final int PORT = 8989;

    public static void main(String[] args) throws ServletException, LifecycleException {

        final Tomcat tomcat = new Tomcat();
        tomcat.setPort(PORT);
        tomcat.addWebapp("/", new File(WEBAPP_DIR).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}
