package hiper.models;

public class Answer extends AbstractEntity<Long, Answer> {
    private Question question;
    private String text;
    private String pictureURL; //optional
    private int score;

    public Answer() {
    }

    public Answer(Long id) {
        super(id);
    }

    public Answer(Question question, String text, int score) {
        this.question = question;
        this.text = text;
        this.score = score;
    }

    public Answer(Long id, Question question, String text, int score) {
        super(id);
        this.question = question;
        this.text = text;
        this.score = score;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Answer{");
        sb.append("id=").append(getId());
        sb.append(", created=").append(getCreated());
        sb.append(", modified=").append(getModified());
        sb.append(", question=").append(question);
        sb.append(", text='").append(text).append('\'');
        sb.append(", pictureURL='").append(pictureURL).append('\'');
        sb.append(", score=").append(score);
        sb.append('}');
        return sb.toString();
    }
}
