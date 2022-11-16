object HelperFunctions {
    // 数値で構成される配列を受け取り、最大値のインデックスを返します。
    fun maxInArrayIndex(intArr: IntArray): Int{
        var maxIndex: Int = 0
        var maxValue: Int =  intArr[0]
        for(i in 1 until intArr.size){
            if(intArr[i] > maxValue) {
                maxValue = intArr[i]
                maxIndex = i
            }
        }
        return maxIndex
    }
}