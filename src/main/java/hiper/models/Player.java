package hiper.models;

import java.util.List;

public class Player extends User {
    private List<QuizResult> results;
    private long overallScore;

    public Player() {
    }

    public Player(Long id) {
        super(id);
    }

    public Player(String username, String email, String password, Gender gender, Role role) {
        super(username, email, password, gender, role);
    }

    public Player(Long id, String username, String email, String password, Gender gender, Role role, boolean status, List<Quiz> quizzes, List<QuizResult> results, long overallScore) {
        super(id, username, email, password, gender, role);
        this.results = results;
        this.overallScore = overallScore;
    }

    public List<QuizResult> getResults() {
        return results;
    }

    public void setResults(List<QuizResult> results) {
        this.results = results;
    }

    public long getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(long overallScore) {
        this.overallScore = overallScore;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Player{");
        sb.append("id=").append(getId());
        sb.append(", created=").append(getCreated());
        sb.append(", modified=").append(getModified());
        sb.append(", results=").append(results);
        sb.append(", overallScore=").append(overallScore);
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
