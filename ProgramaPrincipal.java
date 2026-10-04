public class ProgramaPrincipal {

    public static void main(String[] args) {

        ClasseCriptografica criptografia = new ClasseCriptografica();

        String paraula = "ESTERNOCLEIDOMASTOIDEO";
        int clau = 3;

        String encriptat = criptografia.encripta(paraula, clau);

        System.out.println("Original: " + paraula);
        System.out.println("Encriptat: " + encriptat);

        String desencriptat = criptografia.desencripta(encriptat, clau);

        System.out.println("Desencriptat: " + desencriptat);
    }
}