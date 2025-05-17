package com.deck

class Deck(amount: Int = 1) {
    private var _cards: List<Card>
    private var _index = 0

    val currentTopCardIndex: Int
        get() = _index

    val cards: List<Card>
        get() = _cards

    init {
        require(amount > 0) {"Amount must exceed 0"}
        val ranks = Rank.entries
        val suits = Suit.entries
        _cards = List(amount) {
            suits.flatMap { suit ->
                ranks.map { rank ->
                    Card(rank, suit)
                }
            }
        }.flatten()
    }

    fun popCard(): Card? {
        return when {
            _index < _cards.size -> _cards[_index++]
            else -> null
        }
    }

    fun shuffle() {
        _cards = _cards.shuffled()
        _index = 0
    }



    fun cardsToString(): String {
        val sBuilder = StringBuilder()
        for (i in 0..< cards.size) {
            sBuilder.append(cards[i].getEmblem() + " ")
            if ( (i + 1) % 10 == 0) {
                sBuilder.append("\n")
                }
            }
        return sBuilder.toString()
    }
}