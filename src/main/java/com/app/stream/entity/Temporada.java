package com.app.stream.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "seasons")
public class Temporada {

    @Id
    private String id;
    private String title;
    private String releaseDate;
    private List<Episodio> episodes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Episodio> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episodio> episodes) {
        this.episodes = episodes;
    }
}
