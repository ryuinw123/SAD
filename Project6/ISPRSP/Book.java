/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solid.book;

/**
 *
 * @author ryu
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;

public class Book {
    private String title;
    private List<String> pages;
    private ListIterator<String> iterator;
    private String currentPage;

    public Book(String title, List<String> pages) {
        this.title = title;
        this.pages = pages;
        iterator = pages.listIterator();
        if (iterator.hasNext()) {
            currentPage = iterator.next();
        } else {
            currentPage = null;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public boolean turnToNextPage() {
        if (iterator.hasNext()) {
            currentPage = iterator.next();
            return true;
        } else {
            return false;
        }
    }
    
    interface Printer{
        public void printPage(Book book);
    }
}