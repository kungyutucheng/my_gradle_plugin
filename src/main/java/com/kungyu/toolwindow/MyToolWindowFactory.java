package com.kungyu.toolwindow;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Condition;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;


/**
 * @author wengyongcheng
 * @since 2020/3/1 10:31 下午
 */
public class MyToolWindowFactory implements ToolWindowFactory, Condition<Project> {

    /**
     * 创建 tool window
     * @param project
     * @param toolWindow
     */
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        MyToolWindow myToolWindow = new MyToolWindow(toolWindow);
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(myToolWindow.getContent(), "自定义tool window", false);
        toolWindow.getContentManager().addContent(content);

    }


    /**
     * 控制tool window是否展示
     * @param project
     * @return
     */
    @Override
    public boolean value(Project project) {
        return false;
    }
}
