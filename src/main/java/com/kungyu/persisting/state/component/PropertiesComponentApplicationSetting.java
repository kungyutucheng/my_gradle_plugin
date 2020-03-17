package com.kungyu.persisting.state.component;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author wengyongcheng
 * @since 2020/3/17 9:22 上午
 * application 级别的properties Component
 */
public class PropertiesComponentApplicationSetting implements Configurable {
    private JTextField textField;
    private JPanel mainPanel;

    private static final String APPLICATION_KEY = "applicationKey";

    public PropertiesComponentApplicationSetting() {
        textField.setText(PropertiesComponent.getInstance().getValue(APPLICATION_KEY));
    }

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "Application Level Properties Component";
    }


    @Nullable
    @Override
    public JComponent createComponent() {
        return mainPanel;
    }

    @Override
    public boolean isModified() {
        return !StringUtils.equals(textField.getText(),PropertiesComponent.getInstance().getValue(APPLICATION_KEY));
    }

    @Override
    public void apply() throws ConfigurationException {
        PropertiesComponent.getInstance().setValue(APPLICATION_KEY, textField.getText());
    }
}
