package com.kungyu.toolview;

import com.intellij.execution.Executor;
import com.intellij.execution.ExecutorRegistry;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.plaf.IconUIResource;

/**
 * @author wengyongcheng
 * @since 2020/7/11 2:15 下午
 */
public class CustomRunExecutor extends Executor {

    public static final String TOOL_WINDOW_ID = "tool window plugin";

    @Override
    public String getToolWindowId() {
        return TOOL_WINDOW_ID;
    }

    @Override
    public Icon getToolWindowIcon() {
        return IconUtil.ICON;
    }

    @NotNull
    @Override
    public Icon getIcon() {
        return IconUtil.ICON;
    }

    @Override
    public Icon getDisabledIcon() {
        return IconUtil.ICON;
    }

    @Override
    public String getDescription() {
        return TOOL_WINDOW_ID;
    }

    @NotNull
    @Override
    public String getActionName() {
        return TOOL_WINDOW_ID;
    }

    @NotNull
    @Override
    public String getId() {
        return StringConst.PLUGIN_ID;
    }

    @NotNull
    @Override
    public String getStartActionText() {
        return TOOL_WINDOW_ID;
    }

    @Override
    public String getContextActionId() {
        return "custom context action id";
    }

    @Override
    public String getHelpId() {
        return TOOL_WINDOW_ID;
    }

    public static Executor getRunExecutorInstance() {
        return ExecutorRegistry.getInstance().getExecutorById(StringConst.PLUGIN_ID);
    }
}

