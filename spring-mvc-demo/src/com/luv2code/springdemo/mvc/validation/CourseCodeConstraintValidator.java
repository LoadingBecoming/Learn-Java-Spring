package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{
	
	private String[] coursePrefixs;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefixs = theCourseCode.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		
		boolean result = false;  
		if(theCode != null)
		{
			//
            // loop thru course prefixes
            //
            // check to see if code matches any of the course prefixes
            //
			for(String coursePrefix: coursePrefixs) {
				result = theCode.startsWith(coursePrefix);
				
				// if we found a match then break out of the loop
				if (result) {
                    break;
                }
			}
		}
		else {
			result = true;
		}
		return result;
	}

	

}
