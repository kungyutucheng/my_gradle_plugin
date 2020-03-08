package com.kungyu.jbsplitter;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

/**
 * @author wengyongcheng
 * @since 2020/3/8 2:39 下午
 */
public class JBSplitterAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        new JBSplitterDialogWrapper().showAndGet();
    }
}
