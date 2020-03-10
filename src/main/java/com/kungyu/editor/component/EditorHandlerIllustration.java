package com.kungyu.editor.component;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.editor.actionSystem.EditorActionManager;
import com.intellij.openapi.editor.actionSystem.TypedAction;
import com.intellij.openapi.editor.actionSystem.TypedActionHandler;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * @author wengyongcheng
 * @since 2020/3/10 2:32 下午
 */
public class EditorHandlerIllustration extends AnAction {

    static {
        final EditorActionManager editorActionManager = EditorActionManager.getInstance();
        final TypedAction typedAction = editorActionManager.getTypedAction();
        typedAction.setupHandler(new MyTypedHandler());
    }


    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        final Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        EditorActionHandler editorActionHandler = EditorActionManager.getInstance().getActionHandler(IdeActions.ACTION_EDITOR_CLONE_CARET_BELOW);
        editorActionHandler.execute(editor, editor.getCaretModel().getPrimaryCaret(), e.getDataContext());
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        final Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        final Project project = e.getProject();
        boolean menuAllowed = false;
        if (editor != null && project != null) {
            menuAllowed = !editor.getCaretModel().getAllCarets().isEmpty();
        }
        e.getPresentation().setEnabledAndVisible(menuAllowed);

    }
}
