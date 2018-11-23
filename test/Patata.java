public class Patata extends Tubercle {

    private String tipus;

    public Patata(String procedència, float massa, String tipus) {
        super(procedència, massa);
        this.tipus = tipus;
    }

    public Patata(float massa){
        super(massa);
        this.tipus = null;
    }

    public Patata(float massa, String tipus){
        super(massa);
        this.tipus = tipus;
    }

}
