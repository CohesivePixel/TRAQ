package model;

public abstract class Song {

    protected String name;
    protected String album;
    protected String author;
    protected double duration;
    protected double bpm;
    protected int trackNr;
    protected int discNr;
    protected String coverImg;
    protected double popularity;

    public Song(String name, String album, String author, double duration, double bpm, int trackNr, int discNr, String coverImg, double popularity, String releaseDate) {
        this.name = name;
        this.album = album;
        this.author = author;
        this.duration = duration;
        this.bpm = bpm;
        this.trackNr = trackNr;
        this.discNr = discNr;
        this.coverImg = coverImg;
        this.popularity = popularity;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getBpm() {
        return bpm;
    }

    public void setBpm(double bpm) {
        this.bpm = bpm;
    }

    public int getTrackNr() {
        return trackNr;
    }

    public void setTrackNr(int trackNr) {
        this.trackNr = trackNr;
    }

    public int getDiscNr() {
        return discNr;
    }

    public void setDiscNr(int discNr) {
        this.discNr = discNr;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String releaseDate;
}
