

import java.util.Comparator;

public class comparadorNumero implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        int aux = o1 - o2;
        if(aux > 0){
            return 1;
        }
        else if(aux<0){
            return -1;
        }
        else {
            return 0;
        }
    }
    
}
