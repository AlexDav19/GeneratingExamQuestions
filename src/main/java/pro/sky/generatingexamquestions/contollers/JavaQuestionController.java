package pro.sky.generatingexamquestions.contollers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.generatingexamquestions.Question;
import pro.sky.generatingexamquestions.service.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {
    JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(path = "/java/add") //добавить вопрос
    public String add(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        javaQuestionService.add(question, answer);
        return javaQuestionService.add(question, answer) + " добавлен";
    }

    @GetMapping(path = "/java/remove") //удалить вопрос
    public String remove(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        Question q = new Question(question, answer);
        javaQuestionService.remove(q);
        return q + " удален";
    }

    @GetMapping(path = "/java") //Показать список вопросов
    public Collection<Question> getQuestion() {
        return javaQuestionService.getAll();
    }

}
