package hiper.models;

import java.io.Serializable;
import java.util.List;

public class AllCollections implements Serializable {
    private List<User> users;
    private List<Quiz> quizzes;
    private List<Question> questions;
    private List<Answer> answers;
    private List<QuizResult> quizResults;

    public AllCollections() {
    }

    public AllCollections(List<User> users, List<Quiz> quizzes, List<Question> questions, List<Answer> answers, List<QuizResult> quizResults) {
        this.users = users;
        this.quizzes = quizzes;
        this.questions = questions;
        this.answers = answers;
        this.quizResults = quizResults;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<QuizResult> getQuizResults() {
        return quizResults;
    }

    public void setQuizResults(List<QuizResult> quizResults) {
        this.quizResults = quizResults;
    }
}
