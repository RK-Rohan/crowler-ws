package it.stasbranger.crowlerws.ws.bo;

import it.stasbranger.crowlerws.ws.mvc.SearchModel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SearchValidatorBO implements Validator{

	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    public boolean supports(Class clazz) {
        return SearchModel.class.equals(clazz);
    }

	public void validate(Object obj, Errors errors) {
		SearchModel im = (SearchModel) obj;
		 if (im == null) {
			 errors.rejectValue("cosa", "error.not-specified", null, "Value required.");
		 } else {
			 logger.info("Validating with " + im + ": " + im.getCosa());
		 }	 
	 }

}
