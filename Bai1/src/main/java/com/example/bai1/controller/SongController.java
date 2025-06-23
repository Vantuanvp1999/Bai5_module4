package com.example.bai1.controller;

import com.example.bai1.model.Song;
import com.example.bai1.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/songs")
public class SongController {
private final String uploadPath = "C:/music-files/";

@Autowired
    private SongService songService;
@GetMapping("")
    public String showList(Model model) {
    model.addAttribute("songs", songService.findAll());
    return "list";
}
@GetMapping("/create")
    public String create(Model model) {
    model.addAttribute("song", new Song());
    return "create";

}
@PostMapping("/save")
    public String save(@ModelAttribute Song song, @RequestParam("file") MultipartFile file) {
    if (!file.isEmpty()) {
        String fileName = file.getOriginalFilename();
        try{
            FileCopyUtils.copy(file.getBytes(),new File(uploadPath+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    songService.save(song);
    return "redirect:/songs";
}
@GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
    Song song = songService.findById(id);
    if (song != null) {
        model.addAttribute("song", song);
        return "edit";
    }
    return "redirect:/songs";
}
@PostMapping("/update")
    public String update(@ModelAttribute Song song, @RequestParam("file") MultipartFile file) {
    if (!file.isEmpty()) {
        String fileName = file.getOriginalFilename();
    try{
        FileCopyUtils.copy(file.getBytes(),new File(uploadPath+fileName));
        song.setFilePath(fileName);

    }catch (IOException e) {
        e.printStackTrace();
    }
    }
    songService.save(song);
    return "redirect:/songs";
}
@GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
    songService.delete(id);
    return "redirect:/songs";
}
}
