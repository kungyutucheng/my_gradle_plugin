package com.kungyu.dialog;

import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;

/**
 * @author wengyongcheng
 * @since 2020/3/1 10:30 下午
 */
public class MyToolWindow  {

    private JButton hideButton;

    private JButton dialogButton;

    private JPanel myToolWindowContent;

    public MyToolWindow(ToolWindow toolWindow) {

        init();

        hideButton.addActionListener(e -> toolWindow.hide(null));
    }

    private void init() {
        dialogButton = new JButton("触发自定义dialog");
        dialogButton.addActionListener(e -> {
            if (new CustomDialogWrapper().showAndGet()) {
                // 监听弹框消失，相当于show 和 getExitCode方法的结合
                System.out.println("show and get");
            }
        });

        hideButton = new JButton("取消");

        myToolWindowContent = new JPanel();
        myToolWindowContent.add(dialogButton);
        myToolWindowContent.add(hideButton);


    }

    public JPanel getContent() {
        return myToolWindowContent;
    }

}
