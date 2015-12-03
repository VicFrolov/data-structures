public class BinaryTreeTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_Constructor();
        test_Cursors();
        test_Nodes();
        test_PreOrderIterator();
        test_contains();


        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void test_Constructor() {
        System.out.println("Testing Constructors...");
        Node n = new Node(new Long(10), null);
        BinaryTree bt = new BinaryTree();
        BinaryTree bt2 = new BinaryTree(new Node(new String("root"), null));

        try {
            displaySuccessIfTrue(n.getParent() == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n.getData().equals(new Long(10)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n.getLeftSon() == null && n.getRightSon() == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bt.size() == 0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(bt2.size() == 1);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(bt2.contains("root"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(bt2.contains("roote"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                                                    
    }

    private static void test_Cursors() {
        System.out.println("Testing cursors...");

        BinaryTree btFail = new BinaryTree();
        BinaryTree bt = new BinaryTree(new String("root"));
        bt.attachLeftSonAtCursor(new String("left son of root"));
        bt.attachRightSonAtCursor(new String("right son of root"));

        try {
            displaySuccessIfTrue(!btFail.putCursorAtRoot());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(bt.putCursorAtRoot());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(bt.getCursorData().equals("root"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }        

        try {
            displaySuccessIfTrue(bt.putCursorAtLeftSon());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(bt.getCursorData().equals("left son of root"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(bt.getCursorNode().getRightBrother().getData().equals("right son of root"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                            

        try {
            displaySuccessIfTrue(!bt.putCursorAtRightSon());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bt.putCursorAtFather());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bt.getCursorData().equals("root"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(bt.putCursorAtRightSon());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bt.getCursorData().equals("right son of root"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(bt.putCursorAtFather());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(!bt.attachLeftSonAtCursor(new Long(10)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }

    private static void test_Nodes() {
        System.out.println("Testing Nodes...");
        Node n = new Node(new Long(10), null);
        Node n2 = new Node(new Long(2), n);
        n.setRightSon(n2);


        try {
            displaySuccessIfTrue(n2.getParent().equals(n));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n.getRightSon().equals(n2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n.getLeftSon() == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n2.getData().equals(new Long(2)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n.getLeftSon() == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        Node n3 = new Node(new Long(0), n);
        n.setLeftSon(n3);

        try {
            displaySuccessIfTrue(n3.getRightBrother().equals(n2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        n3.setAndCreateRightSon(new String("right son of n3"));
        n3.setAndCreateLeftSon(new String("left son of n3"));

        Node n4 = n3.getLeftSon();
        Node n5 = n3.getRightSon();

        try {
            displaySuccessIfTrue(n5.getData().equals(new String("right son of n3")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n4.getRightBrother().equals(n5));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n4.getParent().equals(n3));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n5.getParent().equals(n3));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n3.getRightSon().equals(n5));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n3.getLeftSon().equals(n4));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n4.getData().equals("left son of n3"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        System.out.println("Secondary pointer Node Tests...");

        Node testNodeRoot = new Node(new String("root"), null);
        Node testNodeDangler = new Node(new String("I dangle"), null);

        Node level1Left = new Node(new String("left son of root"), testNodeRoot);
        testNodeRoot.setLeftSon(level1Left);

        testNodeRoot.setAndCreateRightSon(new String("right son of root"));

        try {
            displaySuccessIfTrue(testNodeRoot.getLeftSon().equals(level1Left));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(testNodeRoot.getRightSon().getData().equals("right son of root"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }        
        try {
            displaySuccessIfTrue(level1Left.getParent().equals(testNodeRoot));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }        
        try {
            displaySuccessIfTrue(level1Left.getLeftSon() == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }        
        try {
            displaySuccessIfTrue(level1Left.getRightBrother().getData().equals("right son of root"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }        
        try {
            displaySuccessIfTrue(testNodeRoot.getRightSon().getParent().equals(testNodeRoot));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }        
        try {
            displaySuccessIfTrue(testNodeRoot.getRightSon().getLeftSon() == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        testNodeRoot.getRightSon().setLeftSon(testNodeDangler);
        Node level1Right = testNodeRoot.getRightSon();

        try {
            displaySuccessIfTrue(level1Right.getLeftSon().equals(testNodeDangler));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(testNodeDangler.getParent().equals(level1Right));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }  
    }

    private static void test_PreOrderIterator() {
        System.out.println("testing PreOrderiterator...");

        BinaryTree b = new BinaryTree(new String("a"));
        b.attachLeftSonAtCursor(new String("b"));
        b.putCursorAtLeftSon();
        b.attachLeftSonAtCursor(new String("c"));
        b.putCursorAtLeftSon();
        b.attachRightSonAtCursor(new String("d"));
        b.putCursorAtRoot();
        b.attachRightSonAtCursor(new String("e"));
        b.putCursorAtRightSon();
        b.attachLeftSonAtCursor(new String("f"));
        b.attachRightSonAtCursor("g");
        b.putCursorAtRightSon();
        b.attachRightSonAtCursor(new String("h"));
        String output = "";

        for (Object o : b) {
            output += o;
        }

        try {
            displaySuccessIfTrue(output.equals("abcdefgh"));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        BinaryTree b2 = new BinaryTree(new Integer(1));
        b2.attachLeftSonAtCursor(new Integer(2));
        b2.putCursorAtLeftSon();
        b2.attachLeftSonAtCursor(new Integer(3));
        b2.putCursorAtLeftSon();
        b2.attachLeftSonAtCursor(new Integer(4));
        b2.putCursorAtLeftSon();
        b2.attachLeftSonAtCursor(new Integer(5));
        b2.attachRightSonAtCursor(new Integer(6));
        b2.putCursorAtRoot();
        b2.attachRightSonAtCursor(new Integer(7));
        b2.putCursorAtRightSon();
        b2.attachRightSonAtCursor(new Integer(8));
        b2.putCursorAtRightSon();
        b2.attachLeftSonAtCursor(new Integer(9));
        b2.attachRightSonAtCursor(new Integer(10));
        b2.putCursorAtRightSon();
        b2.attachRightSonAtCursor(new Integer(11));

        String b2output = "";
        for(Object o : b2) {
            b2output += o;
        }

        try {
            displaySuccessIfTrue(b2output.equals("1234567891011"));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        BinaryTree b3 = new BinaryTree();

        try {
            for(Object o : b3) {
                System.out.println(o);

            }
        } catch(Exception e) {
            throw new NullPointerException("error for empty trees on iteration");
        }

        // PreOrderiterator i = b2.iterator();
    } 
    private static void test_contains() {
        System.out.println("Testing contains...");

        BinaryTree b = new BinaryTree();
        BinaryTree b2 = new BinaryTree(new Integer(1));
        b2.attachLeftSonAtCursor(new Integer(2));
        b2.putCursorAtLeftSon();
        b2.attachLeftSonAtCursor(new Integer(3));
        b2.putCursorAtLeftSon();
        b2.attachLeftSonAtCursor(new Integer(4));
        b2.putCursorAtLeftSon();
        b2.attachLeftSonAtCursor(new Integer(5));
        b2.attachRightSonAtCursor(new Integer(6));
        b2.putCursorAtRoot();
        b2.attachRightSonAtCursor(new Integer(7));
        b2.putCursorAtRightSon();
        b2.attachRightSonAtCursor(new Integer(8));
        b2.putCursorAtRightSon();
        b2.attachLeftSonAtCursor(new Integer(9));
        b2.attachRightSonAtCursor(new Integer(10));
        b2.putCursorAtRightSon();
        b2.attachRightSonAtCursor(new Integer(11));

        try {
            displaySuccessIfTrue(b2.contains(new Integer(11)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(!b2.contains(new Integer(12)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }        

    }
}