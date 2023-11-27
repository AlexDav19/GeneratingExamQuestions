package pro.sky.generatingexamquestions.service;

import org.springframework.stereotype.Service;
import pro.sky.generatingexamquestions.Question;
import pro.sky.generatingexamquestions.exceptions.ExaminerServiceException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> getQuestions = new HashSet<>();
        if (amount > questionService.getAll().size()) {
            throw new ExaminerServiceException("Превышение количества вопросов");
        }
        while (getQuestions.size() < amount) {
            getQuestions.add(questionService.getRandomQuestion());
        }
        return getQuestions;
    }
}
