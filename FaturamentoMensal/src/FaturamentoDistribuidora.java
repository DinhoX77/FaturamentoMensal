import java.util.List;

public class FaturamentoDistribuidora {
    private List<FaturamentoEstado> faturamentos;

    public FaturamentoDistribuidora(List<FaturamentoEstado> faturamentos) {
        this.faturamentos = faturamentos;
    }

    public double calcularFaturamentoTotal() {
        return faturamentos.stream()
                .mapToDouble(FaturamentoEstado::getValor)
                .sum();
    }

    public void calcularPercentuais() {
        double faturamentoTotal = calcularFaturamentoTotal();

        System.out.println("Faturamento Total: R$ " + faturamentoTotal);
        faturamentos.forEach(estado -> {
            double percentual = (estado.getValor() / faturamentoTotal) * 100;
            System.out.printf("%s: %.2f%%\n", estado.getEstado(), percentual);
        });
    }
}
