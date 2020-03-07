package com.kungyu.file.chooser;

import com.intellij.ide.util.AbstractTreeClassChooserDialog;
import com.intellij.ide.util.BrowseFilesListener;
import com.intellij.ide.util.TreeFileChooserFactory;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.ui.*;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.apache.commons.collections.CollectionUtils;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @author wengyongcheng
 * @since 2020/3/6 11:55 下午
 */
public class FileChooserDialogWrapper extends DialogWrapper {

    private TextFieldWithBrowseButton textFieldWithBrowseButton;

    private JTextField fileTextFiled;

    public FileChooserDialogWrapper(){
        super(true);
        init();
        setTitle("文件选择对话框");
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {

        JPanel panel = new JPanel();
        textFieldWithBrowseButton = new TextFieldWithBrowseButton();
        fileTextFiled = new JTextField();
        FileChooserDescriptor chooserDescriptor = new FileChooserDescriptor(true,true,true,true,true,true);
        TextBrowseFolderListener listener = new TextBrowseFolderListener(chooserDescriptor);
        textFieldWithBrowseButton.addBrowseFolderListener(listener);
        textFieldWithBrowseButton.setText(File.separator + "Users" + File.separator + "wengyongcheng" + File.separator + "swagger-html" + File.separator);
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(400,40));
        panel.add(textFieldWithBrowseButton, BorderLayout.CENTER);


        return panel;
    }

    @Nullable
    @Override
    protected ValidationInfo doValidate() {
        String filePath = textFieldWithBrowseButton.getText();
        VirtualFile virtualFile = LocalFileSystem.getInstance().findFileByPath(filePath);
        if (virtualFile != null) {
            Messages.showMessageDialog(virtualFile.getPath(), virtualFile.getName(), Messages.getInformationIcon());
        }
        return null;
    }
}
