object Dealer {
    // 参加人数を受け取り、それぞれのプレイヤーにカードを配る処理を作成します。
        fun startGame(table: Table): ArrayList<ArrayList<Card>> {
            //新しいデッキを作ります
            val deck = Deck()
            //デッキをシャッフルします
            deck.shuffleDeck()
            val playerCards: ArrayList<ArrayList<Card>> = ArrayList()
            // プレーヤの手札
            for (i in 0 until table.amountOfPlayers) {
                val playerHand: ArrayList<Card> = ArrayList(initialCards(table.gameMode))
                for (j in 0 until initialCards(table.gameMode)) {
                    val card1 = deck.draw()
                    playerHand.add(card1)
                }
                playerCards.add(playerHand)
            }
            return playerCards
        }
    fun initialCards(gameMode: String): Int {
            if(gameMode == "poker") return 5
            if(gameMode == "21") return 2
            else return 0
        }
    // 卓の情報を表示するメソッドを作成します。table を受け取り、卓の情報とそれぞれのプレイヤーの手札を表示します。
    fun printTableInformation(playerCards: ArrayList<ArrayList<Card>>, table: Table){
        println("Amount of player: ${table.amountOfPlayers}... Game mode: ${table.gameMode}. At this table: ")
        for(i in 0 until playerCards.size){
            println("player " + (i + 1) + " hand is:")
            for(j in 0 until playerCards[i].size){
                println(playerCards[i][j].getCardString())
            }
            println()
        }
    }
    // 各プレーヤーの手札を受け取って、合計値を計算するscore21Individualメソッドを作成します。
    // ブラックジャックでは値の合計値が21を超えるとNGなのでその場合は0とします。
    fun score21Individual(cards: ArrayList<Card>): Int{
        var value: Int = 0
        for(i in cards.indices){
            value += cards[i].intValue
        }
        if(value > 21) value = 0
        return value
    }

    // ブラックジャックで誰が勝利したか表示する関数を作成します。
    // それぞれのプレイヤーの手札をscore21Individualで計算し、配列に保存します。例: [10,16,15,16,15,15]
    // この場合、勝利するプレイヤーが複数存在することからHashMapでcacheを作成し、
    // cache[10] = 1, cache[15] = 3, cache[16] = 2のように書き換えます。
    // 配列 [10,16,15,16,15,15]の最大値は16で、cache[16] > 1なのでドローになります。
    // もし、0 <= cache[16] <= 1なら、そのプレイヤーの勝利、それ以外の場合は勝者が誰もいないことになります。
    // ではこのロジックを関数にしてみましょう。
    fun winnerOf21(playerCards: ArrayList<ArrayList<Card>>): String {
        val cache: HashMap<Int, Int?> = HashMap()
        val points: IntArray = IntArray(playerCards.size)

        for (i in playerCards.indices) {
            val point: Int = score21Individual(playerCards[i])
            points[i]= point
            if (cache[point] == null) {
                cache[point] = 1
            } else cache.replace(point, cache[point]!! + 1)
        }
        val winnerIndex: Int = HelperFunctions.maxInArrayIndex(points)
        if (cache[points[winnerIndex]]!! > 1) return "It is a draw "
        else if (cache[points[winnerIndex]]!! >= 0) return "player ${winnerIndex + 1} is winner"
        else return "No winners.."
    }

}