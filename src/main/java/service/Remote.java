package service;

import model.Song;

public class Remote extends Song {

    public Remote(String name, String album, String author, double duration, double bpm, int trackNr, int discNr, String coverImg, double popularity, String releaseDate) {
        super(name, album, author, duration, bpm, trackNr, discNr, coverImg, popularity, releaseDate);
    }
}
