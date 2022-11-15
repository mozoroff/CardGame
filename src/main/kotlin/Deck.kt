import kotlin.math.floor

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
            println(deck[i].getCardString())
        }
    }
    // シャッフルする関数はtwo pointerを活用します。for文で一つ一つのカードをランダムに入れ替える処理を書きましょう。
    fun shuffleDeck(){
        for(i in deck.size - 1 downTo 0) {
            val j: Int = floor(Math.random() * i + 1).toInt()
            val temp: Card = deck[i]
            deck[i] = deck[j]
            deck[j] = temp
        }
    }
    //カードをドロー
    fun draw(): Card{
        //最後の一枚をpop
        return deck.removeAt(deck.size - 1)
    }
}