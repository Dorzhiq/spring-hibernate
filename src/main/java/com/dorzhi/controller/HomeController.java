package com.dorzhi.controller;

import com.dorzhi.content.Book;
import com.dorzhi.content.Content;
import com.dorzhi.content.Music;
import com.dorzhi.services.MediaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@RequestMapping(value = "/controller")
@Controller
public class HomeController {

    private final Logger logger = Logger.getLogger(HomeController.class);

    @RequestMapping(value = "/")
    public String home() {
        return "test";
    }

    @Autowired
    private MediaService service;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){

        service.save(getBook());
        service.save(getTrack());
        logger.info("Spisok vseh elementov: ");
        for (Content content: service.getAll()){
            logger.info(content);
        }
        return "test";
    }
    private static Content getBook() {
        Book book = new Book();
        book.setTitle("Nad propastyu Kappa123");
        book.getAuthor().setFirstName("Dj");
        book.getAuthor().setMiddleName("DavidGetto");
        book.getAuthor().setLastName("Selincer");
        book.setPageCount(500);
        return book;
    }
    private static Content getTrack() {
        Music track = new Music();
        track.setTitle("MobyDick - Lift Me Up");
        track.getAuthor().setFirstName("Rich");
        track.getAuthor().setMiddleName("Mell");
        track.getAuthor().setLastName("Hall");
        track.setBitRate(256);
        return track;
    }

}
