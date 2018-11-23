public class Tubercle implements Comparable<Tubercle>{

    private String procedencia;
    private float massa;

    public Tubercle(String procedencia, float massa){
        this.procedencia = procedencia;
        this.massa = massa;
    }

    public Tubercle(float massa){
        this.procedencia = null;
        this.massa = massa;
    }

    @Override
    public int compareTo(Tubercle o) {
        if(this.massa > o.massa){
            return 1;
        } else if(this.massa == o.massa){
            return 0;
        } else {
            return -1;
        }
    }
}