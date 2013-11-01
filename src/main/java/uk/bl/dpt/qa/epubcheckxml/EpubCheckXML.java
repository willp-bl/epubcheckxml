package uk.bl.dpt.qa.epubcheckxml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.adobe.epubcheck.api.EpubCheck;

/**
 * Wrapper for EpubCheck library
 * @author wpalmer
 *
 */
public class EpubCheckXML {

	private EpubCheckXML() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param pFile file to check
	 * @return true/false if epubcheck considers file valid
	 */
	public static boolean runEpubCheck(File pFile) {
		boolean ret = false;
		
		EpubCheckReportXML report = new EpubCheckReportXML();
		
		EpubCheck epubcheck = new EpubCheck(pFile, report);
		
		boolean valid = epubcheck.validate();
		
		saveXMLReport(pFile, valid, report, pFile+".epubcheck.xml");
		
		return ret;
	}
	
	private static void saveXMLReport(File pFile, boolean valid, EpubCheckReportXML report, String outputFile) {
		
		try {
			PrintWriter out = new PrintWriter(new FileWriter(outputFile));
			
			out.println("<epubcheck>");

			out.println("     <file>"+pFile+"</file>");
			out.println("     <valid>"+valid+"</valid>");
			
			for(String s:report.getWarnings()) {
				out.println(s);
			}
			
			for(String s:report.getErrors()) {
				out.println(s);
			}
			
			for(String s:report.getExceptions()) {
				out.println(s);
			}
			
			out.println("</epubcheck>");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Main method
	 * @param args arguments
	 */
	public static void main(String[] args) {
		
		for(String file:args) {
			File f = new File(file);
			if(f.exists()) {
				runEpubCheck(f);
			}
		}
	}
	
	
}
