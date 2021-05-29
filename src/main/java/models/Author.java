package models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "author")
public class Author {
    private String id;
    private String name;

    public Author() {
        super();
    }

    public Author(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @XmlElement(name = "author_id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "author_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author [id=" + id + ", name=" + name + "]";
    }

}
