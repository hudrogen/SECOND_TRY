package ru.innopolis;

import org.pf4j.*;
import ru.innopolis.api.Greeting;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Boot {
    public static void main(String[] args) throws InterruptedException, PluginException {
        System.setProperty("pf4j.pluginsDir", "C:\\Users\\salimgaraev\\Desktop\\plugins");
        System.setProperty("pf4j.mode", "development");
        PluginManager pluginManager = new DefaultPluginManager();
        pluginManager.loadPlugins();
        pluginManager.startPlugins();

        for (PluginWrapper pluginWrapper : pluginManager.getPlugins()) {
            System.out.println("Плагин айди= " + pluginWrapper.getPluginId());
        }

        Set<String> extensionClassNames = new HashSet<String>();
//        System.out.println("Find Extensions...");
//        // print extensions ids for each started plugin
//        List<PluginWrapper> startedPlugins = pluginManager.getStartedPlugins();
//        for (PluginWrapper plugin : startedPlugins) {
//            String pluginId = plugin.getDescriptor().getPluginId();
//            System.out.println(String.format("Extensions added by plugin '%s':", pluginId));
//            extensionClassNames = pluginManager.getExtensionClassNames(pluginId);
//            for (String extension : extensionClassNames) {
//                System.out.println("   " + extension);
//            }
//        }

        System.out.println("Run extensions...");
        List<Greeting> greetings = pluginManager.getExtensions(Greeting.class);
        System.out.println(String.format("Found %d extensions for extension point '%s'", greetings.size(), Greeting.class.getName()));
        for (Greeting greeting : greetings) {
            System.out.println(">>> " + greeting.getGreeting());
        }
    }
}
