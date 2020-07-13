package com.kungyu.toolview;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * @author wengyongcheng
 * @since 2020/7/11 2:06 下午
 */
public class ConsoleViewAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        runExecutor(e.getProject());

    }

    public void runExecutor(Project project) {
        if (project == null) {
            return;
        }
        CustomExecutor executor = new CustomExecutor(project);
        // 设置restart和stop
        executor.withReturn(() -> runExecutor(project)).withStop(() -> ConfigUtil.setRunning(project,false), () ->
            ConfigUtil.getRunning(project));
        executor.run();
    }
}
