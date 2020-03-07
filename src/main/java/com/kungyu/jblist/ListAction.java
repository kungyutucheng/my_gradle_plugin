package com.kungyu.jblist;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

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
