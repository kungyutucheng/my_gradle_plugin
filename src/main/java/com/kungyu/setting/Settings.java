package com.kungyu.setting;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wengyongcheng
 * @since 2020/3/14 10:27 下午
 */
@State(name = "MainSetting", storages = @Storage("main-setting.xml"))
public class Settings implements PersistentStateComponent<Settings> {

    private Map<String, String> settingMap;

    public Map<String, String> getSettingMap() {
        return settingMap;
    }

    public void setSettingMap(Map<String, String> settingMap) {
        this.settingMap = settingMap;
    }

    public static Settings getInstance() {

        return ServiceManager.getService(Settings.class);
    }

    public Settings(){
        init();
    }

    private void init() {
        settingMap = new HashMap<>();
    }

    @Nullable
    @Override
    public Settings getState() {
        return this;
    }

    /**
     * 新的组件状态被加载时，调用该方法，如果IDE运行期间，保存数据的文件被从外部修改，则该方法会被再次调用
     * @param state
     */
    @Override
    public void loadState(@NotNull Settings state) {
        setSettingMap(state.getSettingMap());
    }
}
