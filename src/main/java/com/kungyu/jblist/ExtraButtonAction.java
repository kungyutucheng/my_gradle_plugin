package com.kungyu.jblist;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.IconLoader;
import com.intellij.ui.AnActionButton;
import com.intellij.ui.components.JBList;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @author wengyongcheng
 * @since 2020/3/7 9:38 下午
 */
public class ExtraButtonAction extends AnActionButton {

    private JBList list;

    private DefaultListModel<Integer> model;

    public ExtraButtonAction(DefaultListModel<Integer> model,JBList list) {
        super("Extra", IconLoader.getIcon("/icons/edit.svg"));
        this.model = model;
        this.list = list;
    }


    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        int index = list.getSelectedIndex();
        String newValue = Messages.showInputDialog(model.get(index) + "", "Edit", Messages.getInformationIcon());
        if (StringUtils.isNotBlank(newValue)) {
            model.add(index, Integer.valueOf(newValue));
        }
    }
}
