package me.cbitler.raidbot.utility;

import me.cbitler.raidbot.RaidBot;
import net.dv8tion.jda.core.entities.Emote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reactions {
    /**
     * List of reactions representing classes
     */
    static String[] specs = {
            "Guardian", // 480207269913428008
            "Dragonhunter", // 480207267233267732
            "Firebrand", // 480207273487106061
            "Revenant", // 480207263668240404
            "Herald", // 480207275974459402
            "Renegade", // 480207269221367819
            "Warrior", // 480207274795597844
            "Berserker", // 480207274615373874
            "Spellbreaker", // 480207273579380736
            "Engineer", // 480207268965646337
            "Scrapper", // 480207271696138252
            "Holosmith", // 480207276427444239
            "Ranger", // 480207273990291457
            "Druid", // 480207271192952832
            "Soulbeast", // 480207278621065227
            "Thief", // 480207275672207361
            "Daredevil", // 480207276402278401
            "Deadeye", // 480207276217729035
            "Elementalist", // 480207269297127425
            "Weaver", // 480207275957551114
            "Tempest", // 480207269120704512
            "Mesmer", // 480207272312832002
            "Chronomancer", // 480207277908033557
            "Mirage", // 480207272858091530
            "Necromancer", // 480207268185505802
            "Reaper", // 480207274540007444
            "Scourge" // 480207277534740480
    };
    
    public static String[] coreClasses = {
            "Guardian", // 530541438891589643
            "Revenant", // 530541439751290901
            "Warrior", // 530541440145555466
            "Engineer", // 530541439172608062
            "Ranger", // 530541439642501121
            "Thief", // 530541439701221378
            "Elementalist", // 530541438891589642
            "Mesmer", // 530541438769823747
            "Necromancer" // 530541439218876416
    };

    static Emote[] reactions = {
            getEmoji("480207269913428008"), // Guardian
            getEmoji("480207267233267732"), // Dragonhunter
            getEmoji("480207273487106061"), // Firebrand
            getEmoji("480207263668240404"), // Revenant
            getEmoji("480207275974459402"), // Herald
            getEmoji("480207269221367819"), // Renegade
            getEmoji("480207274795597844"), // warrior
            getEmoji("480207274615373874"), // Berserker
            getEmoji("480207273579380736"), // Spellbreaker
            getEmoji("480207268965646337"), // Engineer
            getEmoji("480207271696138252"), // Scrapper
            getEmoji("480207276427444239"), // Holosmith
            getEmoji("480207273990291457"), // Ranger
            getEmoji("480207271192952832"), // Druid
            getEmoji("480207278621065227"), // Soulbeast
            getEmoji("480207275672207361"), // Thief
            getEmoji("480207276402278401"), // Daredevil
            getEmoji("480207276217729035"), // Deadeye
            getEmoji("480207269297127425"), // Elementalist
            getEmoji("480207275957551114"), // Tempest
            getEmoji("480207269120704512"), // Weaver
            getEmoji("480207272312832002"), // Mesmer
            getEmoji("480207277908033557"), // Chronomancer
            getEmoji("480207272858091530"), // Mirage
            getEmoji("480207268185505802"), // Necromancer
            getEmoji("480207274540007444"), // Reaper
            getEmoji("480207277534740480"), // Scourge 
            getEmoji("668876709382324224"), // Flex
            getEmoji("668876743888732170"), // Swap
			getEmoji("668657164931301417") // X_
    };

    static Emote[] reactionsCore = {
            getEmoji("480207269913428008"), // Guardian
            getEmoji("480207263668240404"), // Revenant
            getEmoji("480207274795597844"), // Warrior
            getEmoji("480207268965646337"), // Engineer
            getEmoji("480207273990291457"), // Ranger
            getEmoji("480207275672207361"), // Thief
            getEmoji("480207269297127425"), // Elementalist
            getEmoji("480207272312832002"), // Mesmer
            getEmoji("480207268185505802"), // Necromancer
            getEmoji("668876709382324224"), // Flex
            getEmoji("668876743888732170"), // Swap
            getEmoji("668657164931301417") // X_
    };

    static Emote[] reactionsOpenWorld = {
			getEmoji("668698621050617867"), // Check
            getEmoji("668657164931301417") // X_
    };

    /**
     * Get an emoji from it's emote ID via JDA
     *
     * @param id The ID of the emoji
     * @return The emote object representing that emoji
     */
    private static Emote getEmoji(String id) {
        return RaidBot.getInstance().getJda().getEmoteById(id);
    }

    /**
     * Get the list of reaction names as a list
     *
     * @return The list of reactions as a list
     */
    public static List<String> getSpecs() {
        return new ArrayList<>(Arrays.asList(specs));
    }

    /**
     * Get the list of emote objects
     *
     * @return The emotes
     */
    public static List<Emote> getEmotes() {
        return new ArrayList<>(Arrays.asList(reactions));
    }

    /**
     * Get the list of core class emote objects
     *
     * @return The emotes
     */
    public static List<Emote> getCoreClassEmotes() {
        return new ArrayList<>(Arrays.asList(reactionsCore));
    }
    
    /**
     * Get the list of open world emote objects
     *
     * @return The emotes
     */
    public static List<Emote> getOpenWorldEmotes() {
        return new ArrayList<>(Arrays.asList(reactionsOpenWorld));
    }

    public static Emote getEmoteByName(String name) {
        for (Emote emote : reactions) {
            if (emote != null && emote.getName().equalsIgnoreCase(name)) {
                return emote;
            }
        }
        return null;
    }
}
