package vrsoftware.aplicativoteste.statusenum;

public enum StatusEnum {
    EXCLUIDO(0), ATIVO(1);
    
    private final int valor;
    
    StatusEnum(int valor) {
        this.valor = valor;
    }
    
    public int getValor() {
        return valor;
    }
    
}
