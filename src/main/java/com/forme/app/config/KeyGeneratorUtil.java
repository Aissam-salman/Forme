package com.forme.app.config;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * The type Key generator util.
 */
public class KeyGeneratorUtil {
    /**
     * Generate and store keys.
     *
     * @throws Exception the exception
     */
    public static void generateAndStoreKeys() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
        keyGen.initialize(256);
        KeyPair keyPair = keyGen.generateKeyPair();

        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // Store the private key
        Files.write(Paths.get("privateKey.key"), privateKey.getEncoded());

        // Store the public key
        Files.write(Paths.get("publicKey.key"), publicKey.getEncoded());
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try {
            generateAndStoreKeys();
            System.out.println("Keys generated and stored successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
