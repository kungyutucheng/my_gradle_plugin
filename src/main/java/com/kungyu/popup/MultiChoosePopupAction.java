package com.kungyu.popup;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.ui.popup.*;
import org.jetbrains.annotations.NotNull;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wengyongcheng
 * @since 2020/3/3 10:48 下午
 */
public class MultiChoosePopupAction extends AnAction implements ListSelectionListener, JBPopupListener {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        // 可以多选，如果传入的list是action，选中不会触发对应的actionPerformed方法
        IPopupChooserBuilder<String> popupChooserBuilder = JBPopupFactory.getInstance().createPopupChooserBuilder(Stream.of("value1","value2").collect(Collectors.toList()));
        JBPopup popup = popupChooserBuilder.createPopup();
        popup.showInBestPositionFor(e.getDataContext());

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
