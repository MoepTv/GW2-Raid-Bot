package me.cbitler.raidbot.raids.templates;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigObject;
import com.typesafe.config.ConfigValue;
import me.cbitler.raidbot.RaidBot;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages the role templates for raids
 */
public class TemplateManager {

    private static Map<String, Template> raidTemplates;
    private static Map<String, Template> fractalTemplates;


    public static void loadTemplates() {
        Config config = RaidBot.getInstance().getConfig("role-templates");
        raidTemplates = loadTemplates(config, "raids");
        fractalTemplates = loadTemplates(config, "fractals");
    }

    private static Map<String, Template> loadTemplates(Config config, String type) {
        Map<String, Template> templates = new LinkedHashMap<>();
        for (Map.Entry<String, ConfigValue> entry : config.getConfig(type).root().entrySet()) {
            Template template = new Template(entry.getKey(), ((ConfigObject) entry.getValue()).toConfig());
            templates.put(template.getId(), template);
        }
        return templates;
    }

    public static List<Template> getRaidTemplates() {
        return new ArrayList<>(raidTemplates.values());
    }

    public static List<Template> getFractalTemplates() {
        return new ArrayList<>(fractalTemplates.values());
    }

    public static List<Template> getAllTemplates() {
        List<Template> list = new ArrayList<>();
        list.addAll(raidTemplates.values());
        list.addAll(fractalTemplates.values());
        return list;
    }
}
