import com.sun.jdi.Value;

import java.sql.Array;
import java.util.*;

public class Heap<ValueType extends Comparable<? super ValueType>> implements Iterable<ValueType> {

        public ArrayList<ValueType> elements;
        private final boolean isMax;

        public int size(){
            return elements.size() - 1;
        }

        @Override
        public Iterator<ValueType> iterator() {
            return elements.listIterator(1);
        }

        public Heap(boolean isMax, Collection<ValueType> elements){
            // Ne pas modifier ces lignes
            this.isMax = isMax;
            this.elements = new ArrayList<>();
            this.elements.add(null);
            this.elements.addAll(elements);
            // Ne pas modifier ces lignes

            /* TODO Ajouter une ligne de code pour construire le heap */
            buildHeap();
        }

        /* TODO Implementer le compare pour un MaxHeap et MinHeap */
        protected boolean compare(ValueType first, ValueType second){
            if(isMax){
                return first.compareTo(second)>0;
            }else{
                return first.compareTo(second)<0;
            }
        }

        /* TODO Retourner l'index du parent */
        public int parentIndex(int index){
            return index / 2;
        }

        /* TODO Retourner l'enfant gauche du noeud */
        public int leftChildIndex(int index){
            return index*2;
        }

        /* TODO Retourner l'enfant droit du noeud */
        public int rightChildIndex(int index){
            return index*2+1;
        }

        /* TODO Retourner si l'index present est une feuille */
        public boolean isLeaf(int pos)
        {
            return pos*2>size();
        }

        /* TODO Constuire le monceau avec les noeuds dans "elements" */
        // O(n)
        public void buildHeap(){
            for( int i = size()/ 2; i > 0; i--)
                percolateDown( i );
        }

        /* TODO Echanger les elements qui se retrouve aux indexes currentIndex et parentIndex */
        private void swap(int currentIndex, int parentIndex)
        {
            ValueType tmp = elements.get(parentIndex);
            elements.set(parentIndex, elements.get(currentIndex));
            elements.set(currentIndex, tmp);
        }

        /* TODO Ajouter un element dans le monceaux. */
        // O(log n)
        public void insert(ValueType value){
            elements.add(value);
            int hole = size();
            for( ; hole>1 && compare(value, elements.get(parentIndex(hole))); hole/=2){ // percolateUp
                swap(hole, parentIndex(hole));
            }
        }

        /* TODO Completer l'implementation des conditions de percolateDown pour un heap */
        // O(log n)
        private void percolateDown(int index){
            int child;
            ValueType temp = elements.get(index);
            for(; index * 2 < size(); index = child){

                child = index * 2;

                if(child != size() &&
                        compare(elements.get(child+1), elements.get(child)) /* TODO Ajouter une condition pour evaluer les deux noeuds */) {
                    child++;
                }

                if(compare(elements.get(child), temp) /*TODO Ajouter une condition pour evaluer les deux noeuds */){
                    elements.set(index, elements.get(child));
                }
                else
                    break;
            }
            elements.set(index, temp);
        }

        /* TODO En utilisant leftChildIndex, ajouter les elements gauche du Heap dans une liste et les retourner. */
        public List<ValueType> getLeftElements(){
            ArrayList<ValueType> leftElements = new ArrayList<>();

            for(int i = 1; i<=size()/2; i++){
                leftElements.add(elements.get(leftChildIndex(i)));
            }

            return leftElements;
        }

        /* TODO En utilisant rightChildIndex, ajouter les droites du Heap dans une liste et les retourner. */
        public List<ValueType> getRightElements(){
            ArrayList<ValueType> rightElements = new ArrayList<>();

            for(int i = 1; i<=size()/2; i++){
                rightElements.add(elements.get(rightChildIndex(i)));
            }

            return rightElements;
        }

        /* TODO En utilisant parentIndex, ajouter les noeuds  parents du Heap dans une liste et les retourner. */
        public List<ValueType> getParentElements(){
            ArrayList<ValueType> parentElements = new ArrayList<>();
            for(int i = size(); i>1; i-=2){
                parentElements.add(elements.get(parentIndex(i)));
            }

            return  parentElements;
        }

        /* TODO Ajouter les noeuds feuilles du monceau en utilisant isLeaf */
        public List<ValueType> getLeaves(){
            ArrayList<ValueType> leaves = new ArrayList<>();
            for(int i = size(); i>size()/2; i--){
                if(isLeaf(i)) {
                    leaves.add(elements.get(i));
                }
            }

            return  leaves;
        }

}

