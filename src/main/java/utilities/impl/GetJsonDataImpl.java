package utilities.impl;

import java.util.List;

import com.google.gson.Gson;

import models.Book;
import utilities.GetJson;

public class GetJsonDataImpl implements GetJson {

    @Override
    public void displayJsonData(List<Book> books) {
        Gson gson = new Gson();
        String jsonData = gson.toJson(books);
        System.out.println(jsonData);
    }
    
}
