package pro.sky.generatingexamquestions.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.generatingexamquestions.Question;
import pro.sky.generatingexamquestions.utils.QuestionGenerator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class JavaQuestionServiceTest {
    QuestionGenerator q = new QuestionGenerator();
    public JavaQuestionService javaQuestionService = new JavaQuestionService();


    @Test
    void addWithParamTest_success() {
        Question expected = new Question(q.CORRECT_QUESTION, q.CORRECT_ANSWER);
        Question actual = javaQuestionService.add(q.CORRECT_QUESTION, q.CORRECT_ANSWER);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addWithObjectTest_success() {
        Question expected = new Question(q.CORRECT_QUESTION, q.CORRECT_ANSWER);
        Question actual = javaQuestionService.add(expected);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void remove_success() {
        Question expected = new Question(q.CORRECT_QUESTION, q.CORRECT_ANSWER);
        Question actual = javaQuestionService.remove(expected);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAll_success() {
        Question question = new Question(q.CORRECT_QUESTION, q.CORRECT_ANSWER);
        Collection<Question> expected = new HashSet<>();
        expected.add(question);
        javaQuestionService.add(question);
        Collection<Question> actual = javaQuestionService.getAll();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getRandomQuestionTest_success() {
        Question expected = new Question(q.CORRECT_QUESTION, q.CORRECT_ANSWER);
        javaQuestionService.add(expected);
        Question actual = javaQuestionService.getRandomQuestion();
        Assertions.assertEquals(expected, actual);
    }

    @Test //Проверка, что добавляются разные вопросы.
        // Есть крошечный шанс, что все 10 раз вернется один и тот же вопрос
    void getRandomQuestionTest_quantityQuestions() {
        Question question1 = new Question(q.CORRECT_QUESTION, q.CORRECT_ANSWER);
        Question question2 = new Question("Сколько запретных заклинаний существует", "3");
        Set<Question> questions = new HashSet<>();
        questions.add(question1);
        questions.add(question2);
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);
        Set<Question> actual = new HashSet<>();
        for (int i = 0; i <10; i++) {
            actual.add(javaQuestionService.getRandomQuestion());
        }
        Assertions.assertEquals(2, actual.size());
    }
}
