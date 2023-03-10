/*
 * This file is generated by jOOQ.
 */
package com.javatechie.jooq.model;


import com.javatechie.jooq.model.tables.Book;
import com.javatechie.jooq.model.tables.records.BookRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in 
 * test.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<BookRecord> KEY_BOOK_PRIMARY = Internal.createUniqueKey(Book.BOOK, DSL.name("KEY_book_PRIMARY"), new TableField[] { Book.BOOK.ID }, true);
}
