package controller;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.Details;
import services.impl.DetailsImpl;

public class GetData extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        InputStreamReader inputStreamReader = null;

        BufferedReader bufferedReader = null;

        try {
            inputStreamReader = new InputStreamReader(req.getInputStream());
            bufferedReader = new BufferedReader(inputStreamReader);

            /* prints the whole JSON data in string format */
            String data = "";

            if (bufferedReader != null) {
                data = bufferedReader.readLine();
            }

            Details details = new DetailsImpl();

            details.makeDetails(data);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
