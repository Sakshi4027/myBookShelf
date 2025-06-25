package com.BookShelf.myBookShelf.BookController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck
{
    @GetMapping("HealthCheck")
    public String healthCheck()
    {
        return "Everything is OK!";
    }
}
