package ru.innopolis;

import org.pf4j.Extension;
import org.pf4j.Plugin;
import org.pf4j.PluginException;
import org.pf4j.PluginWrapper;
import ru.innopolis.api.Greeting;

public class MyPlugin extends Plugin {
    public MyPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void start() throws PluginException {
        System.out.println("MyPlugin starts...");
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
        }
    }

    @Override
    public void stop() throws PluginException {
        System.out.println("MyPlugin stops...");
    }


    @Extension
    public static class WelcomeGreeting implements Greeting {

        @Override
        public String getGreeting() {
            return "Welcome from my plugin as extension";
        }
    }
}
