package org.oguz.platform.utils;

import org.oguz.platform.business.model.impl.Exam;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component("surveyFormValidator")
public class ExamFormValidator implements Validator
{
	private static final String START_DATE = null;

	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class clazz)
	{
		return Exam.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object model, Errors errors)
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.name",
			"Exam name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "StartDate", "required.StartDate",
			"Start Date is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "EndDate", "required.EndDate",
			"End Date is required.");
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "QUESTION","required.QUESTION",
// "can not be blank.");

		/* ValidationUtils.rejectIfEmpty(errors, "START_DATE","required.SURVEY_NAME", "Enter date"); */
	}

}
