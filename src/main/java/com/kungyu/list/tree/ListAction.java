package com.kungyu.list.tree;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.apache.commons.collections.CollectionUtils;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * @author wengyongcheng
 * @since 2020/3/5 11:23 下午
 */
public class ListAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        new ListDialogWrapper().showAndGet();
    }
}
