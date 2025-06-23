package com.example.baitap1.service;

import com.example.baitap1.model.Song;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SongService implements ISongService {
    private final List<Song> songs = new ArrayList<Song>();

    @Override
    public List<Song> findAll() {
        return songs;
    }

    @Override
    public void save(Song song) {
        songs.add(song);
    }
}
