package com.kungyu.popup;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

/**
 * @author wengyongcheng
 * @since 2020/3/4 5:28 下午
 */
public class SubAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Messages.showMessageDialog("nest", "nest", Messages.getInformationIcon());

    }
}
