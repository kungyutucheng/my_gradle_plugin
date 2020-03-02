package com.kungyu.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.pom.Navigatable;
import com.intellij.util.messages.impl.Message;
import org.jetbrains.annotations.NotNull;

/**
 * @author wengyongcheng
 * @since 2020/2/28 9:18 上午
 */
public class PopupDialogAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        // 获取当前工程
        Project project = e.getProject();
        // e.getPresentation() 获取当前组建
        StringBuffer dialogMsg = new StringBuffer(e.getPresentation().getText() + " selected");
        String dialogTitle = e.getPresentation().getDescription();
        // 获取当前选中对象
        Navigatable nav = e.getData(CommonDataKeys.NAVIGATABLE);
        if (nav != null) {
            // 选中对象文件名或者目录名称，此处为全路径
            dialogMsg.append(String.format("\nSelected elements:%s", nav.toString()));
        }
        Messages.showMessageDialog(project, dialogMsg.toString(), dialogTitle.toString(), Messages.getInformationIcon());

    }

    @Override
    public void update(@NotNull AnActionEvent e) {

    }
}
