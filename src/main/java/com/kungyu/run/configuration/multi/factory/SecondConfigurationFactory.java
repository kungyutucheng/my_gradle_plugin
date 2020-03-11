package com.kungyu.run.configuration.multi.factory;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * @author wengyongcheng
 * @since 2020/3/10 5:01 下午
 */
public class SecondConfigurationFactory extends ConfigurationFactory {

    private static final String FACTORY_NAME = "Second configuration factory";

    protected SecondConfigurationFactory(@NotNull ConfigurationType type) {
        super(type);
    }

    @NotNull
    @Override
    public RunConfiguration createTemplateConfiguration(@NotNull Project project) {
        return new SecondConfiguration(project,this,"Second");
    }

    @NotNull
    @Override
    public String getName() {
        return FACTORY_NAME;
    }
}
