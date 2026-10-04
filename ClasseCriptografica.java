public class ClasseCriptografica {

    public String encripta(String paraula, int clau) {

        String resultat = "";

        for (int i = 0; i < paraula.length(); i++) {

            // Separar les lletres de la paraula
            char lletra = paraula.charAt(i);

            // Passar les lletres a numeros
            int posicio = lletra - 'A' + 1;

            // Sumar la clau
            int nouValor = posicio + clau;

            // Si el valor es major a 26 es restara 26
            if (nouValor > 26) {
                nouValor = nouValor - 26;
            }


            // Sumar +7
            int valorfinal = nouValor + 7;

            if (valorfinal > 26) {
                valorfinal = valorfinal - 26;
            }


            // Crear número de 4 xifres
            int numerolletra = valorfinal * 100 + (clau * 10) + i;

            String sizeNumeroLletra = String.valueOf(numerolletra);

            if (sizeNumeroLletra.length() < 4) {
                sizeNumeroLletra = "0" + sizeNumeroLletra;
            }

            resultat = resultat + sizeNumeroLletra;
        }

        return resultat;
    }

    public String desencripta(String missatge, int clau) {

    String resultat = "";

    int posicioBloc = 0;

    // Llegim el missatge de 4 en 4
    for (int i = 0; i < missatge.length(); i += 4) {

        // Agafem 4 números
        String bloc = missatge.substring(i, i + 4);

        // Convertim el bloc a int
        int numeroLletra = Integer.parseInt(bloc);

        // Recuperem el valor de la lletra encriptada
        int valorFinal =
                (numeroLletra - (clau * 10) - posicioBloc) / 100;

        // Desfem el +7
        int nouValor = valorFinal - 7;

        if (nouValor <= 0) {
            nouValor = nouValor + 26;
        }

        // Desfem la clau
        int posicioOriginal = nouValor - clau;

        if (posicioOriginal <= 0) {
            posicioOriginal = posicioOriginal + 26;
        }

        // Convertim el número a lletra
        char lletraOriginal = (char) ('A' + posicioOriginal - 1);

        resultat = resultat + lletraOriginal;

        posicioBloc++;
    }

    return resultat;
}
}