package hiper.models;

import java.util.List;

public class Administrator extends User {
    private List<Quiz> quizzesBlocked;

    public Administrator() {
    }

    public Administrator(Long id) {
        super(id);
    }

    public Administrator(String username, String email, String password, Gender gender, Role role) {
        super(username, email, password, gender, role);
    }

    public Administrator(Long id, String username, String email, String password, Gender gender, Role role) {
        super(id, username, email, password, gender, role);
    }

    public List<Quiz> getQuizzesBlocked() {
        return quizzesBlocked;
    }

    public void setQuizzesBlocked(List<Quiz> quizzesBlocked) {
        this.quizzesBlocked = quizzesBlocked;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Administrator{");
        sb.append("id=").append(getId());
        sb.append(", created=").append(getCreated());
        sb.append(", modified=").append(getModified());
        sb.append(", quizzesBlocked=").append(quizzesBlocked);
        sb.append(", username='").append(getUsername()).append('\'');
        sb.append(", email='").append(getEmail()).append('\'');
        sb.append(", gender=").append(getGender());
        sb.append(", role=").append(getRole());
        sb.append(", pictureURL='").append(getPictureURL()).append('\'');
        sb.append(", description='").append(getDescription()).append('\'');
        sb.append(", metadata='").append(getMetadata()).append('\'');
        sb.append(", status=").append(isStatus());
        sb.append(", quizzes=").append(getQuizzes());
        sb.append('}');
        return sb.toString();
    }
}
