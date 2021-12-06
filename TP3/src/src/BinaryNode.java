import java.util.List;

public class BinaryNode<T extends Comparable<? super T>> {
    private T data;
    private BinaryNode<T> right;
    private BinaryNode<T> left;

    // TODO: initialisation
    // O(1)
    public BinaryNode(T data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    // TODO: on retourne la donnee voulue
    // O(1)
    public T getData() {
        return data;
    }

    // TODO: on ajoute une nouvelle donnee au bon endroit
    // O(log(n))
    public void insert(T item) {
        int compareResult = item.compareTo(this.data);

        if(compareResult <= 0){
            if(this.left != null){
                left.insert(item);
            }else {
                left = new BinaryNode<>(item);
            }
        }else{
            if(this.right != null){
                right.insert(item);
            }else {
                right = new BinaryNode<>(item);
            }
        }
    }

    // TODO: est-ce que l'item fais partie du noeuds courant
    // O(log(n))
    public boolean contains(T item) {
        int compareValue = item.compareTo(data);
        if(compareValue < 0 && left != null){
            return left.contains(item);
        }else if(compareValue > 0 && right != null){
            return right.contains(item);
        }
        return compareValue == 0;
    }

    // TODO: on retourne la maximale de l'arbre
    // O(n)
    public int getHeight() {
        int leftHeight;
        int rightHeight;

        if(left != null){
            leftHeight = left.getHeight();
        }else{
            leftHeight = -1;
        }

        if(right != null){
            rightHeight = right.getHeight();
        }else{
            rightHeight = -1;
        }

        return Math.max(rightHeight, leftHeight) + 1;
    }

    // TODO: l'ordre d'insertion dans la liste est l'ordre logique
    // de manière que le plus petit item sera le premier inseré
    // O(n)
    public void fillListInOrder(List<BinaryNode<T>> result) {
        if(left != null) {
            left.fillListInOrder(result);
        }
        result.add(this);
        if(right != null) {
            right.fillListInOrder(result);
        }
    }
}