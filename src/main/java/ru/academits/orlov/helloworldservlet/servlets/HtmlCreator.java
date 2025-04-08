package ru.academits.orlov.helloworldservlet.servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.text.StringEscapeUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

class HtmlCreator {
    public static void performGetRequest(HttpServlet servlet, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        Map<String, String> parameters = new HashMap<>();

        ServletContext servletContext = servlet.getServletContext();
        Enumeration<String> contextParametersNames = servletContext.getInitParameterNames();

        while (contextParametersNames.hasMoreElements()) {
            String parameterName = contextParametersNames.nextElement();

            parameters.put(StringEscapeUtils.escapeHtml4(parameterName),
                    StringEscapeUtils.escapeHtml4(servletContext.getInitParameter(parameterName)));
        }

        Enumeration<String> servletParametersNames = servlet.getInitParameterNames();

        while (servletParametersNames.hasMoreElements()) {
            String parameterName = servletParametersNames.nextElement();

            parameters.put(StringEscapeUtils.escapeHtml4(parameterName),
                    StringEscapeUtils.escapeHtml4(servlet.getInitParameter(parameterName)));
        }

        writer.println("""
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Parameters</title>
                    <style>
                        table, th, td {
                            border: 1px solid black;
                            border-collapse: collapse;
                            padding: 5px;
                        }
                
                        th {
                            font-weight: bold;
                        }
                    </style>
                </head>
                <body>
                <table>
                    <thead>
                    <tr>
                        <th>Parameter name</th>
                        <th>Parameter value</th>
                    </tr>
                    </thead>
                    <tbody>
                """);

        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            writer.println("""
                        <tr>
                            <td>%s</td>
                            <td>%s</td>
                        </tr>
                    """.formatted(entry.getKey(), entry.getValue()));
        }

        writer.println("""
                    </tbody>
                </table>
                </body>
                </html>
                """);
    }
}
