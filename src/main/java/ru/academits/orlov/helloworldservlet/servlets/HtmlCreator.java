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

        Enumeration<String> contextParametersNames = servlet.getServletContext().getInitParameterNames();
        String firstContextParameterName = contextParametersNames.nextElement();
        String firstContextParameterValue = servlet.getServletContext().getInitParameter(firstContextParameterName);
        String secondContextParameterName = contextParametersNames.nextElement();
        String secondContextParameterValue = servlet.getServletContext().getInitParameter(secondContextParameterName);

        Enumeration<String> servletParametersNames = servlet.getInitParameterNames();
        String firstServletParameterName = servletParametersNames.nextElement();
        String firstServletParameterValue = servlet.getInitParameter(firstServletParameterName);
        String secondServletParameterName = servletParametersNames.nextElement();
        String secondServletParameterValue = servlet.getInitParameter(secondServletParameterName);

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
                        <td>%s</td>
                        <td>%s</td>
                    </tr>
                    <tr>
                        <td>%s</td>
                        <td>%s</td>
                    </tr>
                    <tr>
                        <td>%s</td>
                        <td>%s</td>
                    </tr>
                    <tr>
                        <td>%s</td>
                        <td>%s</td>
                    </tr>
                    </tbody>
                </table>
                </body>
                </html>
                """.formatted(firstContextParameterName, firstContextParameterValue,
                secondContextParameterName, secondContextParameterValue,
                firstServletParameterName, firstServletParameterValue,
                secondServletParameterName, secondServletParameterValue));
    }
}
