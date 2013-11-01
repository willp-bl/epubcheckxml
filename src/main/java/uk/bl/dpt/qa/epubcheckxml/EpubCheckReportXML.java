package uk.bl.dpt.qa.epubcheckxml;

import java.util.ArrayList;
import java.util.List;

import com.adobe.epubcheck.api.Report;
import com.adobe.epubcheck.util.FeatureEnum;

/**
 * This is a skeleton implementation of Report that stores information as XML
 * @author wpalmer
 *
 */
public class EpubCheckReportXML implements Report {

	private List<String> warnings = new ArrayList<String>();
	private List<String> errors = new ArrayList<String>();
	private List<String> exceptions = new ArrayList<String>();
	
	/**
	 * Constructor for skeleton implementation
	 */
	public EpubCheckReportXML() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void warning(String resource, int line, int column, String message) {
		String warning = "";
		warning += "     <warning resource=\""+resource+"\" line=\""+line+"\" column=\""+column+"\">\n";
		warning += "          <message>"+message+"</message>\n";
		warning += "     </warning>";
		warnings.add(warning);
	}
	
	/**
	 * Get warnings
	 * @return warnings
	 */
	public List<String> getWarnings() {
		return warnings;
	}
	
	@Override
	public void error(String resource, int line, int column, String message) {
		String error = "";
		error += "     <error resource=\""+resource+"\" line=\""+line+"\" column=\""+column+"\">\n";
		error += "          <message>"+message+"</message>\n";
		error += "     </error>";		
		errors.add(error);
	}

	/**
	 * Get errors
	 * @return errors
	 */
	public List<String> getErrors() {
		return errors;
	}
	
	@Override
	public void exception(String resource, Exception ex) {
		String exception = "";
		exception += "     <exception resource=\""+resource+"\">\n";
		exception += "          <message>"+ex.getMessage()+"<message>\n";
		exception += "     </exception>";
		exceptions.add(exception);
	}

	/**
	 * Get exceptions
	 * @return exceptions
	 */
	public List<String> getExceptions() {
		return exceptions;
	}
	
	@Override
	public int getErrorCount() {
		return errors.size();
	}

	@Override
	public int getExceptionCount() {
		return exceptions.size();
	}

	@Override
	public int getWarningCount() {
		return warnings.size();
	}

	@Override
	public void hint(String resource, int line, int column, String message) {
		// no thanks
	}

	@Override
	public void info(String resource, FeatureEnum feature, String value) {
		// no thanks
	}


}
