package me.cbitler.raidbot;

import me.cbitler.raidbot.handlers.DMHandler;
import me.cbitler.raidbot.utility.EnvVariables;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Start the program, read the token, and start the bot
 * @author Christopher Bitler
 */
public class Main {
    public static void main(String[] args) throws LoginException, InterruptedException, RateLimitedException {
        String token = null;
        try {
            token = readToken();
        } catch (IOException e) {
            System.out.println("Specify Discord Bot Token in file 'token'");
            System.exit(1);
        }

        JDA jda = new JDABuilder(AccountType.BOT).setToken(token).buildBlocking();
        RaidBot bot = new RaidBot(jda);
    }

    /**
     * Read the token from the token file
     * @return The token text
     * @throws IOException
     */
    private static String readToken() throws IOException {
        // get token file from jar dir instead of execution dir
        URI tokenPath;
        try{
            tokenPath = Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().resolve("token");
        } catch(URISyntaxException e){
            throw new IOException();
        }
        File tokenFile = new File(tokenPath);
        // if token file does not exist in jar dir, try loading it from execution dir
        if(!tokenFile.exists()) tokenFile = new File("token");
        BufferedReader br = new BufferedReader(
                new FileReader(tokenFile));
        return br.readLine();
    }
}
