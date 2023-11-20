package com.app.stream.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "series")
public class Serie {

    @Id
    private String id;
    private String title;
    private String description;
    private String releaseDate;
    private List<Temporada> seasons;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Temporada> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Temporada> seasons) {
        this.seasons = seasons;
    }
}
