package com.kungyu.editor.component;

import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.TypedActionHandler;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * @author wengyongcheng
 * @since 2020/3/10 2:36 下午
 */
public class MyTypedHandler implements TypedActionHandler {
    @Override
    public void execute(@NotNull Editor editor, char charTyped, @NotNull DataContext dataContext) {
        final Document document = editor.getDocument();
        final Project project = editor.getProject();
        Runnable runnable = () -> document.insertString(0,"test");
        WriteCommandAction.runWriteCommandAction(project,runnable);
    }
}
