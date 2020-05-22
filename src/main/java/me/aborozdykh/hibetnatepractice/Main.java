package me.aborozdykh.hibetnatepractice;

import me.aborozdykh.hibetnatepractice.lib.Injector;
import me.aborozdykh.hibetnatepractice.models.Author;
import me.aborozdykh.hibetnatepractice.models.Book;
import me.aborozdykh.hibetnatepractice.models.Genre;
import me.aborozdykh.hibetnatepractice.service.AuthorService;
import me.aborozdykh.hibetnatepractice.service.BookService;
import me.aborozdykh.hibetnatepractice.service.GenreService;

public class Main {
    private static Injector injector = Injector.getInstance("me.aborozdykh.hibernatepractice");

    public static void main(String[] args) {
        GenreService genreService = (GenreService) injector.getInstance(GenreService.class);
        var genreFantasy = new Genre();
        genreFantasy.setName("Fantasy");
        genreService.add(genreFantasy);

        var genreClassic = new Genre();
        genreClassic.setName("Classic");
        genreService.add(genreClassic);


        AuthorService authorService = (AuthorService) injector.getInstance(AuthorService.class);
        var authorFranko = new Author();
        authorFranko.setFirstName("Ivan");
        authorFranko.setLastName("Franko");
        authorService.add(authorFranko);

        var authorTolkien = new Author();
        authorFranko.setFirstName("John");
        authorFranko.setLastName("Tolkien");
        authorService.add(authorTolkien);

        BookService bookService = (BookService) injector.getInstance(BookService.class);
        var bookZakharBerkut = new Book();
        bookZakharBerkut.setTitle("Zakhar Berkut");
        bookZakharBerkut.setAuthor(authorFranko);
        bookZakharBerkut.setGenre(genreClassic);
        bookService.add(bookZakharBerkut);

        var bookTheLordOfTheRings = new Book();
        bookTheLordOfTheRings.setTitle("The Lord of the Rings");
        bookTheLordOfTheRings.setAuthor(authorTolkien);
        bookTheLordOfTheRings.setGenre(genreFantasy);
        bookService.add(bookTheLordOfTheRings);

        System.out.println("Get by title Lord of the Rings: " + bookService.getBookByTitle("The Lord of The Rings").toString());

        System.out.println("Get all by author");
        bookService.getAllByAuthor(authorFranko).forEach(System.out::println);

        System.out.println("Get all by genre");
        bookService.getAllByGenre(genreFantasy).forEach(System.out::println);
    }
}
