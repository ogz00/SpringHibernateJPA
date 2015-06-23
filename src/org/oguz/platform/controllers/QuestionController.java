package org.oguz.platform.controllers;


import java.util.ArrayList;
import java.util.List;

import org.oguz.platform.business.model.IAnswer;
import org.oguz.platform.business.model.IQuestion;
import org.oguz.platform.business.model.impl.Answer;
import org.oguz.platform.business.model.impl.Question;
import org.oguz.platform.business.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QuestionController
{
	private List<Integer> orders = new ArrayList<Integer>();
	private IQuestionService questionService;

	@Autowired(required = true)
	@Qualifier("questionService")
	private void setQuestionService(IQuestionService questionService)
	{
		this.questionService = questionService;
	}

	@RequestMapping(value = "/questions", method = RequestMethod.GET)
	public String listQuestions(Model model)
	{

		model.addAttribute("question", new Question());
		model.addAttribute("listQuestions", this.questionService.listQuestions());
		for (int i = 0; i < 10; i++)
		{
			orders.add(i + 1);
		}
		model.addAttribute("listOrder", orders);
		return "question";

	}

	@RequestMapping(value = "/add/question", method = RequestMethod.POST)
	public String addQuestion(@ModelAttribute("question") Question q)
	{

		if (q.getIdQuestion() == 0)
		{
			this.questionService.addQuestion(q);
		}
		else
		{
			this.questionService.updateQuestion(q);
		}

		return "redirect:/questions";
	}

	@RequestMapping("/remove/question/{id}")
	public String removeQuestion(@PathVariable("id") int id)
	{
		this.questionService.removeQuestion(id);
		return "redirect:/questions";
	}

	@RequestMapping("/edit/question/{id}")
	public String editQuestion(@PathVariable("id") int id, Model model)
	{

		model.addAttribute("question", this.questionService.getQuestionById(id));
		model.addAttribute("listQuestions", this.questionService.listQuestions());
		model.addAttribute("listOrder", orders);

		return "question";
	}

	/*
	 * @RequestMapping("/questions/getQuestionWithAnswers/{id}") public String
	 * getQuestionsWithAnswer(@PathVariable("id") int questionId, Model model) {
	 * model.addAttribute("question", this.questionService.getQuestionById(questionId));
	 * model.addAttribute("listAnswerByQuestion",
	 * this.questionService.getAnswersByQuestion(questionId));
	 * 
	 * return "answerbyquestion"; }
	 */

	@RequestMapping("/questions/saveAnswer/{id}")
	public String saveAnswer(@PathVariable("id") int questionId, IAnswer answer, Model model)
	{
		model.addAttribute("answer", answer);
		// this.questionService.getQuestionById(questionId).getAnswers().add(answer);

		return "answerbyquestion";

	}



}
