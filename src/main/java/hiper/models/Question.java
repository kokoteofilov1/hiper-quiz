package hiper.models;

import java.util.List;

public class Question extends AbstractEntity<Long, Question> {
    private Quiz quiz;
    private String text;
    private String pictureURl; //optional
    private List<Answer> answers;

    public Question() {
    }

    public Question(Long id) {
        super(id);
    }

    public Question(Quiz quiz, String text, List<Answer> answers) {
        this.quiz = quiz;
        this.text = text;
        this.answers = answers;
    }

    public Question(Long id, Quiz quiz, String text, List<Answer> answers) {
        super(id);
        this.quiz = quiz;
        this.text = text;
        this.answers = answers;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPictureURl() {
        return pictureURl;
    }

    public void setPictureURl(String pictureURl) {
        this.pictureURl = pictureURl;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Question{");
        sb.append("id=").append(getId());
        sb.append(", created=").append(getCreated());
        sb.append(", modified=").append(getModified());
        sb.append(", quiz='").append(quiz).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append(", pictureURl='").append(pictureURl).append('\'');
        sb.append(", answers=").append(answers);
        sb.append('}');
        return sb.toString();
    }
}
