package com.kungyu.dialog;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.ValidationInfo;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author wengyongcheng
 * @since 2020/3/2 10:36 下午
 */
public class CustomDialogWrapper extends DialogWrapper {

    private JTextField inputTextField;

    private CustomOKAction okAction;
    private DialogWrapperExitAction exitAction;

    public CustomDialogWrapper() {
        super(true);
        init();
        setTitle("自定义dialog");
    }


    /**
     * 创建视图
     * @return
     */
    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel("这就是自定义dialog");
        label.setPreferredSize(new Dimension(100,100));
        panel.add(label,BorderLayout.CENTER);
        inputTextField = new JTextField();
        panel.add(inputTextField, BorderLayout.NORTH);
        return panel;

    }

    /**
     * 校验数据
     * @return 通过必须返回null，不通过返回一个 ValidationInfo 信息
     */
    @Nullable
    @Override
    protected ValidationInfo doValidate() {
        String text = inputTextField.getText();
        if(StringUtils.isNotBlank(text)) {
            return null;
        } else {
            return new ValidationInfo("校验不通过");
        }
    }

    /**
     * 覆盖默认的ok/cancel按钮
     * @return
     */
    @NotNull
    @Override
    protected Action[] createActions() {
        exitAction = new DialogWrapperExitAction("自定义cancel按钮", CANCEL_EXIT_CODE);
        okAction = new CustomOKAction();
        // 设置默认的焦点按钮
        okAction.putValue(DialogWrapper.DEFAULT_ACTION, true);
        return new Action[]{okAction,exitAction};
    }

    /**
     * 自定义 ok Action
     */
    protected class CustomOKAction extends DialogWrapperAction {

        protected CustomOKAction() {
            super("自定义ok按钮");
        }

        @Override
        protected void doAction(ActionEvent e) {
            // 点击ok的时候进行数据校验
            ValidationInfo validationInfo = doValidate();
            if (validationInfo != null) {
                Messages.showMessageDialog(validationInfo.message,"校验不通过", Messages.getInformationIcon());
            } else {
                close(CANCEL_EXIT_CODE);
            }
        }
    }
}
