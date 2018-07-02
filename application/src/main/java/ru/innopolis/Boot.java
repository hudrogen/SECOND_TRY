package ru.innopolis;

import org.pf4j.*;
import ru.innopolis.api.Greeting;

import java.util.List;
import java.util.Set;

public class Boot {
    public static void main(String[] args) throws InterruptedException, PluginException {
        System.setProperty("pf4j.pluginsDir", "C:\\Users\\salimgaraev\\IdeaProjects\\SECOND_TRY\\plugin\\target");
        PluginManager pluginManager = new DefaultPluginManager();
        pluginManager.loadPlugins();
        pluginManager.startPlugins();

        for (PluginWrapper pluginWrapper : pluginManager.getPlugins()) {
            System.out.println("Плагин айди= " + pluginWrapper.getPluginId());
        }

        // print extensions from classpath (non plugin)
        System.out.println("Extensions added by classpath:");
        Set<String> extensionClassNames = pluginManager.getExtensionClassNames(null);
        for (String extension : extensionClassNames) {
            System.out.println("   " + extension);
        }

        System.out.println("Поиск расширений");
        // print extensions ids for each started plugin
        List<PluginWrapper> startedPlugins = pluginManager.getStartedPlugins();
        for (PluginWrapper plugin : startedPlugins) {
            String pluginId = plugin.getDescriptor().getPluginId();
            System.out.println(String.format("Extensions added by plugin '%s':", pluginId));
            extensionClassNames = pluginManager.getExtensionClassNames(pluginId);
            for (String extension : extensionClassNames) {
                System.out.println("   " + extension);
            }
        }

    }
}
