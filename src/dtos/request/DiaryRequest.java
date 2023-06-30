package dtos.request;

import java.time.LocalDate;

public class DiaryRequest {
    private int id;
    private String title;
    private String content;
    private LocalDate date;

    public void setId(int id){
    this.id = id;
    }
    public int getId(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
