package org.oguz.platform.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.oguz.platform.business.model.impl.Answer;
import org.oguz.platform.business.model.impl.Exam;
import org.oguz.platform.business.model.impl.Question;
import org.oguz.platform.business.service.IAnswerService;
import org.oguz.platform.business.service.IExamService;
import org.oguz.platform.business.service.IQuestionService;
import org.oguz.platform.utils.ExamFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExamController
{

	private IExamService examService;

	private IAnswerService answerService;

	private IQuestionService questionService;


	@Autowired
	@Qualifier("answerService")
	public void setAnswerService(IAnswerService answerService)
	{
		this.answerService = answerService;
	}


	@Autowired
	@Qualifier("questionService")
	public void setQuestionService(IQuestionService questionService)
	{
		this.questionService = questionService;
	}

	@Autowired
	@Qualifier("examService")
	public void setExamService(IExamService examService)
	{
		this.examService = examService;
	}

	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}

	@Autowired
	private ExamFormValidator validator;

	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping("/viewAllExam")
	public ModelAndView getAllExam()
	{
		ModelAndView mav = new ModelAndView("showExam");
		List<Exam> exam = this.examService.listExams();
		mav.addObject("SEARCH_EXAM_RESULTS_KEY", exam);
		return mav;
	}
	
	@RequestMapping(value = "/viewQuestions", method = RequestMethod.GET)
	public ModelAndView newQuestionForm(@RequestParam("idExam") Integer idExam)
	{
		ModelAndView mav = new ModelAndView("showQuestions");
		//Exam exam = this.examService.getExamById(idExam);
		List<Question> questions = this.questionService.getQuestionsByExamId(idExam);
		mav.addObject("SEARCH_QUESTIONS_RESULT_KEY", questions);

		return mav;
	}

	@RequestMapping(value = "/saveExam", method = RequestMethod.GET)
	public ModelAndView newExamForm()
	{
		ModelAndView mav = new ModelAndView("newExam");
		Exam exam = new Exam();
		mav.getModelMap().put("newExam", exam);
		return mav;
	}

	@RequestMapping(value = "/saveExam", method = RequestMethod.POST)
	public String create(@ModelAttribute("newExam") Exam exam, BindingResult result,
		SessionStatus status)
	{
		validator.validate(exam, result);
		if (result.hasErrors())
		{
			return "newExam";
		}

		int examId = this.examService.save(exam);
		List<String> questions = exam.getQuestions();
		Question ques = null;
		if (questions != null)
		{
			for (String question : questions)
			{
				ques = new Question();
				ques.setQuestionText(question);
				ques.setExam(exam);
				int quesId = this.questionService.save(ques);
				List<String> answers = exam.getAnswers();
				List<Boolean> isTure = exam.getTrueAnswer();
				Answer answer = null;
				if (answers != null)
				{
					for (int i=0; i<answers.size();i++)
					{
						answer = new Answer();
						answer.setAnswerText(answers.get(i));
						answer.setQuestion(ques);
						answer.setSequenceNo(i);
						answer.setTrueAnswer(isTure.get(i));
						answer.setQuestion(ques);
						int ansId = this.answerService.save(answer);
						
					}
				}

			}
		}
		status.setComplete();
		return "redirect:viewAllExam.do";
	}

	@RequestMapping(value = "/updateExam", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("idExam") Integer idExam)
	{
		ModelAndView mav = new ModelAndView("editExam");
		Exam exam = this.examService.getExamById(idExam);
		mav.addObject("editExam", exam);
		return mav;
	}

	@RequestMapping(value = "/updateExam", method = RequestMethod.POST)
	public String update(@ModelAttribute("editExam") Exam exam, BindingResult result,
		SessionStatus status)
	{
		validator.validate(exam, result);
		if (result.hasErrors())
		{
			return "editExam";
		}
		this.examService.updateExam(exam);
		status.setComplete();
		return "redirect:viewAllExam.do";
	}

	@RequestMapping(value = "/viewExam", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam("idExam") Integer idExam)
	{
		ModelAndView mav = new ModelAndView("viewExam");
		Exam exam = this.examService.getExamById(idExam);
		mav.addObject("viewExam", exam);
		return mav;
	}

}
