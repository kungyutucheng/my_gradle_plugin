package com.kungyu.dialog;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.ValidationInfo;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * @author wengyongcheng
 * @since 2020/3/2 10:36 下午
 */
public class CustomerDialogWrapper extends DialogWrapper {

    private JTextField inputTextField = new JTextField();

    public CustomerDialogWrapper() {
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
        System.out.println(text);
        if(StringUtils.isNotBlank(text)) {
            return null;
        } else {
            ValidationInfo validationInfo = new ValidationInfo("校验不通过");
            return validationInfo;
        }
    }

    /**
     * 覆盖默认的ok/cancel按钮
     * @return
     */
    @NotNull
    @Override
    protected Action[] createActions() {
        DialogWrapperExitAction exitAction = new DialogWrapperExitAction("自定义cancel按钮", 1);
        CustomerOkAction customerOkAction = new CustomerOkAction();
        // 设置默认的焦点按钮
        customerOkAction.putValue(DialogWrapper.DEFAULT_ACTION, true);
        return new Action[]{customerOkAction,exitAction};
    }
}
