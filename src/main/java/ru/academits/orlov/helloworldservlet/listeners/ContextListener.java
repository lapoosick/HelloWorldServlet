package ru.academits.orlov.helloworldservlet.listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Контекст \"" + sce.getServletContext().getServletContextName() + "\" создан.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Контекст \"" + sce.getServletContext().getServletContextName() + "\" уничтожен.");
    }
}
