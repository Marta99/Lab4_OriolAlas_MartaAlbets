public class Moniato extends Tubercle {

    private String tipus;

    public Moniato(String procedència, float massa) {
        super(procedència, massa);
        tipus = null;
    }

    public Moniato(float massa){
        super(massa);
        this.tipus = null;
    }

    public Moniato(float massa, String tipus){
        super(massa);
        this.tipus = tipus;
    }
}
