
public class AlunoMemento {
    private AlunoEstado estado;
    public AlunoMemento(AlunoEstado estadoSalvar) {
        estado = estadoSalvar;
    }
    public AlunoEstado getEstadoSalvo(){
        return estado;
    }
    public String toString(){
        return estado.getEstado();
    }
}
