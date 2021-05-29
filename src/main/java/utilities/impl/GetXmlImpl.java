package utilities.impl;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import models.Books;
import utilities.GetXml;

public class GetXmlImpl implements GetXml {

    @Override
    public void getXmlData(Books books) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // File file = new File("books.xml");
            System.out.println();
            marshaller.marshal(books, System.out); // book, file
        } catch (JAXBException e) {
            // TODO: handle exception
        }

    }

}
