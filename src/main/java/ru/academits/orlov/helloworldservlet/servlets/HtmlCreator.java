package ru.academits.orlov.helloworldservlet.servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.text.StringEscapeUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

class HtmlCreator {
    protected static void performGetRequest(HttpServlet servlet, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        List<String> parametersNamesList = new ArrayList<>();
        List<String> parametersValuesList = new ArrayList<>();

        ServletContext servletContext = servlet.getServletContext();
        Enumeration<String> contextParametersNames = servletContext.getInitParameterNames();

        while (contextParametersNames.hasMoreElements()) {
            String parameterName = contextParametersNames.nextElement();

            parametersNamesList.add(StringEscapeUtils.escapeHtml4(parameterName));
            parametersValuesList.add(StringEscapeUtils.escapeHtml4(servletContext.getInitParameter(parameterName)));
        }

        Enumeration<String> servletParametersNames = servlet.getInitParameterNames();

        while (servletParametersNames.hasMoreElements()) {
            String parameterName = servletParametersNames.nextElement();

            parametersNamesList.add(StringEscapeUtils.escapeHtml4(parameterName));
            parametersValuesList.add(StringEscapeUtils.escapeHtml4(servlet.getInitParameter(parameterName)));
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
                """.formatted(parametersNamesList.getFirst(), parametersValuesList.getFirst(),
                parametersNamesList.get(1), parametersValuesList.get(1),
                parametersNamesList.get(2), parametersValuesList.get(2),
                parametersNamesList.get(3), parametersValuesList.get(3)));
    }
}
