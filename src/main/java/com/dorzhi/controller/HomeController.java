package com.dorzhi.controller;

import com.dorzhi.content.Book;
import com.dorzhi.content.Content;
import com.dorzhi.content.Music;
import com.dorzhi.services.MediaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("/controller")
public class HomeController {

    private final Logger logger = Logger.getLogger(HomeController.class);

    @RequestMapping(value = "/")
    public String home() {
        return "test";
    }

    @Autowired
    private MediaService service;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public void hello(){

        service.save(getBook());
        service.save(getTrack());
        logger.info("Spisok vseh elementov: ");
        for (Content content: service.getAll()){
            logger.info(content);
        }

    }
    private static Content getBook() {
        Book book = new Book();
        book.setTitle("Nad propastyu vo rzhi");
        book.getAuthor().setFirstName("Djerom");
        book.getAuthor().setMiddleName("David");
        book.getAuthor().setLastName("Selinjer");
        book.setPageCount(500);
        return book;
    }
    private static Content getTrack() {
        Music track = new Music();
        track.setTitle("Moby - Lift Me Up");
        track.getAuthor().setFirstName("Richard");
        track.getAuthor().setMiddleName("Mellvin");
        track.getAuthor().setLastName("Hall");
        track.setBitRate(256);
        return track;
    }

}
