package pro.sky.generatingexamquestions.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.generatingexamquestions.Question;
import pro.sky.generatingexamquestions.exceptions.ExaminerServiceException;
import pro.sky.generatingexamquestions.utils.QuestionGenerator;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {
    @Mock
    QuestionService questionService;
    QuestionGenerator q = new QuestionGenerator();

    @InjectMocks
    ExaminerServiceImpl examinerService;


    @Test
    void getQuestionsTest_success() {
        Question question = new Question(q.CORRECT_QUESTION, q.CORRECT_ANSWER);
        Collection<Question> questions = new HashSet<>();
        questions.add(question);
        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandomQuestion()).thenReturn(question);
        Collection<Question> extended = new HashSet<>(List.of(question));
        Collection<Question> actual;
        actual = examinerService.getQuestions(1);
        Assertions.assertEquals(extended, actual);
    }

    @Test
    void getQuestionsTest_ExaminerServiceException_success() {
        Question question = new Question(q.CORRECT_QUESTION, q.CORRECT_ANSWER);
        Collection<Question> questions = new HashSet<>();
        questions.add(question);
        when(questionService.getAll()).thenReturn(questions);
        Exception exception = Assertions.assertThrows(ExaminerServiceException.class,
                () -> examinerService.getQuestions(2));
        String extendedMessage = "Превышение количества вопросов";
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(extendedMessage, actualMessage);
    }
}
