object Dealer {
    // 参加人数を受け取り、それぞれのプレイヤーにカードを配る処理を作成します。

        fun startGame(table: Table): ArrayList<ArrayList<Card>> {
            //新しいデッキを作ります
            val deck = Deck()
            //デッキをシャッフルします
            deck.shuffleDeck()
            val playerCards: ArrayList<ArrayList<Card>> = arrayListOf()
            // プレーヤの手札
            for (i in 0..table.amountOfPlayers) {
                // arrayListOfとArrayListのちがいを見つける
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
}