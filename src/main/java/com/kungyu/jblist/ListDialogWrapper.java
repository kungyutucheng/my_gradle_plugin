package com.kungyu.jblist;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.ValidationInfo;
import com.intellij.ui.ColoredListCellRenderer;
import com.intellij.ui.ListSpeedSearch;
import com.intellij.ui.ToolbarDecorator;
import com.intellij.ui.components.JBList;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * @author wengyongcheng
 * @since 2020/3/6 11:55 下午
 */
public class ListDialogWrapper extends DialogWrapper {

    private JBList<Integer> list;

    private DefaultListModel<Integer> defaultListModel;

    public ListDialogWrapper(){
        super(true);
        init();
        setTitle("JBList");
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {

        defaultListModel = new DefaultListModel<>();
        for (int i = 0;i < 10; i++) {
            defaultListModel.addElement(i);
        }
        list = new JBList<>(defaultListModel);

        // 修饰每一行的元素
        ColoredListCellRenderer<Integer> coloredListCellRenderer = new ColoredListCellRenderer<Integer>() {
            @Override
            protected void customizeCellRenderer(@NotNull JList<? extends Integer> list, Integer value, int index, boolean selected, boolean hasFocus) {
                append(value + "-suffix");
            }
        };
        list.setCellRenderer(coloredListCellRenderer);

        // 触发快速查找
        new ListSpeedSearch<>(list);

        // 增加工具栏（新增按钮、删除按钮、上移按钮、下移按钮）
        ToolbarDecorator decorator = ToolbarDecorator.createDecorator(list);
        // 新增元素动作
        decorator.setAddAction(actionButton -> addAction());
        // 自定义按钮
        decorator.addExtraAction(new ExtraButtonAction(defaultListModel,list));

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(decorator.createPanel(), BorderLayout.CENTER);
        return panel;
    }

    private void addAction() {
        String newItem = Messages.showInputDialog("Input A Item", "Add", Messages.getInformationIcon());
        if (StringUtils.isNotBlank(newItem)) {
            defaultListModel.addElement(Integer.valueOf(newItem));
        }
    }


    @Nullable
    @Override
    protected ValidationInfo doValidate() {
        Integer value = list.getSelectedValue();
        if (value != null) {
            Messages.showMessageDialog(value + "",value + "", Messages.getInformationIcon());
        }
        return null;
    }
}
