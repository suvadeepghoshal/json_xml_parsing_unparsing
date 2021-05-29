package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.Details;
import services.impl.DetailsImpl;

public class GetXmlData extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            inputStreamReader = new InputStreamReader(req.getInputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
            String xmlLine = "";
            StringBuilder xmlData = new StringBuilder("");
            while ((xmlLine = bufferedReader.readLine()) != null) {
                xmlData = xmlData.append(xmlLine);
            }
            String data = xmlData.toString();
            Details details = new DetailsImpl();
            details.makeXmlDetails(data);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
