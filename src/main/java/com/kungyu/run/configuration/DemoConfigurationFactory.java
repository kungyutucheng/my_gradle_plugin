package com.kungyu.run.configuration;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * @author wengyongcheng
 * @since 2020/3/10 5:01 下午
 */
public class DemoConfigurationFactory extends ConfigurationFactory {

    private static final String FACTORY_NAME = "Demo configuration factory";

    protected DemoConfigurationFactory(@NotNull ConfigurationType type) {
        super(type);
    }

    @NotNull
    @Override
    public RunConfiguration createTemplateConfiguration(@NotNull Project project) {
        return new DemoRunConfiguration(project,this,"Demo");
    }

    @NotNull
    @Override
    public String getName() {
        return FACTORY_NAME;
    }
}
