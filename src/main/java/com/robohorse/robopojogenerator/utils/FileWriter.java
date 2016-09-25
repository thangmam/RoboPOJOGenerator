package com.robohorse.robopojogenerator.utils;

import com.intellij.psi.PsiDirectory;
import com.robohorse.robopojogenerator.errors.FileWriteException;
import com.robohorse.robopojogenerator.errors.RoboPluginException;
import com.robohorse.robopojogenerator.generator.ClassItem;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by vadim on 25.09.16.
 */
public class FileWriter {

    public void writeFile(PsiDirectory directory, ClassItem classItem) throws RoboPluginException {
        final String path = directory.getVirtualFile().getPath();
        final File file = new File(path + File.separator + classItem.getClassName() + ".java");
        try {
            file.createNewFile();
            FileUtils.writeStringToFile(file, classItem.toString());
        } catch (IOException e) {
            throw new FileWriteException(e.getMessage());
        }
    }
}
