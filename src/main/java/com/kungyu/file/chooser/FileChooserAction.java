package com.kungyu.file.chooser;

import com.intellij.ide.util.TreeFileChooser;
import com.intellij.ide.util.TreeFileChooserFactory;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.Consumer;
import gherkin.lexer.Fi;
import org.apache.commons.collections.CollectionUtils;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.List;

/**
 * @author wengyongcheng
 * @since 2020/3/5 11:23 下午
 */
public class FileChooserAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        // 方式1，直接使用 FileChooser.chooseFile
        FileChooserDescriptor chooserDescriptor = new FileChooserDescriptor(true,true,true,true,true,true);
//        VirtualFile virtualFile = FileChooser.chooseFile(chooserDescriptor, e.getProject(), null);
//
//        if(virtualFile != null) {
//            Messages.showMessageDialog(virtualFile.getName(), "获取到的文件名称", Messages.getInformationIcon());
//        } else {
//            Messages.showMessageDialog("文件名称为空", "文件名称为空", Messages.getInformationIcon());
//        }


        // 方式二，直接使用FileChooser.chooseFiles
        VirtualFile toSelect = LocalFileSystem.getInstance().findFileByPath(File.separator + "Users" + File.separator + "wengyongcheng" + File.separator + "swagger-html" + File.separator);
        FileChooser.chooseFiles(chooserDescriptor, null, toSelect, virtualFiles -> {
            if (CollectionUtils.isNotEmpty(virtualFiles)) {
                for (VirtualFile file : virtualFiles) {
                    Messages.showMessageDialog(file.getPath(), file.getName(), Messages.getInformationIcon());
                }
            }
        });

        // 方式三，自定义文件选择窗口视图
//         new FileChooserDialogWrapper().showAndGet();


        // 方式四 树形文件选择器
//        TreeFileChooserFactory instance = TreeFileChooserFactory.getInstance(e.getProject());
//        TreeFileChooser.PsiFileFilter fileFilter = file -> file.getName().endsWith(".java");
//        TreeFileChooser javaFileChooser = instance.createFileChooser("java文件选择器", null, null, fileFilter);
//        javaFileChooser.showDialog();
//        PsiFile selectedFile = javaFileChooser.getSelectedFile();
//        if (selectedFile != null) {
//            Messages.showMessageDialog(selectedFile.getVirtualFile().getPath(), selectedFile.getVirtualFile().getName(), Messages.getInformationIcon());
//        }

    }
}
