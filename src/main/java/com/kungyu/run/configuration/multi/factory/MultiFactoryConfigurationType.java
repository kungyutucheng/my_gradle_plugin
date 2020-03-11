package com.kungyu.run.configuration.multi.factory;

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
public class MultiFactoryConfigurationType implements ConfigurationType {
    @NotNull
    @Override
    public String getDisplayName() {
        return "MultiFactoryRunConfiguration";
    }

    @Nls
    @Override
    public String getConfigurationTypeDescription() {
        return "Multi Factory Run Configuration Desc";
    }

    @Override
    public Icon getIcon() {
        return AllIcons.General.Information;
    }

    @NotNull
    @Override
    public String getId() {
        return "MultiFactoryRunConfiguration";
    }

    @Override
    public ConfigurationFactory[] getConfigurationFactories() {
        return new ConfigurationFactory[]{new FirstConfigurationFactory(this),new SecondConfigurationFactory(this)};
    }
}
