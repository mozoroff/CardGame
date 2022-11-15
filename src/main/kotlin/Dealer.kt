class Dealer {
    // 参加人数を受け取り、それぞれのプレイヤーにカードを配る処理を作成します。
    companion object {
        fun startGame(amountOfPlayers: Int): ArrayList<ArrayList<Card>> {
            //新しいデッキを作ります
            val deck = Deck()
            //デッキをシャッフルします
            deck.shuffleDeck()
            val table: ArrayList<ArrayList<Card>> = arrayListOf()
            // プレーヤの手札
            for (i in 0..amountOfPlayers) {
                // arrayListOfとArrayListのちがいを見つける
                val playerHand: ArrayList<Card> = ArrayList(2)
                for (j in 0 until 2) {
                    val card1 = deck.draw()
                    playerHand.add(card1)
                }
                table.add(playerHand)
            }
            return table
        }
    }
}