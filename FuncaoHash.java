import java.security.MessageDigest;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class FuncaoHash {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma senha: ");
        String senha = scanner.nextLine();

        // Aplica função hash SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(senha.getBytes(StandardCharsets.UTF_8));

        // Converte o hash para string hexadecimal
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }

        System.out.println("Hash SHA-256 da senha: " + hexString.toString());
        scanner.close();
    }
}