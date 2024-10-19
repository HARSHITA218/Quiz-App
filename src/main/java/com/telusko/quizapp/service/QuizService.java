package com.telusko.quizapp.service;

import com.telusko.quizapp.dao.QuestionDao;
import com.telusko.quizapp.dao.QuizDao;
import com.telusko.quizapp.model.Question;
import com.telusko.quizapp.model.QuestionWrapper;
import com.telusko.quizapp.model.Quiz;
import com.telusko.quizapp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuestionDao questionDao;

    @Autowired
    QuizDao quizDao;

    public ResponseEntity<String> createQuiz(String category, int noOfQuestion, String title) {

        List<Question> question = questionDao.findRandomQuestionByCategory(category,noOfQuestion);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(question);
        quizDao.save(quiz);

        return new ResponseEntity<>("SUCCESS",HttpStatus.OK);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQusetion(int quizId) {
        Optional<Quiz> quiz = quizDao.findById(quizId);
        List<Question> questionFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for(Question q:questionFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionForUser.add(qw);
        }
        
        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> caluculateMarks(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int i = 0;
        int rightans = 0;
        for(Response response:responses){
            if (response.getResponse().equals(questions.get(i).getRightanswer()))
                rightans++;
            i++;
        }
        return new ResponseEntity<>(rightans,HttpStatus.OK);
    }
}
