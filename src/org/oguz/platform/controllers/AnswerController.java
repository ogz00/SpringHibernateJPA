package org.oguz.platform.controllers;

import java.util.ArrayList;
import java.util.List;

import org.oguz.platform.business.model.IAnswer;
import org.oguz.platform.business.model.impl.Answer;
import org.oguz.platform.business.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AnswerController
{
	private List<Integer> listSeq = new ArrayList<Integer>();


	private IAnswerService answerService;

	@Autowired
	@Qualifier("answerService")
	public void setAnswerService(IAnswerService answerService)
	{
		this.answerService = answerService;
	}

	@RequestMapping(value = "/answers", method = RequestMethod.GET)
	public String listAnswers(Model model)
	{

		model.addAttribute("answer", new Answer());
		model.addAttribute("listAnswers", this.answerService.listAnswers());
		for (int i = 0; i < 4; i++)
		{
			listSeq.add(i + 1);
		}
		model.addAttribute("listSeq", listSeq);
		return "answer";

	}

	@RequestMapping(value = "/add/answer", method = RequestMethod.POST)
	public String addAnswer(@ModelAttribute("answer") Answer a)
	{

		if (a.getIdAnswer() == 0)
		{
			this.answerService.addAnswer(a);
		}
		else
		{
			this.answerService.updateAnswer(a);
		}

		return "redirect:/answers";
	}


	@RequestMapping("/edit/answer/{id}")
	public String editAnswer(@PathVariable("id") int id, Model model)
	{

		model.addAttribute("answer", this.answerService.getAnswerById(id));
		model.addAttribute("listAnswers", this.answerService.listAnswers());
		model.addAttribute("listSeq", listSeq);

		return "answer";
	}


}
