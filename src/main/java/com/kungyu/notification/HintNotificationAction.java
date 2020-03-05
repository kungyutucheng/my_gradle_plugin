package com.kungyu.notification;

import com.intellij.codeInsight.hint.HintManager;
import com.intellij.notification.*;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.ui.Messages;
import com.intellij.ui.Hint;
import org.jetbrains.annotations.NotNull;

import javax.swing.event.HyperlinkEvent;

/**
 * @author wengyongcheng
 * @since 2020/3/4 11:11 下午
 */
public class HintNotificationAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        //HintManager.getInstance().showErrorHint(CommonDataKeys.EDITOR.getData(e.getDataContext()),"错误信息");

//        HintManager.getInstance().showQuestionHint(CommonDataKeys.EDITOR.getData(e.getDataContext()), "questionAction", 0, 0, () -> {
//            Messages.showMessageDialog("question", "Question", Messages.getInformationIcon());
//            return true;
//        });
//
//        HintManager.getInstance().showInformationHint(CommonDataKeys.EDITOR.getData(e.getDataContext()),"information");

        // 第三个参数logByDefault代表是否记入event log
        NotificationGroup notificationGroup = new NotificationGroup("notificationGroup", NotificationDisplayType.NONE, true);
        Notification notification = notificationGroup.createNotification();
        notification.setContent("notification");
        Notifications.Bus.notify(notification);

        Notification infoNotification = notificationGroup.createNotification(NotificationType.INFORMATION);
        infoNotification.setContent("info");
        Notifications.Bus.notify(infoNotification);

        Notification errorNotification = notificationGroup.createNotification("error",NotificationType.ERROR);
        Notifications.Bus.notify(errorNotification);
//
//        Notification messageNotification = notificationGroup.createNotification("messageType", MessageType.WARNING);
//        Notifications.Bus.notify(messageNotification);
//
//        Notification subTitleNotification = notificationGroup.createNotification("title", "subTitle", "content", NotificationType.WARNING);
//        Notifications.Bus.notify(subTitleNotification);
//
//        Notification eventNotification = notificationGroup.createNotification("title", "content", NotificationType.WARNING, new NotificationListener() {
//            @Override
//            public void hyperlinkUpdate(@NotNull Notification notification, @NotNull HyperlinkEvent event) {
//                Messages.showMessageDialog(event.getURL().toString(), "Url", Messages.getInformationIcon());
//            }
//        });
//        Notifications.Bus.notify(eventNotification);

    }
}
