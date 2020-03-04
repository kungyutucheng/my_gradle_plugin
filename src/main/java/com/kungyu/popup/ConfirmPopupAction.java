package com.kungyu.popup;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.popup.*;
import org.jetbrains.annotations.NotNull;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author wengyongcheng
 * @since 2020/3/3 10:48 下午
 */
public class ConfirmPopupAction extends AnAction implements ListSelectionListener, JBPopupListener {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        // 确认类型popup，展示俩个选项，对应执行俩种操作，TODO 这里不知道为什么选中其中一个之后必定会先弹出no信息框
        ListPopup confirmation = JBPopupFactory.getInstance().createConfirmation("confirm", "yes", "no", () -> Messages.showMessageDialog("yes", "yes", Messages.getInformationIcon()), () -> Messages.showMessageDialog("no", "no", Messages.getInformationIcon()), 0);
        confirmation.showInBestPositionFor(e.getDataContext());

    }


    /**
     * 上下键选择事件，仅仅是改变，而不是按住回车之后的选择
     * @param e
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int firstIndex = e.getFirstIndex();
        int lastIndex = e.getLastIndex();
        boolean valueIsAdjusting = e.getValueIsAdjusting();
        System.out.println("firstIndex:" + firstIndex);
        System.out.println("lastIndex:" + lastIndex);
        System.out.println("valueIsAdjusting:" + valueIsAdjusting);

    }

    /**
     * popup 关闭监听
     * @param event
     */
    @Override
    public void onClosed(@NotNull LightweightWindowEvent event) {
        JBPopup jbPopup = event.asPopup();
        System.out.println("关闭popup");
        jbPopup.cancel();
    }
}
