package com.example.songr.web;

import com.example.songr.domain.Album;
import com.example.songr.infrastructure.AlbumsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class helloController {


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/hello")
    //RequestParam  for query
    // Pathvariable
    String hello(@RequestParam(name = "name", required = false, defaultValue = "Hello World") String name, Model model){
        System.out.println("Hello folks => " + name);

        model.addAttribute("name", name);
        model.addAttribute("age",99);

        return "hello";
    }

//    /capitalize/

    @GetMapping("/capitalize/{name}")
    String capitalize(@PathVariable(name = "name", required = false) String name, Model model){
        if(name == null)
        {
            //you need an Exception;
        }
        else
        {
            name = name.toUpperCase();
        }
        System.out.println("Hello folks => " + name);
        model.addAttribute("name", name.toUpperCase());

        return "capitalize";
    }


    @ResponseBody
    @GetMapping("/Albums")
    List<Album> getAllAlbums()
    {
        List<Album> albums = new ArrayList<>();
        albums.add(new Album ("Insan","Hamza Namira",2,12,"./Hamza/Insan.png"));
        albums.add(new Album ("Hateer min tani","Hamza Namira",3,7,"./Hamza/HateerMinTani.png"));
        albums.add(new Album ("Esmaani","Hamza Namira",1,9,"./Hamza/ُEsmaani.png"));
        albumsRepositories.save(albums.get(0));
        albumsRepositories.save(albums.get(1));
        albumsRepositories.save(albums.get(2));

        return albums;

    }

//addAlbums

    @Autowired
    AlbumsRepositories albumsRepositories;


    @GetMapping("/GetAllAlbums")
    public String getAllAlbums(Model model)
    {
        model.addAttribute("AlbumsList",albumsRepositories.findAll());
        return "Album";
    }

    @PostMapping("/addAlbums")
    public RedirectView createAlbums(@ModelAttribute Album album)
    {
        albumsRepositories.save(album);
        return new RedirectView("GetAllAlbums");
    }


}
