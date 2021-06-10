package hiper.models;

import java.util.List;
import java.util.Objects;

public class Quiz extends AbstractEntity<Long, Quiz> {
    private String title;
    private User author;
    private String description;
    private List<Question> questions;
    private int expectedDuration;
    private String pictureURL; //optional
    private String tags;

    public Quiz() {
    }

    public Quiz(Long id) {
        super(id);
    }

    public Quiz(String title, User author, String description, int expectedDuration, String tags) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.expectedDuration = expectedDuration;
        this.tags = tags;
    }

    public Quiz(Long id, String title, User author, String description, int expectedDuration, String tags) {
        super(id);
        this.title = title;
        this.author = author;
        this.description = description;
        this.expectedDuration = expectedDuration;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getExpectedDuration() {
        return expectedDuration;
    }

    public void setExpectedDuration(int expectedDuration) {
        this.expectedDuration = expectedDuration;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Quiz quiz = (Quiz) o;
        return expectedDuration == quiz.expectedDuration && Objects.equals(title, quiz.title) && Objects.equals(author, quiz.author) && Objects.equals(description, quiz.description) && Objects.equals(questions, quiz.questions) && Objects.equals(pictureURL, quiz.pictureURL) && Objects.equals(tags, quiz.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, author, description, questions, expectedDuration, pictureURL, tags);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Quiz{");
        sb.append("id=").append(getId());
        sb.append(", created=").append(getCreated());
        sb.append(", modified=").append(getModified());
        sb.append(", title='").append(title).append('\'');
        sb.append(", author=").append(author);
        sb.append(", description='").append(description).append('\'');
        sb.append(", questions=").append(questions);
        sb.append(", expectedDuration=").append(expectedDuration);
        sb.append(", pictureURL='").append(pictureURL).append('\'');
        sb.append(", tags='").append(tags).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
