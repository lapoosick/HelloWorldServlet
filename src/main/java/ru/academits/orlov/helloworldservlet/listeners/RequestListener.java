package ru.academits.orlov.helloworldservlet.listeners;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Пришёл запрос с id = " + sre.getServletRequest().getRequestId() + ".");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Обработан запрос с id = " + sre.getServletRequest().getRequestId() + ".");
    }
}
