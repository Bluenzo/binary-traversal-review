public class TraversalReview {

    /**
     * Returns three times the sum of the values in the tree.
     * 
     * If node is null returns 0.
     * 
     * Example:
     * 
     *             -9
     *             / \
     *            2   5
     *           / \   \
     *          7   1  -3
     *         /       / \
     *        4       8  33
     *         \        /  \
     *         -6      0    77
     * 
     * Result: 3*(-9+2+7+4+-6+1+5+-3+8+33+77) = 357
     * 
     * @param node the root of the tree
     * @return three times the sum of the nodes in the tree
     */
   
    public static int tripleSum(TreeNode node) {
        
        return 3 * treeSum(node);
    }

    public static int treeSum(TreeNode node) {
        if (node == null){
            return 0;
        }

        int leftSum = treeSum(node.left);
        int rightSum = treeSum(node.right);

        return node.data + leftSum + rightSum;
    }

  

    /**
     * Returns the sum of all positive values in the tree.
     * 
     * If the node is null or the tree contains only negative values, returns 0.
     * 
     * Example:
     * 
     *             -9
     *             / \
     *            2   5
     *           / \   \
     *          7   1  -3
     *         /       / \
     *        4       8  33
     *         \        /  \
     *         -6      0    77
     * 
     * 
     * Result: 2+7+4+1+5+8+33+77 = 137
     * 
     * @param node the root of the tree
     * @return the sum of the positive values in the tree
     */
    public static int positiveSum(TreeNode node) {
        if (node == null){
            return 0;
        }

        int leftSum = positiveSum(node.left);
        int rightSum = positiveSum(node.right);

        int sum = 0;

        if(node.data > 0){
            sum += node.data;       
        }
        sum += leftSum + rightSum;

        return sum;

        
    }

    /**
     * Returns the maximum even value in the tree.
     * 
     * If node is null or there are no even values in the tree, returns Integer.MIN_VALUE.
     * 
     * Example:
     * 
     *             -9
     *             / \
     *            2   5
     *           / \   \
     *          7   1  -3
     *         /       / \
     *        4       8  33
     *         \        /  \
     *         -6      0    77
     * 
     * Result: 8
     * 
     * @param node
     * @return
     */
    public static int evenMax(TreeNode node) {
        if (node == null){
            return Integer.MIN_VALUE;
        }

        int leftMax = evenMax(node.left);
        int rightMax = evenMax(node.right);

        if(node.data % 2 == 0 && node.data > leftMax && node.data > rightMax){
            return node.data;
        }



        // int leftSubTreeBiggest = evenMax(node.left);
        // int rightSubTreeBiggest = evenMax(node.right);

        // int biggest = Integer.MIN_VALUE;
        //we can write like this....
        // int biggest = Math.max(leftSubTreeBiggest, rightSubTreeBiggest);

        // we need this....

         // if(leftSubTreeBiggest < rightSubTreeBiggest){
        //     biggest = rightSubTreeBiggest;
        // }

        //or we can write like this....
        int biggest = Math.max(evenMax(node.left), evenMax(node.right));


       
        //we need this in all of the them to put the value od node.data in biggest
        if(node.data > biggest && node.data % 2 == 0){
            biggest = node.data;
        }

        return Integer.MIN_VALUE;

    }

    /**
     * Returns whether all children of every node in a binary tree has a value
     * strictly greater (not equal) than their parent.
     * 
     * If a node has no children or the node is null, returns true.
     * 
     * Example:
     * 
     *             -9
     *             / \
     *            2   5
     *           / \   \
     *          7   1  -3
     *         /       / \
     *        4       8  33
     *         \        /  \
     *         -6      0    77
     * 
     * Result: false (some of the child nodes have lower values than their parents
     *                For example, 1 < 2).
     * 
     * @param node the root of the tree
     * @return whether all child nodes have strictly greater values than the parents
     */
    public static boolean isIncreasing(TreeNode node) {
        if (node == null){
            return true;
        }
        
        if(node.left != null && node.left.data <= node.data){
            return false;
        }

        if(node.right != null && node.right.data <= node.data){
            return false;
        }

        return isIncreasing(node.left) && isIncreasing(node.right);

            
    }
    /**
     * Returns whether every node in the tree has either 0 or 2 children.
     * 
     * If node is null returns true.
     * 
     * Example:
     * 
     *             -9
     *             / \
     *            2   5
     *           / \   \
     *          7   1  -3
     *         /       / \
     *        4       8  33
     *         \        /  \
     *         -6      0    77
     * 
     * Result: false (some nodes have only one child. For example, the 4 node)
     * 
     * @param node the root of the tree
     * @return whether every node has 0 or 2 children
     */
    public static boolean noSingleChildren(TreeNode node) {
        if (node == null){
            return true;
        }
        if((node.left == null && node.right != null) || (node.left != null && node.right == null)){
            return false;
        }
        return noSingleChildren(node.left) && noSingleChildren(node.right);

    }

    /**
     * Returns whether at least one of the values in the tree is zero.
     * 
     * If node is null, returns false.
     * 
     * Example:
     * 
     *             -9
     *             / \
     *            2   5
     *           / \   \
     *          7   1  -3
     *         /       / \
     *        4       8  33
     *         \        /  \
     *         -6      0    77
     * 
     * Result: true (there is at least one zero in the tree)
     * 
     * @param node the root of the tree
     * @return whether there is it least one zero value in the tree.
     */
    public static boolean hasZero(TreeNode node) {
        // if(node == null) return false;

        // if(node.data == 0){
        //     return true;
        // }

        // if(hasZero(node.left)){
        //     return true;
        // }

        // if(hasZero(node.right)){
        //     return true;
        // }

        // return false;

        return node != null && (node.data == 0 || hasZero(node.left) || hasZero(node.right));

    }

    /**
     * Returns whether there exists at least one value in the tree that is not divisible by k.
     * 
     * If node is null, returns false.
     * 
     * Example:
     * 
     *             -9
     *             / \
     *            2   5
     *           / \   \
     *          7   1  -3
     *         /       / \
     *        4       8  33
     *         \        /  \
     *         -6      0    77
     * 
     * Example k: 3
     * Result: true (some nodes in the tree have values not divisible by 3. For example, 5)
     * 
     * @param node the root of the tree
     * @param k the value to check for divisibility by
     * @return whether every value is divisible by k
     */
    public static boolean hasNonDivisible(TreeNode node, int k) {
        if(node == null){
            return false;
        }
        if(node.data % k != 0){
            return true;
        }
        return hasNonDivisible(node.left, k) || hasNonDivisible(node.right, k);


    }

    /**
     * Returns a String of the concatenated values of the tree traversed in-order.
     * 
     * If the node is null, returns an empty String.
     * 
     * Example:
     * 
     *             -9
     *             / \
     *            2   5
     *           / \   \
     *          7   1  -3
     *         /       / \
     *        4       8  33
     *         \        /  \
     *         -6      0    77
     * 
     * Result: "4-6721-958-303377"
     * 
     * @param node the root of the tree
     * @return a string with all the values of the tree concatenated in-order
     */
    public static String concatenate(TreeNode node) {
        if (node == null){
        return "";
        }

        String leftConcat = concatenate(node.left);
        String rightConcat = concatenate(node.right);
        String currentValue = String.valueOf(node.data);


        return leftConcat + currentValue + rightConcat;
    }
    
}