import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class CriptografiaSimetrica {
    public static void main(String[] args) throws Exception {
        String textoOriginal = "Mensagem secreta";

        // Gerar chave AES
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // ou 256
        SecretKey chave = keyGen.generateKey();

        // Criptografar
        Cipher cifra = Cipher.getInstance("AES");
        cifra.init(Cipher.ENCRYPT_MODE, chave);
        byte[] textoCriptografado = cifra.doFinal(textoOriginal.getBytes());
        String criptografadoBase64 = Base64.getEncoder().encodeToString(textoCriptografado);

        // Descriptografar
        cifra.init(Cipher.DECRYPT_MODE, chave);
        byte[] textoDescriptografado = cifra.doFinal(Base64.getDecoder().decode(criptografadoBase64));

        System.out.println("Texto original: " + textoOriginal);
        System.out.println("Criptografado: " + criptografadoBase64);
        System.out.println("Descriptografado: " + new String(textoDescriptografado));
    }
}
