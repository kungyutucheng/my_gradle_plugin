package com.kungyu.dialog;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

/**
 * @author wengyongcheng
 * @since 2020/3/2 11:01 下午
 */
public class CustomerOkAction extends AbstractAction {

    public CustomerOkAction() {
        super("自定义OK按钮");
    }


    @Override
    public Object getValue(String key) {
        return super.getValue(key);
    }

    @Override
    public void putValue(String key, Object value) {
        super.putValue(key,value);
    }

    @Override
    public void setEnabled(boolean b) {
        super.setEnabled(b);
    }

    @Override
    public boolean isEnabled() {
        return super.isEnabled();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
