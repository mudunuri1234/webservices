package com.learning.ws.rest;

import javax.ws.rs.MatrixParam;

public class BookServiceImpl implements BookService {

    public String getBooks(String year, String author, String country) {
        return "year: " + year + " author: " + author + " country: " + country;
    }

//    public String getBooks(@MatrixParam("") Book bookBean) {
//        return " year: " + bookBean.getYear() +
//               " author: " + bookBean.getAuthor() +
//               " country: " + bookBean.getCountry();
//    }

}
