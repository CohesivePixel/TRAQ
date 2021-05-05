package service;

import model.Song;

import static org.apache.commons.io.FilenameUtils.removeExtension;

public class Local extends Song {

    private String localName;

    public Local(String name, String album, String author, double duration, double bpm, int trackNr, int discNr, String coverImg, double popularity, String releaseDate, String localName) {
        super(name, album, author, duration, bpm, trackNr, discNr, coverImg, popularity, releaseDate);

        this.localName = localName;
    }

    public void setLocalData() {
        String[] namen = localName.split("-");

        author = namen[0];
        name = removeExtension(namen[1]);
    }

}
