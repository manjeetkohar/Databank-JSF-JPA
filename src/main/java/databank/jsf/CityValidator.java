package databank.jsf;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("cityValidator")
public class CityValidator implements Validator<String> {
	
	private static final Pattern CITY_PATTERN = Pattern.compile("^[a-zA-Z]+(?:(?:\\\\s+|-)[a-zA-Z]+)*$");
	@Override
	public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
		if(value==null) {
			FacesMessage msg = new FacesMessage("City is not empty","Invalid Format");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
		if (!CITY_PATTERN.matcher(value).matches()) {
			FacesMessage msg = new FacesMessage("Incorrect City", "Invalid Format");
			throw new ValidatorException(msg);
		}
		
	}

}
