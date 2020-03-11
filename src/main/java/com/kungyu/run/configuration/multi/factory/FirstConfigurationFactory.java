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
public class FirstConfigurationFactory extends ConfigurationFactory {

    private static final String FACTORY_NAME = "First configuration factory";

    protected FirstConfigurationFactory(@NotNull ConfigurationType type) {
        super(type);
    }

    @NotNull
    @Override
    public RunConfiguration createTemplateConfiguration(@NotNull Project project) {
        return new FirstConfiguration(project,this,"First");
    }

    @NotNull
    @Override
    public String getName() {
        return FACTORY_NAME;
    }
}
