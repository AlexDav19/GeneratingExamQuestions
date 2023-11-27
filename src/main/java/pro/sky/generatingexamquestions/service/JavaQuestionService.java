package pro.sky.generatingexamquestions.service;

import org.springframework.stereotype.Service;
import pro.sky.generatingexamquestions.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {


    private final Set<Question> questions = new HashSet<>();


    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        questions.add(q);
        return q;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int x = random.nextInt(questions.size());
        return (Question) questions.toArray()[x];
    }

}
