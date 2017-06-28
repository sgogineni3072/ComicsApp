package com.example.admin.comicsapp.models;

import java.util.List;

/**
 * Created by Admin on 27/06/2017.
 */

public class Result {
    public String id;
    public String digitalId;
    public String title;
    public String issueNumber;
    public String variantDescription;
    public String description;
    public String modified;
    public String isbn;
    public String upc;
    public String diamondCode;
    public String ean;
    public String issn;
    public String format;
    public String pageCount;
    public String resourceURI;
    public List<Date> dates = null;
    public List<Price> prices = null;
    public Thumbnail thumbnail;
    public List<Image> images = null;
    public Creators creators;
}
