package com.kungyu.toolview;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

/**
 * @author wengyongcheng
 * @since 2020/7/11 2:06 下午
 */
public class ConsoleViewAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        CustomExecutor executor = new CustomExecutor(e.getProject());
        executor.run();
    }
}
