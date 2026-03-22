class WordDictionary() {

    class TrieNode (var isEndOfWorld:Boolean){
        val children: MutableList<TrieNode?> = MutableList<TrieNode?>(26){null}
    }

    val root:TrieNode = TrieNode(false)

    fun addWord(word: String) {
        var crawler:TrieNode = root

        for(i in 0 until word.length){
            val index:Int = word[i]- 'a'

            if(crawler.children[index]==null){
                crawler.children[index] = TrieNode(false)
            }

            crawler = crawler.children[index] ?: TrieNode(false)
        }

        crawler.isEndOfWorld = true
    }

    fun searchUtil(root:TrieNode, word:String):Boolean{
        var crawler:TrieNode = root

        for(i in 0 until word.length){
            val ch:Char = word[i]

            if(ch == '.'){
                for(j in 0 until 26){
                    if(crawler.children[j] != null){
                        if(searchUtil(crawler.children[j]!!, word.substring(i+1))== true){
                            return true
                        }
                    }
                }
                return false
            }
            else if(crawler.children[ch-'a']==null){
                return false
            }

            crawler = crawler.children[ch-'a']!! 
        }

        return (crawler!=null && crawler.isEndOfWorld)
    }

    fun search(word: String): Boolean { 
        return searchUtil(root,word)
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */