/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.xmlexchange;

import java.io.File;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.jdom2.JDOMException;

import com.archimatetool.editor.model.IEditorModelManager;
import com.archimatetool.editor.model.IModelImporter;
import com.archimatetool.model.IArchimateModel;



/**
 * Import Open Exchange XML Format to Archi Model
 * 
 * @author Phillip Beauvoir
 */
public class XMLExchangeImportProvider implements IModelImporter, IXMLExchangeGlobals {
    
    @Override
    public void doImport() throws IOException {
        File file = askOpenFile();
        if(file == null) {
            return;
        }

        // Create a model
        IArchimateModel model = null;
        
        try {
            XMLModelImporter xmlModelImporter = new XMLModelImporter();
            model = xmlModelImporter.createArchiMateModel(file);
        }
        catch(JDOMException ex) {
            ex.printStackTrace();
            throw new IOException(ex);
        }

        // And open the Model in the Editor
        if(model != null) {
            IEditorModelManager.INSTANCE.openModel(model);
        }
    }
    
    private File askOpenFile() {
        FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.OPEN);
        dialog.setFilterExtensions(new String[] { FILE_EXTENSION_WILDCARD, "*.*" } ); //$NON-NLS-1$
        String path = dialog.open();
        return path != null ? new File(path) : null;
    }
}
