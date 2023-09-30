package tarea7.utils.Sorting;

public class SorterFactory {
    public static Sorter getSorter(SorterMethods method){

        return switch (method){
            case BUBBLE -> null;
            case SELECTION -> new Sorter(){

                @Override
                public void sort(int[] N) {
                    for(int i=0;i<N.length-1;i++){
                        int minIndex=i;
                        for(int j=i+1;j<N.length;j++){
                            COMPARACIONES++;
                            if(N[minIndex]>N[j]){
                                minIndex = j;
                            }
                        }
                        if(minIndex!=i){
                            MOVIMIENTOS++;
                            swap(N,minIndex,i);
                        }
                    }
                }
            };
            case INSERTION -> null;
            case SHELL -> null;
            case MERGE -> null;
            case QUICK -> null;
            case HEAP -> null;
            default -> throw new IllegalStateException("Unexpected value: " + method);
        };

    }
}
