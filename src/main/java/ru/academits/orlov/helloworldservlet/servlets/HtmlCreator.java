package ru.academits.orlov.helloworldservlet.servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

class HtmlCreator {
    static void performGetRequest(HttpServlet servlet, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

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
                    <tr>
                        <td>
                """);

        Enumeration<String> contextParametersNames = servlet.getServletContext().getInitParameterNames();
        String contextParameterName = contextParametersNames.nextElement();

        writer.println(contextParameterName);
        writer.println("""
                        </td>
                        <td>
                """);
        writer.println(servlet.getServletContext().getInitParameter(contextParameterName));
        writer.println("""
                        </td>
                    </tr>
                    <tr>
                        <td>
                """);

        contextParameterName = contextParametersNames.nextElement();

        writer.println(contextParameterName);
        writer.println("""
                        </td>
                        <td>
                """);
        writer.println(servlet.getServletContext().getInitParameter(contextParameterName));
        writer.println("""
                        </td>
                    </tr>
                    <tr>
                        <td>
                """);

        Enumeration<String> servletParametersNames = servlet.getInitParameterNames();
        String servletParameterName = servletParametersNames.nextElement();

        writer.println(servletParameterName);
        writer.println("""
                        </td>
                        <td>
                """);
        writer.println(servlet.getInitParameter(servletParameterName));
        writer.println("""
                        </td>
                    </tr>
                    <tr>
                        <td>
                """);

        servletParameterName = servletParametersNames.nextElement();
        writer.println(servletParameterName);
        writer.println("""
                        </td>
                        <td>
                """);
        writer.println(servlet.getInitParameter(servletParameterName));
        writer.println("""
                        </td>
                    </tr>
                    </tbody>
                </table>
                </body>
                </html>
                """);
    }
}
