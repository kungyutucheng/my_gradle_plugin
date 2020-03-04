package com.kungyu.popup;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

/**
 * @author wengyongcheng
 * @since 2020/3/4 11:06 上午
 */
public class CustomFirstAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Messages.showMessageDialog("第一个action触发", "第一个action", Messages.getInformationIcon());
    }
}
