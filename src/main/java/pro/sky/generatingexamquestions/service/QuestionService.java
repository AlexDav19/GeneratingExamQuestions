package pro.sky.generatingexamquestions.service;
import pro.sky.generatingexamquestions.Question;
import java.util.Collection;

public interface QuestionService {
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();
}