package Game;

public class MiniMaxAI extends AI{
    public static int nodeCount =0;
    @Override
    int play(int[][] boardState) throws Exception {
        nodeCount = 0;
        Node root = new Node(Game.getInstance().clone(boardState),NodeType.MAX, null,7);

        Node bestChild = null;
        for (Node c: root.children){
            if(root.eval== c.eval){
                bestChild=c;
                break;
            }
        }
        int way;
        if(bestChild==null)
            throw new Exception("child pay na");
        else way = root.getDifference(bestChild);


        System.out.println(nodeCount+" node created\n");

        if(way<7 && way>=0){
            return way;
        }
        else throw new Exception("AI baire dite chay");
    }


}