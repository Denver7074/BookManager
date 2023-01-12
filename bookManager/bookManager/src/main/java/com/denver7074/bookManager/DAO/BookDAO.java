package com.denver7074.bookManager.DAO;

import com.denver7074.bookManager.model.Books;
import com.denver7074.bookManager.model.Images;
import com.denver7074.bookManager.model.constant.Genre;
import com.denver7074.bookManager.repositories.BookRep;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class BookDAO {

    @NonNull
    private final BookRep bookRep;

    public List<Books> booksList(String title){
        if (title != null) return bookRep.findBooksByTitleBookContainingIgnoreCase(title);
        return bookRep.findAll();
    }




    public void addBook(Books book, MultipartFile file)  {
        Images coverBook;
        if (file.getSize() != 0){
            try {
                coverBook = toImageEntity(file);
                book.addImage(coverBook);
            }
            catch (IOException ex){
                log.error("Error: " + ex.getMessage());
            }
        }
        bookRep.save(book);
        log.info("New book: " + book.getTitleBook());
    }
    private Images toImageEntity(MultipartFile file) throws IOException {
        Images image = new Images();
        image.setName(file.getName());
        image.setSize(file.getSize());
        image.setType(file.getContentType());
        image.setBytes(file.getBytes());
        return image;
    }
    public void deleteBook(Long id){
        bookRep.deleteById(id);
    }
    public void updateBook(String titleBook,
                           String author,
                           double price,
                           LocalDate yearWrite,
                           Genre genre,
                           String isbn,
                           Long id){
        Books book = bookRep.findById(id).orElse(null);
        book.setTitleBook(titleBook);
        book.setAuthor(author);
        book.setPrice(price);
        book.setYearWrite(yearWrite);
        book.setGenre(genre);
        book.setIsbn(isbn);
        bookRep.save(book);
        log.info("Update book: " + titleBook);
    }
    public Optional<Books> bookInfo(Long id){
        Optional<Books> book = bookRep.findById(id);
        ArrayList<Books> books = new ArrayList<>();
        book.ifPresent(books::add);
        return book;
    }


}
