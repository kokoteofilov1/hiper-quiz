package hiper.models;

import java.util.List;
import java.util.Objects;

public class User extends AbstractEntity<Long, User> {
    private String username;
    private String email;
    private String password;
    private Gender gender;
    private Role role;
    private String pictureURL; //optional
    private String description; //optional
    private String metadata; //optional
    private boolean status;
    private List<Quiz> quizzes;

    public User() {
    }

    public User(Long id) {
        super(id);
    }

    public User(String username, String email, String password, Gender gender, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.role = role;
        this.status = true;
    }

    public User(Long id, String username, String email, String password, Gender gender, Role role) {
        super(id);
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.role = role;
        this.status = true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return status == user.status && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && gender == user.gender && role == user.role && Objects.equals(pictureURL, user.pictureURL) && Objects.equals(description, user.description) && Objects.equals(metadata, user.metadata) && Objects.equals(quizzes, user.quizzes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), username, email, password, gender, role, pictureURL, description, metadata, status, quizzes);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(getId());
        sb.append(", created=").append(getCreated());
        sb.append(", modified=").append(getModified());
        sb.append(", username='").append(username).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", gender=").append(gender);
        sb.append(", role=").append(role);
        sb.append(", pictureURL='").append(pictureURL).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", metadata='").append(metadata).append('\'');
        sb.append(", status=").append(status);
        sb.append(", quizzes=").append(quizzes);
        sb.append('}');
        return sb.toString();
    }
}
