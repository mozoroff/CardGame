class Deck {
    var deck :ArrayList<Card> = arrayListOf()
    init{
        this.deck = generateDeck()
    }
    // デッキを生み出すメソッドを作成します。staticメソッドを使います。
    // ここではインスタンス無しでも使える関数と考えていただければ問題ありません。
    // 全記号・全ての値を用意し、for文で一つずつカードを生成します。
    companion object {
        fun generateDeck(): ArrayList<Card> {
            val newDeck: ArrayList<Card> = arrayListOf()
            val suits: Array<String> = arrayOf("♣", "♦", "♥", "♠")
            val value: Array<String> = arrayOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
            for (i in suits.indices) {
                for (j in value.indices) {
                    newDeck.add(Card(suits[i], value[j], j + 1))
                }
            }
            return newDeck
        }
    }
        fun printDeck(){
            println("Displaying cards...")
            for(i in 0  until  deck.size){
                println(deck.get(i).getCardString())
            }
        }

}