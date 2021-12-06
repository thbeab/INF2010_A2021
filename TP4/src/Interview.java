import java.util.Comparator;
import java.util.PriorityQueue;

public class Interview {

        public int lastBox(int[] boxes){

            // Ne pas modifier la ligne suivante
            PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

            for (int box : boxes) {
                heap.add(box);
            }

            while(heap.size()>1) {
                int boite2 = heap.poll();
                int boite1 = heap.poll();

                if (boite2 != boite1) {
                    boite2 = boite2-boite1;
                    heap.add(boite2);
                }
            }
            return heap.isEmpty() ? 0 : heap.poll() ;
        }
}


