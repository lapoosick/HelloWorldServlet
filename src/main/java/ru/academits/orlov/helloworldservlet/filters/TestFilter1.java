package ru.academits.orlov.helloworldservlet.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebFilter("/*")
public class TestFilter1 extends HttpFilter {
    @Serial
    private static final long serialVersionUID = 3L;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        res.addHeader("X-Test-1", "Test-1");
        chain.doFilter(req, res);
    }
}
