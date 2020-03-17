package com.kungyu.persisting.state.component;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author wengyongcheng
 * @since 2020/3/17 10:00 上午
 * project 级别的 properties component
 */
public class PropertiesComponentProjectSetting implements Configurable {
    private JTextField textField;
    private JPanel mainPanel;

    private Project project;

    private static final String PROJECT_KEY = "projectKey";


    public PropertiesComponentProjectSetting() {
        Project [] projects = ProjectManager.getInstance().getOpenProjects();
        this.project = projects.length > 0 ? projects[0] : ProjectManager.getInstance().getDefaultProject();
        textField.setText(PropertiesComponent.getInstance(project).getValue(getKey())) ;
    }
    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "Project Level Properties Component";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        return mainPanel;
    }

    @Override
    public boolean isModified() {
        return !StringUtils.equals(textField.getText(), PropertiesComponent.getInstance(project).getValue(getKey()));
    }

    @Override
    public void apply() throws ConfigurationException {
        PropertiesComponent.getInstance(project).setValue(getKey(), textField.getText());
    }

    private String getKey() {
        return this.project.getName() + "-" + PROJECT_KEY;
    }
}
