package ru.academits.orlov.helloworldservlet.servlets;

import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebServlet(value = "/servlet1",
        initParams = {
                @WebInitParam(name = "servlet1param1", value = "servlet1Value1"),
                @WebInitParam(name = "servlet1param2", value = "servlet1Value2")
        })
public class HelloWorldServlet1 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HtmlCreator.performGetRequest(this, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("The servlet 1 POST request was successfully completed.");
    }
}
