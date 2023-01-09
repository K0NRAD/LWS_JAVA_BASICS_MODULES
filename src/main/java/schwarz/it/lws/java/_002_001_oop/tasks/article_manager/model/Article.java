package schwarz.it.lws.java._002_001_oop.tasks.article_manager.model;

import schwarz.it.lws.java._002_001_oop.tasks.article_manager.exceptions.EANAlreadyExistsException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Article {
    private String id;
    private String name;
    private String description;
    private double price;
    private TaxId taxId;
    private List<EAN> eans;
}
