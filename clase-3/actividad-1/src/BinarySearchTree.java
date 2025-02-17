public class BinarySearchTree {

    // Método para buscar un valor en el BST
    public TreeNode searchBST(TreeNode root, int x) {
        // Caso base: si el nodo es nulo o si el valor del nodo es el que estamos buscando
        if (root == null || root.value == x) {
            return root;
        }

        // Si el valor a buscar es menor que el valor del nodo actual, buscar en el subárbol izquierdo
        if (x < root.value) {
            return searchBST(root.left, x);
        }

        // Si el valor a buscar es mayor que el valor del nodo actual, buscar en el subárbol derecho
        return searchBST(root.right, x);
    }


    public static int getHeight(TreeNode root) {
        // Caso base: si el nodo es nulo, la altura es -1
        if (root == null) {
            return -1;
        }

        // Calcular la altura del subárbol izquierdo
        int leftHeight = getHeight(root.left);

        // Calcular la altura del subárbol derecho
        int rightHeight = getHeight(root.right);

        // La altura del nodo actual es el máximo de las alturas de sus subárboles más uno
        return Math.max(leftHeight, rightHeight) +1;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Crear un árbol de ejemplo
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(25);
        root.right.right.right = new TreeNode(30);

        int resultado=getHeight(root);

        System.out.println("La altura del arbol es: "+resultado);


    }
}

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}