package me.cbitler.raidbot.creation;

import java.util.List;

import me.cbitler.raidbot.RaidBot;
import me.cbitler.raidbot.raids.templates.Template;
import me.cbitler.raidbot.raids.templates.TemplateManager;

import me.cbitler.raidbot.raids.PendingRaid;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

/**
 * Role setup step for the event.
 * Gives the user the option to choose a role template or return to manual creation.
 * @author Franziska Mueller
 */
public class RunRoleSetupTemplateStep implements CreationStep {

    CreationStep nextStep;
    List<Template> templates;
    
    public RunRoleSetupTemplateStep() {
		this.templates = TemplateManager.getAllTemplates();
		nextStep = new RunPermDiscRoleSetupStep();
	}

    /**
     * Handle user input.
     * @param e The direct message event
     * @return True if the user made a valid choice, false otherwise
     */
    public boolean handleDM(PrivateMessageReceivedEvent e) {
        RaidBot bot = RaidBot.getInstance();
        PendingRaid raid = bot.getPendingRaids().get(e.getAuthor().getId());
        if (raid == null) {
        	// this will be caught in the handler
        	throw new RuntimeException();
        }

        try {
            int choiceId = Integer.parseInt(e.getMessage().getRawContent()) - 1;
            if (choiceId == templates.size()) { // user chose to add roles manually
                nextStep = new RunRoleSetupManualStep();
                return true;
            } else {
                raid.addTemplateRoles(templates.get(choiceId).getRoles().values());
                return true;
            }
        } catch (Exception exp) {
            e.getChannel().sendMessage("Please choose a valid option.").queue();
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    public String getStepText() {
        String message = "Choose from these available role templates or go back to manual role creation: \n";
        for (int i = 0; i < templates.size(); i++) {
            message += "`" + (i+1) + "` " + templates.get(i) + "\n";
        }
        
        return message + "`" + (templates.size()+1) + "` add roles manually";
    }

    /**
     * {@inheritDoc}
     */
    public CreationStep getNextStep() {
        return nextStep;
    }
}
