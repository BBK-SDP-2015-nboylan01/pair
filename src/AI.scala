class AI(private var player: Player, private var depth: Int) extends Solver {

  override def getMoves(b: Board): Array[Move] = ???

  def minimax(s: State) {
    
  }

  def evaluateBoard(b: Board): Int = {
    val winner = b.hasConnectFour()
    var value = 0
    if (!winner.isDefined) {
      val locs = b.winLocations()
      for (loc <- locs; p <- loc) {
        value += (if (p == player) 1 else if (p != null) -1 else 0)
      }
    } else {
      var numEmpty = 0
      var r = 0
      while (r < Board.NUM_ROWS) {
        var c = 0
        while (c < Board.NUM_COLS) {
          if (b.getTile(r, c) == null) numEmpty += 1
          c = c + 1
        }
        r = r + 1
      }
      value = (if (winner.get == player) 1 else -1) * 10000 * numEmpty
    }
    value
  }
}




object AI {

  

  def createGameTreeHelper(s: State, d: Int): Unit = {
    
    
    
       s.writeToFile
    
    
    if (d!=0)  {
        println ("In createGameTree Depth is " + d.toString)
         val stateList: Array[State] = s.initializeChildren()
         stateList.map(state => AI.createGameTree(state, d-1))
      }
      else
        println("we're at the bottom")
    
    
  }
  
  def createGameTree(s: State, d: Int): Unit = {
    

    var nodeTree = new Node(d, s.lastMove.column)
    // reset array list of tree nodes 
    createGameTreeHelper(s, d)
    
    
 
    
    
  }

  def minimax(ai: AI, s: State) {
    ai.minimax(s)
  }
}

