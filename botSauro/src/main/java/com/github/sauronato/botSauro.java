package com.github.sauronato;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import org.javacord.api.*;

public class botSauro {
    public static void main(String[] args) throws FileNotFoundException {
        //Leer token de Bot
        try{
        InputStream in = new FileInputStream(".secret/passwd");
        Scanner obj = new Scanner(in);
        
        // Insert your bot's token here
        String token = obj.nextLine();

        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        // Add a listener which answers with "Pong!" if someone writes "!ping"
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!ping")) {
                event.getChannel().sendMessage("Pong!");
            }
        });

        // Print the invite url of your bot
        System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());

    }catch (FileNotFoundException e) {
        System.err.println("Error, archivo con Token no encontrado: "+e.getMessage());
    }
    
    }
}