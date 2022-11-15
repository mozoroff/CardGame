class Card(private val suit: String, private val value: String, private var intValue: Int ) {
    // トランプアプリを開発していきます。ここでは21を開発しますが、
    // どのトランプゲームでも組み込めるような設計にします。
    // まずは1枚分のカードを表すクラスCardを生成しましょう。
    // 記号(♣, ♦, ♥, ♠の内1つ)・値（A,2,~,Kの内1つ）
    // ・数値（0~12の内1つ）をインスタンス化させるコンストラクタと、それらの情報を返す関数を作成します。


    fun getCardString() : String{
        return this.suit + this.value + "(" + this.intValue + ")"
    }

}