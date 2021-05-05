package util;

import com.mpatric.mp3agic.*;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import service.Local;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Tag {

    private String appId;
    private boolean marked;

    public Tag() {}


    private boolean getMarked(String path) throws UnsupportedTagException, InvalidDataException, IOException {

        Mp3File localFile = new Mp3File(path);
        String comment;
        marked = false;

        if(localFile.hasId3v1Tag()) {
            ID3v1 localID3v1 = localFile.getId3v1Tag();
            comment = localID3v1.getComment();
        } else if(localFile.hasId3v2Tag()) {
            ID3v2 localID3v2 = localFile.getId3v2Tag();
            comment = localID3v2.getComment();
        } else {
            comment = null;
        }

        if(comment != null && comment.contains("@@~NOTRACK")) {
            marked = true;
        } else if (comment != null && comment.contains("@@~TRAQED")) {
            marked = true;
        }

        return marked;
    }


    public ArrayList<Local> getNewFiles(final File folder) {

        ArrayList<Local> names = new ArrayList<>();

        for(final File entry : Objects.requireNonNull(folder.listFiles())) {
            if(entry.isDirectory()) {
                getNewFiles(entry);
            } else {
                if(entry.getName().endsWith(".mp3")) {
                    try {
                        if(!getMarked(entry.getPath())) {
                            Local newFile = new Local(
                                    "",
                                    "",
                                    "",
                                    0,
                                    0,
                                    0,
                                    0,
                                    "",
                                    0,
                                    "",
                                    entry.getName());
                            newFile.setLocalData();
                            names.add(newFile);
                        }
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return names;
    }
}
