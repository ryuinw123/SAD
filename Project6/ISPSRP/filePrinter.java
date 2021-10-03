/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solid.book;

import com.mycompany.srpispviolation.Book.Printer;


/**
 *
 * @author ryu
 */
public class filePrinter implements Printer{

    @Override
    public void printPage(Book book) {
        do {
            System.out.println(book.getCurrentPage());
        } while (book.turnToNextPage());
    }

    
}
