package com.kungyu.run.configuration.multi.factory;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * @author wengyongcheng
 * @since 2020/3/11 3:43 下午
 */
public class FirstSettingsEditor extends SettingsEditor<FirstConfiguration> {

    private JPanel panel;
    private JLabel label;

    @Override
    protected void resetEditorFrom(@NotNull FirstConfiguration s) {

    }

    @Override
    protected void applyEditorTo(@NotNull FirstConfiguration s) throws ConfigurationException {

    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        label = new JLabel("First Label");
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }
}
