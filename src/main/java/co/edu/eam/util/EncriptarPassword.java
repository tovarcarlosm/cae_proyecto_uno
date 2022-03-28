package co.edu.eam.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {
    public static void main(String[] args){
        var password = "visitante1234";

        System.out.println("Contraseña: " + password);
        System.out.println("Encriptada: " + encriptar(password));
    }

    public static String encriptar(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
