package gui;

import java.io.File;

public class FileFilter extends javax.swing.filechooser.FileFilter {
    @Override
    public boolean accept(File file) {
        String name = file.getName();

        String extension = Utils.getExtension(name);

        if (extension == null){
            return false;
        }
        if (extension.equals("lib")){
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "library Database Files (*lib)";
    }
}
