/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package org.opengroup.archimate.xmlexchange;

/**
 * XML Exception
 * 
 * @author Phillip Beauvoir
 */
public class XMLModelParserException extends Exception {

	public XMLModelParserException() {
		super("Error occurred in XML Model Parsing."); //$NON-NLS-1$
	}

	public XMLModelParserException(String message)  {
		super(message);
	}

	public XMLModelParserException(String message, Throwable cause)  {
		super(message, cause);    
	}    

}
