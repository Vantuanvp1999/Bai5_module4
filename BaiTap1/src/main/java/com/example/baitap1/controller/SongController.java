package com.example.baitap1.controller;

import com.example.baitap1.model.Song;
import com.example.baitap1.model.SongForm;
import com.example.baitap1.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class SongController {
    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private final ISongService songService;

    public SongController(ISongService songService) {
        this.songService = songService;
    }
    @GetMapping("/songs" )
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("/index");
        List<Song> songs = songService.findAll();
        modelAndView.addObject("songs", songs);
        return modelAndView;

    }
    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("/create");
        List<String> genres = Arrays.asList("Pop", "Rock", "Ballad", "EDM", "R&B");
        modelAndView.addObject("songForm", new SongForm());
        modelAndView.addObject("genres", genres);
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute SongForm songForm) {
        MultipartFile multipartFile = songForm.getFile();
        String fileName = multipartFile.getOriginalFilename();
        if(fileName==null || fileName.isEmpty()||multipartFile.getSize()==0){
            ModelAndView errorModelAndView = new ModelAndView("/create");
            errorModelAndView.addObject("message","Choose a file");
            return errorModelAndView;
        }
        try {
            FileCopyUtils.copy(songForm.getFile().getBytes(),new File(fileUpload+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Song song = new Song(songForm.getName(),songForm.getArtist(),songForm.getGenre(),fileName);
        songService.save(song);
        return new ModelAndView("redirect:/songs");
    }
}

