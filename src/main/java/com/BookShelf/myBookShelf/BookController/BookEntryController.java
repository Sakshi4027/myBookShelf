package com.BookShelf.myBookShelf.BookController;

import com.BookShelf.myBookShelf.Entity.BookEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("BookShelf")
public class BookEntryController
{
    private Map<Long, BookEntry> bookEntries = new HashMap<>();


    @GetMapping
    public List<BookEntry> getAll()
    {
        return new ArrayList<>(bookEntries.values());
    }

    @PostMapping
    public String createBookEntry(@RequestBody BookEntry myEntry)
    {
        bookEntries.put(myEntry.getId(), myEntry);
        return "data entry created successfully";
    }

    @GetMapping("/id/{myid}")
    public BookEntry getBookEntryById(@PathVariable Long myid)
    {
        return bookEntries.get(myid);
    }

    @DeleteMapping("/id/{myId}")
    public String deleteBookEntryById(@PathVariable Long myId)
    {
        bookEntries.remove(myId);
        return "data entry deleted successfully";
    }

    @PutMapping("/id/{myId}")
    public String updateBookEntryById(@PathVariable Long myId, @RequestBody BookEntry myEntry)
    {
        bookEntries.put(myId, myEntry);
        return "data updated successfully";
    }

    @RequestMapping("/maxPriceBook")
    public BookEntry getBookWithMaxPrice()
    {
        double maxPrice = 0.0;
        BookEntry Max = null;

        for(BookEntry book : bookEntries.values())
        {
            if(book.getPrice() > maxPrice)
            {
                maxPrice = book.getPrice();
                Max = book;
            }
        }

        return Max;
    }



}
