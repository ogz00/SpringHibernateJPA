package org.oguz.platform.business.dao;

import java.util.List;


import org.oguz.platform.business.model.impl.Exam;


public interface IExamDAO
{
	public void addExam(Exam e);

	public void updateExam(Exam e);

	public List<Exam> listExams();

	public Exam getExamById(int id);

	public int save(Exam exam);

	public void view(Exam exam);

	public void removeExam(int id);

}
