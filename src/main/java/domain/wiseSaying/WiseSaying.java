package domain.wiseSaying;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WiseSaying {

    private int id;
    private String content;
    private String author;

    public WiseSaying(String content, String author) {
        this.content = content;
        this.author = author;
    }

    public boolean isNew() {
        return this.id == 0;
    }
}