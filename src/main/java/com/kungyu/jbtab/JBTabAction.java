package com.kungyu.jbtab;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

/**
 * @author wengyongcheng
 * @since 2020/3/8 3:41 下午
 */
public class JBTabAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        new JBTabDialogWrapper(e.getProject()).showAndGet();
    }
}
