package uy.KatzeTrinktMate.service;
import uy.KatzeTrinktMate.model.Book;

import java.math.BigDecimal;

public class ValidationBook {
    //Compare if the price of book is negative
    public boolean priceNegative(BigDecimal p){
       return p.compareTo(BigDecimal.ZERO) < 0 || p == null;
    }
    //Verifique if a isbn alredy exist
    public boolean isbnExist(String isbn, Book i){
        return i.getIsbn().trim().equals(isbn.trim());
    }
}
