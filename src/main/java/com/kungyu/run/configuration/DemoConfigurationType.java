package com.kungyu.run.configuration;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.icons.AllIcons;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @author wengyongcheng
 * @since 2020/3/10 4:59 下午
 */
public class DemoConfigurationType implements ConfigurationType {
    @NotNull
    @Override
    public String getDisplayName() {
        return "DemoRunConfiguration";
    }

    @Nls
    @Override
    public String getConfigurationTypeDescription() {
        return "Demo Run Configuration Desc";
    }

    @Override
    public Icon getIcon() {
        return AllIcons.General.Information;
    }

    @NotNull
    @Override
    public String getId() {
        return "DemoRunConfiguration";
    }

    @Override
    public ConfigurationFactory[] getConfigurationFactories() {
        return new ConfigurationFactory[]{new DemoConfigurationFactory(this)};
    }
}
