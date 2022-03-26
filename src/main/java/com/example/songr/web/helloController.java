package com.example.songr.web;

import com.example.songr.domain.Album;
import com.example.songr.domain.song;
import com.example.songr.infrastructure.AlbumsRepositories;
import com.example.songr.infrastructure.songRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class helloController {

    private final AlbumsRepositories AlbumsRepositories;
    private final songRepositories songRepositories;

    public helloController(AlbumsRepositories albumsRepositories, songRepositories songRepositories) {
        this.AlbumsRepositories = albumsRepositories;
        this.songRepositories = songRepositories;
    }


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
    @PostMapping("/addAlbums")
    public RedirectView createAlbum(@ModelAttribute Album album)
    {
        AlbumsRepositories.save(album);
        return new RedirectView("GetAllAlbums");
    }


    @GetMapping("/GetAllAlbums")
    public String getAllAlbums(Model model)
    {
        model.addAttribute("AlbumsList",AlbumsRepositories.findAll());
        return "Album";
    }



    @ResponseBody
    @PostMapping("/addSongs")
    public RedirectView createSongs(@ModelAttribute song song)
    {
        songRepositories.save(song);
        return new RedirectView("GetAllSongs");
    }


    @GetMapping("/GetAllSongs")
    public String getAllSongs(Model model)
    {
        model.addAttribute("AlbumsList",songRepositories.findAll());
        return "song";
    }


//      *************************************        Lab13               **************************************
        /**
     * Creates a new album
     *
     * @param album
     * @return
     */

    @ResponseBody
    @PostMapping("/Albums")
    Album createAlbums(@RequestBody Album album)
    {
            return AlbumsRepositories.save(album);
    }

    /**
     * Creates a new song
     *
     * @param song
     * @parma id
     * @return
     */

    @ResponseBody
    @PostMapping("/Albums/{id}")
    song addNewSongToAlbum(@RequestBody song song, @PathVariable Long id){

        Album album = AlbumsRepositories.findById(id).orElseThrow();
        song.setAlbum(album);
        return songRepositories.save(song);

    }

    @ResponseBody
    @GetMapping("/Albums")
    List<Album> getAllAlbums()
    {
        return AlbumsRepositories.findAll();
    }


//    @ResponseBody
//    @GetMapping("/Albums/{id}/songs")
//    List<song> findAllSongsOfAlbum(@PathVariable Long id) {
//
//        return songRepositories.findAllByAlbum_Id(id);
//    }















    //
//
//    @ResponseBody
//    @GetMapping("/Albums")
//    List<Album> getAllAlbums()
//    {
//        List<Album> albums = new ArrayList<>();
////        albums.add(new Album ("Insan","Hamza Namira",2,12,"./Hamza/Insan.png"));
////        albums.add(new Album ("Hateer min tani","Hamza Namira",3,7,"./Hamza/HateerMinTani.png"));
////        albums.add(new Album ("Esmaani","Hamza Namira",1,9,"./Hamza/ُEsmaani.png"));
////        albumsRepositories.save(albums.get(0));
////        albumsRepositories.save(albums.get(1));
////        albumsRepositories.save(albums.get(2));
//        return albums;
//    }


//    @ResponseBody
//    @GetMapping("/Albums")
//    List<Album> getAllAlbums()
//    {
//       return AlbumsRepositories.findAll();
//    }


//    /**
//     * Creates a new album
//     *
//     * @param album
//     * @return
//     */
//
//    @ResponseBody
//    @PostMapping("/albums")
//    Album createNewAlbum(RequestBody Album album)
//    {
//        return AlbumsRepositories.save(album);
//    }











}
