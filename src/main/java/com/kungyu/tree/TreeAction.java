package com.kungyu.tree;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

/**
 * @author wengyongcheng
 * @since 2020/3/7 10:21 下午
 */
public class TreeAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        new TreeDialogWrapper().showAndGet();
    }
}
