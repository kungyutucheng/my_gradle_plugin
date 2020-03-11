package com.kungyu.run.configuration.multi.factory;

import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * @author wengyongcheng
 * @since 2020/3/11 3:43 下午
 */
public class SecondSettingsEditor extends SettingsEditor<SecondConfiguration> {

    private JPanel panel;
    private JLabel label;

    @Override
    protected void resetEditorFrom(@NotNull SecondConfiguration s) {

    }

    @Override
    protected void applyEditorTo(@NotNull SecondConfiguration s) throws ConfigurationException {

    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        label = new JLabel("Second Label");
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }
}
