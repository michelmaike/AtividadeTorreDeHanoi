import java.util.concurrent.TimeUnit;

public class TorreDeHanoi {
    private static long contadorDeMovimentos;

    public static void main(String[] args) {
        int numeroDeDiscos = 41;
        contadorDeMovimentos = 0;

        long tempoInicio = System.nanoTime();
        resolverHanoi(numeroDeDiscos, 'A', 'C', 'B');
        long tempoFim = System.nanoTime();

        long duracaoEmMillis = TimeUnit.NANOSECONDS.toMillis(tempoFim - tempoInicio);
        String tempoFormatado = formatarDuracao(duracaoEmMillis);

        System.out.println("Tempo de execução: " + tempoFormatado);
        System.out.println("Quantidade de movimentos: " + contadorDeMovimentos);
    }

    private static void resolverHanoi(int n, char deHaste, char paraHaste, char hasteAux) {
        if (n == 0) {
            return;
        }
        resolverHanoi(n - 1, deHaste, hasteAux, paraHaste);
        contadorDeMovimentos++;
        resolverHanoi(n - 1, hasteAux, paraHaste, deHaste);
    }

    private static String formatarDuracao(long millis) {
        long horas = TimeUnit.MILLISECONDS.toHours(millis);
        long minutos = TimeUnit.MILLISECONDS.toMinutes(millis) -
                       TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis));
        long segundos = TimeUnit.MILLISECONDS.toSeconds(millis) -
                       TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis));
        long milissegundos = millis - TimeUnit.SECONDS.toMillis(
                TimeUnit.MILLISECONDS.toSeconds(millis));

        return String.format("%02d:%02d:%02d:%03d", horas, minutos, segundos, milissegundos);
    }
}
