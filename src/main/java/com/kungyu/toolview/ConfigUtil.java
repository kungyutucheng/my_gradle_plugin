package com.kungyu.toolview;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.project.Project;

/**
 * @author wengyongcheng
 * @since 2020/7/13 9:12 下午
 */
public class ConfigUtil {

    public static void setRunning(Project project, boolean value) {
        PropertiesComponent.getInstance(project).setValue(StringConst.RUNNING_KEY, value);
    }

    public static boolean getRunning(Project project){
        return PropertiesComponent.getInstance(project).getBoolean(StringConst.RUNNING_KEY);
    }
}
