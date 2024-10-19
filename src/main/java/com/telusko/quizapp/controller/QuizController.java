package com.telusko.quizapp.controller;
import com.telusko.quizapp.model.QuestionWrapper;
import com.telusko.quizapp.model.Response;
import com.telusko.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;


    @PostMapping("create")
    public ResponseEntity<String>  createQuiz(@RequestParam String category,@RequestParam int noOfQuestion,@RequestParam String title){
//        return new ResponseEntity<>("i am here",HttpStatus.OK);
        return quizService.createQuiz(category,noOfQuestion,title);
    }

//    http://localhost:8080/quiz/create?category=Java&noOfQuestion=5&title=JQuiz
    @GetMapping("get/{quizId}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable int quizId){
        return quizService.getQuizQusetion(quizId);
    }

//    http://localhost:8080/quiz/submit/2
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.caluculateMarks(id,responses);
    }


}
