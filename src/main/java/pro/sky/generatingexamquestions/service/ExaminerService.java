package pro.sky.generatingexamquestions.service;

import pro.sky.generatingexamquestions.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
