package com.kungyu.toolwindow;

import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wengyongcheng
 * @since 2020/3/1 10:30 下午
 */
public class MyToolWindow  {

    private JButton hideButton;

    private JLabel datetimeLabel;

    private JPanel myToolWindowContent;

    public MyToolWindow(ToolWindow toolWindow) {

        init();

        hideButton.addActionListener(e -> toolWindow.hide(null));
    }

    private void init() {
        datetimeLabel = new JLabel();
        datetimeLabel.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        hideButton = new JButton("取消");

        myToolWindowContent = new JPanel();
        myToolWindowContent.add(datetimeLabel);
        myToolWindowContent.add(hideButton);


    }

    public JPanel getContent() {
        return myToolWindowContent;
    }

}
