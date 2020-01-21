package me.cbitler.raidbot.raids.templates;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigValue;
import me.cbitler.raidbot.raids.RaidRole;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A role template for raids
 */
public class Template {
    private final String name;
    private final Map<String, RaidRole> roles = new LinkedHashMap<>();

    public Template(String name, Config config) {
        this.name = name;
        for (Map.Entry<String, ConfigValue> entry : config.root().entrySet()) {
            RaidRole role = new RaidRole(config.getInt(entry.getKey()), entry.getKey());
            roles.put(role.getName().toLowerCase(), role);
        }
    }

    public String getId() {
        return name.toLowerCase();
    }

    public Map<String, RaidRole> getRoles() {
        return roles;
    }

    public String toString() {
        return name + " (" + roles.values().stream().map(r -> r.getAmount() + " x " + r.getName()).collect(Collectors.joining(", ")) + ")";
    }
}
