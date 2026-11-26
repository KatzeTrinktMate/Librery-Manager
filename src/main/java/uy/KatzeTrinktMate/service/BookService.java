package uy.KatzeTrinktMate.service;
import uy.KatzeTrinktMate.model.Book;

import java.math.BigDecimal;

public class BookService {
    //Compare if the price of book is negative
    public boolean priceNegative(BigDecimal p){
       return p == null || p.compareTo(BigDecimal.ZERO) < 0;
    }
}
