import java.util.ArrayList;

public class vertice<T> {

    private String name;
    private T value;
    private ArrayList<Arco<T>> adjuntos;
    private char colour;

    public vertice(String name, T value) {
        this.name = name;
        this.value = value;
        this.adjuntos = new ArrayList<>();
        this.colour = 'w';
    }

    

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public T getValue() {
        return value;
    }



    public void setValue(T value) {
        this.value = value;
    }



    public char getColour() {
        return colour;
    }



    public void setColour(char colour) {
        this.colour = colour;
    }



    public ArrayList<Arco<T>> getAdjuntos(){
        return new ArrayList<>(adjuntos);
    }

    public void addArco(Arco<T> edge){
        adjuntos.add(edge);
    }

    @Override
    public String toString(){
        return "Name: " + name + ", Value: " + value;
    }

}
